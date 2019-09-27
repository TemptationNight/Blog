package com.lucas.blog.myblog.controller.admin;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.controller.admin
 * @ClassName: IndexControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/25 16:31
 * @Version: 1.0
 */

import com.lucas.blog.myblog.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.HashMap;

import java.util.Map;

/**
 * @program: myblog
 *
 * @ClassName: IndexControllerAdmin

 *
 * @author: Lucas
 *
 * @create: 2019-09-25 16:31
 **/


@Controller
@RequestMapping("/admin")
public class IndexControllerAdmin {

	@Autowired
	private WebsiteService websiteServiceImpl;


	@GetMapping("/index")
	public String getWebsiteInfo(Model mdoel){

		/*
		 * 获取站点所有信息
		 **/
		Integer articleNum = websiteServiceImpl.getArticleNum();
		Integer browseNum = websiteServiceImpl.getBrowseNum();
		Integer categoryNum = websiteServiceImpl.getCategoryNum();
		Integer commentNum = websiteServiceImpl.getCommentNum();
		Integer linkNum = websiteServiceImpl.getLinkNum();
		Integer moneyNum = websiteServiceImpl.getMoneyNum();
		Integer visitorToday = websiteServiceImpl.getVisitorToday();
		Integer sourceNum = websiteServiceImpl.getSourceNum();

		/*
		 将获取的信息放入model  发给前台页面
		 **/
		Map<String,Integer> map=new HashMap<>();
		map.put("articleNum",articleNum);
		map.put("browseNum",browseNum);
		map.put("categoryNum",categoryNum);
		map.put("commentNum",commentNum);
		map.put("linkNum",linkNum);
		map.put("moneyNum",moneyNum);
		map.put("visitorToday",visitorToday);
		map.put("sourceNum",sourceNum);
		mdoel.addAttribute("websiteInfo",map);
		return "admin/index";
	}






}
