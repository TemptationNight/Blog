package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.MyMapper;
import com.lucas.blog.myblog.entity.Article;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper extends MyMapper<Article> {

	//查询最新发布的top10
	@Select("select * from article order by addTime desc LIMIT 10")
	List<Article> getArticleTenByTime();


	//获取点击量的top5
	@Select("select * from article order by browsenum desc LIMIT 4")
	List<Article> getArticleByBrowsers();

	@Select("select * from article where id = (select MAX( id) from article where id < #{id}) ")
	Article getPreOne(Integer id);


	@Select("select * from article where id = (select  MIN( id)  from article where id > #{id} )")
	Article getNextOne(Integer id);




}