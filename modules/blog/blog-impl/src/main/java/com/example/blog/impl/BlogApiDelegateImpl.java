package com.example.blog.impl;

import com.example.BlogApiDelegate;
import com.example.BlogModuleApi;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.model.BlogEntryDTO;
import com.example.model.GetBlogEntries200Response;
import com.example.model.RequestData;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BlogApiDelegateImpl implements BlogApiDelegate {

  @Autowired
  BlogModuleApi blogApi;

  @Autowired
  BlogEntryMapper blogEntryMapper;

  @Override
  public ResponseEntity<GetBlogEntries200Response> getBlogEntries(RequestData requestData) {

    Sort sort = Sort.by(Sort.Direction.valueOf(requestData.getSortDir().getValue()),
        requestData.getSortBy());

    Pageable pageable =
        PageRequest.of(requestData.getPageNo() - 1, requestData.getPageSize(), sort);

    Page<BlogEntryDomainImpl> blogEntryDomainPage =
        blogApi.getBlogEntries(blogEntryMapper.filterRestToDomain(requestData), pageable);

    GetBlogEntries200Response response = new GetBlogEntries200Response();

    response.setPageNo(requestData.getPageNo());
    response.setPageSize(requestData.getPageSize());
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
  public ResponseEntity<Void> uploadImage(Long entryId, String name, String type,
                                          MultipartFile fileByteString){

    ImageDomainImpl imageDomain = new ImageDomainImpl();

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
}
