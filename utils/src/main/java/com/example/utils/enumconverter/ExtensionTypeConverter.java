package com.example.utils.enumconverter;

import com.example.utils.enums.ExtensionType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ExtensionTypeConverter implements AttributeConverter<ExtensionType, String> {
    @Override
    public String convertToDatabaseColumn(ExtensionType extensionType) {
        return extensionType.getName();
    }

    @Override
    public ExtensionType convertToEntityAttribute(String s) {
        return ExtensionType.toExtensionType(s);
    }
}

