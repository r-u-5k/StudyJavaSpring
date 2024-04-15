package com.itwill.jpa.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.entity.User;

class UserRepositoryTest extends SpringJpaApplicationTests {
	@Autowired
	UserRepository userRepository;

	@Test
	void save() {
		User user1 = User.builder()
				.userId("guard26")
				.password("2626")
				.name("김경호26")
				.email("guard26@gmail.com")
				.build();
		User user2 = User.builder()
				.userId("guard27")
				.password("2727")
				.name("김경호27")
				.email("guard27@gmail.com")
				.build();
		
		User savedUser1 = userRepository.save(user1);
		User savedUser2 = userRepository.save(user2);
		
		assertThat(savedUser1).isEqualTo(user1);
		assertThat(savedUser2).isEqualTo(user2);
	}
	
	@Test
	void findById() {
		Optional<User> optionalUser = userRepository.findById("guard1");
		if (optionalUser.isPresent()) {
			User findUser1 = optionalUser.get();
			System.out.println(findUser1);
		}
	}
	
	@Test
	void update() {
		User findUser1 = userRepository.findById("guard1").get();
		findUser1.setName("가드1");
		findUser1.setEmail("guard1@naver.com");
		userRepository.save(findUser1);
	}
	
	@Test
	void delete() {
		User deleteUser = User.builder().userId("guard99").password("9999").build();
		userRepository.save(deleteUser);
		userRepository.deleteById("guard99");
	}
	
	@Test
	void customSelect() {
//		System.out.println(userRepository.findByNameSQL("김경호11"));
//		System.out.println(userRepository.findByNameLike("김경호1" + "%"));
//		System.out.println(userRepository.findByNameOrEmail("김경호20", "guard22@gmail.com"));
		System.out.println(userRepository.findTop3ByNameOrderByUserId("김경호20"));
	}
	

	
	
}
