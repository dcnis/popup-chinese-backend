package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import lombok.Data;

@Entity
@Data
@TypeDefs({
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
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
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    public List<VocabularyItem> vocabulary;

    public String difficulty;
    public String thumbnail;

    @ElementCollection(targetClass=TranscriptItem.class)
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    public List<TranscriptItem> transcript;
    

}