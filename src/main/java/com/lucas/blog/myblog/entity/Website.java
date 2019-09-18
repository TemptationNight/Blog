package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "website")
public class Website {
    /**
     * 网站文章数量
     */
    @Column(name = "articleNum")
    private Integer articlenum;

    /**
     * 网站评论总量
     */
    @Column(name = "commmentsNum")
    private Integer commmentsnum;

    /**
     * 文章分类总量
     */
    @Column(name = "categoryNum")
    private Integer categorynum;

    /**
     * 关键字总数
     */
    @Column(name = "keyWordNum")
    private Integer keywordnum;

    /**
     * 友链总数
     */
    @Column(name = "linksNum")
    private Integer linksnum;

    /**
     * 最后更新时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "endUpdateTime")
    private Date endupdatetime;

    /**
     * 浏览总量
     */
    @Column(name = "browseNum")
    private Integer browsenum;


    public Website(){}


	public Website(Integer articlenum, Integer commmentsnum, Integer categorynum, Integer keywordnum, Integer linksnum, Date endupdatetime, Integer browsenum) {
		this.articlenum = articlenum;
		this.commmentsnum = commmentsnum;
		this.categorynum = categorynum;
		this.keywordnum = keywordnum;
		this.linksnum = linksnum;
		this.endupdatetime = endupdatetime;
		this.browsenum = browsenum;
	}

	/**
     * 获取网站文章数量
     *
     * @return articleNum - 网站文章数量
     */
    public Integer getArticlenum() {
        return articlenum;
    }

    /**
     * 设置网站文章数量
     *
     * @param articlenum 网站文章数量
     */
    public void setArticlenum(Integer articlenum) {
        this.articlenum = articlenum;
    }

    /**
     * 获取网站评论总量
     *
     * @return commmentsNum - 网站评论总量
     */
    public Integer getCommmentsnum() {
        return commmentsnum;
    }

    /**
     * 设置网站评论总量
     *
     * @param commmentsnum 网站评论总量
     */
    public void setCommmentsnum(Integer commmentsnum) {
        this.commmentsnum = commmentsnum;
    }

    /**
     * 获取文章分类总量
     *
     * @return categoryNum - 文章分类总量
     */
    public Integer getCategorynum() {
        return categorynum;
    }

    /**
     * 设置文章分类总量
     *
     * @param categorynum 文章分类总量
     */
    public void setCategorynum(Integer categorynum) {
        this.categorynum = categorynum;
    }

    /**
     * 获取关键字总数
     *
     * @return keyWordNum - 关键字总数
     */
    public Integer getKeywordnum() {
        return keywordnum;
    }

    /**
     * 设置关键字总数
     *
     * @param keywordnum 关键字总数
     */
    public void setKeywordnum(Integer keywordnum) {
        this.keywordnum = keywordnum;
    }

    /**
     * 获取友链总数
     *
     * @return linksNum - 友链总数
     */
    public Integer getLinksnum() {
        return linksnum;
    }

    /**
     * 设置友链总数
     *
     * @param linksnum 友链总数
     */
    public void setLinksnum(Integer linksnum) {
        this.linksnum = linksnum;
    }

    /**
     * 获取最后更新时间
     *
     * @return endUpdateTime - 最后更新时间
     */
    public Date getEndupdatetime() {
        return endupdatetime;
    }

    /**
     * 设置最后更新时间
     *
     * @param endupdatetime 最后更新时间
     */
    public void setEndupdatetime(Date endupdatetime) {
        this.endupdatetime = endupdatetime;
    }

    /**
     * 获取浏览总量
     *
     * @return browseNum - 浏览总量
     */
    public Integer getBrowsenum() {
        return browsenum;
    }

    /**
     * 设置浏览总量
     *
     * @param browsenum 浏览总量
     */
    public void setBrowsenum(Integer browsenum) {
        this.browsenum = browsenum;
    }
}