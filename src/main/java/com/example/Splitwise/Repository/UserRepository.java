package com.example.Splitwise.Repository;

import com.example.Splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {
    List<User> findAllById(long userid);


    Optional<User> findByPhoneNo(String  phoneNo);

    @Override
     User  save(User entity);


}
