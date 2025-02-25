package com.example.Alfayomi.config;

import com.example.Alfayomi.entity.UserEntity;
import com.example.Alfayomi.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsServices implements UserDetailsService {
    private final UserRepo userRepo;

    public AppUserDetailsServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("user not found with email : " + email)
        );
        return new AppUserDetails(userEntity);
    }
}
