package com.example.NeoTec;

import com.example.NeoTec.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NeoTecApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NeoTecApplication.class, args);
	}

	@Autowired
	private ProductoRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception{


	}
}
