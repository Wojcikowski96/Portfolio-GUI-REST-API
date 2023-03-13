package com.example.blog.impl;

import com.example.BlogModuleApi;
import com.example.BlogEntryDomain;
import com.example.ImageDomain;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.model.ImageModel;
import com.example.blog.repository.BlogEntryRepository;
import com.example.blog.repository.ImagesRepository;
import com.example.blog.specification.BlogSearchSpecification;
import com.example.utils.Updater;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BlogApiImpl implements BlogModuleApi {
    @Autowired
    BlogEntryRepository blogEntryRepository;

    @Autowired
    ImagesRepository imagesRepository;

    @Autowired
    BlogSearchSpecification blogSearchSpecification;

    @Autowired
    BlogEntryMapper blogEntryMapper;

    @Override
    public Page getBlogEntries(BlogEntryDomain blogEntryDomain, Pageable pageable) {

        Page<BlogEntryModel> blogEntryModels =
                blogEntryRepository.findAll(blogSearchSpecification.getEntries(blogEntryDomain), pageable);

        BlogEntryDomainImpl impl = blogEntryMapper.modelToDomain(blogEntryModels.getContent().get(0));


        Page<BlogEntryDomain> blogEntryDomainPage =
                blogEntryModels.map((blogEntry) -> blogEntryMapper.modelToDomain(blogEntry));

        return blogEntryDomainPage;
    }

    @Override
    public void saveBlogEntry(BlogEntryDomain blogEntryDomain) {
        if (blogEntryDomain.getId() == null) {

            blogEntryRepository.save(blogEntryMapper.domainToModel(blogEntryDomain));

        } else {
            Optional<BlogEntryModel> blogEntryModelOptonal = blogEntryRepository.findById(blogEntryDomain.getId());

            BlogEntryModel blogEntryModelFromDomain = blogEntryMapper.domainToModel(blogEntryDomain);

            BlogEntryModel mergedBlogEntryModel = Updater.updater(blogEntryModelOptonal.get(), blogEntryModelFromDomain);

            blogEntryRepository.save(mergedBlogEntryModel);

        }
    }

    @Override
    public void deleteEntries(List<Long> ids) {

        blogEntryRepository.deleteAllById(ids);
    }

    @Override
    public void uploadImage(ImageDomain imageDomain, Long entryId) {

        Optional<BlogEntryModel> blogEntryModelOptional = blogEntryRepository.findById(entryId);

        ImageModel imageModelFromDomain = blogEntryMapper.domainToModel(imageDomain);

        BlogEntryModel blogEntryModel = blogEntryModelOptional.get();

        if(blogEntryModel.getImage() !=null && blogEntryModel.getImage().getId()!=null){

            ImageModel imageModelFromEntry = blogEntryModel.getImage();

            ImageModel mergedImageModel= Updater.updater(imageModelFromEntry, imageModelFromDomain);

            imagesRepository.save(mergedImageModel);

        }else{

            blogEntryModel.setImage(imageModelFromDomain);

            blogEntryRepository.save(blogEntryModel);
        }


    }
}
