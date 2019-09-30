package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.entity.Link;
import com.lucas.blog.myblog.service.LinkService;
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
	
	
	@GetMapping("/links")
	public String  getLinks(Model model,Integer startPage,Integer pageSize){
		PageInfo<Link> pageInfo = linkServiceImpl.getLinkByPage(startPage, pageSize);
		model.addAttribute("linkPageInfo",pageInfo);
		return "admin/links";
	}



	@GetMapping("/getLinksListNotChecked")
	public String getLinksListNotChecked(Model model){
		List<Link> checkedNot = linkServiceImpl.getLinksListCheckedOrNot(0);
		model.addAttribute("notCheck",checkedNot);
		return "redirect:/admin/links";
	}





	@GetMapping("/getLinksListChecked")
	public String getLinksListChecked(Model model){
		List<Link> checked = linkServiceImpl.getLinksListCheckedOrNot(1);
		model.addAttribute("checked",checked);
		return "redirect:/admin/links";
	}


	@GetMapping("/delete/{id}/link")
	public String deleteLink(@PathVariable Integer id){
		linkServiceImpl.deleteLink(id);
		return "redirect:/admin/links";
	}


	@GetMapping("/setLinkChecked/{id}/link")
	public String setLinkChecked(@PathVariable Integer id){
		linkServiceImpl.setLinkChecked(id);
		return "redirect:/admin/links";
	}


	@PostMapping("/addLink")
	public String  addLink(@RequestParam String linkUrl,@RequestParam String linkName){
		linkServiceImpl.addLink(linkUrl,linkName);
		return "redirect:/admin/links";
	}







}
