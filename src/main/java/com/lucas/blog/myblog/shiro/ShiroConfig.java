package com.lucas.blog.myblog.shiro;


import com.lucas.blog.myblog.shiro.UserRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.Configuration
 * @ClassName: ShiroConfig
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 16:25
 * @Version: 1.0
 */

@Configuration
public class ShiroConfig {


	//不加这个注解不生效，具体不详
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
		defaultAAP.setProxyTargetClass(true);
		return defaultAAP;
	}

	//将自己的验证方式加入容器
	@Bean
	public UserRealm myShiroRealm() {
		UserRealm userRealm = new UserRealm();
		return userRealm;
	}

	//权限管理，配置主要是Realm的管理认证
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	/**
	 * 配置Shiro的Web过滤器，拦截浏览器请求并交给SecurityManager处理
	 *
	 * @return
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		//配置拦截链 使用LinkedHashMap,因为LinkedHashMap是有序的，shiro会根据添加的顺序进行拦截
		Map<String, String> map = new LinkedHashMap<>();

		//配置退出过滤器logout，由shiro实现
		map.put("/admin/login", "logout");

		
		/*
		 *  authc:所有url都必须认证通过才可以访问
		 *  anon:所有url都都可以匿名访问,先配置anon再配置authc
		 *  必须要配置静态资源放行
		 *
		 **/

		//静态资源放行
		map.put("/images/**", "anon");
		map.put("/css/**", "anon");
		map.put("/js/**", "anon");
		map.put("/lib/**", "anon");
		//前台页面放行
		map.put("/page/**", "anon");


		//拦截一切
		map.put("/**", "authc");

		//设置默认登录的URL.  不设置的会默认跳转到:login.jsp
		shiroFilterFactoryBean.setLoginUrl("/page/login");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}


	/**
	 * 开启shiro aop注解支持.
	 * 使用代理方式;所以需要开启代码支持;
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}
