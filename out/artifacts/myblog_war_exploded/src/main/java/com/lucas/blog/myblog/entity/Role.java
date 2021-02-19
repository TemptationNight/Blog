package com.lucas.blog.myblog.entity;/**
import	java.security.Permission;
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.entity
 * @ClassName: Role
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 13:17
 * @Version: 1.0
 */

import javax.persistence.*;

import java.util.Set;

/**
 * @program: myblog
 *
 * @ClassName: Role

 *
 * @author: Lucas
 *
 * @create: 2019-12-30 13:17
 **/


@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;



	/**
	 * 角色名称
	 */
	@Column(name="roleName")
	private String roleName;


	public Role(Integer id,String roleName) {
		this.id=id;
		this.roleName = roleName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


}
