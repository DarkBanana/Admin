package cn.admin.service;

import java.util.List;

import cn.admin.pojo.po.SysRole;
import cn.admin.pojo.vo.SysRoleCustom;

/**
 * service接口，便于扩展
 * @author qiaorenjie
 *
 */
public interface SysRoleService {

	// 根据 角色 名查找角色信息
	public SysRole findSysRoleByRoleName(String roleName) throws Exception;

	// 查询用户列表
	public List<SysRoleCustom> findSysRoleList(SysRoleCustom sysRoleCustom);



	

}
