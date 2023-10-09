package org.zerock.board.domain;

import javax.persistence.AttributeConverter;

public class BoardTypeDefinerConverter implements AttributeConverter<BoardTypeDefiner, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BoardTypeDefiner attribute) {
        return attribute.getValue();
    }

    @Override
    public BoardTypeDefiner convertToEntityAttribute(Integer dbData) {
        try {
            return BoardTypeDefiner.fromInteger(dbData);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
