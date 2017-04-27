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
<title>栏目管理</title>  
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/zTree/v3/css/demo.css" />
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/zTree/v3/css/zTreeStyle/zTreeStyle.css" />
</head>
<body>
<div style="float:left;">
  <ul id="channelTree" class="ztree" style="height:777px;"></ul>
</div>	
<iframe id="listChannel" Name="listChannel" frameborder=0  src="<%=path %>/admin/channel/0_0"
		scrolling=auto width=885px  height=720px style="float:right;"></iframe>
<script type="text/javascript" src="<%=path %>/resources/static/plugins/zTree/v3/api/apiCss/jquery-1.6.2.min.js" ></script>
<script type="text/javascript" src="<%=path %>/resources/static/plugins/zTree/v3/api/apiCss/jquery.ztree.core-3.5.js" ></script>
<script type="text/javascript" src="<%=path %>/resources/static/lib/js/channel.js"></script>		
<script type="text/javascript">
var mt;
$(function(){
	mt = $("#channelTree").mytree();
});
function refreshTree() {
	mt.reAsyncChildNodes(null,"refresh");
}
</script>
</body>
</html>