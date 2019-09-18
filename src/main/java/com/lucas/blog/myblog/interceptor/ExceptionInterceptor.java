package com.lucas.blog.myblog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.interceptor
 * @ClassName: ExceptionInterceptor
 * @Author: Heyuanhui
 * @Description: ${拦截所有的异常进行处理}
 * @Date: 2019/9/3 20:57
 * @Version: 1.0
 */


@ControllerAdvice   //拦截所有带有Controller注解的类
public class ExceptionInterceptor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionhander(HttpServletRequest request, Exception e) throws Exception {



		//控制台打印错误信息
		logger.error("Request:URL : {},Exception : {}", request.getRequestURI(), e);


		//抛出异常 交由springboot处理
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}


		//将错误信息返回给前端error页面
		ModelAndView mv = new ModelAndView();
		mv.addObject("url", request.getRequestURI());
		mv.addObject("exception", e);
		mv.setViewName("error/error");
		return mv;
	}
}
