package com.quizapp.multiplechoice.service.impl;

import com.quizapp.multiplechoice.model.User;
import com.quizapp.multiplechoice.model.UserRole;
import com.quizapp.multiplechoice.repo.RoleRepository;
import com.quizapp.multiplechoice.repo.UserRepository;
import com.quizapp.multiplechoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //Kullanıcı oluşturma
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local=this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("Kullanıcı zaten mevcut !!");
            throw new Exception("Kullanıcı mevcut !!");
        } else {
            //Kullanıcı oluşturma
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }


        return local;
    }

    //kullanıcı adına göre alma
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
