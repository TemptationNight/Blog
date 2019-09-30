package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;

import java.util.List;

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
}
