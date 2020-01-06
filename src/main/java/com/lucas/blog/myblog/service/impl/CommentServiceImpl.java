package com.lucas.blog.myblog.service.impl;

import java.util.ArrayList;

import com.lucas.blog.myblog.entity.Comment;
import com.lucas.blog.myblog.mapper.CommentMapper;
import com.lucas.blog.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @ProjectName: myblog
 * @Package: com.heyuanhui.blog.myblog.service.impl
 * @ClassName: CommentServiceImpl
 * @Author: Heyuanhui
 * @Description: ${description}
 * @Date: 2019/9/4 21:07
 * @Version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {


	@Autowired
	private CommentMapper commentMapper;

	//添加留言
	@Override
	public Integer addComment(Comment comment) {
		comment.setAddtime(new Date());
		Integer insert = commentMapper.insert(comment);
		return insert;
	}

	//删除留言
	@Override
	public Integer deleteComment(Integer id) {
		Example example = new Example(Comment.class);
		example.createCriteria().andEqualTo("id", id);
		Integer delete = commentMapper.deleteByExample(example);
		return delete;
	}

	//获取某一篇文章下的所有评论    并且设置他们之间的层级（父子）关系
	@Override
	public List<Comment> getCommentsByBlogId(Integer blogId) {
		Example example = new Example(Comment.class);
		//按照发布时间进行排序
		example.setOrderByClause("addtime DESC");
		example.createCriteria().andEqualTo("articleid", blogId);
		List<Comment> comments = commentMapper.selectByExample(example);
		//找出所有的顶级节点并放入一个集合中
		List<Comment> parentComments = new ArrayList<Comment>();
		for (Comment comment : comments) {
			if (comment.getParent_commentId() == -1) {
				parentComments.add(comment);
			}
		}

		List<Comment> childComments;
		//为每一个父节点添加子节点集合
		for (int i = 0; i < parentComments.size(); i++) {
			childComments = new ArrayList<>();
			for (int j = 0; j < comments.size(); j++) {
				//该节点的父节点Id=父节点结合中的节点id
				if (comments.get(j).getParent_commentId() == parentComments.get(i).getId()) {
					childComments.add(comments.get(j));
				}
			}
			//给该父节点添加  子节点集合
			parentComments.get(i).setChildComment(childComments);
		}
		//返回所有的父节点集合


		System.out.println(parentComments+"==========================="+parentComments.size());
		return parentComments;
	}
}
