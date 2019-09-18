package com.lucas.blog.myblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.exception.NotFoundException;
import com.lucas.blog.myblog.mapper.CategoryMapper;
import com.lucas.blog.myblog.service.CategoryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;




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
	 * @Version  1.0
	 * @Description   添加一个类别

	 * @Return   Integer
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
	 * @Version  1.0
	 * @Description    删除一个类
	 * @Return   Integer
	 * @Exception
	 * @Date 2019/9/17 9:28
	 */
	@Transactional
	@Override
	public Integer deleteCategory(Integer id) {
		Example example = new Example(Category.class);
		example.createCriteria().andCondition("id=", id);
		return categoryMapper.deleteByExample(example);
	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description  修改一个类别

	 * @Return  Integer
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
		return  categoryMapper.updateByPrimaryKeySelective(c);
	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description      根据id获取一个类别

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


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description 根据名称获取一个类别

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:29
	 */
	@Override
	public Category getCategoryByName(String name ) {
		Example example=new Example(Category.class);
		example.createCriteria().andCondition("categoryName=",name);
		 return categoryMapper.selectOneByExample(example);

	}


	/**
	 * @Method
	 * @Author Lenovo
	 * @Version  1.0
	 * @Description          获取分页信息

	 * @Return
	 * @Exception
	 * @Date 2019/9/17 9:30
	 */
	@Transactional
	@Override
	public PageInfo<Category> getCategoryPage(Integer startPage, Integer pageSize) {
		PageHelper.startPage(0, 20);
		Example example = new Example(Category.class);
		PageInfo<Category> pageInfo = new PageInfo<>(categoryMapper.selectByExample(example));
		return  pageInfo;
	}





}
