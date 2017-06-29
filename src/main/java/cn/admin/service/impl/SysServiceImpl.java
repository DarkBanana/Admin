package cn.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.admin.mapper.SysPermissionMapperCustom;
import cn.admin.mapper.SysUserMapper;
import cn.admin.mapper.SysUserMapperCustom;
import cn.admin.pojo.po.SysPermission;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.po.SysUserExample;
import cn.admin.pojo.po.SysUserExample.Criteria;
import cn.admin.service.SysService;

/**
 * 认证授权实现类 
 * @author qiaorenjie
 * @date 2017年6月6日 上午11:26:11
 *
 */
@Service("SysService")
public class SysServiceImpl implements SysService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	
	@Override
	public SysUser findSysUserByuseraccount(String useraccount) throws Exception {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseraccountEqualTo(useraccount);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		
		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception {
		return sysPermissionMapperCustom.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {
		return sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

	
	

}
