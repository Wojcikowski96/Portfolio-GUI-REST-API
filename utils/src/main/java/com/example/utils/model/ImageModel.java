package com.example.utils.model;

import com.example.utils.enums.ImageType;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;


@Data
@MappedSuperclass
public class ImageModel extends BaseModel {

  @Column(name = "NAME")
  private String name;

//  @Column(name = "TYPE")
//  private ImageType type;

  @Column(name = "IMAGE", unique = false, nullable = false, length = 100000)
  private byte[] image;

  @Column(name = "IMAGE_URL")
  private String imageUrl;

}