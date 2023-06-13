package com.build.repositories;

import com.build.entity.Admin;
import com.build.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
    Optional<Admin> findByadminName(String adminName);
}
