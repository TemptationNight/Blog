package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitorMapper extends MyMapper<Visitor> {
}