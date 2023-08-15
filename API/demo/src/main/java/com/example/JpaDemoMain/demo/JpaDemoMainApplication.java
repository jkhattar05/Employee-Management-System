package com.example.JpaDemoMain.demo;

import com.example.JpaDemoMain.demo.DataAccessLayer.IDataAccessLayer;
import com.example.JpaDemoMain.demo.Model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoMainApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoMainApplication.class, args);
	}

	@Autowired
	private IDataAccessLayer IDataAccessLayer;

	@Override
	public void run(String... args) throws Exception {

	}
}
