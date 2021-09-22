package com.arrudamoreira.fisioneurapp.dto;

import java.io.Serializable;

public class FisioterapeutaSenhaUpdateDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String senhaAtual;
	
	private String novaSenha;
	
	private String senhaConfirmacao;

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

}
