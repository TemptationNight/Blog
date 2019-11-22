package com.lucas.blog.myblog.aop;

import com.lucas.blog.myblog.entity.Log;
import com.lucas.blog.myblog.service.LogService;
import com.lucas.blog.myblog.utils.UserAgentUtils;
import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

import java.util.Date;

/**
 * @program: myblog
 * @ClassName: SystenLogAspect
 * @author: Lucas
 * @create: 2019-10-26 21:52
 **/


@Aspect
@Component
public class SystenLogAspect {

	@Autowired
	private LogService logServiceImpl;

	// Controller层切点
	@Pointcut("@annotation(com.lucas.blog.myblog.aop.SystemLog)")
	public void serviceAspect() {
	}

	@After("serviceAspect()")
	public void doServiceLog(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		try {
			// 数据库日志
			Log log = new Log();
			// 获取日志描述信息
			log.setUsertype(getUserType(joinPoint));
			String args=joinPoint.getArgs().toString();
			log.setArgs(args);
			log.setDescription(getDescription(joinPoint));
			log.setTime(new Date());
			log.setActionType(String.valueOf(getActionType(joinPoint)));
			log.setIp(UserAgentUtils.getIp(request));
			if (!log.getArgs().equals("none")) {
				logServiceImpl.insertLog(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getDescription(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemLog.class).description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中的用户信息 用于controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 用户类型
	 * @throws Exception
	 */

	public static String getUserType(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String userType = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					userType = method.getAnnotation(SystemLog.class).userType();
					break;
				}
			}
		}
		return userType;
	}

	/**
	 * 获取注解中的用户操作类型信息 用于controller层注解
	 *
	 * @param joinPoint 切点
	 * @return 操作类型（增删查改）
	 * @throws Exception
	 */

	public static ActionType getActionType(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		ActionType actionType = ActionType.UNKNOWN;
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					actionType = method.getAnnotation(SystemLog.class).actionType();
					break;
				}
			}
		}
		return actionType;
	}


}
