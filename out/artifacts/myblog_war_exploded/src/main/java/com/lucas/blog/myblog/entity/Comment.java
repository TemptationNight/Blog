package com.lucas.blog.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "comment")
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评论时间
     */
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
     * 内容
     */
    private String content;

    /**
     * 文章id
     */
    @Column(name = "articleId")
    private Integer articleid;






	/**
	 * 父级评论id
	 */
	@Column(name = "parent_commentId")

	private Integer parent_commentId;



	/**
	 * 该评论的子评论集合
	 */
	private List<Comment> childComment;



	public List<Comment> getChildComment() {
		return childComment;
	}

	public void setChildComment(List<Comment> childComment) {
		this.childComment = childComment;
	}









	public Integer getParent_commentId() {
		return parent_commentId;
	}

	public void setParent_commentId(Integer parent_commentId) {
		this.parent_commentId = parent_commentId;
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


	public Comment(Date addtime, String nickname, String email, String content,
				   Integer articleid, Integer parent_commentId) {
		this.addtime = addtime;
		this.nickname = nickname;
		this.email = email;
		this.content = content;
		this.articleid = articleid;
		this.parent_commentId=parent_commentId;
	}


	public Comment() {
		super();
	}



	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", addtime=" + addtime +
				", nickname='" + nickname + '\'' +
				", email='" + email + '\'' +
				", content='" + content + '\'' +
				", articleid=" + articleid +
				", parent_commentId=" + parent_commentId +
				", childComment=" + childComment +
				'}';
	}
}