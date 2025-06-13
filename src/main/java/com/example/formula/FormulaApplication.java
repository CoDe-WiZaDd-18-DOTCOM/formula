package com.example.formula;

import com.example.formula.utils.JwtUtil;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormulaApplication implements CommandLineRunner {

	@Autowired
	private JwtUtil jwtUtil;

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
		SpringApplication.run(FormulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String token = jwtUtil.generateToken("test1");
		System.out.println("✅ JWT Token: " + token);
	}
}
