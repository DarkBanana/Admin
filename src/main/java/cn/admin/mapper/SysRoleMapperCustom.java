package cn.admin.mapper;

import java.util.List;

import cn.admin.pojo.vo.SysRoleCustom;

/**
 * 自定义mapper接口
 * @author qiaorenjie
 *
 */
public interface SysRoleMapperCustom {

	//查询角色
	List<SysRoleCustom> findSysRoleList(SysRoleCustom sysRoleCustom);
	


	
}