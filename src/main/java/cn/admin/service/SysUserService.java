package cn.admin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.admin.pojo.po.QueryCondition;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.vo.SysUserCustom;
import cn.admin.pojo.vo.SysUserQueryVo;
import cn.admin.util.DatatablesView;
import cn.admin.util.Query;
import cn.admin.util.Result;

/**
 * service接口，便于扩展
 * @author qiaorenjie
 *
 */
public interface SysUserService {


	List<SysUser> queryUser(SysUserQueryVo sysuserQueryVo) throws Exception;

	void addUser(SysUserCustom sysuserCustom) throws Exception;

	void deleteUser(String id) throws Exception;

	void editUser(String id, SysUserCustom sysuserCustom) throws Exception;


	void queryByid(String id, SysUserCustom sysuserCustom) throws Exception;

	
	SysUser findByUserAccount(String useraccount) throws Exception;


	

}
