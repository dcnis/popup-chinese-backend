package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_id_seq")
    @SequenceGenerator(name = "User_id_seq", sequenceName = "User_id_seq", allocationSize=1)
    public Integer id;
    public String name;
    public String firstName;
    public String email;

}