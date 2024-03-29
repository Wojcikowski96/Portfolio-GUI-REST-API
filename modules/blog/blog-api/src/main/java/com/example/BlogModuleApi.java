package com.example;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogModuleApi {
  Page getBlogEntries(BlogEntryDomain blogEntryDomain, Pageable pageable);

  BlogEntryDomain getBlogEntry(Long id);

  void saveBlogEntry(BlogEntryDomain blogEntryDomain);

  void deleteEntries(List<Long> ids);

  void uploadImage(BlogMediaDomain blogMediaDomain, Long entryId);

  byte [] getImage(Long entryId);
}
