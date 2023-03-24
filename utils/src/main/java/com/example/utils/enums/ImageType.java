package com.example.utils.enums;

import lombok.Getter;

@Getter
public enum ImageType {

  LEFT_PANE("left_pane"),

  BODY("body"),

  TITTLE("tittle");

  public final String name;

  ImageType(String name) {
    this.name = name;
  }

  public static ImageType toImageType(String status) {
    switch (status) {
      case "body":
        return ImageType.BODY;
      case "tittle":
        return ImageType.TITTLE;
      default:
        return ImageType.LEFT_PANE;
    }
  }
}