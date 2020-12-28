<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script>

        $(function () {
            $("#tj").click(function () {
                $.post({
                    url:"${pageContext.request.contextPath}/addType",
                    data:{'name':$("#type").val()},
                    success:function (data) {
                        console.log(data)
                        console.log(data.flag)
                        console.log(data.msg)
                        $("span").html(data.msg)

                    }
                });
            })
        })
    </script>
</head>
<body>
<h2>hello world!</h2>
<input id="type" type="text"><br/>
<span></span>
<input type="submit" id="tj" value="注册">
</body>
</html>
