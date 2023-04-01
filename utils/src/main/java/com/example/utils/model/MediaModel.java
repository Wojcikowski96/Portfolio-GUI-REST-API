package com.example.utils.model;

import com.example.utils.enums.ImageType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;


@Data
@MappedSuperclass
public class MediaModel extends BaseModel {

  @Column(name = "NAME")
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "TYPE")
  private ImageType type;

  @Column(name = "IMAGE", unique = false, nullable = false, length = 100000)
  private byte[] image;

  @Column(name = "IMAGE_URL")
  private String imageUrl;

}