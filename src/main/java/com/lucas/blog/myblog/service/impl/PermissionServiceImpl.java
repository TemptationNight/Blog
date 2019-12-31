package com.lucas.blog.myblog.service.impl;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.service.impl
 * @ClassName: PermissionServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 20:54
 * @Version: 1.0
 */

import com.lucas.blog.myblog.entity.Permission;
import com.lucas.blog.myblog.entity.Role;
import com.lucas.blog.myblog.mapper.PermissionMapper;
import com.lucas.blog.myblog.mapper.RoleMapper;
import com.lucas.blog.myblog.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;


import java.util.ArrayList;
import java.util.List;

/**
 * @program: myblog
 * @ClassName: PermissionServiceImpl
 * @author: Lucas
 * @create: 2019-12-30 20:54
 **/

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PermissionMapper permissionMapper;


	//根据角色获取其对应的权限         因为数据有冗余，所以此处设计的不太好，但也能实现功能
	@Override
	public List<Permission> getPermissionsByRoleName(String roleName) {
		Example example = new Example(Role.class);
		Example example1 = new Example(Permission.class);
		//先通过角色名称查出其所对应的权限id
		example.createCriteria().andEqualTo("roleName", roleName);
		List<Role> roles = roleMapper.selectByExample(example);
		List<Permission> list = new ArrayList();
		for (Role role : roles) {
			//再根据权限id查出权限
			example1.createCriteria().andEqualTo("id", role.getPermissionId());
			Permission permission =  permissionMapper.selectOneByExample(example1);
			list.add(permission);
		}
		return list;
	}
}
