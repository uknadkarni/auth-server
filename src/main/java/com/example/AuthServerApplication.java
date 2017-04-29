package com.example;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServerApplication implements CommandLineRunner {
	private Logger logger = Logger.getLogger(AuthServerApplication.class);
	private AccountRepository ar;
	
	public AuthServerApplication(AccountRepository ar) {
		// TODO Auto-generated constructor stub
		this.ar = ar;
	}
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Account a1 = new Account("user1", "p1", true);
		this.ar.save(a1);
		logger.info("Saving: " + a1);
		Account a2 = new Account("user2", "p2", true);
		this.ar.save(a2);
		logger.info("Saving: " + a2);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
