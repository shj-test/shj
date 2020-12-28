<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="//at.alicdn.com/t/font_976080_vcih1xte9um.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/layui.css">
    <link rel="stylesheet" href="/css/common.css?v=2020071502">
    <link rel="stylesheet" href="/css/register_index.css?v=2020071501">
</head>
<body>
<div class="cp-header">
    <div>
        <a class="cp-logo">
            <img src="/images/logo.png">
        </a>
        <div class="layui-nav headerRight">
            <div class="cp-header-search">
                <input id="cpTopSearchInput" onkeypress="cpTopSearchHandle(false);" placeholder="可以搜索标题、作者、标签哦！"
                       onkeyup="inputListener($(this).val())">
                <a href="javascript:;" onclick="cpTopSearchHandle(true);" class="iconfont icon-search"></a>
                <div class="inputListenerBox">
                    <p class="searchWord">正在搜索:“<span class="world"></span>”</p>
                    <div class="searchNovelBox cp-card">
                        <div class="cp-card-header cp-card-header-bold">
                            <span class="cp-card-header-line"></span>
                            <h3>小说</h3>
                        </div>
                        <ul class="listBox" type="novel"></ul>
                    </div>
                    <div class="searchAuthorBox cp-card">
                        <div class="cp-card-header cp-card-header-bold">
                            <span class="cp-card-header-line"></span>
                            <h3>作者</h3>
                        </div>
                        <ul class="listBox" type="author"></ul>
                    </div>
                </div>
            </div>
            <div class="cp-header-link">
                <a href="javascript:;" class="cp-app-down">
                    <span>下载APP</span>
                    <span class="cp-app-down-qrcode">
                        <img src="/images/app_down.png" alt="">
                    </span>
                </a>
                <a href="javascript:goRecharge();">充值</a>
            </div>
            <div class="cp-header-user">
                <a href="javascript: register()">注册</a>
                <span></span>
                <a href="javascript:loginModel();">登录</a>
            </div>
        </div>
    </div>
</div>
<div class="cp-main-box">
    <div class="layui-layer-title" style="cursor: move;">用户登录</div>
    <div id="" class="layui-layer-content" style="height: 407px;">
        <div id="loginBox" class="cp-hidden cp-login-box layui-layer-wrap" style="display: block;">
            <form id="loginForm" class="layui-form" onsubmit="return false;">
                <div class="layui-form-item login_tel loginBox">
                    <div class="layui-input-inline ncodeBox" style="width: 150px;">
                        <select name="ncode" lay-filter="nationCode">
                            <option value="86">中国大陆</option>
                            <option value="852">中国香港</option>
                            <option value="853">中国澳门</option>
                            <option value="886">中国台湾</option>
                        </select>
                        <div class="layui-unselect layui-form-select">
                            <div class="layui-select-title"><input type="text" placeholder="请选择" value="中国大陆" readonly=""
                                                                   class="layui-input layui-unselect"><i
                                    class="layui-edge"></i></div>
                            <dl class="layui-anim layui-anim-upbit">
                                <dd lay-value="86" class="layui-this">中国大陆</dd>
                                <dd lay-value="852" class="">中国香港</dd>
                                <dd lay-value="853" class="">中国澳门</dd>
                                <dd lay-value="886" class="">中国台湾</dd>
                            </dl>
                        </div>
                    </div>
                    <div class="layui-input-inline nameBox">
                        <input type="text" name="username" placeholder="输入账号" autocomplete="off" class="layui-input tel"
                               lay-verify="required">
                    </div>

                </div>

                <div class="layui-form-item">
                    <div class="layui-input-inline" style="width: 100%;">
                        <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input"
                               lay-verify="required">
                    </div>
                </div>
                <div id="ncContainer" class="nc-container" data-nc-idx="1">
                    <div id="nc_1_wrapper" class="nc_wrapper">
                        <div id="nc_1_n1t" class="nc_scale">
                            <div id="nc_1__bg" class="nc_bg"></div>
                            <span id="nc_1_n1z" class="nc_iconfont btn_slide"></span>
                            <div id="nc_1__scale_text" class="scale_text"><span class="nc-lang-cnt"
                                                                                data-nc-lang="_startTEXT">请按住滑块，拖动到最右边</span>
                            </div>
                            <div id="nc_1_clickCaptcha" class="clickCaptcha">
                                <div class="clickCaptcha_text">
                                    <b id="nc_1__captcha_text" class="nc_captch_text"></b>
                                    <i id="nc_1__btn_2" class="nc_iconfont nc_btn_2 btn_refresh"></i>
                                </div>
                                <div class="clickCaptcha_img"></div>
                                <div class="clickCaptcha_btn"></div>
                            </div>
                            <div id="nc_1_imgCaptcha" class="imgCaptcha">
                                <div class="imgCaptcha_text"><input id="nc_1_captcha_input" maxlength="6" type="text"
                                                                    style="ime-mode:disabled"></div>
                                <div class="imgCaptcha_img" id="nc_1__imgCaptcha_img"></div>
                                <i id="nc_1__btn_1" class="nc_iconfont nc_btn_1 btn_refresh"
                                   onclick="document.getElementById('nc_1__imgCaptcha_img').children[0].click()"></i>
                                <div class="imgCaptcha_btn">
                                    <div id="nc_1__captcha_img_text" class="nc_captcha_img_text"></div>
                                    <div id="nc_1_scale_submit" class="nc_scale_submit"></div>
                                </div>
                            </div>
                            <div id="nc_1_cc" class="nc-cc"></div>
                            <i id="nc_1__voicebtn" tabindex="0" role="button" class="nc_voicebtn nc_iconfont"
                               style="display:none"></i>
                            <b id="nc_1__helpbtn" class="nc_helpbtn"><span class="nc-lang-cnt" data-nc-lang="_learning">了解新功能</span></b>
                        </div>
                        <div id="nc_1__voice" class="nc_voice"></div>
                    </div>
                </div>
                <input name="zzz" type="hidden" value="login|3b789f8670954b237ad26a6119da7036">

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <input type="checkbox" name="remember" value="1" title="记住宝宝" lay-skin="primary" checked="">
                        <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary">
                            <span>记住宝宝</span><i class="layui-icon"></i></div>
                    </div>
                    <div class="layui-inline checkIt" style="margin-top: 10px; float: right;cursor: pointer;"
                         onclick="checklogintype(this)" logintype="tel">
                        <span class="loginType">邮箱登录</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-inline" style="width: 100%;">
                        <button id="loginBtn" disabled="" class="layui-btn layui-disabled" style="width: 100%;"
                                lay-submit="" lay-filter="login"> 立即登录
                        </button>
                    </div>
                </div>
                <div class="cp-over-hidden">
                    <a class="right" href="/register/findpsw">忘记密码</a>
                </div>
            </form>
        </div>
    </div>
    <span class="layui-layer-setwin"><a class="layui-layer-ico layui-layer-close layui-layer-close1"
                                        href="javascript:;"></a></span><span class="layui-layer-resize"></span>

</div>
</body>
</html>