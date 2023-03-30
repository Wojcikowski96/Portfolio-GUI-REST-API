package com.example.utils.enums;

import lombok.Getter;

@Getter
public enum ImageType {

  IMAGE_LEFT_PANE("image_left_pane"),

  IMAGE_BODY("image_body"),

  DOCUMENT("document");

  public final String name;

  ImageType(String name) {
    this.name = name;
  }

  public static ImageType toImageType(String status) {
    switch (status) {
      case "image_body":
        return ImageType.IMAGE_BODY;
      case "image_left_pane":
        return ImageType.IMAGE_LEFT_PANE;
      default:
        return ImageType.DOCUMENT;
    }
  }
}