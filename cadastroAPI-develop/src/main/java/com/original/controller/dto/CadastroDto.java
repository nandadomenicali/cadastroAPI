package com.original.controller.dto;

import io.swagger.annotations.ApiModelProperty;

public class CadastroDto {
	@ApiModelProperty(value = "Status das requisicoes") 
	

	private int statusCode;
	private String mensagem;
	private Object body;
	
	public int getStatusCode() {
		return statusCode;
	}
	public String getMensagem() {
		return mensagem;
	}
	public Object getBody() {
		return body;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	
}
