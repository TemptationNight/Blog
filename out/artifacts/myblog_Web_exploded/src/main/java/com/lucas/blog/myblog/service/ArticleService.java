package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: ArticleService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:03
 * @Version: 1.0
 */
public interface ArticleService {
	PageInfo<Article> getArticleByPage(Integer startPage, Integer pageSize);

	Integer addArticle(Article article);

	Integer deleteArticle(Integer id);

	List<Article> articleList();

	Integer updateArticle(Integer id, Article article);

	Integer upOrDownShilft(Integer id, Integer status);

	Integer downOrUpRecommend(Integer id, Integer status);

	Integer getArticleCount();

	Article getArticleById(Integer id);



	List<Article> getArticleTenByTime(); //最新文章
	Set<Article> getArticleByTop();      //置顶文章
	Set<Article> getArticleByRecommend();  //推荐文章

	List<Article> getArticleByBrowsers();  //点击排行



	HashSet<String> getKeywords(); //关键字


	//博客的浏览量+1
	Integer addBrowsersOne(Integer id);

	//文章的点赞量+1
	Integer addAgreeOne(Integer id);



	//根据type获取文章
	List<Article> getArticleByTypeName(String  typeName);

	//根据标签获取文章
	List<Article> getArticleByKeyWords(String keyWords);


	//全局搜索文章
	List<Article> searchBlog(String search);


	List<Article> getAll();



	//获取下一篇文章
	Article getNextOne(Integer id);


	//获取上一篇文章
	Article getPreOne(Integer id);



	//获取相似文章

	List<Article>  getLikeArticle(String type,String keyWords,String title,Integer id);





}
