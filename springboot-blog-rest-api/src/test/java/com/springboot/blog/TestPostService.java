
package com.springboot.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.dto.PostDto;
import com.springboot.blog.dto.PostResponse;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.impl.PostServiceImpl;

@SpringBootTest
public class TestPostService {

	@Mock
	private PostRepository PostRepository;

	@InjectMocks
	private PostServiceImpl postService;

	@Test
	void getPostByIdTest() {
		Post post = new Post(1L, "title", "description", "content", null);

		when(PostRepository.findById(1L)).thenReturn(Optional.of(post));

		PostDto result = postService.getPostById(1L);

		assertEquals("title", result.getTitle());
	}

	@Test
	void createPostTest() {
		List<CommentDto> commentList = new ArrayList<>();

		CommentDto commentDto = new CommentDto();
		commentDto.setId(101);
		commentDto.setName("arman");
		commentDto.setEmail("arman@gmail.com");

		commentList.add(commentDto);

		PostDto postDto = new PostDto(1L, "title", "description", "content", commentList);

		Post savedPost = new Post(1L, "title", "description", "content", null);

		when(PostRepository.save(savedPost)).thenReturn(savedPost);

		PostDto result = postService.createPost(postDto);

		assertEquals(1L, result.getId());
		assertEquals("title", result.getTitle());

	}

	@Test
	void getAllPostTest() throws Exception {

		List<Comment> comments = new ArrayList<>();
		comments.add(new Comment(1, "arman", "arman@gmai.com", "body", null));
		List<Post> postList = new ArrayList<>();

		Post post = new Post(1L, "title", "description", "content", comments);
		postList.add(post);
		postList.add(new Post(1L, "title", "description", "content", comments));
		System.out.println("postList::" + postList);

		PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));

		when(PostRepository.findAll(pageRequest)).thenReturn(new PageImpl<>(postList, pageRequest, postList.size()));

		PostResponse allPost = postService.getAllPost(0, 2, "id");

		assertNotNull(allPost);
		assertEquals(2, postList.size());
		assertEquals(2, allPost.getContent().size());
		assertEquals(0, allPost.getPageNo());
		assertEquals(2, allPost.getPageSize());

	}

}
