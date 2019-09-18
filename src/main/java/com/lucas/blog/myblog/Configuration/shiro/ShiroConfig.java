package com.lucas.blog.myblog.Configuration.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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




	//创建  ShiroFilterFactoryBean
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);


		return  shiroFilterFactoryBean;
	}



	//创建 DefaultWebSecurityManager
	@Bean(name="defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm realm){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(realm);

		return  securityManager;
	}





	//创建realm
	@Bean(name="userRealm")
	public UserRealm getRealm(){
		return  new UserRealm();
	}





}
