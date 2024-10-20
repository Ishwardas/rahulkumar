package com.hms2.service;

import com.hms2.entity.AppUser;
import com.hms2.repository.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private AppUserRepository appUserRepository;

    public UserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser saveProfile(AppUser appUser) {
        AppUser save = appUserRepository.save(appUser);
        return save;
    }
}
