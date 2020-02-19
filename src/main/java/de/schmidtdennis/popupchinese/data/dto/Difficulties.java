package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

/**
 * Difficulties
 */
@Entity
@Data
public class Difficulties {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String description;

    @OneToOne(mappedBy = "difficulty")
    public Lessons lesson;
    
}