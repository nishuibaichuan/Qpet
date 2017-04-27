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
<title>宠物列表信息</title>
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/pagination/pagination.css">
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
<script src="<%=path %>/resources/static/plugins/pagination/jquery.pagination.js"></script>
<script>
  $(function(){
	  $(".on").click(function(){
			$(this).each(function(){
				var username = $(this).next(":input").val();
				var id =  $(this).next(":input").next(":input").val();
				var flag = confirm("确定要删除" + "'" + username + "'" + "吗 ?");
				if(flag){
					$(this).attr("href", '<%=path %>/admin/knowledge/delete/' + id);
					return true;
				}else{
					//取消超链接默认行为
					return false;
				}
			
		    });
		});
  
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
    $("#listform").attr("action", '<%=path %>/admin/knowledge/' + (new_page_index));
    $("#listform").submit();
    return false;
}

</script> 

</head>
<body>
<form id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=path%>/admin/knowledge/knowledgeSave"> 添加内容</a> </li>
        <div style="padding-left: 32%;">
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a>
         </li>
        </div>  
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="5%">编号</th>
        <th width="10%">标题</th>
        <th>作者</th>
        <th width="10%">关键字</th>
        <th>所属栏目</th>
        <th width="10%">创建时间</th>
        <th width="310">操作</th>
      </tr>
      <c:forEach items="${knowledgeVos }" var="knowledge">
	        <tr>
	          <td>${knowledge.pkid }</td>
	          <td><a href="<%=path%>/admin/knowledge/knowledgeShow/${knowledge.pkid }"><font color="#00CC99">${knowledge.pkname }</font></a></td>
	          <td>${knowledge.creator }</td>
	          <td>${knowledge.label }</td>
	          <td><font color="#00CC99">${knowledge.channelName }</font></td>
	          <td><fmt:formatDate value="${knowledge.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	          <td><div class="button-group"> <a class="button border-main" href="<%=path%>/admin/knowledge/knowledgeUpdate/${knowledge.pkid}"><span class="icon-edit"></span> 修改</a> 
	          <a class="button border-red on" href="javascript:void(0)" >
	          <span class="icon-trash-o"></span> 删除</a> <input type="hidden" value="${knowledge.pkname }" />
	          <input type="hidden" id="knowledgeId" value="${knowledge.pkid}" /></div></td>
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