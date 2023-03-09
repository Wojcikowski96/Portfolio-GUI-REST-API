package com.example.blog.repository;

import com.example.blog.model.BlogEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogEntryRepository extends JpaRepository<BlogEntryModel, Long> ,
    JpaSpecificationExecutor<BlogEntryModel> {
}
