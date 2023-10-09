package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String ownerId;

    private String icon;

    private Date createdDate;

    private Date modifiedDate;

    private Date deletedDate;

    private int sortOrder;

    private int writableGrade; //등급별 글쓰기 권한

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentBoardId", referencedColumnName = "id", nullable = false)
    private Board parentBoard = null;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "type", referencedColumnName = "type", nullable = false)
    private BoardType boardType;

    public boolean ableToWrite(int userGrade) {
        return (writableGrade & userGrade) > 0;
    }
}
