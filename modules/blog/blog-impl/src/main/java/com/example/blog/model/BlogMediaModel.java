package com.example.blog.model;

import com.example.utils.model.MediaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BLOG_MEDIA")
public class BlogMediaModel extends MediaModel {


}
