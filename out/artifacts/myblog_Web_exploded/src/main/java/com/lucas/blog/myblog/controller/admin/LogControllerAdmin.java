package com.lucas.blog.myblog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Log;
import com.lucas.blog.myblog.service.LogService;
import com.lucas.blog.myblog.utils.DateUtils;
import com.lucas.blog.myblog.utils.TimeOutUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller.admin
 * @ClassName: LogControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:37
 * @Version: 1.0
 */
@Controller
@RequestMapping("/admin")
public class LogControllerAdmin {

	@Autowired
	private LogService logServiceImpl;


	private static final String customer = "普通游客";
	private static final String administrator = "管理员";

	@GetMapping("/logs")
	public String Logs(@RequestParam(value = "startTime", required = false) String startTime, @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(defaultValue = "1") Integer startPage, @RequestParam(defaultValue = "10") Integer pageSize, Model model, @RequestParam(value = "userType", required = false) String userType, @RequestParam(value = "desc", defaultValue = "") String desc) {
		//为什么每一个查询都要带    startPage 和pageSize呢   因为后续进行分页操作的时候方便
		PageInfo<Log> logPageInfo = null;
		logPageInfo = logServiceImpl.getLogByPage(startPage, pageSize);
		Integer logCount=logServiceImpl.getLogCount();
		model.addAttribute("logCount",logCount);
		//对距离现在时间进行处理  获取实时时间数据
		TimeOutUtils.TimeDistanceNow(logPageInfo);
		model.addAttribute("logInfo", logPageInfo);
		return "admin/log";
	}


	//参数表达化查询
	@SystemLog(description = "关键字查询日志",actionType = ActionType.SELECT)
	@GetMapping("/searchByDesc")
	public String searchByDesc(String userType, String desc, @RequestParam(defaultValue = "1") Integer startPage, @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
		PageInfo<Log> logPageInfo = null;
		Integer  count=null;
		if (userType.equals("customer")) {
			logPageInfo = logServiceImpl.getLogByPageCustomer(startPage, pageSize, customer, desc);
			count=logServiceImpl.getLogCountByArgs(customer,desc);
		} else if (userType.equals("administrator")) {
			logPageInfo = logServiceImpl.getLogByPageAdministrator(startPage, pageSize, administrator, desc);
			count=logServiceImpl.getLogCountByArgs(administrator,desc);
		}
		System.out.println("count="+count);
		//对距离现在时间进行处理  获取实时时间数据
		TimeOutUtils.TimeDistanceNow(logPageInfo);
		model.addAttribute("logInfo", logPageInfo);
		model.addAttribute("logCount",count);
		return "admin/log :: list";
	}


	//按时间查询
	@SystemLog(description = "按时间查询日志:",actionType = ActionType.SELECT)
	@GetMapping("/searByTime")
	public String searByTime(String startTime, String endTime, @RequestParam(defaultValue = "1") Integer startPage, @RequestParam(defaultValue = "10") Integer pageSize,Model model) {
		PageInfo<Log> logPageInfo = null;
		logPageInfo = logServiceImpl.getLogByTime(DateUtils.stringToDate(startTime), DateUtils.stringToDate(endTime), startPage, pageSize);
		Integer count=logServiceImpl.getLogByTime(DateUtils.stringToDate(startTime),DateUtils.stringToDate(endTime));
		//对距离现在时间进行处理  获取实时时间数据
		TimeOutUtils.TimeDistanceNow(logPageInfo);
		model.addAttribute("logInfo", logPageInfo);
		model.addAttribute("count",count);
		return "admin/log :: list";
	}
}


