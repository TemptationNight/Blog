package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.service.VisitorService;
import com.lucas.blog.myblog.utils.DateUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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




	//访客名单统计模块
	@RequestMapping("/visitors")
	public String visitors(Model model, @RequestParam(defaultValue = "0") Integer startPage, @RequestParam(defaultValue = "15") Integer pageSize, @RequestParam(value = "startTime",required = false) String startTime, @RequestParam(value = "endTime",required = false) String endTime, String args) {
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorPage(startPage, pageSize);
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackIpCount();
		int ipCount=visitorServiceImpl.getIpCount();
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		model.addAttribute("count",count).addAttribute("blackCount",blackCount).addAttribute("ipCount",ipCount);
		return "admin/visitors";
	}





	@SystemLog(description = "关键字查询访客:",actionType = ActionType.SELECT)
	@GetMapping("/getVisitorByArgs")
	public String getVisitorByArgs(Model model,@RequestParam(defaultValue = "0") Integer startPage,@RequestParam(defaultValue = "15") Integer pageSize,String args){
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorByArgs(args, startPage, pageSize);
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		int count=visitorServiceImpl.getCountByArgs(args);
		model.addAttribute("count",count);
		return "admin/visitors :: visitorList";
	}


	@SystemLog(description = "按时间查询访客:",actionType = ActionType.SELECT)
	@GetMapping("/getVisitorByTime")
	public String getVisitorByTime(Model model,@RequestParam(defaultValue = "0") Integer startPage,@RequestParam(defaultValue = "10") Integer pageSize,String startTime,String endTime ){
		PageInfo<Visitor> visitorPageInfo = null;
		visitorPageInfo = visitorServiceImpl.getVisitorByTime(DateUtils.stringToDate(startTime), DateUtils.stringToDate(endTime), startPage, pageSize);
		int count=visitorServiceImpl.getCountByTime(DateUtils.stringToDate(startTime), DateUtils.stringToDate(endTime));
		model.addAttribute("count",count);
		model.addAttribute("visitorPageInfo", visitorPageInfo);
		return "admin/visitors :: visitorList";
	}


	//访客ip操作模块
	@GetMapping("/visitorStatistic")
	public String visitorStatistic(Model model,@RequestParam(defaultValue = "0") Integer startPage,@RequestParam(defaultValue = "10") Integer pageSize){
		List<Visitor> visitorList=visitorServiceImpl.getVisitorGroupByIp(startPage,pageSize);
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackIpCount();
		int ipCount=visitorServiceImpl.getIpCount();
		model.addAttribute("visitorPageInfo", visitorList);
		model.addAttribute("currentPage",startPage);
		model.addAttribute("count1",count).addAttribute("blackCount1",blackCount).addAttribute("ipCount1",ipCount);
		return "admin/visitor_statistic";
	}


	@SystemLog(description = "关键字查询访客:",actionType = ActionType.SELECT)
	@GetMapping("/getVisitorStatisticByArgs")
	public String getVisitorStatisticByArgs(String args,@RequestParam(defaultValue = "0") Integer startPage,@RequestParam(defaultValue = "10") Integer pageSize,Model model){
		List<Visitor> visitorList=visitorServiceImpl.getStatisticByArgs(args,startPage,pageSize);
		int ipCount=visitorServiceImpl.getIpCountByArgs(args);
		model.addAttribute("ipCount1",ipCount);
		model.addAttribute("currentPage",startPage);
		model.addAttribute("visitorPageInfo", visitorList);
		return "admin/visitor_statistic :: stasticList";
	}



	//黑名单操作模块
	@GetMapping("/visitorBlack")
	public String visitorBlack(Model model){
		List<Visitor> visitorList=visitorServiceImpl.getBlackVisitorIp();
		for(Visitor visitor:visitorList){
			System.out.println(visitor.toString());
		}
		int count=visitorServiceImpl.getCount();
		int blackCount=visitorServiceImpl.getBlackIpCount();
		int ipCount=visitorServiceImpl.getIpCount();
		model.addAttribute("visitorPageInfo", visitorList);
		model.addAttribute("count",count).addAttribute("blackCount",blackCount).addAttribute("ipCount",ipCount);
		return "admin/visitor_black";
	}


	@SystemLog(description = "关键字查询黑名单:",actionType = ActionType.UNKNOWN)
	@GetMapping("/getVisitorBlackByArgs")
	public String getVisitorBlackByArgs(String args,Model model){
		List<Visitor> visitorList=visitorServiceImpl.getBlackByArgs(args);
		model.addAttribute("visitorPageInfo", visitorList);
		return "admin/visitor_black :: blackList ";
	}


	//将ip加入黑名单
	@RequiresRoles(value = "root")
	@SystemLog(description = "将ip加入黑名单:",actionType = ActionType.UNKNOWN)
	@PostMapping("/addBlack")
	public String addBlack(String ip){
		Integer i=visitorServiceImpl.addBlack(ip);
		return "redirect:/admin/visitorStatistic";
	}


	//将ip移除黑名单
	@RequiresRoles(value = "root")
	@SystemLog(description = "将ip移除黑名单:",actionType = ActionType.UNKNOWN)
	@PostMapping("/outBlack")
	public String outBlack(String ip){
		Integer i=visitorServiceImpl.outBlack(ip);
		return "redirect:/admin/visitorBlack";
	}
}



//约定：数据改变显示使用ajax  数据状态改变使用  全局刷新
