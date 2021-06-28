package br.com.estudo.bootstrap.spring.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.estudo.bootstrap.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEmail(String email);

	List<Usuario> findByNome(String nome);

	List<Usuario> findByNascimento(Date nacimento);
}
