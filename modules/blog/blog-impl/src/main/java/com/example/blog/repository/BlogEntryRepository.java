package com.example.blog.repository;

import com.example.blog.model.BlogEntryModel;
import com.example.blog.model.BlogMediaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BlogEntryRepository extends JpaRepository<BlogEntryModel, Long> ,
    JpaSpecificationExecutor<BlogEntryModel> {
  BlogEntryModel findByTittle(String tittle);
}
