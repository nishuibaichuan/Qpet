<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>评价管理</title>
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
<script src="<%=path %>/resources/static/lib/js/delete.js"></script> 
</head>
<body>
<form method="post" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 评价列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">评价者昵称</th>
        <th>真实名称</th>
        <th>邮件</th>
        <th>手机号</th>
        <th>评价内容</th>
        <th width="10%">评价时间</th>
        <th width="310">操作</th>
      </tr>
        <c:forEach items="${messageVos }" var="message">
	        <tr>
	          <td>${message.username }</td>
	          <td>${message.realname }</td>
	          <td width="10%">${message.email }</td>
	          <td>${message.phone }</td>
	          <td><font color="#00CC99">${message.context }</font></td>
	          <td><fmt:formatDate value="${message.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	          <td><div class="button-group"><a class="button border-red on" href="<%=path %>/admin/message/delete/${message.id}" >
	          <span class="icon-trash-o"></span> 删除</a> <input type="hidden" value="${user.username }" /></div></td>
	        </tr>
        </c:forEach>
    </table>
  </div>
</form>
</body>
</html>