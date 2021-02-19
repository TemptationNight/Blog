package com.lucas.blog.myblog.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


@Table(name = "admin")
public class Admin  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 博主邮箱
     */
    private String email;



	/**
	 * 该用户的角色（可能不只一个）
	 */
    @Column(name="roleId")
    private Integer roleId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}



	/**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取博主邮箱
     *
     * @return email - 博主邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置博主邮箱
     *
     * @param email 博主邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }





	public Admin(String username, String password, String email,Integer  roleId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleId=roleId;
	}


	public Admin() {
		super();
	}
}