package br.com.estudo.bootstrap.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.bootstrap.spring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{


}
