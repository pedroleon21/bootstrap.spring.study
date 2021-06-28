package br.com.estudo.bootstrap.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.bootstrap.spring.DTO.CompraDTO;
import br.com.estudo.bootstrap.spring.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{

	List<Compra> findByUsuarioId(Long id);

}
