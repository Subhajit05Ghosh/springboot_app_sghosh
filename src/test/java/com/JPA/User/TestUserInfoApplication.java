package com.JPA.User;

import org.springframework.boot.SpringApplication;

public class TestUserInfoApplication {

	public static void main(String[] args) {
		SpringApplication.from(UserInfoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
