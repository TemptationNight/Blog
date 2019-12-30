package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.exception.NotFoundException;
import com.lucas.blog.myblog.mapper.ArticleMapper;
import com.lucas.blog.myblog.service.ArticleService;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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
		return pageInfo;
	}

	//发布文章
	@Transactional
	@Override
	public Integer addArticle(Article article) {
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
		Article a = articleMapper.selectByPrimaryKey(id);
		if (a == null) {
			throw new NotFoundException("没有找到该文章");
		}
		a.setCategoryid(article.getCategoryid());
		a.setContent(article.getContent());
		a.setImages(article.getImages());
		a.setIsrecommend(article.getIsrecommend());
		a.setIstop(article.getIstop());
		a.setTitle(article.getTitle());
		return articleMapper.updateByPrimaryKey(a);
	}


	//文章上架  文章下架
	@Transactional
	@Override
	public Integer upOrDownShilft(Integer id, Integer status) {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article = new Article();
		article.setStatus(status);
		return articleMapper.updateByExampleSelective(article, example);
	}


	//文章加推荐  取推荐
	@Override
	public Integer downOrUpRecommend(Integer id, Integer status) {
		System.out.println("id=" + id);
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article = new Article();
		article.setIsrecommend(status);
		return articleMapper.updateByExampleSelective(article, example);
	}


	//获取文章的记录数
	@Override
	public Integer getArticleCount() {
		Example example = new Example(Article.class);
		return articleMapper.selectCountByExample(example);
	}


	//=============================== 客户端=============================================
	//获取发布时间前十的文章
	@Override
	public List<Article> getArticleTenByTime() {
		return articleMapper.getArticleTenByTime();
	}

	//获取置顶文章
	@Override
	public Set<Article> getArticleByTop() {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("istop", 1);
		List<Article> articles = articleMapper.selectByExample(example);
		//只取置顶的随机三篇文章
		Set set = new LinkedHashSet(3);
		int size = articles.size() - 1;
		Random random = new Random();
		while (set.size() < 3) {
			int i = random.nextInt(size);
			if (articles.get(i).getImages() != null) {
				set.add(articles.get(i));
			}
		}
		return set;
	}

	//获取推荐文章
	@Override
	public Set<Article> getArticleByRecommend() {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("isrecommend", 1);
		List<Article> articles = articleMapper.selectByExample(example);
		//只取随机三篇推荐文章
		Set set = new LinkedHashSet(4);
		Random random = new Random();
		int size = articles.size() - 1;
		while (set.size() < 4) {
			int i = random.nextInt(size);
			if (articles.get(i).getImages() != null) {
				set.add(articles.get(i));
			}
		}
		return set;
	}


	//根据id获取文章
	@Override
	public Article getArticleById(Integer id) {
		return articleMapper.selectByPrimaryKey(id);
	}


	//获取点击量的top5
	@Override
	public List<Article> getArticleByBrowsers() {
		return articleMapper.getArticleByBrowsers();
	}

	//获取所有的关键字
	@Override
	public HashSet<String> getKeywords() {
		List<Article> articles = articleMapper.selectAll();
		HashSet<String> set = new HashSet<>();   //为什么使用hashSet  因为可以去除重复的数据
		String[] split = null;
		String keyword = "";
		for (Article article : articles) {
			keyword = article.getKeyword();
			//按中文和英文分号（；;）将多个标签划分
			split = keyword.split("[;\\；]");
			for (int i = 0; i < split.length; i++) {
				set.add(split[i]);
			}
		}
		return set;
	}

	//文章的浏览值+1
	@Override
	public Integer addBrowsersOne(Integer id) {
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article = articleMapper.selectOneByExample(example);
		article.setBrowsenum(article.getBrowsenum() + 1);
		return articleMapper.updateByExampleSelective(article, example);
	}

	//文章的点赞量+1
	@Override
	public Integer addAgreeOne(Integer id) {
		System.out.println("id=" + id);
		Example example = new Example(Article.class);
		example.createCriteria().andEqualTo("id", id);
		Article article = articleMapper.selectOneByExample(example);
		article.setAgreenum(article.getAgreenum() + 1);
		return articleMapper.updateByExampleSelective(article, example);
	}

	//根据typeId获取文章
	@Override
	public List<Article> getArticleByTypeName(String  typeName) {
		Example example=new Example(Article.class);
		example.createCriteria().andLike("categoryName","%"+typeName+"%");
		return articleMapper.selectByExample(example);
	}

	//根据标签获取文章
	@Override
	public List<Article> getArticleByKeyWords(String keyWords) {
		Example example=new Example(Article.class);
		example.createCriteria().andLike("keyword","%"+keyWords+"%");
		return articleMapper.selectByExample(example);
	}

	@Override
	public List<Article> searchBlog(String search) {
		Example example=new Example(Article.class);
		example.createCriteria()
				.orLike("title" , "%"+search + "%")
				.orLike("categoryName" , "%"+search + "%")
				.orLike("keyword" , "%"+search + "%");
		List<Article> articles = articleMapper.selectByExample(example);
		return articles;
	}

	//获取所有的文章
	@Override
	public List<Article> getAll() {
		return articleMapper.selectAll();
	}


}
