package com.example.Splitwise.CommandLine;

import jakarta.persistence.criteria.CriteriaBuilder;

public class AddExpense implements Commands{
    @Override
    public boolean Matches(String Input) {
        return Input.toLowerCase().contains("addexpense");
    }

    @Override
    public void execute(String String) {

            }
}
