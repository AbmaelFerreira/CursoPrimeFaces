package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Produtos;

public class CadastroProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Produtos produtos;

	public Produto salvar(Produto produto) {
		return produtos.guardar(produto);
	}
	
}
