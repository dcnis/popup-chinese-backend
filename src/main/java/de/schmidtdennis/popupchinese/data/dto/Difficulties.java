package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * Difficulties
 */
@Entity(name = "Difficulties")
@Table(name = "difficulties")
public class Difficulties {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String description;

    @JsonIgnore
    @OneToMany(mappedBy = "difficulty", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lessons> lesson;
    
}