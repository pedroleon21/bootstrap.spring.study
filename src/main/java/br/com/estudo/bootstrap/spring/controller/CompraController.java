package br.com.estudo.bootstrap.spring.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.estudo.bootstrap.spring.DTO.CompraDTO;
import br.com.estudo.bootstrap.spring.model.Compra;
import br.com.estudo.bootstrap.spring.model.Produto;
import br.com.estudo.bootstrap.spring.model.Usuario;
import br.com.estudo.bootstrap.spring.repository.CompraRepository;
import br.com.estudo.bootstrap.spring.repository.ProdutoRepository;
import br.com.estudo.bootstrap.spring.repository.UsuarioRepository;

@RestController
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private CompraRepository compraRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("cliente/{idCliente}")
	public List<CompraDTO> buscarComprasPorUsuario(@PathVariable("idCliente") Long idCliente) {
		return compraRepository.findByUsuarioId(idCliente).stream().map(CompraDTO::new).collect(Collectors.toList());
	}

	@PostMapping("/{idCliente}/comprar/{idProduto}")
	public ResponseEntity<CompraDTO> comprar(@PathVariable("idCliente") Long idCliente, @PathVariable("idProduto") Long idProduto,UriComponentsBuilder uriBuilder) {
		Produto p = produtoRepository.getById(idProduto);
		Usuario u = usuarioRepository.getById(idCliente);
		int comprados = compraRepository.findAll().stream().filter(c -> c.getProduto().getId().equals(idProduto))
				.collect(Collectors.toList()).size();
		if (comprados < p.getQuantidade()) {
			Compra compra = new Compra();
			compra.setProduto(p);
			compra.setUsuario(u);
			compraRepository.save(compra);
			URI uri = uriBuilder.path("/compra/{id}").buildAndExpand(u.getId()).toUri();
			return ResponseEntity.created(uri).body(new CompraDTO(compra));
		}
		return ResponseEntity.noContent().build();
	}

}
