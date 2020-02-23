package de.schmidtdennis.popupchinese;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class PopupChineseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopupChineseApplication.class, args);
	}

}
