package cn.admin.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import cn.admin.pojo.po.SysRole;

public class SysRoleCustom extends SysRole {

	private String roleName;
	
	private List<SysRole> roleList = new ArrayList<SysRole>();
	

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<SysRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}
	
	
	
}
