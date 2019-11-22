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



	//获取文章分页
	@Override
	public PageInfo<Article> getArticleByPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(0, 20);
		Example example = new Example(Article.class);
		PageInfo<Article> pageInfo = new PageInfo<>(articleMapper.selectByExample(example));
		return  pageInfo;
	}

	//发布文章
	@Transactional
	@Override
	public Integer addArticle(Article article) {
		System.out.println("======================================================");
		System.out.println(article.toString());
		return articleMapper.insert(article);
	}




	//根据id删除一个文章
	@Transactional
	@Override
	public Integer deleteArticle(Integer id) {
		Example example = new Example(Article.class);
		example.createCriteria().andCondition("id=", id);
		return articleMapper.deleteByExample(example);
	}


	//获取所有的文章
	@Override
	public List<Article> articleList() {
		return articleMapper.selectAll();
	}


	//修改文章
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



	//文章上架  文章下架
	@Transactional
	@Override
	public Integer upOrDownShilft(Integer id,Integer status) {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article=new Article();
		article.setStatus(status);
		return articleMapper.updateByExampleSelective(article, example);
	}




	//文章加推荐  取推荐
	@Override
	public Integer downOrUpRecommend(Integer id, Integer status) {
		System.out.println("id="+id);
		Example example=new Example(Article.class);
		example.createCriteria().andEqualTo("id",id);
		Article article=new Article();
		article.setIsrecommend(status);
		return  articleMapper.updateByExampleSelective(article,example);
	}


	//获取文章的记录数
	@Override
	public Integer getArticleCount() {
		Example example=new Example(Article.class);
		return articleMapper.selectCountByExample(example);
	}


}
