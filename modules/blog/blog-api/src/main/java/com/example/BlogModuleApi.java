package com.example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogModuleApi {
  Page getBlogEntries(BlogEntryDomain blogEntryDomain, Pageable pageable);
}
