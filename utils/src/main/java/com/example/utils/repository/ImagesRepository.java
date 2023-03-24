package com.example.utils.repository;

import com.example.utils.model.ImageModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ImagesRepository<T extends ImageModel> extends JpaRepository<T, Long> {

}
