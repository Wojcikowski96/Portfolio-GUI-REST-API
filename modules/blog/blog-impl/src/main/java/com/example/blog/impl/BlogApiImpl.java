package com.example.blog.impl;

import com.example.BlogMediaDomain;
import com.example.BlogModuleApi;
import com.example.BlogEntryDomain;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.blog.mapper.BlogImageMapper;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.model.BlogMediaModel;
import com.example.blog.repository.BlogImageRepository;
import com.example.utils.enums.ImageType;
import com.example.utils.model.MediaModel;
import com.example.blog.repository.BlogEntryRepository;
import com.example.blog.specification.BlogSearchSpecification;
import com.example.utils.Utils;
import com.example.utils.exception.ExceptionsFactory;
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
  BlogImageRepository imagesRepository;

  @Autowired
  BlogSearchSpecification blogSearchSpecification;

  @Autowired
  BlogEntryMapper blogEntryMapper;

  @Autowired
  BlogImageMapper blogImageMapper;

  @Override
  public Page getBlogEntries(BlogEntryDomain blogEntryDomain, Pageable pageable) {

    Page<BlogEntryModel> blogEntryModels =
        blogEntryRepository.findAll(blogSearchSpecification.getEntries(blogEntryDomain), pageable);

    Page<BlogEntryDomain> blogEntryDomainPage =
        blogEntryModels.map((blogEntry) -> blogEntryMapper.modelToDomain(blogEntry));

    return blogEntryDomainPage;
  }

  @Override
  public void saveBlogEntry(BlogEntryDomain blogEntryDomain) {
    if (blogEntryDomain.getId() == null) {

      if (blogEntryRepository.findByTittle(blogEntryDomain.getTittle()) != null) {
        throw ExceptionsFactory.createConflict("Wpis z takim tytułem już istnieke",
            "WZTJI", null);
      }

      blogEntryRepository.save(blogEntryMapper.domainToModel(blogEntryDomain));

    } else {
      Optional<BlogEntryModel> blogEntryModelOptonal =
          blogEntryRepository.findById(blogEntryDomain.getId());

      BlogEntryModel blogEntryModelFromDomain = blogEntryMapper.domainToModel(blogEntryDomain);

      BlogEntryModel mergedBlogEntryModel =
          Utils.updater(blogEntryModelOptonal.get(), blogEntryModelFromDomain);

      blogEntryRepository.save(mergedBlogEntryModel);

    }
  }

  @Override
  public void deleteEntries(List<Long> ids) {

    blogEntryRepository.deleteAllById(ids);
  }

  @Override
  public void uploadImage(BlogMediaDomain blogMediaDomain, Long entryId) {

    Optional<BlogEntryModel> blogEntryModelOptional = Optional.ofNullable(
        blogEntryRepository.findById(entryId).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Nie znaleziono wpisu bloga o id: " + entryId, "NZWB", null)));

    try {
      BlogMediaModel imageModelFromDomain = blogImageMapper.domainToModel(blogMediaDomain);


      BlogEntryModel blogEntryModel = blogEntryModelOptional.get();

      if (blogEntryModel.getBlogImage() != null && blogEntryModel.getBlogImage().getId() != null) {

        Optional<BlogMediaModel> blogImageModelToSave =
            imagesRepository.findById(blogEntryModel.getBlogImage().getId());

        blogImageModelToSave.get().setImage(blogMediaDomain.getImage());

        blogImageModelToSave.get().setName(blogMediaDomain.getName());

        blogImageModelToSave.get().setType(ImageType.valueOf(blogMediaDomain.getType()));

        imagesRepository.save(blogImageModelToSave.get());

      } else {

        imageModelFromDomain.setImageUrl(Utils.generateFileUrl(entryId,""));

        blogEntryModel.setBlogImage(imageModelFromDomain);

        blogEntryRepository.save(blogEntryModel);
      }

    } catch (IllegalArgumentException e) {

      throw ExceptionsFactory.createInternalServerError(
          "Brak zdefiniowanego typu obrazka " + blogMediaDomain.getType(), "BZTO", null);
    }
  }

  @Override
  public byte[] getImage(Long entryId) {

    Optional<BlogEntryModel> portfolioItemModelOptional = Optional.ofNullable(
        blogEntryRepository.findById(entryId).orElseThrow(
            () -> ExceptionsFactory.createNotFound(
                "Nie znaleziono wpisu bloga o id: " + entryId, "NZWB", null)));

    MediaModel mediaModel = portfolioItemModelOptional.get().getBlogImage();

    return mediaModel.getImage();

  }
}
