<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Q宠商城</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/resources/static/front/css/main.css" />
<script type="text/javascript" src="<%=path %>/resources/static/front/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/resources/static/front/js/js.js"></script>
</head>
<body>
<div id="header">
	<div id="top">
		<a href="<%=path %>/front/index">首页 </a>
		<a href="<%=path %>/front/">我的Q宠 </a>
		<a href="<%=path %>/front/login">你好，请登录 </a>
		<a href="<%=path %>/front/register"> 注册 </a>
		<a href="<%=path %>/front/">购物车 </a>
	</div>
	<div id="xia">
		<a href="index.html"><img src="<%=path %>/resources/static/front/images/logo.png" id="logo" /></a>
		<div id="search">
			<input type="text" name="search" /><a href="#">搜索</a>
			<div id="xuan">
			<!-- 判断是否火热 -->
				<a href="product.html">零食</a>
				<a href="product.html">服饰</a>
				<a href="product.html">主食</a>
				<a href="product.html">玩具</a>
				<a href="product.html">生活用品</a>
				<a href="product.html">医疗</a>
				<a href="product.html">配饰</a>
				<a href="product.html">书籍</a>
			</div>
		</div>
		<a href="cart.html"><img src="<%=path %>/resources/static/front/images/index_06.jpg" id="sp" /></a>
	</div>
</div> 
<!--top end-->
<div id="nav">
	<ul>
		<c:forEach items="${channels }" var="c">
			<li id="dq"><a href="${c.id }">${c.name }</a></li>
		</c:forEach>
	</ul>
</div>
<!--nav end-->
<div id="wrapper">
<div id="banner">
	<div id="imgchange">
		<ul>
			<li><a href="#"><img src="<%=path %>/resources/static/front/images/banner (2).jpg"/></a></li>
			<li><a href="nv.html"><img src="<%=path %>/resources/static/front/images/banner (3).jpg" /></a></li>
			<li><a href="#"><img src="<%=path %>/resources/static/front/images/banner (4).jpg" /></a></li>
			<li><a href="nv.html"><img src="<%=path %>/resources/static/front/images/banner (1).jpg" /></a></li>
			<li><a href="nan.html"><img src="<%=path %>/resources/static/front/images/banner (5).jpg" /></a></li>
		</ul>
		<p></p>
	</div>
</div>
<div id="qita">
	<div id="xiangbao">
		<div class="one">
			<span><a href="#">玩具</a></span>
			<div class="bao">
				<p>
					<c:forEach items="${channelToy }" var="ct"> 
						<a href="${ct.id }">${ct.name }</a>|
					</c:forEach>
				</p>
			</div>
		</div>
	</div>
	<!--xiangbao end-->
</div>
<!--qita end-->
<div id="paihang">
	<div class="Qpet-l">
		<div class="Qpet-l-left">
			<span>特价抢购</span>
		</div>
		<div class="Qpet-l-right">
			<span>
				<a href="#" id="q">主食</a><a href="#">零食</a><a href="#">日用</a><a href="#">服饰</a><a href="#" id="no">更多>></a>
			</span>
		</div>	
	</div>
	<dl>
		<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/paihang (8).jpg" /></a></dt>
		<dd><a href="nv.html">SINEQUANONE</a></dd>
		<dd><a href="nv.html">2012冬季新品 女士优雅黑羊毛</a></dd>
		<dd>￥1399</dd>
	</dl>
	<dl>
		<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/paihang (1).jpg" /></a></dt>
		<dd><a href="nv.html">SINEQUANONE</a></dd>
		<dd><a href="nv.html">2012冬季新品 女士糖果红羊毛</a></dd>
		<dd>￥1399</dd>
	</dl>
	<dl>
		<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/paihang (3).jpg" /></a></dt>
		<dd><a href="nv.html">RODIKA ZANIAN</a></dd>
		<dd><a href="nv.html">2012秋冬新款-女士大领设计长</a></dd>
		<dd>￥799</dd>
	</dl>
	<dl>
		<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/paihang (2).jpg" /></a></dt>
		<dd><a href="nv.html">ARYN K</a></dd>
		<dd><a href="nv.html">2012秋冬新品-女士长袖露肩针</a></dd>
		<dd>￥299</dd>
	</dl>
