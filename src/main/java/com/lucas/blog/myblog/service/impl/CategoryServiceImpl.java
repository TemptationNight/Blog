package com.lucas.blog.myblog.service.impl;

import com.lucas.blog.myblog.entity.Article;
import com.lucas.blog.myblog.entity.Category;

import com.lucas.blog.myblog.exception.NotFoundException;
import com.lucas.blog.myblog.mapper.CategoryMapper;
import com.lucas.blog.myblog.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: CategoryServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:06
 * @Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 添加一个类别
	 * @Return Integer
	 * @Exception
	 * @Date 2019/9/17 9:27
	 */
	@Transactional
	@Override
	public Integer addCategory(Category category) {
		return categoryMapper.insert(category);
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 删除一个类
	 * @Return Integer
	 * @Exception
	 * @Date 2019/9/17 9:28
	 */
	@Transactional
	@Override
	public Integer deleteCategory(Integer id) {
		Example example = new Example(Category.class);
		example.createCriteria().andCondition("id=", id);
		Category category = categoryMapper.selectOneByExample(example);
		if (category.getArticlenum() != null) {
			//先要删除该类下的文章
			Example example1 = new Example(Article.class);
			example1.createCriteria().andCondition("categoryid=", category.getId());
		}
		return categoryMapper.deleteByExample(example);
	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 修改一个类别
	 * @Return Integer
	 * @Exception
	 * @Date 2019/9/17 9:29
	 */
	@Transactional
	@Override
	public Integer updateCategory(Integer id, Category category) {
		Category c = categoryMapper.selectByPrimaryKey(id);
		if (c == null) {
			throw new NotFoundException("没有找到该类");
		}
		c.setCategoryname(category.getCategoryname());
		return categoryMapper.updateByPrimaryKeySelective(c);
	}

	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 根据id获取一个类别
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:29
	 */
	@Transactional
	@Override
	public Category getCategoryById(Integer id) {
		Example example = new Example(Category.class);
		example.createCriteria().andCondition("id=", id);
		return categoryMapper.selectOneByExample(example);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryMapper.selectAll();
	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version 1.0
	 * @Description 根据名称获取一个类别
	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:29
	 */
	@Override
	public Category getCategoryByName(String name) {
		Example example = new Example(Category.class);
		example.createCriteria().andCondition("categoryName=", name);
		return categoryMapper.selectOneByExample(example);

	}


	/**
	 * Description:   获取记录数
	 *
	 * @author: Lucas
	 * @date: 2019/11/11 15:45
	 * @param:
	 * @return:
	 */
	@Override
	public Integer getCategoryCount() {
		Example example = new Example(Category.class);
		return categoryMapper.selectCountByExample(example);
	}

	@Override
	public List<Category> getTypeByArgs(String args) {
		Example example = new Example(Category.class);
		example.createCriteria().orLike("categoryname", "%" + args + "%");
		List<Category> categories = categoryMapper.selectByExample(example);
		return categories;
	}


}
