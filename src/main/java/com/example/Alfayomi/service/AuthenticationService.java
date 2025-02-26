package com.example.Alfayomi.service;

import com.example.Alfayomi.dto.AuthenticationResponse;
import com.example.Alfayomi.dto.LoginDTO;
import com.example.Alfayomi.dto.RegisterDTO;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterDTO register);
    AuthenticationResponse authenticate(LoginDTO login);
}
