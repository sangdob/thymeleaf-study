package hello.thymeleaf.basic;

import lombok.Data;

@Data
public class User {
	public User(String username, int age) {
		this.username = username;
		this.age = age;
	}

	private String username;
	private int age;
}
