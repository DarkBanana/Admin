package cn.admin.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.google.code.kaptcha.Constants;

import cn.admin.util.ShiroUtils;


/**
 * 
 * @author 202
 * 
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

	// 原FormAuthenticationFilter的认证方法
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response ) throws Exception {
		// 在这里进行验证码的校验
		// 从session获取正确验证码

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		// 取出session的验证码（正确的验证码）
		//String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY); //这样使用ShiroUtilsission不知为何报500错误
		String kaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// 取出页面的验证码
		// 输入的验证和session中的验证进行对比
		String captcha = httpServletRequest.getParameter("captcha");
		if (captcha != null && kaptcha != null
				&& !captcha.equals(kaptcha)) {
			// 如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
			httpServletRequest.setAttribute("shiroLoginFailure",
					"msg");
			// 拒绝访问，不再校验账号和密码
			return true;
		}
		//验证码正确，调用父类的onAccessDenied方法进行username和password的校验
		return super.onAccessDenied(request, response);
	}

}
