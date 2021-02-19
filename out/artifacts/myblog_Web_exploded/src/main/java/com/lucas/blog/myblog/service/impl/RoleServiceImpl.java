package com.lucas.blog.myblog.service.impl;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.service.impl
 * @ClassName: RoleServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 20:46
 * @Version: 1.0
 */

import com.lucas.blog.myblog.entity.Role;
import com.lucas.blog.myblog.mapper.RoleMapper;
import com.lucas.blog.myblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: myblog
 *
 * @ClassName: RoleServiceImpl

 *
 * @author: Lucas
 *
 * @create: 2019-12-30 20:46
 **/

@Service
public class RoleServiceImpl implements RoleService{


	@Autowired
	private RoleMapper rolemapper;


	//根据id获取角色
	@Override
	public Role getRoleById(Integer id) {
		Example example=new Example(Role.class);
		example.createCriteria().andEqualTo("id",id);
		Role role = rolemapper.selectOneByExample(example);
		return role;
	}
}
