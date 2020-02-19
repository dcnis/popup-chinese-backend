package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;
    public String title;

    public String discussion;

    @OneToOne(targetEntity = Difficulties.class)
    public Integer difficulty;
    
    public String thumbnail;

    @OneToMany(mappedBy = "lesson_id")
    public List<Vocabulary> vocabulary;

}