package com.example.blog.impl;

import com.example.BlogModuleApi;
import com.example.BlogEntryDomain;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.repository.BlogEntryRepository;
import com.example.blog.specification.BlogSearchSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BlogApiImpl implements BlogModuleApi {
    @Autowired
    BlogEntryRepository repository;

    @Autowired
    BlogSearchSpecification blogSearchSpecification;

    @Autowired
    BlogEntryMapper blogEntryMapper;

    @Override
    public Page getBlogEntries(BlogEntryDomain blogEntryDomain, Pageable pageable) {

        Page<BlogEntryModel> blogEntryModels =
                repository.findAll(blogSearchSpecification.getEntries(blogEntryDomain), pageable);

        BlogEntryDomainImpl impl = blogEntryMapper.modelToDomain(blogEntryModels.getContent().get(0));


        Page<BlogEntryDomain> blogEntryDomainPage =
                blogEntryModels.map((blogEntry) -> blogEntryMapper.modelToDomain(blogEntry));

        return blogEntryDomainPage;
    }

    @Override
    public void saveBlogEntry(BlogEntryDomain blogEntryDomain) {
        if (blogEntryDomain.getId() == null) {
            repository.save(blogEntryMapper.domainToModel(blogEntryDomain));
        } else {
            Optional<BlogEntryModel> blogEntryModelOptonal = repository.findById(blogEntryDomain.getId());

        }
    }
}
