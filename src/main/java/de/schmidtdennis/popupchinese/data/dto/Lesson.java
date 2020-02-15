package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Lesson {

    public Integer id;
    public String title;
    public String discussion;
    public List<VocabularyItem> vocabulary;
    public String difficulty;
    public String thumbnail;
    public List<TranscriptItem> transcript;
    

}