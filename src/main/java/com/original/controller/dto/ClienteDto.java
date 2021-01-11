package com.original.controller.dto;

import com.original.model.Cliente;

public class ClienteDto {

	private String nome;
	private Long cpf;
	private String email;
	private int cep;
	private String logradouro;
	private int numero;
	private String cidade;
	private String estado;
	
	public ClienteDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteDto(String nome, Long cpf, String email, int cep, String logradouro, int numero, String cidade,
			String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public static ClienteDto gerarClienteDto(Cliente entity) {
		ClienteDto dto = null;
		
		if(entity != null) {
			dto = new ClienteDto(
					entity.getNome(), 
					entity.getCpf(), 
					entity.getEmail(), 
					entity.getCep(), 
					entity.getLogradouro(), 
					entity.getNumero(), 
					entity.getCidade(), 
					entity.getEstado());
		}
		
		return dto;
	}
	
	
}
