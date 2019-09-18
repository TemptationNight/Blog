package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.entity.Log;
import com.lucas.blog.myblog.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends MyMapper<Log> {
}