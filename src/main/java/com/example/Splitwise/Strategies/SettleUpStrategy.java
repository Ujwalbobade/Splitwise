package com.example.Splitwise.Strategies;

import com.example.Splitwise.Models.Expenses;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SettleUpStrategy {
    public List<Expenses> settleUp(List<Expenses> expenses);
}
