package com.example.utils.enums;

import lombok.Getter;

@Getter
public enum ExtensionType {
    PDF("pdf"),
    IMAGE("image");

    public final String name;

    ExtensionType(String name) {
        this.name = name;
    }

    public static ExtensionType toExtensionType(String status) {
        switch (status) {
            case "pdf":
                return ExtensionType.PDF;
            default:
                return ExtensionType.IMAGE;
        }
    }

}
