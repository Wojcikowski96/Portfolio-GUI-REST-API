package com.example.blog.repository;

import com.example.blog.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<ImageModel, Long> {
}
