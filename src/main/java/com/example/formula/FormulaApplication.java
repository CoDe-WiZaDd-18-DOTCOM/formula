package com.example.formula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class FormulaApplication {
	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
		SpringApplication.run(FormulaApplication.class, args);
	}
}
