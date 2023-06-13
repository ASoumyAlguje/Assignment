package com.build.security;

import com.build.entity.Admin;
import com.build.entity.User;
import com.build.exceptions.ResourceNotFoundException;
import com.build.repositories.AdminRepo;
import com.build.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomAdminDetailService implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;


    @Override
    public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {

        Admin adm = this.adminRepo.findByadminName(adminName)
                .orElseThrow(()-> new ResourceNotFoundException("Admin", "adminName: "+adminName, 0));

        return adm;
    }
}
