<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

				<div class="bg-light lter b-b wrapper-md">
					<h1 class="m-n font-thin h3">中华人民共和国行政地区统计表</h1>
				</div>
				<div class="wrapper-md">
					<div class="panel panel-default">
						<div class="input-group">
							<div class="panel-body b-b b-light">
								<span class="input-group-btn"> <input id="filter"
									name="condition" value="${page.conditions[0] }" type="text"
									class="form-control input-sm w-sm inline " />
									<button type="button" class="btn btn-sm bg-light rounded"
										onclick="toPage(1, '')">查询</button>
								</span>
							</div>
						</div>
						<table class="footable metro-blue default ">
							<thead></thead>
							<tbody></tbody>
							<tfoot></tfoot>
						</table>
					</div>
				</div>
	</div>
  </div>
  <!-- / content -->
    <%@include file="/layout/footer.jsp" %>
  </div>
  </body>
  </html>