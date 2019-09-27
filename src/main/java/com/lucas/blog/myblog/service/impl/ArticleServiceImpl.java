package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.exception.NotFoundException;
import com.lucas.blog.myblog.mapper.ArticleMapper;
import com.lucas.blog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: ArticleServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:06
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {


	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * Description:         获取文章分页信息
	 * @author: Lucas
	 * @date: 2019/9/23 21:34
	 * @param:
	 * @return: pageInfo
	 */
	@Override
	public PageInfo<Article> getArticleByPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(0, 20);
		Example example = new Example(Article.class);
		PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));
		return  pageInfo;
	}

	/**
	 * Description:   添加文章
	 * @author: Lucas
	 * @date: 2019/9/23 21:34
	 * @param:
	 * @return: Integer
	 */
	@Transactional
	@Override
	public Integer addArticle(Article article) {
		return articleMapper.insert(article);
	}


	/**
	 * Description:       删除一个文章
	 * @author: Lucas
	 * @date: 2019/9/23 21:34
	 * @param:
	 * @return: Integer
	 */
	@Transactional
	@Override
	public Integer deleteArticle(Integer id) {
		Example example = new Example(Article.class);
		example.createCriteria().andCondition("id=", id);
		return articleMapper.deleteByExample(example);
	}

	/**
	 * Description:       获取所有所有文章信息
	 * @author: Lucas
	 * @date: 2019/9/23 21:39
	 * @param:
	 * @return:      List<Article>
	 */
	@Override
	public List<Article> articleList() {
		return articleMapper.selectAll();
	}

	/**
	 * Description:     修改文章
	 * @author: Lucas
	 * @date: 2019/9/23 21:39
	 * @param:
	 * @return:      Integer
	 */
	@Transactional
	@Override
	public Integer updateArticle(Integer id, Article article) {
		Article a=articleMapper.selectByPrimaryKey(id);
		if(a==null){
			throw new NotFoundException("没有找到该文章");
		}
		a.setCategoryid(article.getCategoryid());
		a.setContent(article.getContent());
		a.setImages(article.getImages());
		a.setIsrecommend(article.getIsrecommend());
		a.setIstop(article.getIstop());
		a.setTitle(article.getTitle());
		return  articleMapper.updateByPrimaryKey(a);
	}

	/**
	 * Description:  文章下架  文章下架
	 * @author: Lucas
	 * @date: 2019/9/23 21:39
	 * @param:   文章id  文章发布状态    0 下架   1 上架
	 * @return: Integer
	 */
	@Transactional
	@Override
	public Integer upOrDownShilft(Integer id,Integer status) {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article=new Article();
		article.setStatus(status);
		return articleMapper.updateByExampleSelective(article, example);
	}



	/**
	 * Description:      文章加推荐  文章取推荐
	 * @author: Lucas
	 * @date: 2019/9/25 15:56
	 * @param:     文章id    文章的推荐状态  0 取消推荐     1 添加推荐
	 * @return:  Integer
	 */
	@Override
	public Integer downOrUpRecommend(Integer id, Integer status) {
		System.out.println("id="+id);
		Example example=new Example(Article.class);
		example.createCriteria().andEqualTo("id",id);
		Article article=new Article();
		article.setIsrecommend(status);
		return  articleMapper.updateByExampleSelective(article,example);
	}





}
