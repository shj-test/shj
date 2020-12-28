<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
</head>
<body>
<h3 id="app">{{message}}</h3>

<script src="https://cdn.jsdelivr.net/npm/vue@2.5.21/dist/vue.min.js"></script>
<script>
    var app=new Vue({
        el:"#app",
        data:{
            message:"hello,vue"
        }
    })
</script>
</body>
</html>