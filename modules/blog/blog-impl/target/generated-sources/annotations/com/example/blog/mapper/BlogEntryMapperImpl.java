package com.example.blog.mapper;

import com.example.BlogEntryDomain;
import com.example.blog.impl.BlogEntryDomainImpl;
import com.example.blog.model.BlogEntryModel;
import com.example.blog.model.BlogMediaModel;
import com.example.model.BlogEntryDTO;
import com.example.model.BlogRequestData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-21T11:24:22+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BlogEntryMapperImpl extends BlogEntryMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242 = DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm" );

    @Override
    public BlogEntryDTO domainToRest(BlogEntryDomainImpl model) {
        if ( model == null ) {
            return null;
        }

        BlogEntryDTO blogEntryDTO = new BlogEntryDTO();

        blogEntryDTO.setImageUrl( model.getUrl() );
        if ( model.getModifiedDate() != null ) {
            blogEntryDTO.setModificationDate( dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242.format( model.getModifiedDate() ) );
        }
        if ( model.getCreationDate() != null ) {
            blogEntryDTO.setCreationDate( dateTimeFormatter_dd_MM_yyyy_HH_mm_12071769242.format( model.getCreationDate() ) );
        }
        blogEntryDTO.setId( model.getId() );
        blogEntryDTO.setTittle( model.getTittle() );
        blogEntryDTO.setContent( model.getContent() );
        List<String> list = model.getNewsPortalsUrls();
        if ( list != null ) {
            blogEntryDTO.setNewsPortalsUrls( new ArrayList<String>( list ) );
        }

        return blogEntryDTO;
    }

    @Override
    public BlogEntryDomainImpl restToDomain(BlogEntryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BlogEntryDomainImpl blogEntryDomainImpl = new BlogEntryDomainImpl();

        blogEntryDomainImpl.setContent( dto.getContent() );
        blogEntryDomainImpl.setTittle( dto.getTittle() );
        blogEntryDomainImpl.setId( dto.getId() );
        List<String> list = dto.getNewsPortalsUrls();
        if ( list != null ) {
            blogEntryDomainImpl.setNewsPortalsUrls( new ArrayList<String>( list ) );
        }
        if ( dto.getCreationDate() != null ) {
            blogEntryDomainImpl.setCreationDate( LocalDateTime.parse( dto.getCreationDate() ) );
        }
        if ( dto.getModificationDate() != null ) {
            blogEntryDomainImpl.setModificationDate( LocalDateTime.parse( dto.getModificationDate() ) );
        }

        return blogEntryDomainImpl;
    }

    @Override
    public BlogEntryDomainImpl modelToDomain(BlogEntryModel model) {
        if ( model == null ) {
            return null;
        }

        BlogEntryDomainImpl blogEntryDomainImpl = new BlogEntryDomainImpl();

        blogEntryDomainImpl.setUrl( modelBlogImageImageUrl( model ) );
        blogEntryDomainImpl.setContent( model.getContent() );
        blogEntryDomainImpl.setTittle( model.getTittle() );
        blogEntryDomainImpl.setId( model.getId() );
        List<String> list = model.getNewsPortalsUrls();
        if ( list != null ) {
            blogEntryDomainImpl.setNewsPortalsUrls( new ArrayList<String>( list ) );
        }
        blogEntryDomainImpl.setCreationDate( model.getCreationDate() );
        blogEntryDomainImpl.setModificationDate( model.getModificationDate() );

        return blogEntryDomainImpl;
    }

    @Override
    public BlogEntryModel domainToModel(BlogEntryDomain domain) {
        if ( domain == null ) {
            return null;
        }

        BlogEntryModel blogEntryModel = new BlogEntryModel();

        blogEntryModel.setId( domain.getId() );
        blogEntryModel.setCreationDate( domain.getCreationDate() );
        blogEntryModel.setTittle( domain.getTittle() );
        blogEntryModel.setContent( domain.getContent() );
        List<String> list = domain.getNewsPortalsUrls();
        if ( list != null ) {
            blogEntryModel.setNewsPortalsUrls( new ArrayList<String>( list ) );
        }

        return blogEntryModel;
    }

    @Override
    public BlogEntryDomainImpl filterRestToDomain(BlogRequestData BlogRequestData) {
        if ( BlogRequestData == null ) {
            return null;
        }

        BlogEntryDomainImpl blogEntryDomainImpl = new BlogEntryDomainImpl();

        blogEntryDomainImpl.setContent( BlogRequestData.getContent() );
        blogEntryDomainImpl.setTittle( BlogRequestData.getTittle() );
        if ( BlogRequestData.getId() != null ) {
            blogEntryDomainImpl.setId( Long.parseLong( BlogRequestData.getId() ) );
        }
        List<String> list = BlogRequestData.getNewsPortalsUrls();
        if ( list != null ) {
            blogEntryDomainImpl.setNewsPortalsUrls( new ArrayList<String>( list ) );
        }
        if ( BlogRequestData.getCreationDate() != null ) {
            blogEntryDomainImpl.setCreationDate( LocalDateTime.parse( BlogRequestData.getCreationDate() ) );
        }
        if ( BlogRequestData.getModificationDate() != null ) {
            blogEntryDomainImpl.setModificationDate( LocalDateTime.parse( BlogRequestData.getModificationDate() ) );
        }

        return blogEntryDomainImpl;
    }

    private String modelBlogImageImageUrl(BlogEntryModel blogEntryModel) {
        if ( blogEntryModel == null ) {
            return null;
        }
        BlogMediaModel blogImage = blogEntryModel.getBlogImage();
        if ( blogImage == null ) {
            return null;
        }
        String imageUrl = blogImage.getImageUrl();
        if ( imageUrl == null ) {
            return null;
        }
        return imageUrl;
    }
}
