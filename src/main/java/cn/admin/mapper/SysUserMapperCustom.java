package cn.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.github.pagehelper.Page;

import cn.admin.pojo.po.QueryCondition;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.vo.SysUserCustom;
import cn.admin.pojo.vo.SysUserQueryVo;
import cn.admin.util.DatatablesView;

/**
 * 自定义mapper接口
 * @author qiaorenjie
 *
 */
public interface SysUserMapperCustom {
	

	// 查询 所有 系统用户 ，要包括 角色名称
	public List<SysUser> findSysUserList(SysUserQueryVo sysUserQueryVo);


	
}