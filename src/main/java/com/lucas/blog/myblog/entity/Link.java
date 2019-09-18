package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "link")
public class Link {
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
    private String isagree;

    /**
     * 是否上架  0否   1是
     */
    @Column(name = "isGrouding")
    private String isgrouding;

    /**
     * 添加时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "addTime")
    private Date addtime;

    public Link(){}

	public Link(String linkurl, String linkname, String isagree, String isgrouding, Date addtime) {
		this.linkurl = linkurl;
		this.linkname = linkname;
		this.isagree = isagree;
		this.isgrouding = isgrouding;
		this.addtime = addtime;
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
    public String getIsagree() {
        return isagree;
    }

    /**
     * 设置是否通过验证   0否  1 是
     *
     * @param isagree 是否通过验证   0否  1 是
     */
    public void setIsagree(String isagree) {
        this.isagree = isagree;
    }

    /**
     * 获取是否上架  0否   1是
     *
     * @return isGrouding - 是否上架  0否   1是
     */
    public String getIsgrouding() {
        return isgrouding;
    }

    /**
     * 设置是否上架  0否   1是
     *
     * @param isgrouding 是否上架  0否   1是
     */
    public void setIsgrouding(String isgrouding) {
        this.isgrouding = isgrouding;
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
}