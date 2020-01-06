package com.lucas.blog.myblog.controller;

import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Comment;
import com.lucas.blog.myblog.service.ArticleService;
import com.lucas.blog.myblog.service.CommentService;
import com.lucas.blog.myblog.service.LinkService;
import com.lucas.blog.myblog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller
 * @ClassName: ArticleControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:34
 * @Version: 1.0
 */
@Controller
@RequestMapping("/page")
public class ArticleController {


	@Autowired
	private ArticleService articleServiceImpl;


	@Autowired
	private LinkService linkServiceImpl;

	@Autowired
	private IndexController indexController;


	@Autowired
	private CommentService componentImpl;


	//在获取文章详情的时候将浏览量顺便+1
	@RequestMapping("/{id}/blogDetail")
	public String getBlogDetails(@PathVariable Integer id, Model model) {
		indexController.getRightInfo(model);
		//浏览量+1
		Integer integer = articleServiceImpl.addBrowsersOne(id);
		//获取当前文章
		Article article = articleServiceImpl.getArticleById(id);
		//获取上一篇文章
		Article preOne = articleServiceImpl.getPreOne(id);
		//获取下一篇文章
		Article nextOne = articleServiceImpl.getNextOne(id);
		//获取相关文章
		List<Article> likeArticles = articleServiceImpl.getLikeArticle(article.getCategoryName(), article.getKeyword(), article.getTitle(), id);
		//获取文章的评论
		List<Comment> commentList = componentImpl.getCommentsByBlogId(id);
		String articleType = article.getCategoryName();
		String articleName = article.getTitle();
		//将文章的内容转成html
		String content = MarkdownUtils.markdownToHtml(article.getContent());
		article.setContent(content);
		model.addAttribute("article", article)
				.addAttribute("articleType", articleType)
				.addAttribute("articleName", articleName)
				.addAttribute("nextOne", nextOne)
				.addAttribute("preOne", preOne)
				.addAttribute("likeArticles", likeArticles)
				.addAttribute("commentList", commentList);
		return "page/blog_detail";
	}


	//点赞量+1
	@PutMapping("/addAgreeOne")
	public String addAgreeOne(Integer id, Map<String, Integer> map, Model model) {
		Integer integer = articleServiceImpl.addAgreeOne(id);
		Article article = articleServiceImpl.getArticleById(id);
		model.addAttribute("article", article);
		return "page/blog_detail::agree";
	}


	//根据分类局部刷新文章
	@GetMapping("/refreshByBlogType")
	public String getBlogByType(String typeName, Model model) {
		System.out.println(typeName);
		List<Article> blogList = articleServiceImpl.getArticleByTypeName(typeName);
		model.addAttribute("articleList", blogList);
		return "page/learn_more::blogArea";
	}


	//根据标签局部刷新文章
	@GetMapping("/refreshByKeyWord")
	public String getBlogByKeyWorks(String keyWord, Model model) {
		System.out.println(keyWord);
		List<Article> blogList = articleServiceImpl.getArticleByKeyWords(keyWord);
		model.addAttribute("articleList", blogList);
		return "page/learn_more::blogArea";
	}


	//根据关键字全局搜索局部刷新文章
	@GetMapping("/refreshSearchBLog")
	public String searchBlogs(String args, Model model) {
		List<Article> blogList = articleServiceImpl.searchBlog(args);
		model.addAttribute("articleList", blogList);
		return "page/learn_more::blogArea";
	}


}
