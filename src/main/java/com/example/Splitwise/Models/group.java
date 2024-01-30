package com.example.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "`group`")
public class group extends BaseModel{
    private String name;
    @ManyToOne
    private User admin ;
    private String UserAdmin;
    @ManyToMany
    private List<User> users;

    @OneToMany
    private List<Expenses> Expenses;
}
