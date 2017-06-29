package cn.admin.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.SessionScope;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jcraft.jsch.Session;
import com.sun.org.apache.xpath.internal.operations.Mod;

import cn.admin.pojo.po.SysRole;
import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.vo.PageQuery;
import cn.admin.pojo.vo.SysRoleCustom;
import cn.admin.pojo.vo.SysUserCustom;
import cn.admin.pojo.vo.SysUserQueryVo;
import cn.admin.process.result.DataGridResultInfo;
import cn.admin.service.SysRoleService;
import cn.admin.service.SysUserService;
import cn.admin.util.DatatablesView;
import cn.admin.util.PageUtils;
import cn.admin.util.Query;
import cn.admin.util.ResultInfo;
import cn.admin.util.Result;
import cn.admin.util.UUIDBuild;


/**
 * 开始用户显示界面
 * @author qiaorenjie
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private SysUserService sysuserService;
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("/query")
	public String query() throws Exception{
		return "user/queryuser";
	}
	
	/**
	 * 查询用户
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/queryuser")	 //value="/queryuser", produces = "text/json;charset=UTF-8"
	@ResponseBody
	public String queryUser(SysUserQueryVo sysuserQueryVo) throws Exception {
		
	   List<SysUser> dataTable = sysuserService.queryUser(sysuserQueryVo);
	   Map<String,Object> map=new HashMap<String, Object>();
	   map.put("data", dataTable);
//	   map.put("draw", 0);
//	   map.put("recordsTotal", dataTable.size());
//	   map.put("recordsFiltered", dataTable.size());
	   String data = JSON.toJSONString(map);
	    
	    System.out.println("data" + data);
	    return data;
	}

	//添加查询
	@RequestMapping( value="/queryadduser" , produces = "text/html;charset=UTF-8" )
	@ResponseBody
	public String queryadduser(Model model) throws Exception {

		// 所有的 的 角色信息
		List<SysRoleCustom> sysRoleCustomList = sysRoleService
				.findSysRoleList(null);
		List<SysRole> roleList = new ArrayList<SysRole>();
		// 将sysRoleCustomList 中的数据放到 sysRole 中
		if (sysRoleCustomList != null) {
			for (SysRoleCustom sysRoleCustom : sysRoleCustomList) {
				SysRole sysRole = new SysRole();
				sysRole.setId(sysRoleCustom.getId());
				sysRole.setName(sysRoleCustom.getName());
				roleList.add(sysRole);
			}
		}
		model.addAttribute(roleList);
		
		String data = JSON.toJSONString(roleList);
		
		System.out.println("data" + data);
		return data;
	}
	
	/**
	 * 添加用户提交
	 * @param sysuserCustom
	 */
	@RequestMapping("/adduser")
	@ResponseBody
	public ResultInfo adduser(SysUserCustom sysuserCustom , Model model) throws Exception{
		//查询role
		
		sysuserService.addUser(sysuserCustom);
		
		return ResultInfo.ok() ;
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/deluser")
	@ResponseBody
	public ResultInfo deluser(String id) throws Exception{
		System.out.println(id);
		sysuserService.deleteUser(id);
		return ResultInfo.ok();
	}
	
	/**
	 * 修改回显
	 * @param id
	 * @param sysuserCustom
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/findbyid")  //url传中文乱码不好解决，传id查了赋值
	public String findbyid(String id , SysUserCustom sysuserCustom) throws Exception {

		sysuserService.queryByid(id , sysuserCustom);
		
		return "edituser";
	}
	
	/**
	 * 修改用户
	 * @param id
	 * @param sysuserCustom
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/edituser")
	@ResponseBody
	public ResultInfo edituser(String id , SysUserCustom sysuserCustom) throws Exception{
		System.out.println(id +"AND"+ sysuserCustom);
		sysuserService.editUser(id, sysuserCustom);
		return ResultInfo.ok();
	}
	
	
}
