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
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var contextPath = "<%=path %>";
	var clickTime = 0;
		function toPage(currentPage, dataCount){
			var url = "area/getAreas.do";
			var condition = $("input[name=condition]").val();
			window.location.href = url + "?pageNum=" + currentPage
									+ "&dataCount=" + dataCount
									+ "&condition=" + condition;
		}
		function showChildren(id){
			var children = Array();
			if(clickTime == 0){
				$.getJSON(contextPath + "/area/getChildrens.do?id="+id,function(result){
					if(result == undefined){
						return;
					}else{
						children = result;
					}
					
					if($("tr[name='children']")!=undefined && $("tr[name='children']").length >= children.length){
						return ;
					}else{
							for(var i=0; i < children.length; i++)
								$('#area_'+id).after("<tr name ='children'><td bgcolor='e91e6f'>"+ result[i].id +"</td><td bgcolor='e91e6f'>"+ result[i].areaCode +"</td><td bgcolor='e91e6f'>"+ result[i].areaName +"</td></tr>");
							clickTime++;
					}
				
				});
			}else{
				$("tr[name='children']").remove();
				clickTime = 0;
			}
			$('#area_'+id).attr("bgcolor","yellow");
			}
		function coloredTable(isOver ,id){
			if(isOver){
				$('#area_'+id).attr("bgcolor","yellow");	
			}else{
				$('#area_'+id).attr("bgcolor","");	
			}
		}
	</script>
  </head>
  
  <body>
	<p><span>条件筛选：<input name="condition" value="${page.conditions[0] }" />
	<input type= "button" onclick="toPage(1, '')" value = "查询"></p>
	</p>
    <table border="1">  
        <thead>  
            <tr>  
                <th>序号</th>  
                <th>地区编号</th>  
                <th>地区</th>  
            </tr>
        </thead>
        <tbody>
            <c:if test="${!empty areaList }">  
                <c:forEach items="${areaList }" var="area">  
                    <tr id="area_${area.id }" onclick="showChildren(${area.id })" onmouseover="coloredTable(true, ${area.id })" onmouseout="coloredTable(false, ${area.id })">  
                        <td>${area.id }</td>  
                        <td>${area.areaCode }</td>  
                        <td>${area.areaName }</td>
                    </tr>               
                </c:forEach>  
            </c:if>
		</tbody> 
    </table>
    <table>
            <tfoot>
<%-- 		         	<a href="javaScript:toPage(${page.currentPage -1}, ${page.dataCount})">上一页</a> --%>
		         	<a href="javascript:void(0);" onclick="toPage(${page.currentPage -1}, ${page.dataCount})">上一页</a>
		         	
		         	<span>${page.currentPage}</span>  
<%-- 		         	<a href="javaScript:toPage(${page.currentPage +1}, ${page.dataCount})">下一页</a> --%>
		         	<a href="javascript:void(0);" onclick="toPage(${page.currentPage +1}, ${page.dataCount})">下一页</a>
	            	<span>[记录总数：${page.dataCount}]</span>
         	</tfoot>
    </table> 
  </body>
</html>
