package com.rishabh.noteApp.services;

import com.rishabh.noteApp.dto.JwtAuthenticationResponse;
import com.rishabh.noteApp.dto.RefreshTokenRequest;
import com.rishabh.noteApp.dto.SignInRequest;
import com.rishabh.noteApp.dto.SignUpRequest;
import com.rishabh.noteApp.entity.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
