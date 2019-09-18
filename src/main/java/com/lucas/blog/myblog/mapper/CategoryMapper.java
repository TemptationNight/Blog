package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper extends MyMapper<Category> {
}