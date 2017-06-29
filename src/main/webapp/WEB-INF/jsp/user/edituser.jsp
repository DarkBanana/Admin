<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<div  id="editUserLayer" style="display: none;"   >
	<form  class="form-horizontal" id="ajaxedit"  >
	<div class="form-group" >
			
		<br>
		<div class="form-group">
		   <div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     用户账号 &nbsp;:&nbsp;&nbsp; <input type="text" id="useraccount" name="useraccount" value="${sysuserCustom.useraccount}" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     用户名称 &nbsp;:&nbsp;&nbsp;<input type="text"  id="username"   name="username" value="${sysuserCustom.username }"   style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		      性别 &nbsp;:&nbsp;&nbsp;<input type="text" id="sex" value="${sysuserCustom.sex }" name="sex" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     工号 &nbsp;:&nbsp;&nbsp;<input type="text"   id="jobnumber" value="${sysuserCustom.jobnumber }" name="jobnumber" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     部门 &nbsp;:&nbsp;&nbsp;<input type="text" id="department"  name="department" value="${sysuserCustom.department }"  style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     电话 &nbsp;:&nbsp;&nbsp;<input type="text"   id="tel" name="tel" value="${sysuserCustom.tel }" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     角色 &nbsp;:&nbsp;&nbsp;<input type="text"   id="role" name="role" value="${sysuserCustom.role }" style="width:180px;"/>
		    </div>
		</div>
		<div class="form-group">
		   	<div class="col-sm-2 control-label">&nbsp;</div>
		   	<div class="col-sm-10">
		     备注 &nbsp;:&nbsp;&nbsp;<input type="text"    id="note" name="note" value="${sysuserCustom.note }" style="width:180px;"/>
		    </div>
		</div>
		
		
	</div>
	</form>
</div>