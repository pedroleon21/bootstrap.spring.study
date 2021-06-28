package br.com.estudo.bootstrap.spring.config.form;

public class ErrFormDTO {
	
	private String campo;
	private String erro;
	
	
	public ErrFormDTO() {
	}
	public ErrFormDTO(String campo, String erro) {
		this.campo = campo;
		this.erro=erro;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
}
