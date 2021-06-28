package br.com.estudo.bootstrap.spring.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {
	/*
	 * INSERT INTO PRODUTO(NOME,PRECO,QUANTIDADE) VALUES('livro',15.99,10);
	INSERT INTO PRODUTO(NOME,PRECO,QUANTIDADE) VALUES('armario',159.99,1);
	INSERT INTO PRODUTO(NOME,PRECO,QUANTIDADE) VALUES('pen-drive 4gb',9.99,100);
	INSERT INTO PRODUTO(NOME,PRECO,QUANTIDADE) VALUES('pente memoria ddr4 8GB 3200Hz',799.99,1);
	INSERT INTO USUARIO(NOME,SENHA,EMAIL) VALUES( 'PEDRO','123456789','PEDRO@HEPTA.COM');
	INSERT INTO USUARIO(NOME,SENHA,EMAIL) VALUES( 'MATEUS', '123456789','MATEUS@HEPTA.COM');
	INSERT INTO USUARIO(NOME,SENHA,EMAIL) VALUES( 'BRUNO', '123456789','BRUNO@HEPTA.COM');
	INSERT INTO USUARIO(NOME,SENHA,EMAIL) VALUES( 'CRIS', '123456789','CRIS@HEPTA.COM');
	INSERT INTO USUARIO(NOME,SENHA,EMAIL) VALUES( 'SALIBA', '123456789','SALIBA@HEPTA.COM');

	INSERT INTO COMPRA(PRODUTO_ID, USUARIO_ID) VALUES(4,1)


	SELECT U.* FROM PRODUTO P
	INNER JOIN COMPRA C ON C.PRODUTO_ID = P.ID
	INNER JOIN USUARIO U ON C.USUARIO_ID = U.ID

	SELECT * FROM COMPRA
	SELECT * FROM USUARIO
	SELECT * FROM PRODUTO

*/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private BigDecimal preco;
	private Integer quantidade;
	
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quatidade) {
		this.quantidade = quatidade;
	}
}
