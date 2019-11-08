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
     * 用户类型  0 普通管理员   1超级管理员
     */
    @Column(name = "userType")
    private String  usertype;

	/**
	 * 请求参数
	 */
	@Column(name = "args")
	private String args;



    /**
     * 操做描述
     */
	@Column(name = "description")
    private String description;

    /**
     * 请求时间
     */


	@Column(name = "time")
    private Date time;


	/**
	 * 请求ip
	 */
	@Column(name = "ip")
	private String  ip;


	/**
	 * 操作的类型  这个属性主要是为了方便根操作据类型查询日志
	 */
	@Column(name = "actionType")
	private String  actionType;


	/**
	 *日志距离当前时间  不会储存再数据库 实时刷新
	 */
	@Column(name = "distanceNow")
	private String distanceNow;

	public Log(Integer id,String usertype, String args, String description, Date time, String  ip,String actionType,String distanceNow) {
		this.id=id;
		this.usertype = usertype;
		this.args = args;
		this.description = description;
		this.time = time;
		this.ip = ip;
		this.actionType=actionType;
		this.distanceNow=distanceNow;
	}


	public Log(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getArgs() {
		return args;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String  getIp() {
		return ip;
	}

	public void setIp(String  ip) {
		this.ip = ip;
	}




	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getDistanceNow() {
		return distanceNow;
	}

	public void setDistanceNow(String distanceNow) {
		this.distanceNow = distanceNow;
	}


	@Override
	public String toString() {
		return "Log{" +
				"id=" + id +
				", usertype='" + usertype + '\'' +
				", args='" + args + '\'' +
				", description='" + description + '\'' +
				", time=" + time +
				", ip='" + ip + '\'' +
				", actionType='" + actionType + '\'' +
				", distanceNow='" + distanceNow + '\'' +
				'}';
	}
}