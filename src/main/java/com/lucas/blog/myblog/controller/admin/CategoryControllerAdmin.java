package com.lucas.blog.myblog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Category;
import com.lucas.blog.myblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller.admin
 * @ClassName: CategoryControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:38
 * @Version: 1.0
 */


@Controller
@RequestMapping("/admin")
public class CategoryControllerAdmin {

	@Autowired
	private CategoryService categoryServiceImpl;

	@GetMapping("/categorys")
	public String categorys(Model model, Integer startPage, Integer pageSize) {
		PageInfo<Category> pageInfo = categoryServiceImpl.getCategoryPage(startPage, pageSize);
		model.addAttribute("pageInfo", pageInfo);
		return "admin/types";
	}


	@PostMapping("/update/category")
	public String updateCategory(Integer id, String name) {
		    System.out.println(id+""+name);
			Category category=new Category();
			category.setCategoryname(name);
		    System.out.println("setCategoryname="+category.getCategoryname());
			Integer integer = categoryServiceImpl.updateCategory(id, category);
			if(integer!=1){
				System.out.println("修改失败");
			}
		return "redirect:/admin/categorys";
	}


	@GetMapping("/delete/{id}/category")
	public String deleteCategory(@PathVariable Integer id) {
		//删除类下面的文章再删除类
		Integer i = categoryServiceImpl.deleteCategory(id);
		
		return "redirect:/admin/categorys";
	}


	@PostMapping("/addCategory")
	public String addCategory(@RequestParam String name) {
		Category c = categoryServiceImpl.getCategoryByName(name);
		if (c != null) {
			//已经存在  不可以重复添加
		} else {
			Category category = new Category();
			category.setCategoryname(name);
			category.setAddtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			Integer i = categoryServiceImpl.addCategory(category);
		}
		return "redirect:/admin/categorys";
	}
}
