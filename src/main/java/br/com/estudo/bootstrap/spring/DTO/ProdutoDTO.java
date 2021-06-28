package br.com.estudo.bootstrap.spring.DTO;

import java.math.BigDecimal;

import br.com.estudo.bootstrap.spring.model.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	
	public ProdutoDTO() {
		
	}
	public ProdutoDTO(Produto produto) {
		id = produto.getId();
		nome = produto.getNome();
		preco = produto.getPreco();
		quantidade = produto.getQuantidade();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getQuatidade() {
		return quantidade;
	}
	public void setQuatidade(Integer quatidade) {
		this.quantidade = quatidade;
	}
}
