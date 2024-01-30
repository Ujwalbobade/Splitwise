package com.example.Splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter@Entity
@Table(name = "users")
public class User extends BaseModel{
    private String name;

    private String phoneNo;

    private String Password;

}
