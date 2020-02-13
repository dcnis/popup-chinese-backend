package de.schmidtdennis.popupchinese;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.schmidtdennis.popupchinese.data.dto.UserAccount;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;

@SpringBootApplication
public class PopupChineseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopupChineseApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserRepository UserRepository){
		return (args) -> {
			UserRepository.save(new UserAccount("Schmidt", "Dennis", "bgk.dennis@yahoo.de"));
			UserRepository.save(new UserAccount("Liu", "Yang", "yangliucello@gmail.com"));
		};
		
	}

}
