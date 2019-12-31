package com.lucas.blog.myblog.aop;

import com.lucas.blog.myblog.entity.Visitor;
import com.lucas.blog.myblog.service.VisitorService;
import com.lucas.blog.myblog.utils.UserAgentUtils;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.aop
 * @ClassName: LogAspect
 * @Author: Heyuanhui
 * @Description: ${日志记录类}
 * @Date: 2019/9/3 21:32
 * @Version: 1.0
 */

@Aspect
@Component
public class VisitAspect {

	@Autowired
	private VisitorService visitorServiceImpl;

	//切面  拦截controller包下的所有方法
	@Pointcut("execution(* com.lucas.blog.myblog.controller..*(..))")
	public void visitor() {}


	//获取访客信息
	@Before("visitor()")
	public void doBefore() throws IOException, GeoIp2Exception {
		ServletRequestAttributes servletRequestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
		HttpServletRequest request = servletRequestAttributes.getRequest();
		String ip = UserAgentUtils.getIp(request);
		List<Visitor> visitorList = visitorServiceImpl.getVisitorByIp(ip);
		Visitor visitor=null;
		if(visitorList.size()>0&&visitorList!=null){
			visitor=visitorList.get(0);
		}

		if(visitor==null||visitor.getBlack()!=0){
			String url = UserAgentUtils.getUrl(request);
			String os = UserAgentUtils.getOsName(request);
			String browser = UserAgentUtils.getBrowserName(request);
			String city = UserAgentUtils.getCity(request, ip);

			Date date = new Date();
			Visitor visitor1 = new Visitor(date, ip, city, url, browser, os, 1);
			//将访客信息写入数据库

			Integer i = visitorServiceImpl.insertVisitor(visitor1);
		}
		if(visitor!=null&&visitor.getBlack()==0){

			System.out.println("黑名单");
		}





		/*if(visitorByIp!=null||visitorByIp.getBlack()!=0){        //不在黑名单中
			String url = UserAgentUtils.getUrl(request);
			String os = UserAgentUtils.getOsName(request);
			String browser = UserAgentUtils.getBrowserName(request);
			String city = UserAgentUtils.getCity(request, ip);
			Date date = new Date();
			Visitor visitor = new Visitor(date, ip, city, url, browser, os, 1);
			//将访客信息写入数据库
			System.out.println("visitor="+visitor);
			Integer i = visitorServiceImpl.insertVisitor(visitor);
		}*/
	}
}