</div>
<!--paihang end-->
<div class="Qpet">
	<div class="Qpet-l">
		<div class="Qpet-l-left">
			<span>狗狗</span>
		</div>
		<div class="Qpet-l-right">
			<span>
				<a href="#" id="q">主食</a><a href="#">零食</a><a href="#">日用</a><a href="#">服饰</a><a href="#">保健</a><a href="#">配饰</a><a href="#" id="no">更多>></a>
			</span>
		</div>	
	</div>
	<div id="t">
		<a href="#"><img src="<%=path %>/resources/static/front/images/bao.jpg" /></a>
		<a href="#"><img src="<%=path %>/resources/static/front/images/bao1.jpg" /></a>
	</div>
	<div class="remen">
		<h2>
			<img src="<%=path %>/resources/static/front/images/re.jpg" />
		</h2>
			<p><a href="#" id="da">AATU</a><a href="#" id="da">巴西淘淘力派</a></p>
			<p><a href="#" id="da">安娜玛特Annamaet</a><a href="#" id="da">美士</a></p>
			<p><a href="#" id="da">爱邦Earthborn</a><a href="#">家比乐</a></p>
			<p><a href="#" id="da">麦可维MAX</a><a href="#">Addiction</a></p>
			<p><a href="#">凌采EVO</a><a href="#">百娜绮BY NATURE</a></p>
			<p><a href="#">贵族Natures Gift</a><a href="#" id="da">LINGDOK</a></p>
			<p><a href="#">Go</a><a href="#">妙趣Mutural</a></p>
			<p><a href="#">维采Vets Choice</a><a href="#">Wellness</a></p>
			<p><a href="#">希尔斯</a><a href="#">欧奇斯Organix</a></p>
			<p><a href="#">艾尔</a><a href="#">比瑞吉</a></p>
			<p><a href="#">BOTH</a><a href="#">迪比克</a></p>
			<p><a href="#">诺瑞Nory</a><a href="#">皇家royal canin</a></p>
			<p><a href="#">好之味</a><a href="#">味优</a></p>
	</div>
	<div class="zhanshi">
		<dl>
			<dt><a href="#"><img src="<%=path %>/resources/static/front/images/zhanshi (2).jpg" /></a></dt>
			<dd><a href="#">DIANE VON FURSTENBERG</a></dd>
			<dd><a href="#">女士香槟金色字母涂鸦装饰化妆包</a></dd>
			<dd>￥760</dd>
		</dl>
		<dl>
			<dt><a href="#"><img src="<%=path %>/resources/static/front/images/zhanshi (3).jpg" /></a></dt>
			<dd><a href="#">CHLOE</a></dd>
			<dd><a href="#">克洛伊 女士复古手拿包</a></dd>
			<dd>￥760</dd>
		</dl>
		<dl>
			<dt><a href="#"><img src="<%=path %>/resources/static/front/images/zhanshi (1).jpg" /></a></dt>
			<dd><a href="#">MENBUR</a></dd>
			<dd><a href="#">女士奢华天鹅绒手拿包</a></dd>
			<dd>￥760</dd>
		</dl>
	</div>
</div>
<div class="Qpet">
	<div class="Qpet-l">
		<div class="Qpet-l-left">
			<span>猫咪</span>
		</div>
		<div class="Qpet-l-right">
			<span>
				<a href="#" id="q">主食</a><a href="#">零食</a><a href="#">日用</a><a href="#">服饰</a><a href="#">保健</a><a href="#">配饰</a><a href="#" id="no">更多>></a>
			</span>
		</div>	
	</div>
	<div id="t">
		<a href="#"><img src="<%=path %>/resources/static/front/images/sf (1).jpg" /></a>
		<a href="#"><img src="<%=path %>/resources/static/front/images/sf (2).jpg" /></a>
	</div>
	<div class="remen">
		<h2>
			<img src="<%=path %>/resources/static/front/images/re.jpg" />
		</h2>
			<p><a href="#" id="da">AATU</a><a href="#" id="da">巴西淘淘力派</a></p>
			<p><a href="#" id="da">安娜玛特Annamaet</a><a href="#" id="da">美士</a></p>
			<p><a href="#" id="da">爱邦Earthborn</a><a href="#">家比乐</a></p>
			<p><a href="#" id="da">麦可维MAX</a><a href="#">Addiction</a></p>
			<p><a href="#">凌采EVO</a><a href="#">百娜绮BY NATURE</a></p>
			<p><a href="#">贵族Natures Gift</a><a href="#" id="da">LINGDOK</a></p>
			<p><a href="#">Go</a><a href="#">妙趣Mutural</a></p>
			<p><a href="#">维采Vets Choice</a><a href="#">Wellness</a></p>
			<p><a href="#">味优</a><a href="#">欧奇斯Organix</a></p>
			<p><a href="#">艾尔</a><a href="#">比瑞吉</a></p>
			<p><a href="#">BOTH</a><a href="#">迪比克</a></p>
			<p><a href="#">诺瑞Nory</a><a href="#">皇家royal canin</a></p>
			<p><a href="#">好之味</a><a href="#">希尔斯</a></p>
	</div>
	<div class="zhanshi">
		<dl>
			<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/zsd (2).jpg" /></a></dt>
			<dd><a href="nv.html">SINEQUANONE</a></dd>
			<dd><a href="nv.html">2012 冬季新品 女士优雅黑羊毛呢</a></dd>
			<dd>￥1399</dd>
		</dl>
		<dl>
			<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/zsd (1).jpg" /></a></dt>
			<dd><a href="nv.html">SINEQUANONE</a></dd>
			<dd><a href="nv.html">2012 冬季新品 女士优雅黑羊毛上衣</a></dd>
			<dd>￥999</dd>
		</dl>
		<dl>
			<dt><a href="nv.html"><img src="<%=path %>/resources/static/front/images/zsd (3).jpg" /></a></dt>
			<dd><a href="nv.html">HALSTON HERITAGE</a></dd>
			<dd><a href="nv.html">2012 冬季新品 女士包缠式长袖连衣</a></dd>
			<dd>￥1699</dd>
		</dl>
	</div>
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
            <a href="#">Q宠社区</a>|
            <a href="#">风险监测</a>|
            <a href="#">Q宠公益</a>|
            <a href="#">English Site</a>|
            <a href="#">Contact Us</a>
        </div>
        <div class="copyright">
        	<p><a href="#">110105001984 京ICP证090703号 Copyright&copy; 2010-2014 shangpin.com ALL Rights Reserved</a></p>
        </div>
	</div>
</div>
</body>
</html>
