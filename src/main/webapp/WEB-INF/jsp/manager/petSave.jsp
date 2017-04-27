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
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/webuploader/0.1.5/webuploaders.css">
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/zTree/v3/css/demo.css" />
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
</head>
<body>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;background:#eee;z-index:999;border:1px solid #999">
		<ul id="mytree" class="ztree" style="margin-top:0;overflow: auto;"></ul>
</div>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 添加宠物信息</strong></div>
  <div class="body-content">
    <sf:form method="post" modelAttribute="petInfo" class="form-x">
      <div class="form-group">
        <div class="label">
          <label>宠物名称：</label>
        </div>
        <div class="field">
          <sf:input path="pname" placeholder="添加名称不能和之前重复" type="text" class="input" name="stitle" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>附加信息：</label>
        </div>
        <div class="field">
          <sf:input path="subtitle" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>市场价：</label>
        </div>
        <div class="field">
          <sf:input path="marketPrice" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>Qpet价：</label>
        </div>
        <div class="field">
          <sf:input path="shopPrice" type="text" class="input" name="surl" value="" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>所属栏目：</label>
        </div>
        <div class="field">
          <input type="text" readonly placeholder="请选择一个文章栏目"  name="channelName" id="channelName" style="cursor:pointer;height:26px;font-size:13.3px;padding-left:8px;"/>
		  <input type="hidden" id="csid" name="csid" value="0"  />
        </div>
      </div>
      <input type="hidden" id="image" name="image" />
      <div class="form-group">
        <div class="label">
          <label>宠物封面：</label>
        </div>
        <div class="field">
        <div class="uploader-list-container">
			<div class="queueList">
				<div id="dndArea" class="placeholder">
					<div id="filePicker-2"></div>
				</div>
			</div>
			<div class="statusBar" style="display:none;">
				<div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
				<div class="info"></div>
				<div class="btns">
					<div id="filePicker2"></div>
					<div class="uploadBtn">开始上传</div>
				</div>
			</div>
		</div>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>宠物内容：</label>
        </div>
        <div class="field">
          <sf:textarea path="pdesc" id="editor" type="text/plain" style="width:1400px;"/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 添加</button>
        </div>
      </div>
    </sf:form>
  </div>
</div>
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script>
<script src="<%=path %>/resources/static/plugins/webuploader/0.1.5/webuploader.min.js"></script>
<script src="<%=path %>/resources/static/plugins/webuploader/0.1.5/image-upload/upload.js"></script> 
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/ueditor.config.js"></script>
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/ueditor.all.min.js"></script>
<script src="<%=path %>/resources/static/plugins/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script src="<%=path %>/resources/static/plugins/zTree/v3/api/apiCss/jquery.ztree.core-3.5.js" ></script>
<script src="<%=path %>/resources/static/lib/js/channel.js"></script>
<script src="<%=path %>/resources/static/lib/js/petSaveZtree.js"></script>
<script src="<%=path %>/resources/static/lib/js/petSave.js"></script>
</body>
</html>