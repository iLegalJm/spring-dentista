package com.sistemacitas.sistemacitas;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.PersonaEntity;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class SistemacitasApplication implements CommandLineRunner {

	private final PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemacitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<PersonaEntity> personas = Arrays.asList(
				new PersonaEntity(null, "admin", "admin", "00000000", "999999999", "admin@gmail.com", "-"));
		personaRepository.saveAll(personas);
	}

}
