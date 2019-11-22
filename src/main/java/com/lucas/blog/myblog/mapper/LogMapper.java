package com.lucas.blog.myblog.mapper;

import com.lucas.blog.myblog.MyMapper;
import com.lucas.blog.myblog.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface LogMapper extends MyMapper<Log> {
	//按条件查询记录数
	@Select("select count(*) from (select * from log l where usertype=#{userType} and description like #{args}) l")
	Integer getCountByargs(@Param("userType")String userType,@Param("args") String args);


	//按时间查询的记录数
	@Select("select count(*) from select * from log l where time BETWEEN #{startTime} and #{endTime}) l")
	Integer getCountByTime(@Param("startTime") Date  startTime,@Param("endTime") Date  endTime);
}