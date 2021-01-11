package com.original.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.original.controller.dto.EnderecoDto;
import com.original.controller.form.CadastroForm;

/**
 * @author domenicalif
 *
 */
@Entity
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private Long cpf;
	private int cep;
	private String logradouro;
	private String cidade;
	private String estado;
	private int numero; 
	

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(Long id, String nome, String email, Long cpf, int cep, String logradouro, String cidade,
			String estado, int numero) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cep = cep;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static Cliente gerarClienteEntity(CadastroForm cadastroForm, EnderecoDto enderecoDto) {
		Cliente cliente = new Cliente();
		
		cliente.setCpf(cadastroForm.getCpf());
		cliente.setEmail(cadastroForm.getEmail());
		cliente.setNome(cadastroForm.getNome());
		cliente.setCep(cadastroForm.getCep());
		cliente.setNumero(cadastroForm.getNumero());
		cliente.setLogradouro(enderecoDto.getLogradouro());
		cliente.setCidade(enderecoDto.getCidade());
		cliente.setEstado(enderecoDto.getEstado());
		
		return cliente;
	}
	
}
