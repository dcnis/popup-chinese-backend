package de.schmidtdennis.popupchinese.data.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * UserLessons
 */
@Data
@Entity
@Table(name = "watched_user_account_lessons")
public class UserLessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "user_account_id")
    private Integer userAccountId;

    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "last_seen")
    private Date lastSeen;

}