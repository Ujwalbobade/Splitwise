package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.User;
import com.example.Splitwise.Models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<UserExpense,Long> {

    List<UserExpense> findAllByUser(User user);
}
