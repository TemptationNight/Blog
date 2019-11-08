package com.lucas.blog.myblog.aop;

import java.lang.annotation.*;

/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.aop
 * @ClassName: SystemLog
 * @Author: Heyuanhui
 * @Description: ${自定义注解}
 * @Date: 2019/10/26 21:11
 * @Version: 1.0
 */


@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {


	/**
	 * 方法描述,可使用占位符获取参数:{{tel}}
	 */
	String description()  default "";



	/**
	 * 访问者类型
	 */
	String userType()  default "管理员";


	/**
	 * 操作类型(enum):主要是select,insert,update,delete
	 */

	ActionType actionType() default ActionType.UNKNOWN;





}
