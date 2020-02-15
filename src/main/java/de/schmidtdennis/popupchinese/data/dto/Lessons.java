package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessons_id_seq")
    @SequenceGenerator( 
        name = "lessons_id_seq",
        sequenceName = "lessons_id_seq", 
        allocationSize = 50
    )
    public Integer id;
    public String title;
    public String discussion;

    @ElementCollection(targetClass=VocabularyItem.class)
    public List<VocabularyItem> vocabulary;

    public String difficulty;
    public String thumbnail;

    @ElementCollection(targetClass=TranscriptItem.class)
    public List<TranscriptItem> transcript;
    

}