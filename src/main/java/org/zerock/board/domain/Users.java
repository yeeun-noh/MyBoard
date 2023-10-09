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
public class Users {

    @Id
    private String id;

    private String password;

    private String nickname;

    private String email;

    private Date registeredDate;

    private Date loginDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UsersGrade usersGrade;
}
