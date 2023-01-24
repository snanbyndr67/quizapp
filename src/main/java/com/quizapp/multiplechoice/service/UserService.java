package com.quizapp.multiplechoice.service;

import com.quizapp.multiplechoice.model.User;
import com.quizapp.multiplechoice.model.UserRole;

import java.util.Set;

public interface UserService {

    //Kullanıcı oluşturma
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //Kullanıcı adına göre alma
    public User getUser(String username);

    // Kimliğe göre kullanıcı silme
    public void deleteUser(Long userId);
}
