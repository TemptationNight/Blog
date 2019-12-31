package com.lucas.blog.myblog.shiro;

import com.lucas.blog.myblog.entity.Admin;
import com.lucas.blog.myblog.entity.Permission;
import com.lucas.blog.myblog.entity.Role;
import com.lucas.blog.myblog.service.AdminService;
import com.lucas.blog.myblog.service.PermissionService;
import com.lucas.blog.myblog.service.RoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

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


	@Autowired
	private AdminService adminServiceImpl;

	@Autowired
	private RoleService roleServiceImpl;

	@Autowired
	private PermissionService permissionServiceImpl;


	//执行授权逻辑
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登陆的用户名
		String username=(String)principalCollection.getPrimaryPrincipal();
		//根据登录用户名获取登录用户
		Admin admin = adminServiceImpl.login(username);
		//添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//获取角色
		Role role = roleServiceImpl.getRoleById(admin.getRoleId());
		//获取该角色对应的所有权限
		List<Permission> permissions = permissionServiceImpl.getPermissionsByRoleName(role.getRoleName());
		//添加角色
			simpleAuthorizationInfo.addRole(role.getRoleName());
			for(Permission permission:permissions){
				//添加权限
				simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
		}
		return simpleAuthorizationInfo;



	}


	
	//执行认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		String username=authenticationToken.getPrincipal().toString();
		Admin admin = adminServiceImpl.login(username);
		if(admin==null){
			//这里返回后会报出对应异常
			return null;
		}else{
			//这里验证authenticationToken和simpleAuthenticationInfo的信息       第三个参数代表当前的Realm的名称  第二个参数是数据库的密码
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, admin.getPassword(), getName());
			return simpleAuthenticationInfo;
		}
	}
}
