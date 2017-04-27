<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>列表信息</title>
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
</head>
<body>
<form id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> </div>
    <div class="padding border-bottom">
    </div>
    <table class="table table-hover text-center">
      <tr>
        	<td><h4>&nbsp;&nbsp;<font color="#00CC99">${knowledgeInfo.pkname }</font></h4></td>
      </tr>
      <tr>
        	<td>&nbsp;&nbsp;<fmt:formatDate value="${knowledgeInfo.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>
        	&nbsp;&nbsp;${knowledgeInfo.creator }
        	</td>
      </tr>
	  <tr>
	        <td>摘要:&nbsp;&nbsp;${knowledgeInfo.summary }</td>
	  </tr>
	  <tr>
	        <td>&nbsp;&nbsp; ${knowledgeInfo.pkdescription }</td>
	  </tr>
      <tr>
        <td colspan="8"><input type="button" name="back" value="返回上一页" onclick="javascript:history.back(-1);"/></td>
      </tr>
    </table>
  </div>
</form>
</body>
</html>