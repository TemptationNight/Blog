package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends MyMapper<Article> {
}