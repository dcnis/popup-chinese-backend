package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessons_id_seq")
    public Integer id;
    public String title;
    public String discussion;
    public String difficulty;
    public String thumbnail;
    

}