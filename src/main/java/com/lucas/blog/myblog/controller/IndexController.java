package com.lucas.blog.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller
 * @ClassName: IndexController
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/3 20:42
 * @Version: 1.0
 */





@Controller
@RequestMapping("/customer")
public class IndexController {
	@GetMapping("/index")
	public String  index(){
		System.out.println("index");
		return "index";
	}
}




