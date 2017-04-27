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
		<title>新用户注册</title>
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
					<span> . 欢迎注册</span>
				</div>
				<div class="logo-login">
					<span>已有账号？<a href="登陆.html">登陆</a></span>
				</div>
			</div>
			<div class="list">
				<div class="list-list">
					<form action="/" method="get">
						<ul>
							<li class="raw">
								<span class="list1">用户名：</span>
								<input type="text" name="username" value="">
							</li>
							<li class="raw">
								<span class="list1">密码：</span>
								<input type="password" name="password" value="">
							</li>
							<li class="raw">
								<span class="list1">确认密码：</span>
								<input type="password" name="password" value="">
							</li>
							<li class="raw">
								<span class="list1">手机号：</span>
								<input type="text" name="username" value="">
							</li>
							<li class="raw raw-2">
								<span class="list1">短信验证码：</span>
								<input type="text1" name="username" value="">
								<input type="button" name="loginbtn" value="获取验证码">
							</li>
							<li class="raw raw-3">							
								<input type="button" name="loginbtn" value="立即注册">
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
