package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "article")
public class Article  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 类别id
     */
    @Column(name = "categoryId")
    private Integer categoryid;

    /**
     * 作者
     */
    private String author;

    /**
     * 文章发布时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "addTime")
    private Date addtime;

    /**
     * 文章点赞数量
     */
    @Column(name = "agreeNum")
    private Integer agreenum;

    /**
     * 文章浏览量
     */
    @Column(name = "browseNum")
    private Integer browsenum;

    /**
     * 文章评论数量
     */
    @Column(name = "commentNum")
    private Integer commentnum;

    /**
     * 文章关键字
     */
    @Column(name = "keyWord")
    private String keyword;

    /**
     * 文章状态     0，草稿箱 1，发布状态
     */
    private Integer status;



    /**
     * 是否为推荐文章 0否  1是
     */
    @Column(name = "isRecommend")
    private Integer isrecommend;

    /**
     * 是否置顶   0 否  ，1是
     */
    @Column(name = "isTop")
    private Integer istop;

    /**
     * 文章图片地址
     */
    private String images;

    /**
     * 文章内容
     */
    private String content;


    public Article(){}


	public Article(String title, Integer categoryid, String author, Date addtime, Integer agreenum, Integer browsenum, Integer commentnum, String keyword, Integer status,  Integer isrecommend, Integer istop, String images, String content) {
		this.title = title;
		this.categoryid = categoryid;
		this.author = author;
		this.addtime = addtime;
		this.agreenum = agreenum;
		this.browsenum = browsenum;
		this.commentnum = commentnum;
		this.keyword = keyword;
		this.status = status;

		this.isrecommend = isrecommend;
		this.istop = istop;
		this.images = images;
		this.content = content;
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
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取类别id
     *
     * @return categoryId - 类别id
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * 设置类别id
     *
     * @param categoryid 类别id
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取文章发布时间
     *
     * @return addTime - 文章发布时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置文章发布时间
     *
     * @param addtime 文章发布时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取文章点赞数量
     *
     * @return agreeNum - 文章点赞数量
     */
    public Integer getAgreenum() {
        return agreenum;
    }

    /**
     * 设置文章点赞数量
     *
     * @param agreenum 文章点赞数量
     */
    public void setAgreenum(Integer agreenum) {
        this.agreenum = agreenum;
    }

    /**
     * 获取文章浏览量
     *
     * @return browseNum - 文章浏览量
     */
    public Integer getBrowsenum() {
        return browsenum;
    }

    /**
     * 设置文章浏览量
     *
     * @param browsenum 文章浏览量
     */
    public void setBrowsenum(Integer browsenum) {
        this.browsenum = browsenum;
    }

    /**
     * 获取文章评论数量
     *
     * @return commentNum - 文章评论数量
     */
    public Integer getCommentnum() {
        return commentnum;
    }

    /**
     * 设置文章评论数量
     *
     * @param commentnum 文章评论数量
     */
    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    /**
     * 获取文章关键字
     *
     * @return keyWord - 文章关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置文章关键字
     *
     * @param keyword 文章关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取文章状态   -1，垃圾箱   0，草稿箱 1，发布状态
     *
     * @return status - 文章状态   -1，垃圾箱   0，草稿箱 1，发布状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置文章状态    0，草稿箱 1，发布状态
     *
     * @param status 文章状态     0，草稿箱 1，发布状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否为推荐文章 0否  1是
     *
     * @return isRecommend - 是否为推荐文章 0否  1是
     */
    public Integer getIsrecommend() {
        return isrecommend;
    }

    /**
     * 设置是否为推荐文章 0否  1是
     *
     * @param isrecommend 是否为推荐文章 0否  1是
     */
    public void setIsrecommend(Integer isrecommend) {
        this.isrecommend = isrecommend;
    }

    /**
     * 获取是否置顶   0 否  ，1是
     *
     * @return isTop - 是否置顶   0 否  ，1是
     */
    public Integer getIstop() {
        return istop;
    }

    /**
     * 设置是否置顶   0 否  ，1是
     *
     * @param istop 是否置顶   0 否  ，1是
     */
    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    /**
     * 获取文章图片地址
     *
     * @return images - 文章图片地址
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置文章图片地址
     *
     * @param images 文章图片地址
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     * 获取文章内容
     *
     * @return content - 文章内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置文章内容
     *
     * @param content 文章内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}