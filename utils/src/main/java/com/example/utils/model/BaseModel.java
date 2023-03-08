package com.example.utils.model;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
  /**
   * Identyfikator encji bazodanowej
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, precision = 19)
  private Long id;

  /**
   * Numer wersji encji
   */
  @Column(precision = 10, name = "VERSION")
  private Integer version;

  /**
   * Data ostatniej modyfikacji encji
   */
  @Column(name = "MODIFICATION_DATE")
  @LastModifiedDate
  private LocalDateTime modificationDate;

  /**
   * Data stworzenia encji
   */
  @Column(name = "CREATION_DATE", updatable = false)
  @CreatedDate
  private LocalDateTime creationDate;
}
