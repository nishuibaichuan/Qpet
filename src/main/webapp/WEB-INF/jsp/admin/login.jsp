<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Qpet后台登录</title>  
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/pintuer.css" />
<link rel="stylesheet" href="<%=path %>/resources/static/lib/css/admin.css" />
</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein page-container">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">           
            </div>         
            <form action="<%=path %>/admin/login" method="post">
            <div class="panel loginbox">
                <div class="text-center margin-big padding-big-top"><h1>Qpet后台管理中心</h1></div>
                <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="text" class="input input-big" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                            <span class="icon icon-user margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field field-icon-right">
                            <input type="password" class="input input-big" name="password" placeholder="登录密码" data-validate="required:请填写密码" />
                            <span class="icon icon-key margin-small"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="field">
                            <input type="text" class="input input-big" name="checkcode" placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
                            <img src="<%=path %>/admin/drawCheckCode" class="captcha passcode" width="150" height="75" style="margin-bottom:5px;cursor:pointer;"/>
                        </div>
                    </div>
                    <span class="msg">${msg}</span>
                </div> 
                <div style="padding:30px;"><input type="submit" class="button button-block bg-main text-big input-big" value="登录"></div>
            </div>
            
            </form>       
            <input type="hidden" id="ctx" value="<%=path %>">   
        </div>
    </div>
</div>
<script src="<%=path %>/resources/static/lib/js/jquery.js"></script>
<script src="<%=path %>/resources/static/lib/js/pintuer.js"></script> 
</body>
</html>