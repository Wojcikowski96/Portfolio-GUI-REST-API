package com.example.blog.impl;

import com.example.BlogEntryDomain;
import com.example.CommentDomain;
import java.util.Set;

public class BlogEntryDomainImpl implements BlogEntryDomain {

  String content;

  String tittle;

  Long id;

  Set<CommentDomain> commentDomainSet;

  @Override
  public String getContent() {
    return this.content;
  }

  @Override
  public void setContent(String content) {
    this.content=content;
  }

  @Override
  public String getTittle() {
    return this.tittle;
  }

  @Override
  public void setTittle(String tittle) {
    this.tittle = tittle;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  @Override
  public Set<CommentDomain> getComments() {
    return this.commentDomainSet;
  }

  @Override
  public void setComments(Set<CommentDomain> comments) {
    this.commentDomainSet = comments;
  }
}
