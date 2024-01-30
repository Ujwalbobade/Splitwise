package com.example.Splitwise.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class UserExpense extends BaseModel {

    @ManyToOne
    // Adjust the column name as needed
    private User user;

    @ManyToOne
    private Expenses expenses;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;

    // Constructors, getters, setters, and other methods
}
