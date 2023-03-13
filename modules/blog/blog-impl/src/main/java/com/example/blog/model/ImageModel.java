package com.example.blog.model;

import com.example.utils.model.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "IMAGES")
@Data
public class ImageModel extends BaseModel {

  @Column(name = "NAME")
  private String name;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "IMAGE", unique = false, nullable = false, length = 100000)
  private byte[] image;

  @Column(name = "IMAGE_URL")
  private String imageUrl;

}