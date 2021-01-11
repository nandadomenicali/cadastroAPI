package com.original.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.original.controller.dto.ClienteDto;
import com.original.controller.dto.EnderecoDto;
import com.original.controller.dto.ViaCepDto;
import com.original.controller.form.CadastroForm;
import com.original.model.Cliente;
import com.original.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	

	public ClienteDto cadastrar(CadastroForm form) throws Exception {
		
		validarClienteExistente(form);
		
		EnderecoDto enderecoDto = buscarEndereco(form.getCep());
		
		Cliente entity = cadastroRepository.save(Cliente.gerarClienteEntity(form, enderecoDto));
		
		return ClienteDto.gerarClienteDto(entity);
	}
	
	public ClienteDto obterClienteComEmail(String email) {
		Cliente entity = cadastroRepository.obterClienteComEmail(email);
		
		return ClienteDto.gerarClienteDto(entity);
	}
	
	
	public EnderecoDto buscarEndereco(Integer cep) {
		String cepFormatado = cep.toString();
		
		if (cepFormatado.length() < 8) {
			for(;cepFormatado.length() < 8;) {
				cepFormatado = "0" + cepFormatado;
			}
		}
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://viacep.com.br/ws/";
		ResponseEntity<ViaCepDto> response = restTemplate.getForEntity(url + cepFormatado + "/json/", ViaCepDto.class);
		
		return EnderecoDto.gerarEndereco(response.getBody());
	}
	
	public void validarClienteExistente (CadastroForm cadastroForm) throws IllegalArgumentException {
		List<Cliente> cliente = cadastroRepository.buscarCpfEmailIguais(cadastroForm.getCpf(), cadastroForm.getEmail());

		if (cliente.size() > 0) {
			throw new IllegalArgumentException("CPF ou Email ja cadastrado.");
		}
		
	}
	
}
