package com.example.InvoiceSimilarityMatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class InvoiceSimilarityMatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceSimilarityMatcherApplication.class, args);
	}

}
