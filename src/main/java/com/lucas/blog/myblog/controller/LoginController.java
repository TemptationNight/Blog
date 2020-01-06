package com.lucas.blog.myblog.controller;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.controller.admin
 * @ClassName: LoginControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 15:25
 * @Version: 1.0
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: myblog
 * @ClassName: LoginControllerAdmin
 * @author: Lucas
 * @create: 2019-12-30 15:25
 **/


@Controller
@RequestMapping("/page")
public class LoginController {


	//跳转到登录页面
	@GetMapping("/login")
	public String login() {
		return "page/login";
	}


	//执行登录认证逻辑
	@PostMapping("/sign_in")
	public String sign_in(String username, String password, Model model) {
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			//主体提交登录请求到SecurityManager
			subject.login(token);
			return "redirect:/admin/index";
		} catch (IncorrectCredentialsException ice) {
			model.addAttribute("msg", "密码不正确");
			return "/page/login";
		} catch (UnknownAccountException uae) {
			model.addAttribute("msg", "账号不存在");
			return "/page/login";
		} catch (AuthenticationException ae) {
			model.addAttribute("msg", "状态不正常");
			return "/page/login";
		}

	}

}
