<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8"
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
<title>添加宠物信息</title>  
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 添加宠物信息</strong></div>
  <div class="body-content">
    <sf:form method="post" modelAttribute="knowledgeInfo" class="form-x">
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <sf:input path="pkname" placeholder="添加名称不能和之前重复" type="text" class="input" name="stitle" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>摘要：</label>
        </div>
        <div class="field">
          <sf:input path="summary" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <sf:input path="creator" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>关键字：</label>
        </div>
        <div class="field">
          <sf:input path="label" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>编写内容：</label>
        </div>
        <div class="field">
          <sf:textarea path="pkdescription" id="editor" type="text/plain" style="width:1400px;"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>
        </div>
      </div>
    </sf:form>
  </div>
</div>
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script>
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/ueditor.config.js"></script>
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/ueditor.all.min.js"></script>
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="<%=path %>/resources/static/lib/js/petSave.js"></script>
</body>
</html>