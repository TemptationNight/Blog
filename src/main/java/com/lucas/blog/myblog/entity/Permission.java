package com.lucas.blog.myblog.entity;/**
 * @ProjectName: myblog
 * @Package: com.lucas.blog.myblog.entity
 * @ClassName: Permission
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/12/30 13:20
 * @Version: 1.0
 */

import javax.persistence.*;

/**
 * @program: myblog
 *
 * @ClassName: Permission

 *
 * @author: Lucas
 *
 * @create: 2019-12-30 13:20
 **/

@Table(name="permission")
public class Permission {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;




	/**
	 * 权限名称
	 */
	@Column(name="permissionName")
	private String permissionName;


	public Permission(String permissionName) {
		this.permissionName = permissionName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
}
