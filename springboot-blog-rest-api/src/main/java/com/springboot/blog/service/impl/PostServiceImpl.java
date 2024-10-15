package com.springboot.blog.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.dto.PostDto;
import com.springboot.blog.dto.PostResponse;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFound;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private CommentRepository commentRepository;

	/*
	 * @Autowired // Constructor Injection public PostServiceImpl(PostRepository
	 * postRepository) { super(); this.postRepository = postRepository; }
	 */

	@Override
	public PostDto createPost(PostDto postDto) {

		// convert Dto to Entity for save
		Post post = mapToEntity(postDto);
		Post savePost = postRepository.save(post);

		// convert entity to Dto for response
		PostDto postResponse = mapToDto(savePost);
		return postResponse;
	}

	@Override
	public PostResponse getAllPost(int pageNo, int pageSize, String sortBy) {

		// Sort sort = sortDir.equalsIgnoreCase(sort.DEFAULT_DIRECTION.ASC.name()) ?
		// Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		// sort not working
		// create pageable instance
		// Pageable paging = PageRequest.of(pageNo, pageSize);
		// Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Post> posts = postRepository.findAll(paging);

		// List<Comment> commentList = commentRepository.findAll();

		// List<CommentDto> commentContent = new ArrayList<>();

		// get content for page object
		List<Post> listOfPost = posts.getContent();

		// list of post to list of PostDto return
		List<PostDto> content = listOfPost.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

		PostResponse postResponse = new PostResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;

	}

	@Override
	public PostDto getPostById(Long id) {
		Post findPost = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post", "id", id));
		return mapToDto(findPost);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post", "id", id));

		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());

		Post updatedPost = postRepository.save(post);
		return mapToDto(updatedPost);
	}

	@Override
	public void deletePostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFound("post", "id", id));
		postRepository.delete(post);

	}

	// Method for Convert Entity into DTO
	private PostDto mapToDto(Post post) {
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		postDto.setTitle(post.getTitle());

		return postDto;

	}

	// Method for convert Dto to Entity
	private Post mapToEntity(PostDto postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		post.setTitle(postDto.getTitle());
		return post;

	}

}
