package com.example.blog.model;

import com.example.utils.model.MediaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "BLOG_MEDIA")
public class BlogMediaModel extends MediaModel {

    @ManyToOne
    @JoinColumn(name = "BLOG_ID")
    private BlogEntryModel blogItemModel;
}
