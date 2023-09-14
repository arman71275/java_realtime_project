package com.springboot.blog.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
	private Long id;
	@NotEmpty  //title should not be null or empty
	@Size(min=3, message ="Post title should be at least 3 character")
	private String title;
	
	@NotEmpty
	@Size(min=10, message ="Post description should have 10 character")
	private String description;
	
	@NotEmpty
	private String content;
	
	private List<CommentDto> comments;

}
