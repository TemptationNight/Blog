package com.lucas.blog.myblog.controller;


import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Link;
import com.lucas.blog.myblog.service.ArticleService;
import com.lucas.blog.myblog.service.CategoryService;
import com.lucas.blog.myblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

@RequestMapping("/page")
public class IndexController {

	@Autowired
	private ArticleService articleServiceImpl;

	@Autowired
	private LinkService linkServiceImpl;

	@Autowired
	private CategoryService categoryServiceImpl;

	//到主页
	@GetMapping("/index")
	public String index(Model model) {
		//获取页面正文所需的文章信息
		List<Article> articleTenByTime = articleServiceImpl.getArticleTenByTime();
		//获取侧边栏信息
		getRightInfo(model);
		model.addAttribute("articleList", articleTenByTime);
		return "page/index";
	}


	//到关于我界面
	@GetMapping("/about")
	public String toAbout() {
		return "/page/about";
	}


	//到图片展示界面
	@GetMapping("/images")
	public String show_images() {
		return "page/show_image";
	}


	//到学无止境展示界面
	@GetMapping("/learnMore")
	public String learn_more(Model model, String args) {
		//加载右侧边栏
		getRightInfo(model);
		//根据typeName获取文章
		List<Article> articleByTypeName = articleServiceImpl.getArticleByTypeName(args);
		System.out.println(articleByTypeName);
		model.addAttribute("articleList", articleByTypeName)
				.addAttribute("typeName", args);
		return "page/learn_more";
	}


	//到时间轴界面   获取所有的文章
	@GetMapping("/timeLine")
	public String timeLine(Model model) {
		List<Article> articles = articleServiceImpl.getAll();
		model.addAttribute("articles", articles);
		return "page/timeLine";
	}

	//到留言界面
	@GetMapping("/message")
	public String message() {
		return "page/message";
	}


	//到技术分享界面
	@GetMapping("/tech_share")
	public String tech_share(Model model, String typeName) {
		typeName = "数据结构";
		//加载右侧边栏
		getRightInfo(model);
		//根据typeId获取文章
		List<Article> articleByTypeName = articleServiceImpl.getArticleByTypeName(typeName);
		model.addAttribute("articleList", articleByTypeName).addAttribute("typeName", typeName);
		return "page/tech_share";
	}


	//慢生活页面
	@GetMapping("/share_life")
	public String show_life(Model model) {
		String typeName = "生活";
		getRightInfo(model);
		List<Article> blogList = articleServiceImpl.getArticleByTypeName(typeName);
		model.addAttribute("articleList", blogList);
		return "page/slow_life";
	}

	//杂谈页面
	@GetMapping("/other")
	public String other(Model model) {
		//加载侧边栏
		String typeName = "杂谈";
		getRightInfo(model);
		List<Article> blogList = articleServiceImpl.getArticleByTypeName(typeName);
		model.addAttribute("articleList", blogList);
		return "page/other";
	}


	//根据分类获取文章
	@GetMapping("/{typeName}/getBlogTypeName")
	public String getBlogByType(@PathVariable String typeName, Model model) {
		List<Article> blogList = articleServiceImpl.getArticleByTypeName(typeName);
		model.addAttribute("articleList", blogList);
		getRightInfo(model);
		return "page/learn_more";
	}


	//根据标签获取文章
	@GetMapping("/{keyword}/getBlogKeyWord")
	public String getBlogByKeyWorks(@PathVariable String keyword, Model model) {
		List<Article> blogList = articleServiceImpl.getArticleByKeyWords(keyword);
		model.addAttribute("articleList", blogList);
		getRightInfo(model);
		return "page/learn_more";
	}


	//根据关键字全局搜索文章
	@GetMapping("/searchBLog")
	public String searchBlogs(@RequestParam("args") String args, Model model) {
		List<Article> blogList = articleServiceImpl.searchBlog(args);
		model.addAttribute("articleList", blogList);
		getRightInfo(model);
		return "page/learn_more";
	}


	//获取右边侧边栏的信息
	public void getRightInfo(Model model) {


		List<Article> slowLife = articleServiceImpl.getArticleByTypeName("生活");
		List<Article> list=new ArrayList<>();


		for(int i=0;i<2; i++){
			list.add(slowLife.get(i));
		}

		System.out.println("====================="+list.size());


		Set<Article> articleByRecommend = articleServiceImpl.getArticleByRecommend();
		Article recommendTop = articleByRecommend.iterator().next();//获取set集合的第一个元素  并把它放在推荐文章最上面的大框框中
		articleByRecommend.remove(recommendTop);//删除第一个元素
		Set<Article> articleByTop = articleServiceImpl.getArticleByTop();     //置顶文章随机三篇
		List<Article> articleByBrowsers = articleServiceImpl.getArticleByBrowsers();
		Article browseTop = articleByBrowsers.get(0); //获取list集合的第一个元素  并把它放在点击量文章最上面的大框框中
		articleByBrowsers.remove(browseTop); //删除第一个元素
		HashSet<String> keywords = articleServiceImpl.getKeywords();
		List<Link> linkList = linkServiceImpl.getLinkList();
		List<Category> typeList = categoryServiceImpl.getCategoryList();
		model.addAttribute("articleByRecommend", articleByRecommend)
				.addAttribute("articleByTop", articleByTop)
				.addAttribute("articleByBrowsers", articleByBrowsers)
				.addAttribute("keywords", keywords)
				.addAttribute("linkList", linkList)
				.addAttribute("recommendTop", recommendTop)
				.addAttribute("browseTop", browseTop)
				.addAttribute("typeList", typeList)
				.addAttribute("slowLife",list);
	}
}




