package com.example;

import java.util.Set;

public interface BlogEntryDomain {

  String getContent();

  void setContent(String content);

  String getTittle();

  void setTittle(String tittle);

  Long getId();

  Set<CommentDomain> getComments();

  void setComments(Set<CommentDomain> comments);
}
