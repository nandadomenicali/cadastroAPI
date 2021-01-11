package com.original.controller.form;

import io.swagger.annotations.ApiModelProperty;


public class CadastroForm {
	@ApiModelProperty(value = "Informacoes recebidas do Cliente") 
	
   
	private String nome;
	private String email;
	private Long cpf;
	private int cep;
	private int numero;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
