package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Log;

import java.util.Date;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: LogService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:04
 * @Version: 1.0
 */
public interface LogService {

	public void insertLog(Log log);


	public PageInfo<Log> getLogByPage(Integer startPage, Integer pageSize);


	public PageInfo<Log> getLogByPageAdministrator(Integer startPage, Integer pageSize,String userType,String desc);


	public PageInfo<Log> getLogByPageCustomer(Integer startPage, Integer pageSize,String userType,String desc) ;


	public PageInfo<Log>  getLogByTime(Date statTime, Date endTime,Integer startPage, Integer pageSize);







}
