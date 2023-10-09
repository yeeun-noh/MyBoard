package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "comments")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int boardId;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private int viewCount;

    private Date createdDate;

    private Date modifiedDate;

    private Date deletedDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(insertable = false, updatable = false)
    private List<PostActivityHistory> activityHistories;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Users writer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(insertable = false, updatable = false)
    private List<Comment> comments;

    public long getLikesCount(){
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Like.getValue()).count();
        return count;
    }

    public long getDislikesCount(){
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Dislike.getValue()).count();
        return count;
    }
}