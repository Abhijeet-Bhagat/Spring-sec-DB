package com.demo.springsec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringsecApplication implements CommandLineRunner {

	@Autowired
	MyRepository myRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Myuser user1 = Myuser.builder()
//				        .email("abhi@gmail.com")
//						.name("abhi")
//				        .password(passwordEncoder.encode("abhi1234"))
//				        .authority("dev").
//				         build();
//
//		Myuser user2 = Myuser.builder()
//				.name("chandu")
//				.email("chandu@gmail.com")
//				.password(passwordEncoder.encode("Chandu123"))
//				.authority("qa")
//				.build();
//
//		myRepository.saveAll(Arrays.asList(user1, user2));
	}
}
