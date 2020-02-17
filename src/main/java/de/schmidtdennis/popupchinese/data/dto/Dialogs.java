package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * Dialogs
 */

@Data
public class Dialogs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "dialog_id")
    public Integer dialogId;

    @Column(name = "lesson_id")
    public Integer lessonId;

    @Column(name = "dialog_order")
    public Integer dialogOrder;

    public String pinyin;
    public String chinese;
    public String english;
    public String speaker;
    
}