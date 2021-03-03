package com.lucas.blog.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "article")
public class Article implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章所属类别id
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
     * 文章状态   -1，垃圾箱   0，草稿箱 1，发布状态
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



	/**
	 * 摘要
	 */
	@Column(name = "summary")
    private String  summary;


	/**
	 * 是否原创  1是  0 否
	 */
	@Column(name = "isYuanChuang")
    private Integer isYuanChuang;


	/**
	 * 本文章是否开启评论 0否  1是   默认为1
	 */
	@Column(name = "isDiscuss")
    private Integer isDiscuss;




	/**
	 * 文章所属类别名称
	 */
	@Column(name = "categoryName")
	private String categoryName;

	public Article() {
		super();
		this.addtime=new Date();
		this.agreenum=0;
		this.browsenum=0;
		this.status=1;
		this.commentnum=0;
	}


	public Article(String title, Integer categoryid, String author, Date addtime, Integer agreenum, Integer browsenum, Integer commentnum, String keyword, Integer status, Integer isrecommend, Integer istop, String images, String content, Integer isYuanChuang, Integer isDiscuss, String categoryName,String summary) {
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
		this.isYuanChuang = isYuanChuang;
		this.isDiscuss = isDiscuss;
		this.categoryName = categoryName;
		this.summary=summary;
	}







	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getAgreenum() {
		return agreenum;
	}

	public void setAgreenum(Integer agreenum) {
		this.agreenum = agreenum;
	}

	public Integer getBrowsenum() {
		return browsenum;
	}

	public void setBrowsenum(Integer browsenum) {
		this.browsenum = browsenum;
	}

	public Integer getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(Integer commentnum) {
		this.commentnum = commentnum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsrecommend() {
		return isrecommend;
	}

	public void setIsrecommend(Integer isrecommend) {
		this.isrecommend = isrecommend;
	}

	public Integer getIstop() {
		return istop;
	}

	public void setIstop(Integer istop) {
		this.istop = istop;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsYuanChuang() {
		return isYuanChuang;
	}

	public void setIsYuanChuang(Integer isYuanChuang) {
		this.isYuanChuang = isYuanChuang;
	}

	public Integer getIsDiscuss() {
		return isDiscuss;
	}

	public void setIsDiscuss(Integer isDiscuss) {
		this.isDiscuss = isDiscuss;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", title='" + title + '\'' +
				", categoryid=" + categoryid +
				", author='" + author + '\'' +
				", addtime=" + addtime +
				", agreenum=" + agreenum +
				", browsenum=" + browsenum +
				", commentnum=" + commentnum +
				", keyword='" + keyword + '\'' +
				", status=" + status +
				", isrecommend=" + isrecommend +
				", istop=" + istop +
				", images='" + images + '\'' +
				", content='" + content + '\'' +
				", isYuanChuang=" + isYuanChuang +
				", categoryName=" + categoryName +
				", isDiscuss=" + isDiscuss +
				'}';
	}
}