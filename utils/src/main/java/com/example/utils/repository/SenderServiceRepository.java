package com.example.utils.repository;

import com.example.utils.model.SenderServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderServiceRepository extends JpaRepository<SenderServiceModel, Long> {
}
