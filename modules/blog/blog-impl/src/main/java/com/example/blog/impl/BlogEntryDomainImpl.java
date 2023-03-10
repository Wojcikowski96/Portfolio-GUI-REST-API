package com.example.blog.impl;

import com.example.BlogEntryDomain;
import com.example.CommentDomain;
import com.example.ImageDomain;
import java.util.Set;

public class BlogEntryDomainImpl implements BlogEntryDomain {

  Long id;

  String tittle;

  String content;

  Integer version;

  Set<CommentDomain> commentDomainSet;

  ImageDomainImpl image;

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
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Set<CommentDomain> getComments() {
    return this.commentDomainSet;
  }

  @Override
  public void setComments(Set<CommentDomain> comments) {
    this.commentDomainSet = comments;
  }

  @Override
  public ImageDomain getImage() {
    return this.image;
  }

  @Override
  public void setImage(ImageDomain imageDomain) {
    this.image = (ImageDomainImpl) imageDomain;
  }
}
