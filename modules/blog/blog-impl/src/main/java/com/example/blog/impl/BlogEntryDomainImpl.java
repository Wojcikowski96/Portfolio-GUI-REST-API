package com.example.blog.impl;

import com.example.BlogEntryDomain;
import com.example.CommentDomain;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class BlogEntryDomainImpl implements BlogEntryDomain {

  Long id;

  String tittle;

  String content;

  Set<CommentDomain> commentDomainSet;

  String url;

  LocalDateTime creationDate;

  LocalDateTime modificationDate;

  List<String> newsPortalsUrls;

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
  public String getUrl() {
    return this.url;
  }

  @Override
  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public LocalDateTime getCreationDate() {
    return this.creationDate;
  }

  @Override
  public LocalDateTime getModifiedDate() {
    return this.modificationDate;
  }

  @Override
  public List<String> getNewsPortalsUrls() {
    return this.newsPortalsUrls;
  }

  @Override
  public void setNewsPortalsUrls(List<String> newsPortalsUrls) {
    this.newsPortalsUrls = newsPortalsUrls;
  }

  @Override
  public void setCreationDate(LocalDateTime date) {
    this.creationDate = date;
  }

  @Override
  public void setModificationDate(LocalDateTime date) {
    this.modificationDate = date;
  }

}
