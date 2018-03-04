package cn.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.jcraft.jsch.Session;

import cn.admin.pojo.po.SysUser;
import cn.admin.pojo.vo.SysUserCustom;
import cn.admin.pojo.vo.SysUserQueryVo;
import cn.admin.util.ResultInfo;
import cn.admin.util.ShiroUtils;

/**
 * login登录界面
 * @author qiaorenjie
 * @date 2017年6月12日 下午4:34:46
 *
 */
@Controller
public class LoginController {

	@Autowired 
	private Producer producer;
	
	/**
	 * Captcha验证码
	 * 
	 */
	@RequestMapping("captcha")
	public void captcha(HttpServletResponse response,HttpServletRequest request)throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        //ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);  //这样使用ShiroUtilsission不知为何报500错误
        
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
	}
	
	

	/**
	 * login
	 * @param request
	 * @throws Exception
	 */
	//Shiro获得报错信息用json传到前端msg
	@RequestMapping("login")
	public String loginSubmit(HttpServletRequest request, Model model)throws Exception{
		// 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		// 根据shiro返回的异常类路径判断，抛出指定异常信息
		if (exceptionClassName != null) {
			String msg = null;
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				msg = "账号不存在";
				model.addAttribute("msg", msg);
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				msg = "密码错误";
				model.addAttribute("msg", msg);
			} else if ("msg".equals(exceptionClassName)) {
				msg = "验证码错误";
				model.addAttribute("msg", msg);
//				request.getSession().setAttribute("msg", msg);
			} else {
				throw new Exception();// 最终在异常处理器生成未知错误
			}
		}
		// 登陆失败还到login页面去aaaabbbb
		return "login";
	}
	
	
	//退出
	@RequestMapping("logout")
	public String logout(){
		return "redirect:login";
	}
	
	

//	/**
//	 * 退出
//	 */
//	@RequestMapping(value = "logout", method = RequestMethod.GET)
//	public String logout() {
//		ShiroUtils.logout();
//		return "redirect:login.html";
//	}
	
}
