package br.com.estudo.bootstrap.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.bootstrap.spring.DTO.ProdutoDTO;
import br.com.estudo.bootstrap.spring.model.Produto;
import br.com.estudo.bootstrap.spring.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public List<ProdutoDTO> getProdutos(){
		 List<Produto> produtos = repository.findAll();
		 return	produtos.stream()
				.map(ProdutoDTO::new)
				.collect(Collectors.toList());
	}
}
