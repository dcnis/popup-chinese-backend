package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

    protected User(){}

    public User(String name, String firstName, String email){
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String firstName;
    public String email;

}