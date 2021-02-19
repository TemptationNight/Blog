package com.lucas.blog.myblog;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;



/**
 * 自己的 Mapper    基础mapper  封装了基础的CRUD操作
 * 特别注意，该接口不能被扫描到，否则会出错
 * @author Heyuanhui
 * @version 1.0.0
 * @date 2019/7/26 0:57
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T>{

}














