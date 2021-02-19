package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Link;
import com.lucas.blog.myblog.service.LinkService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller.admin
 * @ClassName: LinksControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:38
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class LinksControllerAdmin {

	@Autowired
	private LinkService linkServiceImpl;


	//分页获取友链
	@GetMapping("/links")
	public String getLinks(Model model, Integer startPage, Integer pageSize) {
		//PageInfo<Link> pageInfo = linkServiceImpl.getLinkByPage(startPage, pageSize);
		List<Link> list=linkServiceImpl.getLinkList();
		int linkCount = linkServiceImpl.getCount();
		int linkNotChecked = linkServiceImpl.getLinkCountNotCheck();
		int linkIsChecked = linkServiceImpl.getLinkCountChecked();
		model.addAttribute("linkCount",linkCount).addAttribute("linkNotChecked",linkNotChecked).addAttribute("linkIsChecked",linkIsChecked);
		model.addAttribute("list", list);

		return "admin/links";
	}



	//删除友链
	@RequiresRoles(value = "root")
	@SystemLog(description = "删除友链:", actionType = ActionType.DELETE)
	@PostMapping("/delete/link")
	public String deleteLink(Integer id) {


		System.out.println("=============="+id);
		linkServiceImpl.deleteLink(id);
		return "/admin/links";
	}

	//友链通过
	@RequiresRoles(value = "root")
	@SystemLog(description = "验证通过友链:", actionType = ActionType.INSERT)
	@PostMapping("/setLinkChecked/link")
	public String setLinkChecked(Integer id) {
		linkServiceImpl.setLinkChecked(id);
		return "redirect:/admin/links";
	}


	//添加友链
	@RequiresRoles(value = "root")
	@SystemLog(description = "添加友链:", actionType = ActionType.INSERT)
	@PostMapping("/addLink")
	public String addLink(@RequestParam String linkUrl, @RequestParam String linkName) {
		linkServiceImpl.addLink(linkUrl, linkName);
		return "redirect:/admin/links";
	}


	@GetMapping("/searchLinkByArgs")
	public String searchByArgs(String args,Model model){
		List<Link> list = linkServiceImpl.getLinkByArgs(args);
		model.addAttribute("list", list);
		return "admin/links::linkList";
	}



	@PostMapping("/clickAddOne")
	public String clickAddOne(Integer id,Model model){
		Integer integer = linkServiceImpl.clickNumAddOne(id);
		System.out.println("integer="+integer);
		List<Link> list=linkServiceImpl.getLinkList();
		model.addAttribute("list", list);
		return "admin/links::linkList";
	}
}
