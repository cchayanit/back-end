package com.backend.profileservice.repository;

import com.backend.profileservice.models.ERole;
import com.backend.profileservice.models.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    
}
