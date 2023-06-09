package com.ryan.service;

import com.ryan.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);
    Comment saveComment(Comment comment);
}
