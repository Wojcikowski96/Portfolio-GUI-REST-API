package com.example.blog.model;


import com.example.utils.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BLOG_COMMENT")
@Data
public class BlogCommentModel extends BaseModel {

  @Column(name = "CONTENT")
  private String content;
}
