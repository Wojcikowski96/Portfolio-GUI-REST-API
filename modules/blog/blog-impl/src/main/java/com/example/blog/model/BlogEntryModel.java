package com.example.blog.model;

import com.example.utils.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Data;

@Entity
@Table(name = "BLOG_ENTRY")
@Data
public class BlogEntryModel extends BaseModel {

  @Column(name = "TITTLE")
  private String tittle;

  @Column(name= "CONTENT")
  private String content;

  @OneToOne(cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private ImageModel image;

  @OneToMany
  @JoinColumn(name = "BLOG_ENTRY_ID")
  private Set<BlogCommentModel> blogCommentModelSet;

}
