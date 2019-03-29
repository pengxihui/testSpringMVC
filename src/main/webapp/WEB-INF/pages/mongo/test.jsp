<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="<%=request.getContextPath()%>/"/><!-- 页面基链接 -->
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
<script src="static/jquery/jquery-3.3.1.js"></script>
<title>mongodb 练习</title>
</head>
<body>
   <div>
       <table class="table table-bordered table-hover" >
	       <tr>
	          <th>名称</th>
	          <th>用户名</th>
	          <th>性别</th>
	          <th>年龄</th>
	       </tr>
	       <tbody>
		        <c:forEach var="userInfo" items="${userInfoCollection}" varStatus="status">
		            <tr>
		               <td><span id="nickname">${userInfo.nickname}</span></td>
		               <td><span id="username">${userInfo.username}</span></td>
		               <td><span id="sex">${userInfo.sex}</span></td>
		               <td><span id="age">${userInfo.age}</span></td>
		            </tr>
			    </c:forEach>
	       </tbody>
       </table>
   </div>
</body>
</html>