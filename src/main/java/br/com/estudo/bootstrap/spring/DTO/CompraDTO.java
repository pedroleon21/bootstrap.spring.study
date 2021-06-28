package br.com.estudo.bootstrap.spring.DTO;

import br.com.estudo.bootstrap.spring.model.Compra;

public class CompraDTO {
	
	private Long id;
	private ProdutoDTO produto;
	private UsuarioDTO usuario;
	
	public CompraDTO() {
		
	}
	public CompraDTO(Compra compra) {
		id = compra.getId();
		produto = new ProdutoDTO(compra.getProduto());
		usuario = new UsuarioDTO(compra.getUsuario());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
	
}
