package com.example.utils.enums;

import lombok.Getter;

@Getter
public enum ImageType {

  LEFT_PANE("left_pane"),
  BODY("body");

  public final String name;

  ImageType(String name) {
    this.name = name;
  }

  public static ImageType toImageType(String status) {
    switch (status) {
      case "body":
        return ImageType.BODY;
      default:
        return ImageType.LEFT_PANE;
    }
  }
}