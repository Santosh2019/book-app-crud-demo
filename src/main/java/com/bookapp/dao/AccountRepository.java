package com.bookapp.dao;

import com.bookapp.model.AccountRegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface AccountRepository extends JpaRepository<AccountRegistrationDto, Serializable> {
    public AccountRegistrationDto findByUserName(String userName);
}
