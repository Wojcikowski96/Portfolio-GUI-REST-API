package com.example.blog.impl;

import com.example.BlogApiDelegate;
import com.example.BlogModuleApi;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.model.BlogEntryDTO;
import com.example.model.GetBlogEntries200Response;
import com.example.model.BlogRequestData;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BlogApiDelegateImpl implements BlogApiDelegate {

  @Autowired
  BlogModuleApi blogApi;

  @Autowired
  BlogEntryMapper blogEntryMapper;

  @Override
  public ResponseEntity<GetBlogEntries200Response> getBlogEntries(BlogRequestData BlogRequestData) {

    Sort sort = Sort.by(Sort.Direction.valueOf(BlogRequestData.getSortDir().getValue()),
        BlogRequestData.getSortBy());

    Pageable pageable =
        PageRequest.of(BlogRequestData.getPageNo() - 1, BlogRequestData.getPageSize(), sort);

    Page<BlogEntryDomainImpl> blogEntryDomainPage =
        blogApi.getBlogEntries(blogEntryMapper.filterRestToDomain(BlogRequestData), pageable);

    GetBlogEntries200Response response = new GetBlogEntries200Response();

    response.setPageNo(BlogRequestData.getPageNo());
    response.setPageSize(BlogRequestData.getPageSize());
    response.setTotalElements(blogEntryDomainPage.getTotalElements());
    response.setTotalPages(blogEntryDomainPage.getTotalPages());

    response.setResults(
        blogEntryDomainPage.getContent().stream().map(log -> blogEntryMapper.domainToRest(log))
            .collect(
                Collectors.toList()));

    return ResponseEntity.ok(response);
  }

  @Override
  public ResponseEntity<Void> saveBlogEntry(BlogEntryDTO blogEntryDTO) {

    blogApi.saveBlogEntry(blogEntryMapper.restToDomain(blogEntryDTO));

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> deleteBlogEntries(List<Long> entryId) {

    blogApi.deleteEntries(entryId);

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Void> uploadImageBlog(Long entryId, String name, String type,
                                          MultipartFile fileByteString){

    BlogMediaDomainImpl imageDomain = new BlogMediaDomainImpl();

    imageDomain.setName(name);

    imageDomain.setType(type);

    try {
      imageDomain.setImage(fileByteString.getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    blogApi.uploadImage(imageDomain, entryId);

    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<Resource> getImage(Long entryId) {

    byte [] imageData = blogApi.getImage(entryId);

    Resource res = new ByteArrayResource(imageData);

    return ResponseEntity.status(HttpStatus.OK).body(res);
  }
}
