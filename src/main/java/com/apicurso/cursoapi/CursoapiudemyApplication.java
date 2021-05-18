package com.apicurso.cursoapi;

import com.apicurso.cursoapi.dominio.Usuario;
import com.apicurso.cursoapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoapiudemyApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoapiudemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(null, "Lucas Murilo", "murilix", "1231");
		Usuario u2 = new Usuario(null, "Mara Stephanie", "Magrinha", "1234");
		Usuario u3 = new Usuario(null, "Lorenzo Reyes", "Lorenzix", "12345");
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3));

	}
}
