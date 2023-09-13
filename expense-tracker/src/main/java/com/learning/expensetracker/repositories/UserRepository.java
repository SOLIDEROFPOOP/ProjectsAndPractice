package com.learning.expensetracker.repositories;

import com.learning.expensetracker.domain.User;
import com.learning.expensetracker.exceptions.EtAuthException;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Integer create(String fistname , String lastname , String email , String password) throws EtAuthException;
    User findByEmailAndPassword(String email, String password) throws EtAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
