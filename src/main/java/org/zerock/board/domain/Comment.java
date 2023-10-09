package org.zerock.board.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
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
    @JoinColumn(name = "writerId", referencedColumnName = "id")
    private Users writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentCommentId", referencedColumnName = "id", nullable = true)
    private Comment parentComment = null;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentComment", cascade = CascadeType.ALL)
    @OrderBy("createdDate")
    private List<Comment> childComment = null;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "commentId", insertable = false, updatable = false)
    private List<CommentActivityHistory> activityHistories = null;

    public long getLikesCount() {
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Like.getValue()).count();
        return count;
    }

    public long getDislikesCount() {
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Dislike.getValue()).count();
        return count;
    }
}
