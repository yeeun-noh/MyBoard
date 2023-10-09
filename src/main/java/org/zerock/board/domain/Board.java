package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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

    private int writableGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = true)
    private Board parentBoard = null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentBoard", cascade = CascadeType.REMOVE)
    @OrderBy("sortOrder")
    private List<Board> childBoards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "type", nullable = false)
    private BoardType boardType;

    public boolean canWritable(int userGrade){
        return (writableGrade & userGrade) > 0;
    }
}
