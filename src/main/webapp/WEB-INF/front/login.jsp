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
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆</title>
		<link rel="stylesheet" href="<%=path %>/resources/static/front/css/dengluzhuce.css"/>
	</head>
	<body>
		<div id="header">
				<div id="top">
					<a href="<%=path %>/front/index">首页 </a>
					<a href="<%=path %>/front/index">我的Q宠 </a>
					<a href="<%=path %>/front/login">你好，请登录 </a>
					<a href="<%=path %>/front/register"> 注册 </a>
					<a href="<%=path %>/front/index">购物车 </a>
				</div>
			</div>
		<div class="main">
			<div class="logo">
				<div class="logo-picture">
					<img src="<%=path %>/resources/static/front/images/logo.png" />
				</div>
				<div class="logo-welcome">
					<span> . 欢迎登陆</span>
				</div>
				<div class="logo-login">
					<span><a href="<%=path %>/front/register">注册账号</a></span>
				</div>
			</div>
			<div class="list">
				<div class="list-list">
					<form action="/" method="get">
						<ul class="list-login">
							<li class="raw">
								<span class="list1">用户名：</span>
								<input type="text" name="username" value="">
							</li>
							<li class="raw">
								<span class="list1">密码：</span>
								<input type="password" name="password" value="">
							</li>
							<li class="raw raw-2">
								<span class="list1">验证码：</span>
								<input type="text1" name="username" value="">
								<div class="yanzhengma">
									<a><img src="<%=path %>/resources/static/front/img/seccode.png" width="100" height="40"/></a>
								</div>
							</li>
							<li class="raw tips">
								<input type="checkbox">
								<span>自动登录</span>
								<span class="no-password"><a href="#">忘记密码?</a></span>
							</li>
							<li class="raw raw-3">							
								<input type="button" name="loginbtn" value="登陆">
							</li>
						</ul>
					</form>
				</div>
			</div>
			<div id="foot">
				<div id="footer">
					<img src="<%=path %>/resources/static/front/images/df.jpg" id="z" />
					<div class="links">
			            <a href="#">关于我们</a>|
			            <a href="#">联系我们</a>|
			            <a href="#">商家入驻</a>|
			            <a href="#">营销中心</a>|
			            <a href="#">手机京东</a>|
			            <a href="#">友情链接</a>|
			            <a href="#">销售联盟</a>|
			            <a href="#">京东社区</a>|
			            <a href="#">风险监测</a>|
			            <a href="#">京东公益</a>|
			            <a href="#">English Site</a>|
			            <a href="#">Contact Us</a>
			        </div>
			        <div class="copyright">
			        	<p><a href="#">110105001984 京ICP证090703号 Copyright&copy; 2010-2014 shangpin.com ALL Rights Reserved</a></p>
			        </div>
				</div>
			</div>
		</div>
	</body>
</html>
