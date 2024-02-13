package com.nehemie.walkaround;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WalkAroundApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(WalkAroundApplication.class, args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
	}
}
