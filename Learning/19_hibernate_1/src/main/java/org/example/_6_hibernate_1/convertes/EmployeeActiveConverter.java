package org.example._6_hibernate_1.convertes;

import jakarta.persistence.AttributeConverter;
import org.example._6_hibernate_1.enums.Gender;

public class EmployeeActiveConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null) {
            return null;
        }
        return attribute?"YES":"NO";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        return dbData.equals("YES");
    }
}
