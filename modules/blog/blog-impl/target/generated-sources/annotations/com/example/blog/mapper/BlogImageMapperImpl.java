package com.example.blog.mapper;

import com.example.BlogMediaDomain;
import com.example.blog.impl.BlogMediaDomainImpl;
import com.example.blog.model.BlogMediaModel;
import com.example.utils.enums.ImageType;
import com.example.utils.model.MediaModel;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-22T16:30:21+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BlogImageMapperImpl extends BlogImageMapper {

    @Override
    public BlogMediaDomainImpl modelToDomain(MediaModel model) {
        if ( model == null ) {
            return null;
        }

        BlogMediaDomainImpl blogMediaDomainImpl = new BlogMediaDomainImpl();

        blogMediaDomainImpl.setId( model.getId() );
        blogMediaDomainImpl.setName( model.getName() );
        if ( model.getType() != null ) {
            blogMediaDomainImpl.setType( model.getType().name() );
        }
        byte[] image = model.getImage();
        if ( image != null ) {
            blogMediaDomainImpl.setImage( Arrays.copyOf( image, image.length ) );
        }
        blogMediaDomainImpl.setImageUrl( model.getImageUrl() );

        return blogMediaDomainImpl;
    }

    @Override
    public BlogMediaModel domainToModel(BlogMediaDomain domain) {
        if ( domain == null ) {
            return null;
        }

        BlogMediaModel blogMediaModel = new BlogMediaModel();

        blogMediaModel.setId( domain.getId() );
        blogMediaModel.setName( domain.getName() );
        if ( domain.getType() != null ) {
            blogMediaModel.setType( Enum.valueOf( ImageType.class, domain.getType() ) );
        }
        byte[] image = domain.getImage();
        if ( image != null ) {
            blogMediaModel.setImage( Arrays.copyOf( image, image.length ) );
        }
        blogMediaModel.setImageUrl( domain.getImageUrl() );

        return blogMediaModel;
    }
}
