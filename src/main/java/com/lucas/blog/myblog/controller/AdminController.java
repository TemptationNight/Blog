package com.lucas.blog.myblog.controller;

import com.lucas.blog.myblog.entity.Admin;
import com.lucas.blog.myblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller
 * @ClassName: AdminController
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/5 9:55
 * @Version: 1.0
 */


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminServiceImpl;

	/*@ResponseBody
	@GetMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {

		Admin adminer = adminServiceImpl.login(password);
		return adminer == null ? "login" : "admin/index";
	}*/



	/*@RequestMapping("/searchBlog")
	public String searchBlog(){

		return "search_blog";
	}*/



	//注册
	public static  String reg(String username,String password){
		return null;
	}


}


