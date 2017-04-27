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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>Qpet后台管理中心</title>
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css">
<link rel="stylesheet" href="<%=path %>/resources/static/plugins/layui/css/layui.css" />
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>
				<img src="<%=path %>/resources/static/lib/images/y.jpg" class="radius-circle rotate-hover"
					height="50" alt="" />Qpet后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green" href="http://localhost:8080/Qpet/front/index" target="_blank"><span
				class="icon-home"></span> 前台首页</a> &nbsp;&nbsp;<a href="##"
				class="button button-little bg-blue on"><span class="icon-wrench"></span>
				刷新页面</a> &nbsp;&nbsp;<a class="button button-little bg-red"
				href="<%=path %>/admin/logout"><span class="icon-power-off"></span> 退出登录</a>
		</div>
		<div style="float:right;margin:15px 25px;font-size:14px;letter-spacing:1px;background:white;" class="button button-little">
			欢迎 <span style="color:red;">${admin }</span>   登录Qpet后台管理中心
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-home"></span>宠物管理<i class="layui-icon"
				style="position: relative; left: 40px;">&#xe609;</i><span
				class="layui-nav-more"></span>
		</h2>
		<ul>
			<li><a href="<%=path %>/admin/manager/0" target="right"><span
					class="icon-tags"></span>宠物列表管理</a></li>
			<%-- <li><a href="<%=path %>/admin/manager" target="right"><span
					class="icon-tags"></span>宠物类目管理</a></li> --%>
			<li><a href="<%=path %>/admin/knowledge/0" target="right"><span
					class="icon-book"></span>宠物知识百科</a></li>
			<li><a href="<%=path %>/admin/search/reconstructIndex" target="right"><span
					class="icon-search"></span>宠物查询管理</a></li>
		</ul>
		<h2>
			<span class="icon-th"></span>内容管理<i class="layui-icon"
				style="position: relative; left: 39px;">&#xe609;</i>
		</h2>
		<ul>
			<li><a href="<%=path %>/admin/channel" target="right"><span
					class="icon-table"></span>栏目管理</a></li>
					<%-- <li><a href="<%=path %>/admin/channel" target="right"><span
					class="icon-table"></span>图片管理</a></li> --%>
			<li><a href="<%=path %>/admin/message" target="right"><span
					class="icon-list-alt"></span>评价管理</a></li>
		</ul>
		<h2>
			<span class="icon-shopping-cart"></span>订单管理<i class="layui-icon"
				style="position: relative; left: 39px;">&#xe609;</i>
		</h2>
		<ul>
		<!-- 	<li><a href="list.html" target="right"><span
					class="icon-certificate"></span>所有订单</a></li> -->
			<li><a href="list.html" target="right"><span
					class="icon-calendar"></span>订单列表</a></li>
			<li><a href="list.html" target="right"><span
					class="icon-list-alt"></span>订单状态</a></li>
		</ul>
		<h2>
			<span class="icon-user"></span>会员管理<i class="layui-icon"
				style="position: relative; left: 40px;">&#xe609;</i>
		</h2>
		<ul>
			<li><a href="<%=path %>/admin/getPagerDate/0" target="right"><span
					class="icon-fire"></span>会员列表</a></li>
		</ul>
		<h2>
			<span class="icon-cog"></span>基本设置<i class="layui-icon"
				style="position: relative; left: 40px;">&#xe609;</i>
		</h2>
		<ul>
			<li><a href="<%=path %>/admin/app" target="right"><span
					class="icon-align-justify"></span>网站设置</a></li>
			<li><a href="<%=path %>/admin/modify" target="right"><span
					class="icon-edit"></span>修改密码</a></li>
		</ul>
	</div>
	<ul class="bread">
		<li><a href="<%=path %>/resources/admin/welcome.jsp" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color: red;">中文</span></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="<%=path %>/resources/admin/welcome.jsp"
			name="right" width="100%" height="100%"></iframe>
	</div>
<div style="text-align: center;"></div>
<script type="text/javascript" src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/resources/static/lib/js/home.js"></script>

</body>
</html>