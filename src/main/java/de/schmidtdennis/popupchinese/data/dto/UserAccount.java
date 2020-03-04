package de.schmidtdennis.popupchinese.data.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
public class UserAccount {

    protected UserAccount(){}

    public UserAccount(String name, String firstName, String email){
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    public Integer id;
    public String name;
    public String firstName;
    public String email;

    @JsonIgnore
    @OneToMany(mappedBy = "userAccountId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<UserLessons> userLessons;

}