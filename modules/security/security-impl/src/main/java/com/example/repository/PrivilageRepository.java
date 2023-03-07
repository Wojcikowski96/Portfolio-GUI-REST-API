package com.example.repository;

import com.example.model.Privilage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrivilageRepository extends JpaRepository<Privilage, Long> {
    @Query("SELECT s FROM Privilage s WHERE s.name = ?1")
    Privilage findByName(String name);
}
