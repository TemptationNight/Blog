package com.lucas.blog.myblog.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;


@Repository
@Table(name = "category")
public class Category  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类别名称
     */
    @Column(name = "categoryName")
    private String categoryname;

    /**
     * 添加时间
     */
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    @Column(name = "addTime")
	private String addtime;

    /**
     * 该类别下的文章数量
     */
    @Column(name = "articleNum")
    private Integer articlenum;


    public Category (){}

	public Category(String categoryname, String  addtime, Integer articlenum) {
		this.categoryname = categoryname;
		this.addtime = addtime;
		this.articlenum = articlenum;
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
     * 获取类别名称
     *
     * @return categoryName - 类别名称
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * 设置类别名称
     *
     * @param categoryname 类别名称
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * 获取添加时间
     *
     * @return addTime - 添加时间
     */
    public String  getAddtime() {
        return addtime;
    }

    /**
     * 设置添加时间
     *
	 * @param addtime 添加时间
	 */
    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取该类别下的文章数量
     *
     * @return articleNum - 该类别下的文章数量
     */
    public Integer getArticlenum() {
        return articlenum;
    }

    /**
     * 设置该类别下的文章数量
     *
     * @param articlenum 该类别下的文章数量
     */
    public void setArticlenum(Integer articlenum) {
        this.articlenum = articlenum;
    }


	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", categoryname='" + categoryname + '\'' +
				", addtime=" + addtime +
				", articlenum=" + articlenum +
				'}';
	}



}


