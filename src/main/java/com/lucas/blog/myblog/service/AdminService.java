package com.lucas.blog.myblog.service;

import com.lucas.blog.myblog.entity.Admin;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: AdminService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:02
 * @Version: 1.0
 */

public interface AdminService {

	public Admin login(String username);

	public void reg(String username,String password,String email);



}
