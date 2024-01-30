package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.dto.PostResponse;


public interface PostService {
	public  PostDto createPost(PostDto postDto);
	public PostResponse getAllPost(int pageNo, int pageSize,String sortBy);
	public PostDto getPostById(Long id);
	public PostDto updatePost(PostDto postDto, Long id);
	public void deletePostById(Long id);
	

}
