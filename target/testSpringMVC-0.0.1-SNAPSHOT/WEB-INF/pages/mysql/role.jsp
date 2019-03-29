<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!--输出,条件,迭代标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> <!--数据格式化标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> <!--数据库相关标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="<%=request.getContextPath()%>/"/><!-- 页面基链接 -->
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
<script src="static/jquery/jquery-3.3.1.js"></script>
<script src="static/js/mysql/role.js"></script>
<title>mysql练习</title>
</head>
<body>
   <div class="container">
          输入角色id: <input class="form-control" id="roleId" type="text" style="width:50%"/>
              <button type="button" onclick="select()">查询</button>
      
      <div class="body">
         <table id="roletable" class="table table-bordered table-hover">
            <thead>
               <tr>
                  <th>角色名称</th>
                  <th>状态</th>
                  <th>备注</th>
               </tr>
            </thead>
         </table>
      </div>
   </div>
</body>
</html>