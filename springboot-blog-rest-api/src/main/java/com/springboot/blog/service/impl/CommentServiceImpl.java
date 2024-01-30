package com.springboot.blog.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.exception.ResourceNotFound;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;

	
	/*
	 * public CommentServiceImpl(CommentRepository commentRepository,PostRepository
	 * postRepositor) { super(); this.commentRepository = commentRepository;
	 * this.postRepository = postRepository; }
	 */


	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		
		Comment comment = mapToEntity(commentDto);
		
		//retrive post entity by Id
		Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFound("post", "id", postId));
		
		//set post to comment entity
		comment.setPost(post);
		
		//save comment entity to database
		Comment saveNewComment = commentRepository.save(comment);
		
		return mapToDto(saveNewComment);
	}
	
	

	//convert Comment Entity to CommentDto
	private CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getCommentId() );
		commentDto.setName(comment.getName());
		commentDto.setEmail(comment.getEmail());
		commentDto.setBody(comment.getBody());
		return commentDto;
		
	}
	//convert CommentDto to Comment Entity
	private Comment mapToEntity(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setCommentId(commentDto.getId());
		comment.setName(commentDto.getName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		
		return comment;
		
	}



	@Override
	public List<CommentDto> getCommentByPostId(long postId) {
		//retrive comments by postId
		List<Comment> commentList = commentRepository.findByPostId(postId);
		
		//convert list of comment entities to list of comment dto's
		return commentList.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
		
	}



	
	  @Override
	  public CommentDto getCommentById(Long postId, Long commentId) {
	  Post post = postRepository.findById(postId).orElseThrow( 
			  () -> new ResourceNotFound("post", "id", postId));
	  
	  // retrieve comment by id Comment comment =
	  Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new
	  ResourceNotFound("Comment", "id", commentId));
	  
	  if(!comment.getPost().getId().equals(post.getId())){ throw new
	  BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
	  }
	  
	  return mapToDto(comment); }



	@Override
	public CommentDto updateComment(long postId, long commentId, CommentDto commentDto) {
		// retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFound("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }

        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());

        Comment updatedComment = commentRepository.save(comment);
        return mapToDto(updatedComment);
	}



	@Override
	public void deleteComment(Long postId, Long commentId) {
		// retrieve post entity by id
		Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFound("Post", "id", postId));
		
		 // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFound("Comment", "id", commentId));
        
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
        }
        
        commentRepository.delete(comment);
	}
	 



	
}
