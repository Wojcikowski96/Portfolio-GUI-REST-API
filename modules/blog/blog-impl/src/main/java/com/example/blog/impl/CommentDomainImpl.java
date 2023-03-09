package com.example.blog.impl;

import com.example.CommentDomain;

public class CommentDomainImpl implements CommentDomain {

  String content;

  Long id;

  @Override
  public String getContent() {
    return this.content;
  }

  @Override
  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public Long getId() {
    return this.id;
  }
}
