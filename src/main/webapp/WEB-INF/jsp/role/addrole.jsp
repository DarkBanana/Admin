<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<!-- 添加用户 -->
<div id="addUserLayer" style="display: none; width: 600px" >
	<form class="form-horizontal" >
	<div class="form-group" >
			
		<br>
		<div class="form-group">
		   <div class="col-sm-2 control-label">用户账号</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="useraccount" placeholder="用户账号" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">密码</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="password" placeholder="密码" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">用户名称</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control" v-model="username"  placeholder="用户名称" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">性别</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control" v-model="sex"  placeholder="性别" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">年龄</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="age" placeholder="年龄" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">工号</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="jobnumber" placeholder="工号" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">部门</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control" v-model="department"  placeholder="部门" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">电话</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control" v-model="tel"  placeholder="电话" style="width:180px;"/>
		    </div>
		</div>
		
		<div class="form-group">
		   	<div class="col-sm-2 control-label">工种</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="worktype" placeholder="工种" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">职称</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="position" placeholder="职称" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">角色</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control" v-model="role"  placeholder="角色" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">备注</div>
		   	<div class="col-sm-10">
		      <input type="text" class="form-control"  v-model="note" placeholder="备注" style="width:180px;"/>
		    </div>
		</div>

		
	</div>
	</form>
</div>


</body>
</html>

  
  