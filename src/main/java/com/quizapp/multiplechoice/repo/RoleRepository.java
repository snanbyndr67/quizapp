package com.quizapp.multiplechoice.repo;

import com.quizapp.multiplechoice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
