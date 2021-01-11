package com.original.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.original.controller.dto.CadastroDto;
import com.original.controller.dto.ClienteDto;
import com.original.controller.form.CadastroForm;
import com.original.service.CadastroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "CadastroAPI")
@RequestMapping(value = "cadastro")
public class CadastroAPI {
	
	@Autowired
	private CadastroService cadastroService;
	

	@ApiOperation(value = "Responsável por obter o cliente através do email")   
	@GetMapping("email/{email}") 
	                               
	public CadastroDto obterClienteComEmail(@PathVariable String email) {
		CadastroDto dto = new CadastroDto();
		
		try {
			ClienteDto clienteDto = cadastroService.obterClienteComEmail(email);
			dto.setStatusCode(HttpStatus.OK.value());
			
			if(clienteDto != null) {
				dto.setBody(clienteDto);
				dto.setMensagem(HttpStatus.OK.name());				
			}else {
				dto.setMensagem("Email não encontrado!");
			}
			
		} catch (Exception e) {
			dto.setMensagem(e.getMessage());
			dto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		 		
		return dto;	
	}
	
	@PostMapping("cadastrar")
	@ApiOperation(value = "Responsável por cadastrar um novo cliente")  
	public ResponseEntity<CadastroDto> cadastrar(@RequestBody CadastroForm form) {
		CadastroDto cadastroDto = new CadastroDto();
		
		try {
			ClienteDto clienteDto = cadastroService.cadastrar(form);
			
			cadastroDto.setBody(clienteDto);
			cadastroDto.setMensagem(HttpStatus.CREATED.name());
			cadastroDto.setStatusCode(HttpStatus.CREATED.value());
		
		} catch (IllegalArgumentException e) {
			cadastroDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
			cadastroDto.setMensagem(e.getMessage());
				
		} catch (Exception e) {
			cadastroDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			cadastroDto.setMensagem("Erro inesperado, por favor tente mais tarde.");
		}
		
		return ResponseEntity.status(cadastroDto.getStatusCode()).body(cadastroDto);
	}
}
