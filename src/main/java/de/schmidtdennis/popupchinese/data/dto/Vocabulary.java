package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vocabulary_id")
    public Integer vocabularyId;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    public Integer lessonId;

    public String typ;
    public String pinyin; 
    public String chinese;
    public String english;
    
    @Column(name = "vocabulary_order")
    public Integer vocabularyOrder;

}
