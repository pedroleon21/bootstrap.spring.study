package br.com.estudo.bootstrap.spring.form;

import java.util.Date;

import org.springframework.lang.NonNull;

import br.com.estudo.bootstrap.spring.model.Usuario;

public class UsuarioForm {
	
	@NonNull
	private String nome;
	@NonNull
	private String senha;
	@NonNull
	private String email;
	private Date nacimento;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNacimento() {
		return nacimento;
	}
	public void setNacimento(Date nacimento) {
		this.nacimento = nacimento;
	}
	public Usuario toEntity() {
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setNascimento(nacimento);
		user.setNome(nome);
		user.setSenha(senha);
		return user;
	}
	
}
