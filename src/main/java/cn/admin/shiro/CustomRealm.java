package cn.admin.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.admin.pojo.po.SysPermission;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.vo.ActiveUser;
import cn.admin.service.SysService;

/**
 * 自定义Realm
 * @author qiaorenjie
 *
 */
public class CustomRealm extends AuthorizingRealm {

	//service注入
	@Autowired
	private SysService sysService;
	
	// 设置realm的名称
		@Override
		public void setName(String name) {
			super.setName("customRealm");
		}
	
	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		// token是用户输入的
		// 第一步 从token中取出身份信息

		String useraccount = (String) token.getPrincipal();
		// 第二步 根据用户输入的useraccount从数据库查询
		SysUser sysuser = null;
		try{
			sysuser = sysService.findSysUserByuseraccount(useraccount);
		}catch(Exception e){
			e.printStackTrace();
		}
		// 如果查询不到返回null
		if (sysuser == null) {
			return null;
		}
		// 从数据库查询到密码
		String password = sysuser.getPassword();
		// 加盐
		String salt = sysuser.getSalt();
		// 如果查询到返回认证信息AuthenticationInfo
		// ActiveUser 用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysuser.getId());
		activeUser.setUseraccount(sysuser.getUseraccount());
		activeUser.setUsername(sysuser.getUsername());
		
		// 根据用户id取出菜单
		List<SysPermission> menus = null;
		try {
			// 通过service取出菜单
			menus = sysService.findMenuListByUserId(sysuser.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 将用户菜单设置到ActiveUser
		activeUser.setMenus(menus);
		
		// 将ActiveUser设置到simpleAuthenticationInfo
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				activeUser,password, ByteSource.Util.bytes(salt),
				this.getName());
		
		return simpleAuthenticationInfo;
		
	}
	
			
	
		/**
		 * 授权(验证权限时调用)
		 */
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(
				PrincipalCollection principals) {

			// 从 principals获取主身份信息
			// 将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
			ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();

			// 根据身份信息获取权限信息
			// 从数据库获取到权限数据
			List<SysPermission> permissionList = null;
			try {
				permissionList = sysService.findPermissionListByUserId(activeUser
						.getUserid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 单独定一个集合对象
			List<String> permissions = new ArrayList<String>();
			if (permissionList != null) {
				for (SysPermission sysPermission : permissionList) {
					// 将数据库中的权限标签 符放入集合
					permissions.add(sysPermission.getPercode());
				}
			}

			// 查到权限数据，返回授权信息(要包括 上边的permissions)
			SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			// 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
			simpleAuthorizationInfo.addStringPermissions(permissions);

			return simpleAuthorizationInfo;
		}

		// 清除缓存
		public void clearCached() {
			PrincipalCollection principals = SecurityUtils.getSubject()
					.getPrincipals();
			super.clearCache(principals);
		}
	

}
