package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Link;
import com.lucas.blog.myblog.mapper.LinkMapper;
import com.lucas.blog.myblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
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

	//获取所有的友链
	@Override
	public List<Link> getLinkList() {
		return linkMapper.selectAll();
	}


	//获取未验证的友链的个数
	@Override
	public Integer getLinkCountNotCheck() {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("isagree", 0);
		return linkMapper.selectCountByExample(example);
	}



	//获取已经验证的友链的个数
	@Override
	public Integer getLinkCountChecked() {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("isagree", 1);
		return linkMapper.selectCountByExample(example);
	}


	//获取友链的总数目
	@Override
	public Integer getCount() {
		Example example = new Example(Link.class);
		return linkMapper.selectCountByExample(example);
	}



	//验证友链通过
	@Transactional
	@Override
	public Integer setLinkChecked(Integer id) {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("id", id);
		Link link = linkMapper.selectOneByExample(example);
		link.setIsagree(1);
		return linkMapper.updateByExampleSelective(link, example);
	}



	//删除友链
	@Transactional
	@Override
	public Integer deleteLink(Integer id) {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("id", id);

		return linkMapper.deleteByExample(example);
	}


	/*//获取友链点击量
	@Override
	public Integer getClickNum(Integer id) {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("id", id);
		Link link = linkMapper.selectByPrimaryKey(example);
		return link.getClicknum();
	}*/


	//友链点击量+1
	@Transactional
	@Override
	public Integer clickNumAddOne(Integer id) {
		Example example = new Example(Link.class);
		example.createCriteria().andEqualTo("id", id);
		Link link = linkMapper.selectOneByExample(example);
		System.out.println(link.getLinkname());
		Integer clickNum = link.getClicknum() + 1;
		Link link1 = new Link();
		link1.setClicknum(clickNum);
		System.out.println(link1.getLinkname());
		return linkMapper.updateByExampleSelective(link1, example);
	}


	// 添加友链
	@Transactional
	@Override
	public Integer addLink(String url, String name) {
		Link link = new Link(url,name,0,0,new Date());
		return linkMapper.insert(link);
	}

	//搜索友链
	@Override
	public List<Link> getLinkByArgs(String args) {
		Example example=new Example(Link.class);
		example.createCriteria().orLike("linkname","%"+args+"%");
		List<Link> links = linkMapper.selectByExample(example);
		return links;
	}


}
