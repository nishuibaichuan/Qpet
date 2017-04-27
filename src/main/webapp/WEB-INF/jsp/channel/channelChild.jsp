<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
<title>子栏目</title>  
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/pagination/pagination.css">
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
<script src="<%=path %>/resources/static/plugins/layui/lay/modules/layer.js"></script>
<script src="<%=path %>/resources/static/lib/js/clicks.js"></script>
<script src="<%=path %>/resources/static/plugins/pagination/jquery.pagination.js"></script>
<script type="text/javascript">
$(function(){
	if($("#records").val()>0){
		$("#pager").pagination($("#records").val(), {
	        current_page:parseInt($("#currentPage").val()),  
	        items_per_page:$("#pageSize").val(), 
	        num_display_entries:8, 
	        next_text:"下一页",
	        prev_text:"上一页",
	        num_edge_entries:2, 
	        link_to:"javascript:void(0);",
	        callback:handlePaginationClick
		});	
	}
});

// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
    $("#listform").attr("action", '<%=path %>/admin/channel/' + $("#currentChannelName").val() + "_" + (new_page_index)) ;
    $("#listform").submit();
    return false;
}

</script> 
</head>
<body>
<form method="post" action="" style="width:888px;float:right;"  id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 栏目管理</strong></div>
    <div class="padding border-bottom">
          <c:choose>
		    <c:when test="${currentChannelName.parentid ge 0}">
			       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <div class="button-group"> <a class="button border-blue" href="javascript:void(0)" onclick="return del(1)">
			         	当前栏目:  ${currentChannelName.name } </a> </div>
		    </c:when>
		    <c:otherwise>
		    &nbsp;&nbsp; <div class="button-group"> <a class="button border-blue" href="javascript:void(0)" onclick="return del(1)">
			       当前栏目: 网站内容管理栏目 </a> </div>
		    </c:otherwise>
		</c:choose>
		 <div class="button-group"> <a class="button border-blue" href="<%=path%>/admin/channelSave/ ${currentChannelName.id }">
			        <span class="icon-plus"></span> 添加栏目 </a> </div>
		 <div class="button-group"> <a class="button border-blue" href="#"><span class="icon-refresh"></span> 刷新左边树 </a> </div>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="90">栏目名称</th>
        <th>栏目创建者</th>       
        <th width="25%">栏目描述</th>
        <th>创建时间</th>
        <th>顺序</th>
        <th>操作</th>       
      </tr>  
       <c:forEach items="${channels }" var="c">    
        <tr>
          <td>${c.name }</td>
          <td>${c.creator}</td>
          <td>${c.description}</td>
          <td><fmt:formatDate value="${c.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
          <td>${c.channelorder }</td>
          <td><div class="button-group"> <a class="button border-green" href="<%=path%>/admin/channelUpdate/ ${c.id }"><span class="icon-pencil"></span> 修改</a> </div></td>
        </tr>
        </c:forEach>
    </table>
  </div>
</form>
<input type="hidden" id="records" value="${pages.totalRecords}" />
<input type="hidden" id="currentPage" value="${pages.currentPage}" />
<input type="hidden" id="pageSize" value="${pages.pageSize}" />
<input type="hidden" id="currentChannelName" value="${currentChannelName.id }" />
<div id="pager" style="float:right;	margin-top:20px;"></div>
</body>
</html>