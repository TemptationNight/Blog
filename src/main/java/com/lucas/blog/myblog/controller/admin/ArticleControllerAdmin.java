package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller.admin
 * @ClassName: ArticleControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:37
 * @Version: 1.0
 */


@Controller
@RequestMapping("/admin")
public class ArticleControllerAdmin {

	@Autowired
	private ArticleService articleServiceImpl;




	@GetMapping("/articles")
	public String articles(Model model,Integer startPage,Integer pageSize){
		PageInfo pageInfo=articleServiceImpl.getArticleByPage(startPage,pageSize);
		model.addAttribute("articlePageInfo",pageInfo);
		return "admin/blogs";
	}


	@GetMapping("/addArticle")
	public String add(){
		return "admin/write_blog";
	}

	@GetMapping("/delete/{id}/article")
	public String deleteArticle(@PathVariable Integer id){
		int i=articleServiceImpl.deleteArticle(id);
		return "redirect:/admin/articles";
	}


	@GetMapping("/downShilft/{id}/article")
	public String downShilft(@PathVariable Integer id){
		Integer i = articleServiceImpl.upOrDownShilft(id,0);
		return "redirect:/admin/articles";
	}


	@GetMapping("/upShilft/{id}/article")
	public String upShilft(@PathVariable Integer id){
		Integer i = articleServiceImpl.upOrDownShilft(id,1);
		return "redirect:/admin/articles";
	}



	@GetMapping("/upRecommend/{id}/article")
	public String upRecommend(@PathVariable Integer id){
		Integer i=articleServiceImpl.downOrUpRecommend(id,1);
		return "redirect:/admin/articles";
	}


	@GetMapping("/downRecommend/{id}/article")
	public String downRecommend(@PathVariable Integer id){
		System.out.println(id);
		Integer i=articleServiceImpl.downOrUpRecommend(id,0);
		return "redirect:/admin/articles";
	}





}
