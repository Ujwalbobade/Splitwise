package com.example.Splitwise.Strategies;

import com.example.Splitwise.Models.Expenses;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expenses> settleUp(List<Expenses> expenses) {
        return null;
    }
}
