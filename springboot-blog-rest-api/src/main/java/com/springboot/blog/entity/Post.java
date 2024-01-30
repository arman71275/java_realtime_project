package com.springboot.blog.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title",nullable = false)
	private String title;
	private String description;
	private String content;
	
	//@OneToMany(targetEntity = Comment.class,cascade = CascadeType.ALL)
	//@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	//private List<Comment> comment;
	 @OneToMany(mappedBy = "post")
	    private List<Comment> comment;

}
