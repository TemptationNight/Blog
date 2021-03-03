package com.lucas.blog.myblog.service.impl;

import com.lucas.blog.myblog.entity.Admin;
import com.lucas.blog.myblog.mapper.AdminMapper;
import com.lucas.blog.myblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: AdminServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:05
 * @Version: 1.0
 */

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;


	@Override
	public Admin login(String username) {
		Example example = new Example(Admin.class);
		example.createCriteria().andCondition("username=", username);
		Admin admin = adminMapper.selectOneByExample(example);
		return admin;

	}

	//注册用户
	@Override
	public void reg(String username, String password,String email) {
		System.out.println(username+""+password+""+email);
		Admin admin=new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		admin.setUsername(username);
		//默认为普通用户
		admin.setRoleId(5);
		adminMapper.insert(admin);
	}
}
