package com.example.Splitwise.DTO;

import com.example.Splitwise.Models.Expenses;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResDTO {
    private List<Expenses> Transactions;
}
