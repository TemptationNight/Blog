package com.lucas.blog.myblog.controller;

import com.lucas.blog.myblog.aop.ActionType;
import com.lucas.blog.myblog.aop.SystemLog;
import com.lucas.blog.myblog.entity.Comment;
import com.lucas.blog.myblog.service.CommentService;
import com.lucas.blog.myblog.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.controller
 * @ClassName: CommentControllerAdmin
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/10 19:36
 * @Version: 1.0
 */

@Controller
@RequestMapping("/page")
public class CommentController {

	@Autowired
	private CommentService commentServiceImpl;


	//获取所有的评论信息

	@GetMapping("/comments/{blogId}")
	public String  comments(@PathVariable Integer blogId, Model model){
		List<Comment> comments = commentServiceImpl.getCommentsByBlogId(blogId);
		model.addAttribute("commentList",comments);
		return "page/blog_detail::commentList";
	}



	//发布评论
	@PostMapping("/addComment")
	@SystemLog(actionType = ActionType.INSERT,description = "发表评论")
	public  String addComment(Comment comment){
		Integer integer = commentServiceImpl.addComment(comment);
		return "redirect:/page/comments/"+comment.getArticleid();
	}




	public String deleteCommment(Integer id){
		Integer integer = commentServiceImpl.deleteComment(id);
		return "";
	}








}
