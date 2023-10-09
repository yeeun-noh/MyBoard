package org.zerock.board.domain;

import lombok.*;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "id")
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
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    private List<PostActivityHistory> activityHistories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "writerId", referencedColumnName = "id")
    private User writer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "postId", insertable = false, updatable = false)
    private List<Comment> comments;

    public long getLikesCount() {
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Like.getValiue()).count();
        return count;
    }

    public long getDislikesCount() {
        long count = activityHistories.stream()
                .filter(history -> history.getType() == ActivityHistoryTypes.Dislike.getValiue()).count();
        return count;
    }
}
