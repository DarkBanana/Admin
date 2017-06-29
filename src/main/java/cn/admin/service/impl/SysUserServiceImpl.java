package cn.admin.service.impl;

import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.admin.mapper.SysUserMapper;
import cn.admin.mapper.SysUserMapperCustom;
import cn.admin.mapper.SysUserRoleMapper;
import cn.admin.pojo.po.SysRole;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.po.SysUserExample;
import cn.admin.pojo.po.SysUserExample.Criteria;
import cn.admin.pojo.po.SysUserRole;
import cn.admin.pojo.vo.SysUserCustom;
import cn.admin.pojo.vo.SysUserQueryVo;
import cn.admin.service.SysRoleService;
import cn.admin.service.SysUserService;
import cn.admin.util.RandomUtils;
import cn.admin.util.ResultInfo;
import cn.admin.util.UUIDBuild;



/**
 * 接口实现类，实现service接口
 * @author qiaorenjie
 *
 */
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapperCustom sysuserMapperCustom;
	@Autowired
	private SysUserMapper sysuserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleService sysRoleService;
	
	
	/**
	 *查询用户方法
	 */
	@Override
	public List<SysUser> queryUser(SysUserQueryVo sysuserQueryVo) throws Exception {
		
		return sysuserMapperCustom.findSysUserList(sysuserQueryVo);
	}

	/**
	 * 根据useraccount用户账号查询
	 */
	@Override
	public SysUser findByUserAccount (String useraccount) throws Exception{
	
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseraccountEqualTo(useraccount);
		List<SysUser> list = sysuserMapper.selectByExample(example);
		
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		
		return null;
	}
	
	/**
	 * 增加用户方法
	 */
	@Override
	public void addUser(SysUserCustom sysuserCustom) throws Exception {
		// 1.判断 useraccount用户账号是否重复
		String useraccount = sysuserCustom.getUseraccount();
		// 根据用户账号查询sysuser
		SysUser findByUserAccount = this
				.findByUserAccount(useraccount); 
		if (findByUserAccount != null) {
			// 用户账号已存在
			ResultInfo.error("用户账号已存在");
		}
		// 2.校验对应的角色信息
		String role = sysuserCustom.getRole();
		SysRole sysRole = sysRoleService.findSysRoleByRoleName(role);
		if (sysRole == null) {
			// 角色不存在
			ResultInfo.error("角色不存在");
		}
		// 角色的id
		String roleid = sysRole.getId();
		// new 一个 sysUser
		SysUser sysUser = new SysUser();
		String userid = new UUIDBuild().getUUID();
		// 密码 sha256 加密
		String password = sysuserCustom.getPassword();
		String salt = new RandomUtils().generateLowerString(4);
		String pwd_sha = new Sha256Hash(password, salt, 1).toString();
		sysUser.setPassword(pwd_sha);
		sysUser.setSalt(salt);
		// 设置 sysUser的基本属性
		sysUser.setId(userid);
		sysUser.setAge(sysuserCustom.getAge());
		sysUser.setDepartment(sysuserCustom.getDepartment());
		sysUser.setJobnumber(sysuserCustom.getJobnumber());
		sysUser.setPosition(sysuserCustom.getPosition());
		sysUser.setSex(sysuserCustom.getSex());
		sysUser.setTel(sysuserCustom.getTel());
		sysUser.setUseraccount(sysuserCustom.getUseraccount());
		sysUser.setUsername(sysuserCustom.getUsername());
		sysUser.setWorktype(sysuserCustom.getWorktype());
		sysuserMapper.insert(sysUser);
		
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setId(new UUIDBuild().getUUID());
		sysUserRole.setSysRoleId(role);
		sysUserRole.setSysUserId(userid);
		sysUserRoleMapper.insert(sysUserRole);
		
	}

	
	
	
	
	/**
	 * 删除用户方法
	 */
	@Override
	public void deleteUser(String id) throws Exception {
		// TODO Auto-generated method stub
		sysuserMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据id查询回显方法
	 */
	@Override
	public void queryByid(String id, SysUserCustom sysuserCustom ) throws Exception {
		// TODO Auto-generated method stub
		
		SysUser sysuser = sysuserMapper.selectByPrimaryKey(id);
		
		sysuserCustom.setUseraccount(sysuser.getUseraccount());
		sysuserCustom.setUsername(sysuser.getUsername());
		sysuserCustom.setSex(sysuser.getSex());
		sysuserCustom.setJobnumber(sysuser.getJobnumber());
		sysuserCustom.setDepartment(sysuser.getDepartment());
		sysuserCustom.setTel(sysuser.getTel());
		sysuserCustom.setNote(sysuser.getNote());
		
				
	}

	/**
	 * 修改用户方法
	 */
	@Override
	public void editUser(String id, SysUserCustom sysuserCustom) throws Exception {
		
		sysuserMapper.updateByPrimaryKey(sysuserCustom);
	}

	
	
	
	

	

	

}
