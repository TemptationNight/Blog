package com.lucas.blog.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "link")
public class Link implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 连接地址
     */
    @Column(name = "linkUrl")
    private String linkurl;

    /**
     * 连接名称
     */
    @Column(name = "linkName")
    private String linkname;

    /**
     * 是否通过验证   0否  1 是
     */
    @Column(name = "isAgree")
    private Integer isagree;

    /**
     * 添加时间
     */
    @Column(name = "addTime")
    private Date addtime;

	/**
	 * 点击量
	 */
    @Column(name = "clickNum")
    private Integer clicknum;



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
     * 获取连接地址
     *
     * @return linkUrl - 连接地址
     */
    public String getLinkurl() {
        return linkurl;
    }

    /**
     * 设置连接地址
     *
     * @param linkurl 连接地址
     */
    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    /**
     * 获取连接名称
     *
     * @return linkName - 连接名称
     */
    public String getLinkname() {
        return linkname;
    }

    /**
     * 设置连接名称
     *
     * @param linkname 连接名称
     */
    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    /**
     * 获取是否通过验证   0否  1 是
     *
     * @return isAgree - 是否通过验证   0否  1 是
     */
    public Integer getIsagree() {
        return isagree;
    }

    /**
     * 设置是否通过验证   0否  1 是
     *
     * @param isagree 是否通过验证   0否  1 是
     */
    public void setIsagree(Integer isagree) {
        this.isagree = isagree;
    }

    /**
     * 获取添加时间
     *
     * @return addTime - 添加时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置添加时间
     *
     * @param addtime 添加时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * @return clickNum
     */
    public Integer getClicknum() {
        return clicknum;
    }

    /**
     * @param clicknum
     */
    public void setClicknum(Integer clicknum) {
        this.clicknum = clicknum;
    }



	public Link(String linkurl, String linkname, int isagree, int clicknum, Date addtime) {
		this.linkurl=linkurl;
		this.linkname=linkname;
		this.addtime=addtime;
		this.isagree=isagree;
		this.clicknum=clicknum;
	}



	public Link(){}
}