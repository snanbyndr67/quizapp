package com.quizapp.multiplechoice.service.impl;

import com.quizapp.multiplechoice.model.User;
import com.quizapp.multiplechoice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByUsername(username);
        if(user==null)
        {
            System.out.println("Kullanıcı bulunamadı");
            throw new UsernameNotFoundException("Kullanıcı bulunamadı");
        }

        return user;
    }
}
