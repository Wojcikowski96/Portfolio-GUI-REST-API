package com.example.blog.model;

import com.example.utils.model.ImageModel;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BLOG_IMAGE")
public class BlogImageModel extends ImageModel {


}
