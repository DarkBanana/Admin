<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style =(inclued background and div body)= -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">

</head>
<body class="hold-transition login-page" >

<div class="login-box" id="app" v-cloak >
  <div class="login-logo">
    <font color=white > <b>AdminLTE</b>管理系统 </font>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body" style="color: white" >
    <p class="login-box-msg">登录页面 </p>
   					
	  <span  style="font-size:18px;color: #CD2626" text-align:center > ${ msg } </span>
    
     <form id="loginform" name="loginform" action="${pageContext.request.contextPath}/login.action" method="post">   
     
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="username" name="username"  placeholder="账号"> 
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      
       <div class="form-group has-feedback">
        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      
       <div class="form-group has-feedback">
        <input type="text" class="form-control" id="captcha" name="captcha"   placeholder="验证码">
        <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <img id="code" alt="如果看不清楚，请单击图片刷新！" class="pointer" src="captcha.action" onclick="refreshCode()">
        &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" onclick="refreshCode()" style="color: black">点击刷新 </a>
      </div>
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 记住我 
            </label>
          </div>
        </div>     
        <!-- /.col -->
        <div class="col-xs-4" >
          <input  type="button" class="btn btn-primary btn-block btn-flat"  value="登录" onclick="loginsubmit()" /> <!-- onclick="loginsubmit()"  -->
        </div>
        <!-- /.col -->
      </div>
      
       </form> 

    <!-- <a href="register.html"  class="text-center">注册</a> -->

  </div>
  <!-- /.login-box-body -->
</div>


<!-- jQuery 2.2.3 -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<!-- 新引入Layer -->
<script src="${pageContext.request.contextPath}/statics/layer/layer.js"></script>
<script>

 
 	//提交方法
	function loginsubmit(){
	 //非空校验			
	 if($("#username").val().replace(/\s+/g,'')==''){   //方法 .replace(/\s+/g,'')==''去除多个空格 正则 s+表示一个或多个空格
	 layer.msg("账号不能为空",{
		anim: 6 //动画类型
  	 })
 	 }else if( $("#password").val() == "" ){
	 layer.msg("密码不能为空",{
		anim: 6 //动画类型
	 })
	 }else if( $("#captcha").val() =="" ){
	 layer.msg("验证码不能为空",{
		anim: 6 //动画类型
	 })
	 }else {
	 $("#loginform").submit();
	 };
 	}
 
 
 	
 
 
   //刷新验证码
   //实现思路，重新给图片的src赋值，后边加时间，防止缓存 
   function refreshCode() {
	$("#code").attr('src','captcha.action?time=' + $.now());
	}


	//整体风格
	$(function () {
	    $('input').iCheck({
	      checkboxClass: 'icheckbox_square-blue',
	      radioClass: 'iradio_square-blue',
	      increaseArea: '20%' // optional
	    });
	  }); 
 


</script>
</body>
</html>