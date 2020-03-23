package com.quan.blog.dao;


import com.quan.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentDao {

    //根据创建时间倒序来排
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId);

    //查询父级对象
    Comment findByParentCommentId(Long parentCommentId);


    //添加一个评论
    int saveComment(Comment comment);
}
