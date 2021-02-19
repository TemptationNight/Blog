package com.lucas.blog.myblog.service.impl;

import com.lucas.blog.myblog.entity.*;
import com.lucas.blog.myblog.mapper.*;
import com.lucas.blog.myblog.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: WebsiteServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:09
 * @Version: 1.0
 */


@Service
public class WebsiteServiceImpl implements WebsiteService {

	@Autowired
	private WebsiteMapper websiteMapper;


	@Autowired
	private LinkMapper linkMapper;


	@Autowired
	private CategoryMapper categoryMapper;

	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private VisitorMapper visitorMapper;


	@Autowired
	private CommentMapper commentMapper;





	/**
	 * Description:   获取网站的文章总数量
	 * @author: Lucas
	 * @date: 2019/9/22 16:13
	 * @param:
	 * @return:     Integer
	 */
	@Override
	public Integer getArticleNum() {
		Example example = new Example(Article.class);
		return  articleMapper.selectCountByExample(example);
	}

	/**
	 * Description:  获取网站今日访问量
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:   Integer
	 */
	@Override
	public Integer getVisitorToday() {
		Date date=new Date();
        SimpleDateFormat f=new SimpleDateFormat("yyy-MM-dd");
		String time=f.format(date);
		Example example=new Example(Visitor.class);
		Example.Criteria criteria = example.createCriteria();
		return  0;

	}



	/**
	 * Description:  获取网站的标签数目
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:    Integer
	 */
	@Override
	public Integer getTagNum() {
		return 0;
	}

	/**
	 * Description:    获取网站的分类总数
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:   Integer
	 */
	@Override
	public Integer getCategoryNum() {
		Example example=new Example(Category.class);
		return categoryMapper.selectCountByExample(example);
	}

	/**
	 * Description:   获取网站的最后更新时间
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:   String
	 */
	@Override
	public String  getLastUpdateTime() {
		return null;
	}

	/**
	 * Description:   获取网站访问总量
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:  Integer
	 */
	@Override
	public Integer getBrowseNum() {
		Example example=new Example(Visitor.class);

		return  visitorMapper.selectCountByExample(example);


	}

	/**
	 * Description:  获取网站友链总数目
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:  Integer
	 */
	@Override
	public Integer getLinkNum() {
		Example example=new Example(Link.class);
		return  linkMapper.selectCountByExample(example);
	}

	/**
	 * Description:    获取网站评论总数目
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return: Integer
	 */

	@Override
	public Integer getCommentNum() {
		Example example=new Example(Comment.class);
		return  commentMapper.selectCountByExample(example);
	}

	/**
	 * Description:     获取网站资源总数目
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:     Integer
	 */
	@Override
	public Integer getSourceNum() {
		return 0;
	}

	/**
	 * Description:  获取网站打赏数目
	 * @author: Lucas
	 * @date: 2019/9/22 16:14
	 * @param:
	 * @return:     Integer
	 */
	@Override
	public Integer getMoneyNum() {
		return 0;
	}

	/**
	 * Description:     获取所有的连接
	 * @author: Lucas
	 * @date: 2019/9/23 19:54
	 * @param:
	 * @return: List<Link>
	 */






}
