package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评论时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "addTime")
    private Date addtime;

    /**
     * 昵称
     */
    @Column(name = "nickName")
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 容内
     */
    private String content;

    /**
     * 文章id
     */
    @Column(name = "articleId")
    private Integer articleid;

    /**
     * 回复内容
     */
    @Column(name = "answerContent")
    private String answercontent;

    /**
     * 回复人
     */
    @Column(name = "answerPerson")
    private String answerperson;

    /**
     * 回复时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "answerTime")
    private Date answertime;

    public Comment(){}
	public Comment(Date addtime, String nickname, String email, String content, Integer articleid, String answercontent, String answerperson, Date answertime) {
		this.addtime = addtime;
		this.nickname = nickname;
		this.email = email;
		this.content = content;
		this.articleid = articleid;
		this.answercontent = answercontent;
		this.answerperson = answerperson;
		this.answertime = answertime;
	}


	/*
	*
	* 浏览者留言
	* */
	public Comment(Date addtime, String nickname, String email, String content, Integer articleid) {
		this.addtime = addtime;
		this.nickname = nickname;
		this.email = email;
		this.content = content;
		this.articleid = articleid;
	}


	/*
	*
	* 作者回复
	* */
	public Comment(String answercontent, String answerperson, Date answertime) {
		this.answercontent = answercontent;
		this.answerperson = answerperson;
		this.answertime = answertime;
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
     * 获取评论时间
     *
     * @return addTime - 评论时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置评论时间
     *
     * @param addtime 评论时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取昵称
     *
     * @return nickName - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取文章id
     *
     * @return articleId - 文章id
     */
    public Integer getArticleid() {
        return articleid;
    }

    /**
     * 设置文章id
     *
     * @param articleid 文章id
     */
    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    /**
     * 获取回复内容
     *
     * @return answerContent - 回复内容
     */
    public String getAnswercontent() {
        return answercontent;
    }

    /**
     * 设置回复内容
     *
     * @param answercontent 回复内容
     */
    public void setAnswercontent(String answercontent) {
        this.answercontent = answercontent;
    }

    /**
     * 获取回复人
     *
     * @return answerPerson - 回复人
     */
    public String getAnswerperson() {
        return answerperson;
    }

    /**
     * 设置回复人
     *
     * @param answerperson 回复人
     */
    public void setAnswerperson(String answerperson) {
        this.answerperson = answerperson;
    }

    /**
     * 获取回复时间
     *
     * @return answerTime - 回复时间
     */
    public Date getAnswertime() {
        return answertime;
    }

    /**
     * 设置回复时间
     *
     * @param answertime 回复时间
     */
    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }
}