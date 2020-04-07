package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Lessons")
@Table(name = "lessons")
public class Lessons {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer id;

    public String title;

    public String discussion;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "difficulty")
    private Difficulties difficulty;
    
    public String thumbnail;

    public String audio;

    @JsonIgnore
    @OneToMany(mappedBy = "lessonId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<UserLessons> userLessons;

}