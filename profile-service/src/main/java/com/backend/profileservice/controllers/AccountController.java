package com.backend.profileservice.controllers;

import com.backend.profileservice.repository.AccountRepository;
import com.backend.profileservice.models.Account;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@RestController

@RequestMapping("/api/path")
public class AccountController {
    
  @Autowired
  AccountRepository accountRepository;
    

   
  @PutMapping("/accounts/{id}")
  public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account) {
   
     Optional<Account> accountData = accountRepository.findById(id);

    if (accountData.isPresent()) {
      Account _account = accountData.get();
      _account.setEmail(account.getEmail());
      _account.setUsername(account.getUsername());
      
      return new ResponseEntity<>(accountRepository.save(_account), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }




   
 
  
}