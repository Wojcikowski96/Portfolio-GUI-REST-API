package com.example.utils.enumconverter;

import com.example.utils.enums.ImageType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
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