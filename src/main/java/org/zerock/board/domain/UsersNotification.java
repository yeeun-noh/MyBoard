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
public class UsersNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String senderId;

    private String senderNickname;

    private String userId;

    private String content;

    private int contentId;

    private String contentType;

    private Date createdDate;

    private Date modifiedDate;

    private Date deletedDate;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean read;
}
