package com.example.Alfayomi.service.ServiceImpl;

import com.example.Alfayomi.config.AppUserDetails;
import com.example.Alfayomi.config.JwtService;
import com.example.Alfayomi.dto.AuthenticationResponse;
import com.example.Alfayomi.dto.LoginDTO;
import com.example.Alfayomi.dto.RegisterDTO;
import com.example.Alfayomi.entity.UserEntity;
import com.example.Alfayomi.repo.UserRepo;
import com.example.Alfayomi.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServicesImpl implements AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServicesImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationResponse register(RegisterDTO register) {
        UserEntity user = UserEntity
                .builder()
                .role(register.role())
                .firstName(register.firstName())
                .lastName(register.lastName())
                .email(register.email())
                .city(register.city())
                .phone(register.phone())
                .password(passwordEncoder.encode(register.password()))
                .build();
        userRepo.save(user);

        String jwtToken = jwtService.generateToken(new AppUserDetails(user));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(LoginDTO login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.email(),
                        login.password()
                )
        );
        UserEntity user = userRepo.findByEmail(login.email()).orElseThrow();
        String jwtToken = jwtService.generateToken(new AppUserDetails(user));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
