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
<title>会员管理</title>
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/pagination/pagination.css">
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
<script src="<%=path %>/resources/static/lib/js/delete.js"></script> 
<script src="<%=path %>/resources/static/plugins/pagination/jquery.pagination.js"></script> 
<script type="text/javascript">
$(function(){
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
});

// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
    $("#listform").attr("action", '<%=path %>/admin/getPagerDate/' + (new_page_index));
    $("#listform").submit();
    return false;
}

</script>
</head>
<body>
<form method="get" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 会员列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">会员昵称</th>
        <th>真实名称</th>
        <th>邮件</th>
        <th>手机号</th>
        <th>家庭地址</th>
        <th width="18%">创建时间</th>
        <th width="120">操作</th>
      </tr>
        <c:forEach items="${users }" var="user">
	        <tr>
	          <td>${user.username }</td>
	          <td>${user.name }</td>
	          <td width="10%">${user.email }</td>
	          <td>${user.phone }</td>
	          <td><font color="#00CC99">${user.addr }</font></td>
	          <td><fmt:formatDate value="${user.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	          <td><div class="button-group"><a class="button border-red on" href="<%=path %>/admin/member/delete/${user.uid}" >
	          <span class="icon-trash-o"></span> 删除</a> <input type="hidden" value="${user.username }" /></div></td>
	        </tr>
        </c:forEach>
    </table>
  </div>
</form>
<input type="hidden" id="records" value="${pages.totalRecords}" />
<input type="hidden" id="currentPage" value="${pages.currentPage}" />
<input type="hidden" id="pageSize" value="${pages.pageSize}" />
<div id="pager" style="float:right;	margin-top:20px;"></div>
</body>
</html>