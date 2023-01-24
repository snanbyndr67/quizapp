package com.quizapp.multiplechoice.controller;

import com.quizapp.multiplechoice.config.JwtUtils;
import com.quizapp.multiplechoice.model.JwtRequest;
import com.quizapp.multiplechoice.model.JwtResponse;
import com.quizapp.multiplechoice.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class AuthenticateController<UserNotFoundException extends Throwable> implements Serializable {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtUtils jwtUtils;

    //Token oluşturma
    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Kullanıcı Bulunamadı ");
        }
        // Doğrulama
        final UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
        final String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username,String password) throws Exception {

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }catch (DisabledException e)
        {
            throw new Exception("KULLANICI DEVRE DIŞI " + e.getMessage());
        }catch (BadCredentialsException e)
        {
            throw new Exception("Geçersiz kimlik bilgileri " + e.getMessage());
        }
    }
}
