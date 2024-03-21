package com.example;

import com.example.model.BlogEntryDTO;
import com.example.model.BlogRequestData;
import com.example.model.CommentDTO;
import com.example.model.Error;
import com.example.model.GetBlogEntries200Response;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-21T11:23:53.541498400+01:00[Europe/Warsaw]")
@Controller
@RequestMapping("${openapi.blog.base-path:}")
public class BlogApiController implements BlogApi {

    private final BlogApiDelegate delegate;

    public BlogApiController(@Autowired(required = false) BlogApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new BlogApiDelegate() {});
    }

    @Override
    public BlogApiDelegate getDelegate() {
        return delegate;
    }

}
