package com.example.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Expenses extends BaseModel{
    private  String description;
    private  int Amount;
    @ManyToOne
    private User createdBy;

    @ManyToOne
    private group group;

    @OneToMany
    private List<UserExpense> userExpenses;
    @Enumerated(EnumType.ORDINAL)
    private ExpensesType expensesType;
}
