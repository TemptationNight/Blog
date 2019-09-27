package com.lucas.blog.myblog.service;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Category;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: CategoryService
 * @Author: Heyuanhui
 * @Description: ${分类的方法}
 * @Date: 2019/9/4 21:03
 * @Version: 1.0
 */

public interface CategoryService {

	Integer addCategory(Category category);

	Integer deleteCategory(Integer id);

	Integer updateCategory(Integer id,Category  category);

	Category getCategoryById(Integer id);

	public List<Category> getCategoryList();
	Category getCategoryByName(String name);
	PageInfo<Category> getCategoryPage(Integer startPage, Integer pageSize);
}
