package com.sistemacitas.sistemacitas;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.DentistaEntity;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.DentistaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class SistemacitasApplication implements CommandLineRunner {

	private final DentistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SistemacitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<DentistaEntity> entities = Arrays.asList(
				new DentistaEntity(null, "Juan", "Perez", "12345678", "901901901", "jose@gmail.com", "sda",
						"cirujano"),
						new DentistaEntity(null, "Juansss", "Perezsssa", "12345672", "901901901", "jose@gmail.com", "sda",
						"cirujano"));
		repository.saveAll(entities);
	}

}
