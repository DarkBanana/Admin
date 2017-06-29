package cn.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.admin.mapper.SysRoleMapper;
import cn.admin.mapper.SysRoleMapperCustom;
import cn.admin.pojo.po.SysRole;
import cn.admin.pojo.po.SysRoleExample;
import cn.admin.pojo.vo.SysRoleCustom;
import cn.admin.service.SysRoleService;

/**
 * 认证授权实现类 
 * @author qiaorenjie
 * @date 2017年6月6日 上午11:26:11
 *
 */
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleMapperCustom sysRoleMapperCustom;
	
	/**
	 * 根据角色名称 查询 角色
	 */
	@Override
	public SysRole findSysRoleByRoleName(String role) throws Exception {
		SysRoleExample sysRoleExample = new SysRoleExample();
		SysRoleExample.Criteria criteria = sysRoleExample.createCriteria();
		criteria.andIdEqualTo(role);
		List<SysRole> roleList = sysRoleMapper.selectByExample(sysRoleExample);

		if (roleList != null && roleList.size() == 1) {
			return roleList.get(0);
		}

		return null;
	}

	@Override
	public List<SysRoleCustom> findSysRoleList(SysRoleCustom sysRoleCustom) {
		return sysRoleMapperCustom.findSysRoleList(sysRoleCustom);
	}

	
	
	

}
