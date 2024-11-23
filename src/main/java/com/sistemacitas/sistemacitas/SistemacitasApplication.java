package com.sistemacitas.sistemacitas;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.PersonaEntity;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.entity.UsuarioEntity;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.PersonaRepository;
import com.sistemacitas.sistemacitas.infrastructure.adapters.output.persistence.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class SistemacitasApplication implements CommandLineRunner {

	private final PersonaRepository personaRepository;

	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SistemacitasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<PersonaEntity> personas = Arrays.asList(
				new PersonaEntity(null, "admin", "admin", "00000000", "999999999", "admin@gmail.com", "-"),
				new PersonaEntity(null, "user", "user", "11111111", "888888888", "", "-"));
		personaRepository.saveAll(personas);

		List<UsuarioEntity> usuarios = Arrays.asList(
				new UsuarioEntity(null, "admin", passwordEncoder.encode("admin"), "ROLE_ADMIN", personas.get(0)),
				new UsuarioEntity(null, "user", passwordEncoder.encode("user"), "ROLE_USER", personas.get(1)));
		usuarioRepository.saveAll(usuarios);
	}

}
