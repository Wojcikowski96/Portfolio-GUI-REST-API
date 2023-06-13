package com.example.blog.repository;

import com.example.blog.model.BlogMediaModel;
import com.example.utils.repository.ImagesRepository;

import java.util.List;
import java.util.Optional;

public interface BlogImageRepository extends ImagesRepository<BlogMediaModel> {
    Optional<List<BlogMediaModel>> findByBlogItemModelId(Long id);
}
