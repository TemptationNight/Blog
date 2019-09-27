package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Link;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: LinkService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:04
 * @Version: 1.0
 */
public interface LinkService {
	public PageInfo<Link> getLinkByPage(Integer startPage,Integer pageSize);
	public Integer getLinkCountNotCheck();
	public Integer getLinkCountChecked();
	public Integer getCount();
	public List<Link> getLinksListCheckedOrNot(Integer status);
	public Integer setLinkChecked(Integer id);


	public  Integer deleteLink(Integer id);


	public Integer getClickNum(Integer id);
	public Integer clickNumAddOne(Integer id);

}
