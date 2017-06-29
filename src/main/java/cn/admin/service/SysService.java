package cn.admin.service;

import java.util.List;

import cn.admin.pojo.po.SysPermission;
import cn.admin.pojo.po.SysUser;

/**
 * 认证授权接口
 * @author qiaorenjie
 * @date 2017年6月6日 上午11:23:26
 *
 */
public interface SysService {

	//根据用户账号查询用户信息
	SysUser findSysUserByuseraccount(String useraccount) throws Exception;

	//根据用户id查找权限menu
	List<SysPermission> findMenuListByUserId(String userid) throws Exception;

	//根据用户id查找权限范围url
	List<SysPermission> findPermissionListByUserId(String userid) throws Exception;



	
	
}
