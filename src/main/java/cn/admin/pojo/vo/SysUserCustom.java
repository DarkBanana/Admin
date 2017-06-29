package cn.admin.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import cn.admin.pojo.po.SysRole;
import cn.admin.pojo.po.SysUser;

/**
 * 继承po扩展
 * @author qiaorenjie
 *
 */
public class SysUserCustom extends SysUser {

	private String roleName;

	private List<SysRole> roleList = new ArrayList<SysRole>();

	private String role; //取得的json的key id
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
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
