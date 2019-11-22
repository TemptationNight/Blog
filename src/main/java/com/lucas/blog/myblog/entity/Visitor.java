package com.lucas.blog.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "visitor")
public class Visitor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 访问时间
     */
    private Date time;

    /**
     * 访问主机ip
     */
    private String ip;

    /**
     * 访问者的地区
     */
    private String city;

    /**
     * 访问者的路径
     */
    private String url;

    /**
     * 浏览器类型
     */
    @Column(name = "browseType")
    private String browsetype;

    /**
     * 操做系统类型
     */
    @Column(name = "osType")
    private String ostype;


	/**
	 * 是否为黑名单   0否  1是
	 */
    private Integer black;


	public Integer getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	@Column(name = "visitCount")
    private Integer visitCount;

	public Visitor(Date time, String ip, String city, String url, String browsetype, String ostype, int black,Integer visitCount) {
		this.time=time;
		this.ip=ip;
		this.city=city;
		this.url=url;
		this.browsetype=browsetype;
		this.ostype=ostype;
		this.black=black;
		this.visitCount=visitCount;
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
     * 获取访问时间
     *
     * @return time - 访问时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置访问时间
     *
     * @param time 访问时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取访问主机ip
     *
     * @return ip - 访问主机ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置访问主机ip
     *
     * @param ip 访问主机ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取访问者的地区
     *
     * @return city - 访问者的地区
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置访问者的地区
     *
     * @param city 访问者的地区
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取访问者的路径
     *
     * @return url - 访问者的路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问者的路径
     *
     * @param url 访问者的路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取浏览器类型
     *
     * @return browseType - 浏览器类型
     */
    public String getBrowsetype() {
        return browsetype;
    }

    /**
     * 设置浏览器类型
     *
     * @param browsetype 浏览器类型
     */
    public void setBrowsetype(String browsetype) {
        this.browsetype = browsetype;
    }

    /**
     * 获取操做系统类型
     *
     * @return osType - 操做系统类型
     */
    public String getOstype() {
        return ostype;
    }

    /**
     * 设置操做系统类型
     *
     * @param ostype 操做系统类型
     */
    public void setOstype(String ostype) {
        this.ostype = ostype;
    }

    /**
     * @return black
     */
    public Integer getBlack() {
        return black;
    }

    /**
     * @param black
     */
    public void setBlack(Integer black) {
        this.black = black;
    }


	public Visitor(Date time, String ip, String city, String url, String browsetype, String ostype, Integer black) {
		this.time = time;
		this.ip = ip;
		this.city = city;
		this.url = url;
		this.browsetype = browsetype;
		this.ostype = ostype;
		this.black = black;
	}


	public Visitor() {
		super();
	}
}