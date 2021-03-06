package com.lucas.blog.myblog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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

    @Column(name = "addTime")
    private String  addtime;

    /**
     * 该类别下的文章数量
     */
    @Column(name = "articleNum")
    private Integer articlenum;

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
    public void setAddtime(String  addtime) {
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


	public Category(String categoryname, String addtime, Integer articlenum) {
		this.categoryname = categoryname;
		this.addtime = addtime;
		this.articlenum = articlenum;
	}


	public Category() {
		super();
	}
}