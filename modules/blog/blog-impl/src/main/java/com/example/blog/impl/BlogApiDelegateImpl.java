package com.example.blog.impl;

import com.example.BlogApiDelegate;
import com.example.BlogModuleApi;
import com.example.blog.mapper.BlogEntryMapper;
import com.example.model.GetBlogEntries200Response;
import com.example.model.RequestData;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

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

    Page<BlogEntryDomainImpl> blogEntryDomainPage = blogApi.getBlogEntries(blogEntryMapper.filterRestToDomain(requestData), pageable);

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
}
