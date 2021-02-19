package com.lucas.blog.myblog.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "picture")
public class Picture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 图片存储地址
     */
    private String url;

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
     * 获取图片名称
     *
     * @return name - 图片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置图片名称
     *
     * @param name 图片名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取图片存储地址
     *
     * @return url - 图片存储地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片存储地址
     *
     * @param url 图片存储地址
     */
    public void setUrl(String url) {
        this.url = url;
    }


	public Picture(String name, String url) {
		this.name = name;
		this.url = url;
	}


	public Picture() {
		super();
	}
}