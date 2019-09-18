package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Visitor;

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



	public Integer insertVisitor(Visitor visitor);
	public List<Visitor> getAllVisitors();
	public List<Visitor> getVisitorByTime(String startTime,String endTime);
	public List<Visitor> getVisitorByCity(String city);
	public List<Visitor> getVisitorByOs(String os);
	public List<Visitor> getVisitorByInternet(String internet);
	public Integer addVisitorToBlackList(String ip);
	public Integer outVisitorFromBlackList(String ip);
	PageInfo<Visitor> getVisitorPage(Integer startPage, Integer pageSize);
}
