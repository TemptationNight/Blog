package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Log;
import com.lucas.blog.myblog.mapper.LogMapper;
import com.lucas.blog.myblog.service.LogService;
import com.lucas.blog.myblog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: LogServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:08
 * @Version: 1.0
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogMapper logMapper;


	/**
	 * Description:   根据传进去的参数  不同  而进行不同的条件查询   身份为普通游客
	 * @author: Lucas
	 * @date: 2019/10/30 21:31
	 * @param:
	 * @return:
	 */

	@Override
	public PageInfo<Log> getLogByPageCustomer(Integer startPage, Integer pageSize,String userType,String desc) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Log.class);
		//描述信息为空，则直接进行按照身份查询
		if(desc==null||desc.equals("")){
			example.createCriteria().andEqualTo("usertype", "普通游客");
		}else {
			example.createCriteria().andEqualTo("usertype", userType).andLike("description","%"+desc+"%");
		}
		example.setOrderByClause("time DESC");
		PageInfo<Log> pageInfo = new PageInfo<>(logMapper.selectByExample(example));
		return pageInfo;
	}



	/**
	 * Description: 根据传进去的参数  不同  而进行不同的条件查询   身份为管理员
	 * @author: Lucas
	 * @date: 2019/10/31 9:11
	 * @param:
	 * @return:
	 */

	@Override
	public PageInfo<Log> getLogByPageAdministrator(Integer startPage, Integer pageSize,String userType,String desc) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Log.class);
		//描述信息为空，则直接进行按照身份查询
		if(desc==null){
			example.createCriteria().andEqualTo("usertype", userType);
		}else {
			example.createCriteria().andEqualTo("usertype", userType).andLike("description","%"+desc+"%");
		}
		example.setOrderByClause("time DESC");
		PageInfo<Log> pageInfo = new PageInfo<>(logMapper.selectByExample(example));
		return pageInfo;
	}




	/**
	 * Description:   最基本的查询   不带任何条件的查询     跳转到Log页面的数据加载方法
	 * @author: Lucas
	 * @date: 2019/10/30 22:38
	 * @param:
	 * @return:
	 */
	@Override
	public PageInfo<Log> getLogByPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Log.class);
		example.setOrderByClause("time DESC");
		PageInfo<Log> pageInfo = new PageInfo<>(logMapper.selectByExample(example));
		return pageInfo;
	}



	/**
	 * Description:   将日志写入数据库
	 * @author: Lucas
	 * @date: 2019/10/30 21:31
	 * @param:
	 * @return:
	 */
	@Override
	public void insertLog(Log log) {
		logMapper.insert(log);
	}





	/**
	 * Description:  根据时间查询日志记录
	 * @author: Lucas
	 * @date: 2019/10/30 21:31
	 * @param:
	 * @return:
	 */

	@Override
	public PageInfo<Log> getLogByTime(Date statTime, Date endTime, Integer startPage, Integer pageSize) {
		PageHelper.startPage(startPage, pageSize);
		Example example = new Example(Log.class);
		example.createCriteria().andBetween("time",statTime,endTime);
		PageInfo<Log> pageInfo = new PageInfo<>(logMapper.selectByExample(example));
		return pageInfo;
	}

	/**
	 * Description:  返回日志记录总数
	 * @author: Lucas
	 * @date: 2019/11/11 15:40
	 * @param:
	 * @return:
	 */
	@Override
	public Integer getLogCount() {
		Example example=new Example(Log.class);
		return logMapper.selectCountByExample(example);
	}

	//返回满足条件的日志记录数

	@Override
	public Integer getLogCountByArgs(String userType,String args) {
		System.out.println(userType+""+args);
		return logMapper.getCountByargs(userType,"%"+args+"%");
	}

	//返回满足时间条件的日志记录数
	@Override
	public Integer getLogByTime(Date startTime, Date endTime) {
		return logMapper.getCountByTime(startTime,endTime);
	}


}


