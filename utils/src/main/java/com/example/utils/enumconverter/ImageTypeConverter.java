package com.example.utils.enumconverter;

import com.example.utils.enums.ImageType;
import jakarta.persistence.AttributeConverter;

public class ImageTypeConverter implements AttributeConverter<ImageType, String> {
  @Override
  public String convertToDatabaseColumn(ImageType imageType) {
    return imageType.getName();
  }

  @Override
  public ImageType convertToEntityAttribute(String s) {
    return ImageType.toImageType(s);
  }
}