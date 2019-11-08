package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Visitor;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: VisitorService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:04
 * @Version: 1.0
 */
public interface VisitorService {
	Integer insertVisitor(Visitor visitor);

	PageInfo<Visitor> getVisitorByTime(Date startTime, Date endTime, Integer startPage, Integer pageSize);

	PageInfo<Visitor> getVisitorByArgs(String args, Integer startPage, Integer pageSize);

	PageInfo<Visitor> getVisitorPage(Integer startPage, Integer pageSize);

	Integer getCount();

	Integer getBlackCount();

	Integer getUserCount();

	public List<Visitor> getVisitorGroupByIp();

	List<Visitor> getBlackVisitorIp();

}
