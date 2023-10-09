package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class BoardType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Convert(converter = BoardTypeDefinerConverter.class)
    private BoardTypeDefiner type;
}
