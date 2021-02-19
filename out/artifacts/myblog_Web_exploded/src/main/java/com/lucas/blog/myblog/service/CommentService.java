package com.lucas.blog.myblog.service;

import com.lucas.blog.myblog.entity.Comment;
import com.lucas.blog.myblog.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service
 * @ClassName: CommentService
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:03
 * @Version: 1.0
 */
@Service
public interface CommentService {



	public Integer addComment(Comment comment);


	public Integer deleteComment(Integer id);


	public List<Comment> getCommentsByBlogId(Integer blogId);



}
