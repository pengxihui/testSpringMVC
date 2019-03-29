<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <!--<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.min.css>
<script type="text/javascript" src=${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.min.js></script>
<script type="text/javascript" src=${pageContext.request.contextPath}/lib/jquery/jquery-3.3.1.js></script>-->

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script type="text/javascript" src=${pageContext.request.contextPath}/lib/userInfo2.js></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试springMvc返回数据方式页面</title>
</head>

<body onload="init()">
    <!--  <p>${userList[0].USER_NAME}</p>
    <p>${userList[0].COMPANY_TYPE}</p>-->
    <form role="form">
        <div id="loginForm" style="align:center;">
                          用户名:<input id="username" value='${userList[0].USER_NAME}'/><br>
                          密码:<input id="password" class="form-control" type="password" data-toggle="password" data-message="Show/hide password" style="width:10%;"/>
        <div class="input-group input-group-lg" style="width:50%">
			<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
			<input type="text" class="form-control" placeholder="用户名">
		</div><br>
		<div class="input-group input-group-lg" style="width:50%">
			<span class="input-group-addon"><i class="glyphicon glyphicon-lock" aria-hidden="true"></i></span>
			<input type="text" class="form-control" placeholder="密码">
		</div><br>
        
        </div>
    </form>
    <br>
    <p>
		<button type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-sort-by-attributes"></span>
		</button>
		<button type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-sort-by-attributes-alt"></span>
		</button>
		<button type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-sort-by-order"></span>
		</button>
		<button type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-sort-by-order-alt"></span>
		</button>
	</p>
	<button type="button" class="btn btn-default btn-lg">
		<span class="glyphicon glyphicon-user"></span> User
	</button>
	<button type="button" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-user"></span> User
	</button>
	<button type="button" class="btn btn-default btn-xs">
		<span class="glyphicon glyphicon-user"></span> User
	</button>
	
	<table class="table">
	<caption>基本的表格布局</caption>
   <thead>
      <tr>
         <th>名称</th>
         <th>城市</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td>Tanmay</td>
         <td>Bangalore</td>
      </tr>
      <tr>
         <td>Sachin</td>
         <td>Mumbai</td>
      </tr>
   </tbody>
</table>
</body>
</html>