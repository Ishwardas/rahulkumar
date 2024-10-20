package com.hms2.repository;

import com.hms2.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String Username);
    Optional<AppUser> findByEmail(String Email);
}