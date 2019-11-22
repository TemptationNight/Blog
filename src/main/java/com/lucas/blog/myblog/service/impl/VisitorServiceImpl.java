package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.mapper.VisitorMapper;
import com.lucas.blog.myblog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;


/**
 * @Author Lenovo
 * @Version 1.0
 * @Description
 * @Date 2019/9/17 16:57
 */
@Service
public class VisitorServiceImpl implements VisitorService {


	@Autowired
	private VisitorMapper visitorMapper;


	//添加一个访客记录
	@Transactional
	@Override
	public Integer insertVisitor(Visitor visitor) {
		return visitorMapper.insert(visitor);
	}


	//基础查询 分页获取访客信息
	@Override
	public PageInfo<Visitor> getVisitorPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Visitor.class);
		example.setOrderByClause("time desc");
		PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorMapper.selectByExample(example));
		return visitorPageInfo;
	}


	//获取黑名单的记录数  未分组  有重复   可以不需要这个数据
	@Override
	public Integer getBlackCount() {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("black", 0);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}


	//获取用户数  未分组  有重复   可以不需要这个数据
	@Override
	public Integer getUserCount() {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("black", 1);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}


	//根据时间获取访客记录
	@Override
	public PageInfo<Visitor> getVisitorByTime(Date startTime, Date endTime, Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Visitor.class);
		example.createCriteria().andBetween("time", startTime, endTime);
		PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorMapper.selectByExample(example));
		return visitorPageInfo;
	}

	//根据参数描述获取访客信息
	@Override
	public PageInfo<Visitor> getVisitorByArgs(String args, Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Visitor.class);
		example.createCriteria().
				orLike("city", "%" + args + "%").
				orLike("browsetype", "%" + args + "%").
				orLike("ostype", "%" + args + "%");
		PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorMapper.selectByExample(example));
		System.out.println(visitorPageInfo.getList());
		return visitorPageInfo;

	}



	// 根据不同IP获取所有的用户
	//@Cacheable(cacheNames = "visitor", key = "123")      //使用redis 缓存
	@Override
	public List<Visitor> getVisitorGroupByIp(Integer startPage,Integer  pageSize) {
		return visitorMapper.getVisitorGroupByIp(startPage,pageSize);
	}


	// 获取黑名单用户
	@Override
	public List<Visitor> getBlackVisitorIp() {
		return visitorMapper.getBlackVisitorIp();
	}



	//  根据参数条件获取黑名单
	@Override
	public List<Visitor> getBlackByArgs(String args) {
		return visitorMapper.getBlackByArgs("%" + args + "%");
	}



	// 根据参数条件获取用户ip
	@Override
	public List<Visitor> getStatisticByArgs(String args,Integer startPage,Integer pageSize) {
		return visitorMapper.getStatisticByArgs("%" + args + "%",startPage,pageSize);
	}


	//将ip加入黑名单
	@Transactional
	@Override
	public Integer addBlack(String ip) {
		System.out.println("ip=" + ip);
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("ip", ip);
		Visitor visitor = new Visitor();
		visitor.setBlack(0);
		return visitorMapper.updateByExampleSelective(visitor, example);
	}



	//将ip移除黑名单
	@Transactional
	@Override
	public Integer outBlack(String ip) {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("ip", ip);
		Visitor visitor = new Visitor();
		visitor.setBlack(1);
		return visitorMapper.updateByExampleSelective(visitor, example);
	}

	//根据ip获取访客
	@Override
	public List<Visitor> getVisitorByIp(String ip) {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("ip", ip);
		return visitorMapper.selectByExample(example);
	}


	//根据条件获取访客数量
	@Override
	public Integer getCountByArgs(String args) {
		return visitorMapper.getCountByArgs("%" + args + "%");
	}

	//根据时间获取访客数量
	@Override
	public Integer getCountByTime(Date startTime, Date endTime) {
		return visitorMapper.getCountByTime(startTime, endTime);
	}


	//根据条件获取ip数量
	@Override
	public Integer getIpCountByArgs(String args) {
		return visitorMapper.getIpCountByArgs("%" + args + "%");
	}


	//获取黑名单的ip个数
	@Override
	public Integer getBlackIpCount() {
		return visitorMapper.getBlackIpCount();
	}

	//获取不同ip的个数
	@Override
	public Integer getIpCount() {
		return visitorMapper.getIpCount();
	}

	//获取记录数
	@Override
	public Integer getCount() {
		Example example = new Example(Visitor.class);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}



}



