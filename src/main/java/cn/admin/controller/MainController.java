package cn.admin.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.admin.pojo.vo.ActiveUser;

/**
 * 登录index首页
 * @author qiaorenjie
 *
 */
@Controller
public class MainController {

	@RequestMapping("/main")
	public String first(Model model){
		
		// 从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		// 取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		// 通过model传到页面
		model.addAttribute("activeUser", activeUser);
		
		return "/user/queryuser";
	}
	
}
