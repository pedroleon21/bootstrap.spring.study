package br.com.estudo.bootstrap.spring.DTO;

import java.util.Date;

import org.springframework.lang.NonNull;

import br.com.estudo.bootstrap.spring.model.Usuario;

public class UsuarioDTO {
	
	
	private Long id;
	private String email;
	private Date nacimento;
	private String nome;
	
	public UsuarioDTO() {
		
	}
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.nacimento = usuario.getNascimento();
		this.nome = usuario.getNome();
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public Date getNacimento() {
		return nacimento;
	}
	public String getNome() {
		return nome;
	}

}
