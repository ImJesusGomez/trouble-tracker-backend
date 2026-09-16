package com.jesusgomez.trouble_tracker;

import org.springframework.boot.SpringApplication;

public class TestTroubleTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.from(TroubleTrackerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
