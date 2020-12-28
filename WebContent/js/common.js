var isLog = false //记录是否登陆状态，用于websocket登录

function getUserInfo(cache) {
    var userInfo = localStorage.getItem("userInfo") || "{}";
    var sessionId = getCookie('PHPSESSID');
    userInfo = JSON.parse(userInfo);
    if (!cache || userInfo == null || userInfo.sessionId != sessionId) {
        $.ajax({
            url: '/user/getUserInfo',
            async: false,
            success: function (res) {
                if (res.code == 200) {
                    userInfo = res.data;
                } else if (res.code == 9996) {
                    userInfo = {};
                }
                setUserStorage(userInfo);
            }
        });
    }
    return userInfo;
}

function afterLogin(userInfo) {
    if (userInfo.show_uid) { //登录成功
        $('#cpHeaderUser').hide();
        $('#userMsgBox .userName').text(userInfo.nick_name);
        $('#userMsgBox .header').attr('src', userInfo.profile_image);
        $('#userMsgBox').show();
        isLog = true

    } else { //未登录
        $('#cpHeaderUser').show();
        $('#userMsgBox').hide();
    }
}

function logOut() {

    layer.confirm('确定登出？', function (index) {
        $.get('/login/logout', function () {
            layer.close(index);
            setUserStorage({});
            afterLogin(userInfo);
            window.location.reload();
        });
    })
}

function setUserStorage(userInfo) {
    userInfo.sessionId = getCookie('PHPSESSID');
    localStorage.setItem("userInfo", JSON.stringify(userInfo));
}

function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg))
        return unescape(arr[2]);
    else
        return null;
}

function ncCheck(cb) {
    layer.open({
        type: 1,
        title: false,
        closeBtn: false,
        area: ['300px', '34px'],
        shadeClose: true,
        content: '<div id="__ncCheck__"></div>',
        success: function (layero, index) {
            new noCaptcha({
                renderTo: "#__ncCheck__",
                appkey: 'FFFF0N00000000008205',
                scene: "nc_register",
                token: [(new Date()).getTime(), Math.random()].join(':'),
                is_Opt: 0,
                isEnabled: true,
                timeout: 3000,
                times: 5,
                callback: function (data) {
                    cb({
                        csessionid: data.csessionid,
                        token: data.token,
                        sig: data.sig,
                    })
                    layer.close(index);
                }
            })
        }
    });
}
