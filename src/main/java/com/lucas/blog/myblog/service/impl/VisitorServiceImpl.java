package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.mapper.VisitorIpMapper;
import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.mapper.VisitorMapper;
import com.lucas.blog.myblog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	@Autowired
	VisitorIpMapper visitorIpMapper;


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 添加一个访客记录
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:51
	 */
	@Override
	public Integer insertVisitor(Visitor visitor) {
		return visitorMapper.insert(visitor);
	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 基础查询 分页获取访客信息
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:56
	 */
	@Override
	public PageInfo<Visitor> getVisitorPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Visitor.class);
		PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorMapper.selectByExample(example));
		return visitorPageInfo;
	}

	/**
	 * Description:  获取记录数
	 * @author: Lucas
	 * @date: 2019/11/8 18:09
	 * @param:
	 * @return:
	 */
	@Override
	public Integer getCount() {
		Example example = new Example(Visitor.class);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}

	/**
	 * Description:  获取黑名单的记录数
	 * @author: Lucas
	 * @date: 2019/11/8 18:09
	 * @param:
	 * @return:
	 */
	@Override
	public Integer getBlackCount() {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("black",0);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}

	/**
	 * Description:   获取用户数
	 * @author: Lucas
	 * @date: 2019/11/8 18:09
	 * @param:
	 * @return:
	 */
	@Override
	public Integer getUserCount() {
		Example example = new Example(Visitor.class);
		example.createCriteria().andEqualTo("black",1);
		int i = visitorMapper.selectCountByExample(example);
		return i;
	}



	/**
	 * Description:     根据时间获取访客记录
	 *
	 * @author: Lucas
	 * @date: 2019/10/31 21:30
	 * @param:
	 * @return:
	 */
	@Override
	public PageInfo<Visitor> getVisitorByTime(Date startTime, Date endTime, Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Visitor.class);
		example.createCriteria().andBetween("time", startTime, endTime);
		PageInfo<Visitor> visitorPageInfo = new PageInfo<>(visitorMapper.selectByExample(example));
		return visitorPageInfo;
	}

	/**
	 * Description:     根据参数描述获取访客信息
	 *
	 * @author: Lucas
	 * @date: 2019/10/31 21:30
	 * @param:
	 * @return:
	 */
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



	/**
	 * Description:  根据不同IP获取所有的用户
	 * @author: Lucas
	 * @date: 2019/11/8 19:32
	 * @param:
	 * @return:
	 */
	@Override
	public List<Visitor> getVisitorGroupByIp() {
		return  visitorIpMapper.getVisitorGroupByIp();

	}

	/**
	 * Description:  获取黑名单用户
	 * @author: Lucas
	 * @date: 2019/11/8 21:12
	 * @param:
	 * @return:
	 */
	@Override
	public List<Visitor> getBlackVisitorIp() {
		return visitorIpMapper.getBlackVisitorIp();
	}


}
