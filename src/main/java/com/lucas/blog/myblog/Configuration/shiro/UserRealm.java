package com.lucas.blog.myblog.Configuration.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.Configuration.shiro
 * @ClassName: UserRealm
 * @Author: Heyuanhui
 * @Description: ${shiro Realm类}
 * @Date: 2019/9/4 16:28
 * @Version: 1.0
 */
public class UserRealm  extends AuthorizingRealm{

	//执行授权逻辑
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	
	//执行认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		return null;
	}
}
