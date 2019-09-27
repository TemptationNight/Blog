package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.entity.Link;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: WebsiteService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:04
 * @Version: 1.0
 */
public interface WebsiteService {
	public Integer getArticleNum();
	public Integer getVisitorToday();
	public Integer getTagNum();
	public Integer getCategoryNum();
	public String  getLastUpdateTime();
	public Integer getBrowseNum();
	public Integer getLinkNum();
	public Integer getCommentNum();
	public Integer getSourceNum();
	public Integer getMoneyNum();




}
