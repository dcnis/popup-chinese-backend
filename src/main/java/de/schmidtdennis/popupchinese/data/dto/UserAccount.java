package de.schmidtdennis.popupchinese.data.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class UserAccount {

    protected UserAccount(){}

    public UserAccount(String name, String firstName, String email){
        this.name = name;
        this.firstName = firstName;
        this.email = email;
    }

    @Id
    @GeneratedValue(generator = "user_account_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_account_id_seq", sequenceName = "user_account_id_seq")
    public Integer id;
    public String name;
    public String firstName;
    public String email;

}