package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.dto.CommentDto;

public interface CommentService {
	
	CommentDto createComment(long postId,CommentDto commentDto);
	
	public List<CommentDto> getCommentByPostId(long postId);
	
	CommentDto getCommentById(Long postId, Long commentId);
	
	CommentDto updateComment(long postId, long commentId, CommentDto commentDto);

	void deleteComment(Long postId, Long commentId);
}
