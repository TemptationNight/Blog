package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Picture;
import com.lucas.blog.myblog.service.ArticleService;
import com.lucas.blog.myblog.service.CategoryService;
import com.lucas.blog.myblog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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
	@Autowired
	private PictureService pictureServiceImpl;


	@Autowired
	private CategoryService categoryServiceImpl;
	@GetMapping("/articles")
	public String articles(Model model, Integer startPage, Integer pageSize) {
		PageInfo pageInfo = articleServiceImpl.getArticleByPage(startPage, pageSize);

		model.addAttribute("articlePageInfo", pageInfo);
		return "admin/blogs";
	}


	@SystemLog(description="删除博客:",actionType = ActionType.DELETE )
	@GetMapping("/delete/{id}/article")
	public String deleteArticle(@PathVariable Integer id) {
		int i = articleServiceImpl.deleteArticle(id);
		return "redirect:/admin/articles";
	}


	@SystemLog(description = "将博客下架:",actionType = ActionType.UNKNOWN)
	@GetMapping("/downShilft/{id}/article")
	public String downShilft(@PathVariable Integer id) {
		Integer i = articleServiceImpl.upOrDownShilft(id, 0);
		return "redirect:/admin/articles";
	}


	@SystemLog(description = "将博客上架:",actionType = ActionType.UNKNOWN)
	@GetMapping("/upShilft/{id}/article")
	public String upShilft(@PathVariable Integer id) {
		Integer i = articleServiceImpl.upOrDownShilft(id, 1);
		return "redirect:/admin/articles";
	}


	@SystemLog(description = "将博客置顶:",actionType = ActionType.UNKNOWN)
	@GetMapping("/upRecommend/{id}/article")
	public String upRecommend(@PathVariable Integer id) {
		Integer i = articleServiceImpl.downOrUpRecommend(id, 1);
		return "redirect:/admin/articles";
	}


	@SystemLog(description = "将博客取消置顶:",actionType = ActionType.UNKNOWN)
	@GetMapping("/downRecommend/{id}/article")
	public String downRecommend(@PathVariable Integer id) {
		System.out.println(id);
		Integer i = articleServiceImpl.downOrUpRecommend(id, 0);
		return "redirect:/admin/articles";
	}




	@GetMapping("/writeBlog")
	public String getPicture(Model model){
		List<Picture> pictures = pictureServiceImpl.getPictures();
		System.out.println(pictures.size());
		List<Category> categoryList = categoryServiceImpl.getCategoryList();
		System.out.println(categoryList);
		model.addAttribute("categoryList",categoryList);
		model.addAttribute("pictures", pictures);
		return "admin/write_blog";
	}



	@SystemLog(description = "添加一个博客:",actionType = ActionType.INSERT)
	@GetMapping("/addArticle")
	public String addArticle(Model model){

		return "admin/write_blog";
	}



	@GetMapping("/searchBlog")
	public String searchBlog(){
		return "/admin/search_blog";
	}

}
