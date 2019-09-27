package com.lucas.blog.myblog.aspect;

import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.service.VisitorService;
import com.lucas.blog.myblog.utils.UserAgentUtils;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.aspect
 * @ClassName: LogAspect
 * @Author: Heyuanhui
 * @Description: ${日志记录类}
 * @Date: 2019/9/3 21:32
 * @Version: 1.0
 */

@Aspect
@Component
public class LogAspect {

	@Autowired
	private VisitorService visitorServiceImpl;


	//切面  拦截controller包下的所有方法
	@Pointcut("execution(* com.lucas.blog.myblog.controller.*.*(..))")
	public void log(){}



	@Before("log()")
	public void doBefore() throws IOException, GeoIp2Exception {
		ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
		HttpServletRequest request=servletRequestAttributes.getRequest();
		String ip= UserAgentUtils.getIp(request);
		String url=UserAgentUtils.getUrl(request);
		String os=UserAgentUtils.getOsName(request);
		String browser=UserAgentUtils.getBrowserName(request);
		String city=UserAgentUtils.getCity(request,ip);
		Date date=new Date();
		Visitor visitor=new Visitor(date,ip,city,url,browser,os,1);
		//将访客信息写入数据库
		Integer i=visitorServiceImpl.insertVisitor(visitor);
	}
}
