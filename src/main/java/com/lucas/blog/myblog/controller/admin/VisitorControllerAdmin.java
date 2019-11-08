package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.mapper.VisitorIpMapper;
import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.service.VisitorService;
import com.lucas.blog.myblog.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller
 * @ClassName: VisitorControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/5 9:26
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class VisitorControllerAdmin {


	@Autowired
	private VisitorService visitorServiceImpl;

	@Autowired
	private VisitorIpMapper visitorIpMapper;


	//访客名单统计模块
	@RequestMapping("/visitors")
	public String visitors(Model model, @RequestParam(defaultValue = "1") Integer startPage, @RequestParam(defaultValue = "20") Integer pageSize, @RequestParam(value = "startTime",required = false) String startTime, @RequestParam(value = "endTime",required = false) String endTime, String args) {
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorPage(startPage, pageSize);
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackCount();
		int userCount=visitorServiceImpl.getUserCount();
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		model.addAttribute("count",count);
		model.addAttribute("blackCount",blackCount);
		model.addAttribute("userCount",userCount);
		return "admin/visitors";
	}





	@GetMapping("/getVisitorByArgs")
	public String getVisitorByArgs(Model model,@RequestParam(defaultValue = "1") Integer startPage,@RequestParam(defaultValue = "10") Integer pageSize,String args){
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorByArgs(args, startPage, pageSize);
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		return "admin/visitors :: visitorList";
	}


	@GetMapping("/getVisitorByTime")
	public String getVisitorByTime(Model model,@RequestParam(defaultValue = "1") Integer startPage,@RequestParam(defaultValue = "10") Integer pageSize,String startTime,String endTime ){
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorByTime(DateUtils.stringToDate(startTime), DateUtils.stringToDate(endTime), startPage, pageSize);
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		return "admin/visitors :: visitorList";
	}












	//访客名单操作模块
	@GetMapping("/visitorStatistic")
	public String visitorStatistic(Model model){
		List<Visitor> visitorList=visitorIpMapper.getVisitorGroupByIp();
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackCount();
		int userCount=visitorServiceImpl.getUserCount();
		model.addAttribute("visitorPageInfo", visitorList);
		model.addAttribute("count",count);
		model.addAttribute("blackCount",blackCount);
		model.addAttribute("userCount",userCount);
		return "admin/visitor_statistic";
	}






	//黑名单操作模块
	@GetMapping("/visitorBlack")
	public String visitorBlack(Model model){
		List<Visitor> visitorList=visitorIpMapper.getBlackVisitorIp();
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackCount();
		int userCount=visitorServiceImpl.getUserCount();
		model.addAttribute("visitorPageInfo", visitorList);

		model.addAttribute("count",count);
		model.addAttribute("blackCount",blackCount);
		model.addAttribute("userCount",userCount);
		return "admin/visitor_black";
	}
}


