<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <header class="main-header">
    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
         
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs"> 管理员:${activeUser.username} </span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                <p>
                  您好：${activeUser.username} 
                  <small id="time">现在是: </small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">文件</a>
                </div>
                <div class="pull-right">
                  <a href="${pageContext.request.contextPath}/logout.action" class="btn btn-default btn-flat">退出系统</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" ><i class="fa fa-gears"></i> &nbsp;帮助</a>
          </li>
          <li>
          <a href="logout"><i class="fa fa-sign-out"></i> &nbsp;退出系统</a>
          </li>
          
        </ul>
      </div>
    </nav>
  </header>
  
<script type="text/javascript">

// 时间方法
function t(){
var now= new Date();
var y=now.getFullYear();
var mo=now.getMonth()+1;
var da=now.getDate();
var h=now.getHours();
var m=now.getMinutes();
var s=now.getSeconds(); 

var tt=y+"/"+mo+"/"+da+"-"+h+":"+m+":"+s;
document.getElementById("time").value=tt;
}
setInterval('t()',500);

</script>