package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Vocabulary")
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "vocabulary_id")
    public Integer vocabularyId;

    public Integer lessonId;
    public String typ;
    public String pinyin; 
    public String chinese;
    public String english;
    
    @Column(name = "vocabulary_order")
    public Integer vocabularyOrder;

}
