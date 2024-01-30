package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<group,Long> {
    @Override
    Optional<group> findById(Long aLong);
}
