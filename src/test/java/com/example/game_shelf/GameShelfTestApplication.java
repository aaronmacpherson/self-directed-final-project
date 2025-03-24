package com.example.game_shelf;

import org.springframework.boot.SpringApplication;

public class GameShelfTestApplication {

	public static void main(String[] args) {
		SpringApplication.from(GameShelfApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
