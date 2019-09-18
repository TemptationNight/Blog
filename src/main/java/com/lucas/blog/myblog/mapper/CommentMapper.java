package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.entity.Comment;
import com.lucas.blog.myblog.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends MyMapper<Comment> {
}