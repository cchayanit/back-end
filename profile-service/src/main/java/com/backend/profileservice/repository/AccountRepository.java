package com.backend.profileservice.repository;

import com.backend.profileservice.models.Account;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository <Account, Long> {
     List<Account> findByUsernameContaining(String username);
}
