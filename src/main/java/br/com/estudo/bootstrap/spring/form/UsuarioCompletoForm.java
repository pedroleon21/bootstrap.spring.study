package br.com.estudo.bootstrap.spring.form;

import java.util.Date;

import org.springframework.lang.NonNull;

import br.com.estudo.bootstrap.spring.model.Usuario;

public class UsuarioCompletoForm {
	private String nome;
	private String senha;
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

	public void fazerMudancas(Usuario user) {
		if (this.nome != null)
			if (!user.getNome().equals(nome))
				user.setNome(nome);
		if (this.email != null)
			if (!user.getEmail().equals(email))
				user.setEmail(email);
		if (this.nacimento != null)
			if (!user.getNascimento().equals(nacimento))
				user.setNascimento(nacimento);
		if (this.senha != null)
			if (!user.getSenha().equals(senha))
				user.setSenha(senha);
	}
}
