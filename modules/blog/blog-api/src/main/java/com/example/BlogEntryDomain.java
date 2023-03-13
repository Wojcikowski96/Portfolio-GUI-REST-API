package com.example;

import java.time.LocalDateTime;
import java.util.Set;

public interface BlogEntryDomain {

  String getContent();

  void setContent(String content);

  String getTittle();

  void setTittle(String tittle);

  Long getId();

  void setId(Long id);

  Set<CommentDomain> getComments();

  void setComments(Set<CommentDomain> comments);

  String getUrl();

  void setUrl(String url);

  LocalDateTime getCreationDate();

  LocalDateTime getModifiedDate();

  void setCreationDate(LocalDateTime date);

  void setModificationDate(LocalDateTime date);
}
