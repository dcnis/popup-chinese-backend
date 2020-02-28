package de.schmidtdennis.popupchinese.data.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * UserLessons
 */
@Data
@Entity(name = "UserLessons")
@Table(name = "watched_user_account_lessons")
public class UserLessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "user_account_id")
    private UserAccount userAccountId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "lesson_id")
    private Lessons lessonId;

    @Column(name = "last_seen")
    private LocalDateTime lastSeen;

}