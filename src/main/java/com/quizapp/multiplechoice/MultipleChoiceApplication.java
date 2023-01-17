package com.quizapp.multiplechoice;

import com.quizapp.multiplechoice.model.Role;
import com.quizapp.multiplechoice.model.User;
import com.quizapp.multiplechoice.model.UserRole;
import com.quizapp.multiplechoice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MultipleChoiceApplication implements CommandLineRunner {


	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(MultipleChoiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Başlangıç kodu");
//
//		User user = new User();
//
//		user.setFirstName("Sinan");
//		user.setLastName("Bayındır");
//		user.setUsername("snanbyndr");
//		user.setEmail("snan_67@msn.com");
//		user.setPassword("root");
//		user.setProfile("profil.png");
//
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}
}
