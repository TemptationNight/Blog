package com.lucas.blog.myblog;

import com.lucas.blog.myblog.entity.Admin;
import com.lucas.blog.myblog.entity.Role;
import com.lucas.blog.myblog.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogApplication.class)
@Transactional
@Rollback
public class MyblogApplicationTests {

	@Autowired
	private AdminMapper adminMapper;
	@Test
	public void testAdmin() {






	/*	Admin admin=new Admin();
		admin.setUsername("username");
		//admin.setRole(new HashSet<Role>(12,"admin"));
		admin.setEmail("742567489@qq.com");
		admin.setPassword("hyh971127");
		int insert = adminMapper.insert(admin);
		System.out.println("insert="+insert);*/

	}

}
