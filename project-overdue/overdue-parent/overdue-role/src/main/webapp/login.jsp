<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
        
    <script src="/overdue/plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
        
    <script src="/overdue/plugins/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<form id="loginform" action="/overdue/login" method="post"  class="sui-form">
    <div class="input-prepend"><span class="add-on loginname"></span>
        <input id="prependedInput"  name="username" type="text" placeholder="邮箱/用户名/手机号" class="span2 input-xfat">
    </div>
    <div class="input-prepend"><span class="add-on loginpwd"></span>
        <input id="prependedInput1"  name="password" type="password" placeholder="请输入密码" class="span2 input-xfat">
    </div>
    <div class="setting">
        <div id="slider">
            <div id="slider_bg"></div>
            <span id="label">>></span> <span id="labelTip">拖动滑块验证</span>
        </div>
    </div>
    <div class="logined">
        <a class="sui-btn btn-block btn-xlarge btn-danger" onclick="document:loginform.submit()" target="_blank">登&nbsp;&nbsp;录</a>
    </div>
</form>
</body>
</html>