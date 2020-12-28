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
    <div class="cp-register-form">
        <div class="cp-register-tab"><a href="javascript:;" class="active">手机注册</a></div>
        <form onsubmit="return false;" class="layui-form"><input type="hidden" name="type" value="1">
            <div class="layui-form-item"><label class="layui-form-label">手机号码</label>
                <div class="layui-input-inline" style="width: 120px;"><select name="ncode" lay-filter="nationCode">
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
                <div class="layui-input-inline" style="margin-right: 0px; width: 230px;">
                    <input type="text"
                           id="cpRegisterUsername"
                           name="username"
                           required="required"
                           lay-verify="required"
                           placeholder="请输入"
                           autocomplete="off"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-form-item"><label class="layui-form-label">手机验证码</label>
                <div class="layui-input-inline" style="width: 240px;"><input type="text" name="code" required="required"
                                                                             lay-verify="required" placeholder="请输入"
                                                                             autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="width: 110px; margin-right: 0px;"><a
                        class="layui-btn layui-btn-primary" style="width: 100%;">获取验证码</a></div>
            </div>
            <div class="layui-form-item"><label class="layui-form-label">登录密码</label>
                <div class="layui-input-block"><input type="password" name="password" required="required"
                                                      lay-verify="required" placeholder="6-16位字母和数字组合"
                                                      autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item"><label class="layui-form-label">重复密码</label>
                <div class="layui-input-block"><input type="password" name="password_c" required="required"
                                                      lay-verify="required" placeholder="再次输入密码" autocomplete="off"
                                                      class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button lay-filter="formSubmit" class="layui-btn">立即注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>