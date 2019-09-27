package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Link;
import com.lucas.blog.myblog.mapper.LinkMapper;
import com.lucas.blog.myblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: LinkServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:08
 * @Version: 1.0
 */
@Service
public class LinkServiceImpl implements LinkService {


	@Autowired
	private LinkMapper linkMapper;

	/**
	 * Description:  获取所有的友链
	 * @author: Lucas
	 * @date: 2019/9/24 12:36
	 * @param:m
	 * @return:   List<Link>
	 */
	@Override
	public PageInfo<Link> getLinkByPage(Integer startPage,Integer pageSize) {
		PageHelper.startPage(0, 20);
		Example example = new Example(Article.class);
		PageInfo<Link> pageInfo = new PageInfo<>(linkMapper.selectByExample(example));
		return  pageInfo;
	}

	/**
	 * Description:  获取未验证的友链的个数
	 * @author: Lucas
	 * @date: 2019/9/24 12:36
	 * @param:
	 * @return: Integer
	 */
	@Override
	public Integer getLinkCountNotCheck() {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("isAgree",0);
		return linkMapper.selectCountByExample(example);
	}

	/**
	 * Description:     获取已经验证的友链的个数
	 * @author: Lucas
	 * @date: 2019/9/24 12:36
	 * @param:
	 * @return: Integer
	 */
	@Override
	public Integer getLinkCountChecked() {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("isAgree",1);
		return linkMapper.selectCountByExample(example);
	}

	/**
	 * Description:  获取友链的总数目
	 * @author: Lucas
	 * @date: 2019/9/25 18:10
	 * @param:
	 * @return:  Integer
	 */
	@Override
	public Integer getCount() {
		Example example=new Example(Link.class);
		return  linkMapper.selectCountByExample(example);
	}

	/**
	 * Description:   获取已经通过验证或没有通过验证的友链
	 * @author: Lucas
	 * @date: 2019/9/25 18:07
	 * @param:    友链的状态 0 没有被验证通过  1验证通过
	 * @return:  List<Link>
	 */
	@Override
	public List<Link> getLinksListCheckedOrNot(Integer status) {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("isAgree",status);
		return linkMapper.selectByExample(example);
	}


	/**
	 * Description:   验证友链通过
	 * @author: Lucas
	 * @date: 2019/9/25 20:15
	 * @param:
	 * @return: Integer
	 */
	@Override
	public Integer setLinkChecked(Integer id) {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("id",id);
		Link link = linkMapper.selectOneByExample(example);
		link.setIsagree(1);
		return linkMapper.updateByExampleSelective(link,example);
	}


	/**
	 * Description:    删除友链
	 * @author: Lucas
	 * @date: 2019/9/25 20:40
	 * @param:     友链id
	 * @return:  Integer
	 */
	@Override
	public Integer deleteLink(Integer id) {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("id",id) ;
		return linkMapper.deleteByExample(example);
	}

	/**
	 * Description:   获取友链点击量
	 * @author: Lucas
	 * @date: 2019/9/25 21:21
	 * @param:
	 * @return:  Integer
	 */
	@Override
	public Integer getClickNum(Integer id) {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("id",id);
		Link link = linkMapper.selectByPrimaryKey(example);
		return link.getClicknum();
	}

	/**
	 * Description:  友链点击量+1
	 * @author: Lucas
	 * @date: 2019/9/25 21:21
	 * @param:
	 * @return:  Integer
	 */
	@Override
	public Integer clickNumAddOne(Integer id) {
		Example example=new Example(Link.class);
		example.createCriteria().andEqualTo("id",id);
		Link link = linkMapper.selectByPrimaryKey(example);
		Integer clickNum=link.getClicknum()+1;
		Link link1=new Link();
		link1.setClicknum(clickNum);
		return  linkMapper.updateByExampleSelective(link1,example);
	}


}
