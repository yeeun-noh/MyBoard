package org.zerock.board.domain;

import javax.persistence.AttributeConverter;

public class UsersGradeLevelConverter implements AttributeConverter<UsersGradeLevel, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UsersGradeLevel attribute) {
        return attribute.getValue();
    }

    @Override
    public UsersGradeLevel convertToEntityAttribute(Integer dbData) {
        try {
            return UsersGradeLevel.fromInteger(dbData);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
