package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Category;
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
	List<Link> getLinkList();

	Integer getLinkCountNotCheck();

	Integer getLinkCountChecked();

	Integer getCount();

	Integer setLinkChecked(Integer id);

	Integer deleteLink(Integer id);

	Integer clickNumAddOne(Integer id);

	Integer addLink(String url, String name);

	List<Link> getLinkByArgs(String args);

}
