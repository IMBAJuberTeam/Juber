<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

  <link rel="stylesheet" href="static/bower_components/bootstrap/css/bootstrap.css" type="text/css" />
  <link rel="stylesheet" href="static/bower_components/bootstrap/css/animate.css" type="text/css" />
  <link rel="stylesheet" href="static/bower_components/bootstrap/css/font-awesome.min.css" type="text/css" />
  <link rel="stylesheet" href="static/bower_components/bootstrap/css/simple-line-icons.css" type="text/css" />
  <link rel="stylesheet" href="static/css/font.css" type="text/css" />
  <link rel="stylesheet" href="static/css/app.css" type="text/css" />
  
<title>Juber by  Tol brandir</title>
</head>
<body>
<div class="app app-header-fixed  ">
  

<div class="container w-xxl w-auto-xs">
  <a href="#" class="navbar-brand block m-t">Juber</a>
  <div class="m-b-lg">
    <div class="wrapper text-center">
      <strong>join us, Coding to die！！！ by tolbrandir</strong>
    </div>
    <form name="form" class="form-validation" action = "<%=path%>/login.do" method="post">
      <div class="text-danger wrapper text-center">
          
      </div>
      <div class="list-group list-group-sm">
        <div class="list-group-item">
          <input type="email" name ="userName" placeholder="邮箱" class="form-control no-border" required>
        </div>
        <div class="list-group-item">
           <input type="password" name="passWord" placeholder="密码" class="form-control no-border" required>
        </div>
      </div>
      <button type="submit" class="btn btn-lg btn-primary btn-block" >登录</button>
      <div class="text-center m-t m-b"><a ui-sref="access.forgotpwd">忘了密码?点我重置</a></div>
      <div class="line line-dashed"></div>
      <p class="text-center"><small>还没有帐号？</small></p>
      <a href="#" class="btn btn-lg btn-default btn-block">注册Juber</a>
    </form>
  </div>
  <div class="text-center">
    <p>
  <small class="text-muted">本网站刊载的所有内容均在网上搜集,服务用于个人学习、研究或欣赏，本网站内容原作者如不愿意在本网站刊登内容，请及时通知本人tolrandir，予以删除<br>&copy; 2016</small>
</p>
  </div>
</div>


</div>
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="static/bower_components/bootstrap/js/bootstrap.js"></script>
</body>
</html>