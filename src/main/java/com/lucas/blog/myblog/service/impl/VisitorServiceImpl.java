package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.mapper.VisitorMapper;
import com.lucas.blog.myblog.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author Lenovo
 * @Version  1.0
 * @Description
 * @Date 2019/9/17 16:57
 */
@Service
public class VisitorServiceImpl  implements VisitorService{


	@Autowired
	private VisitorMapper visitorMapper;



	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description    添加一个访客

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
	 * @Version  1.0
	 * @Description      获取全部的访客信息
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:52
	 */
	@Override
	public List<Visitor> getAllVisitors() {
		return visitorMapper.selectAll();
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description 根据访问时间获取访客信息

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:53
	 */
	@Override
	public List<Visitor> getVisitorByTime(String startTime, String endTime) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description 根据访客城市获取访客信息

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:53
	 */
	@Override
	public List<Visitor> getVisitorByCity(String city) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description    根据访客操作系统获取访客信息

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:53
	 */
	@Override
	public List<Visitor> getVisitorByOs(String os) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description      根据访客网络类型获取访客信息

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:54
	 */
	@Override
	public List<Visitor> getVisitorByInternet(String internet) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description      根据ip加入访客到黑名单

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:55
	 */
	@Override
	public Integer addVisitorToBlackList(String ip) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description  根据ip将访客移除黑名单

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:55
	 */
	@Override
	public Integer outVisitorFromBlackList(String ip) {
		return null;
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description    分页获取访客信息
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:56
	 */
	@Override
	public PageInfo<Visitor> getVisitorPage(Integer startPage, Integer pageSize) {
		return null;
	}
}
