package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Picture;
import com.lucas.blog.myblog.service.ArticleService;
import com.lucas.blog.myblog.service.CategoryService;
import com.lucas.blog.myblog.service.PictureService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	private CategoryService getCategoryServiceImpl;


	@Autowired
	private CategoryService categoryServiceImpl;

	@GetMapping("/articles")
	public String articles(Model model, Integer startPage, Integer pageSize) {
		PageInfo pageInfo = articleServiceImpl.getArticleByPage(startPage, pageSize);
		int articleCount = articleServiceImpl.getArticleCount();
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("articlePageInfo", pageInfo);
		return "admin/blogs";
	}


	@RequiresRoles(value={"root"})
	@SystemLog(description = "删除动态:", actionType = ActionType.DELETE)
	@PostMapping("/delete/article")
	public String deleteArticle( Integer id) {
		int i = articleServiceImpl.deleteArticle(id);
		return "redirect:/admin/articles";
	}


	@RequiresRoles(value={"root"})
	@SystemLog(description = "将动态隐藏:", actionType = ActionType.UNKNOWN)
	@PostMapping("/downShilft/article")
	public String downShilft( Integer id) {
		Integer i = articleServiceImpl.upOrDownShilft(id, 0);
		return "redirect:/admin/articles";
	}


	@RequiresRoles(value={"root"})
	@SystemLog(description = "将动态发布上架:", actionType = ActionType.UNKNOWN)
	@PostMapping("/upShilft/article")
	public String upShilft( Integer id) {
		Integer i = articleServiceImpl.upOrDownShilft(id, 1);
		return "redirect:/admin/articles";
	}

	@RequiresRoles(value={"root"})
	@SystemLog(description = "将动态推荐:", actionType = ActionType.UNKNOWN)
	@PostMapping("/upRecommend/article")
	public String upRecommend( Integer id) {
		Integer i = articleServiceImpl.downOrUpRecommend(id, 1);
		return "redirect:/admin/articles";
	}


	@RequiresRoles(value={"root"})
	@SystemLog(description = "将动态取推荐:", actionType = ActionType.UNKNOWN)
	@PostMapping("/downRecommend/article")
	public String downRecommend( Integer id) {

		Integer i = articleServiceImpl.downOrUpRecommend(id, 0);
		return "redirect:/admin/articles";
	}


	@PostMapping("/addArticle")
	public String addArticle(Model model) {
		return "admin/write_blog";
	}


	@GetMapping("/searchBlog")
	public String searchBlog() {
		return "/admin/search_blog";
	}


	//写博客获取首图图片
	@GetMapping("/writeBlog")
	public String getPicture(Model model) {
		List<Picture> pictures = pictureServiceImpl.getPictures();
		List<Category> categoryList = categoryServiceImpl.getCategoryList();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("pictures", pictures);
		return "admin/write_blog";
	}


	//发布博客
	@SystemLog(description = "添加一个动态:", actionType = ActionType.INSERT)
	@RequiresRoles(value = "root")
	@PostMapping("/upBlog")
	public String upBlog(HttpServletRequest request,Article article, @RequestParam("typename") String typename, Model model) {

		System.out.println("啥子情况哟这个是");

		Category category = categoryServiceImpl.getCategoryByName(typename);
		int typeId = category.getId();
		Article ar = new Article();   //在构造器中初始化了很多属性  所以只需要把这些传过来的属性值放进去就好了
		ar.setCategoryid(typeId);
		ar.setCategoryName(typename);
		ar.setTitle(article.getTitle());
		ar.setIstop(article.getIstop());
		ar.setIsrecommend(article.getIsrecommend());
		ar.setImages(article.getImages());
		ar.setContent(article.getContent());
		ar.setIsDiscuss(article.getIsDiscuss());
		ar.setKeyword(article.getKeyword());
		ar.setIsYuanChuang(article.getIsYuanChuang());
		ar.setSummary(article.getSummary());

		HttpSession session=request.getSession();
		ar.setAuthor((String) session.getAttribute("username"));
		Integer i = articleServiceImpl.addArticle(ar);


		System.out.println(i+"================================");
		return "admin/write_blog";
	}
}
