package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.Expenses;
import com.example.Splitwise.Models.group;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    List<Expenses> findAllByGroup(group group);
}
