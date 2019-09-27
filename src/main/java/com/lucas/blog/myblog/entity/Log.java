package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "log")
public class Log  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户类型  0 普通用户   1超级管理员
     */
    @Column(name = "userType")
    private Integer usertype;

    /**
     * 登录主机ip
     */
    private String ip;

    /**
     * 管理员操做
     */
    private String description;

    /**
     * 登录时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date time;




    public Log(){}
	public Log(Integer usertype, String ip, String description, Date time) {
		this.usertype = usertype;
		this.ip = ip;
		this.description = description;
		this.time = time;
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
     * 获取用户类型  0 普通管理员   1超级管理员
     *
     * @return userType - 用户类型  0 普通管理员   1超级管理员
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * 设置用户类型  0 普通管理员   1超级管理员
     *
     * @param usertype 用户类型  0 普通管理员   1超级管理员
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * 获取登录主机ip
     *
     * @return ip - 登录主机ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置登录主机ip
     *
     * @param ip 登录主机ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取管理员操做
     *
     * @return description - 管理员操做
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置管理员操做
     *
     * @param description 管理员操做
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取登录时间
     *
     * @return time - 登录时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置登录时间
     *
     * @param time 登录时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
}