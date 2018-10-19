package com.algaworks.pedidovenda.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.pedidovenda.model.Produto;

public class Produtos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager manager;

	public Produto guardar(Produto produto) {
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		produto = manager.merge(produto);
		
		trx.commit();
		return produto;
	}

}
