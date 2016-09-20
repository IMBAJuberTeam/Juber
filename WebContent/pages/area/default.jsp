<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Juber</title>
  <meta name="description" content="juber" />
  <meta name="keywords" content="juber" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<%@ include file="/layout/default.jsp" %>

<script type="text/javascript" src="<%=path %>/static/js/pages/area/area.js"></script>

<script type="text/javascript">
	var contextPath = "<%=path %>";
</script>
</head>
<body>
<div class="app app-header-fixed  ">
  <%@include file="/layout/header.jsp" %>
  <%@include file="/layout/nav.jsp" %>

  
  <!-- content -->
  <div id="content" class="app-content" role="main">
    <div class="app-content-body" >
		在线人数统计：${onlineCount}
		
	</div>
  </div>
  <!-- / content -->
    <%@include file="/layout/footer.jsp" %>
  </div>
  </body>
  </html>