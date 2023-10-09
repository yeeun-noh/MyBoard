package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class UsersGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caption;

    private String icon;

    @Convert(converter = UsersGradeLevelConverter.class)
    private UsersGradeLevel grade;
}
