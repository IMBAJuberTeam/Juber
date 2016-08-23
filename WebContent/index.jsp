<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="../jquery/jquery-3.1.0.min.js"></script>	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <table border="1">  
        <tbody>  
            <tr>  
                <th>序号</th>  
                <th>地区编号</th>  
                <th>地区</th>  
            </tr>  
            <c:if test="${!empty areaList }">  
                <c:forEach items="${areaList }" var="area">  
                    <tr>  
                        <td>${area.id }</td>  
                        <td>${area.areaCode }</td>  
                        <td>${area.areaName }</td>  
                    </tr>               
                </c:forEach>  
            </c:if>
            <tr>
            <a href="getAreas.do?pageNum=${page.currentPage -1} ">上一页</a>
            <span>${page.currentPage}</span>  
            <a href="getAreas.do?pageNum=${page.currentPage +1} ">下一页</a>  
            </tr>
        </tbody>  
    </table>  
  </body>
</html>
