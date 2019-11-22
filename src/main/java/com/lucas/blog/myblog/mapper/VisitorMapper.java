package com.lucas.blog.myblog.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.MyMapper;
import com.lucas.blog.myblog.entity.Visitor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.JDBCType;
import java.util.Date;
import java.util.List;

public interface VisitorMapper extends MyMapper<Visitor> {
	//查询ip列表
	@Select("select * from visitor where black=1 group by ip  LIMIT #{startPage},#{pageSize} ")
	List<Visitor> getVisitorGroupByIp(@Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);

	//查询黑名单列表
	@Select("select * from visitor where black=0 group by ip")
	List<Visitor> getBlackVisitorIp();


	//参数化查询黑名单
	@Select("select * from visitor where black=0 and   (ip like #{args} or city like #{args} or browseType like #{args} or osType like #{args}) group by ip")
	List<Visitor> getBlackByArgs(String args);

	//参数化查询ip列表
	@Select("select * from visitor where black=1 and  ip like #{args} or city like #{args} or browseType like #{args} or osType like #{args}   group by ip  LIMIT #{startPage},#{pageSize} ")
	List<Visitor> getStatisticByArgs(@Param("args") String args,@Param("startPage") Integer startPage,@Param("pageSize") Integer pageSize);


	//按条件查询的记录数
	@Select("select count(*) from (select * from visitor v where ip like #{args} or city like #{args} or browseType like #{args} or osType like #{args}) v")
	Integer getCountByArgs(String args);


	//按时间查询的记录数
	@Select("select count(*) from (select * from visitor v where time between #{startTime} and #{endTime} ) v")
	Integer getCountByTime(@Param("startTime") Date startTime, @Param("endTime") Date endTime);


	//按条件查询ip数
	@Select("select count(*) from (select * from visitor v where v.black=1 and  ip like #{args} or city like #{args} or browseType like #{args} or osType like #{args} group by ip) v")
	Integer getIpCountByArgs(String args);


	//三个数据显示栏的数据
	//查询不同的ip条数
	@Select("select count(*) from (select count(*) from visitor v group by v.ip) v")
	Integer getIpCount();

	//查询黑名单的ip数
	@Select("select count(*) from (select count(*) from visitor v where v.black=0 group by v.ip) v")
	Integer getBlackIpCount();
}