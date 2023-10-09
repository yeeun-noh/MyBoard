package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int postId;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private Date createdDate;

    private Date modifiedDate;

    private Date deletedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Users writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id", nullable = true)
    private Comment parentComment = null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentComment", cascade = CascadeType.ALL)
    @OrderBy("createdDate")
    private List<Comment> childComments;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(insertable = false, updatable = false)
    private List<CommentActivityHistory> activityHistories;

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
