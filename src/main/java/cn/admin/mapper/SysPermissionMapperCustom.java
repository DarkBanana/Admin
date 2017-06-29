package cn.admin.mapper;

import cn.admin.pojo.po.SysPermission;
import cn.admin.pojo.po.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapperCustom {

	//根据用户id查询菜单
	List<SysPermission> findMenuListByUserId(String userid);
	
	//根据用户id查询权限url
	List<SysPermission> findPermissionListByUserId(String userid);
   
}