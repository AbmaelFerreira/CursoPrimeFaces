package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.algaworks.pedidovenda.model.Categoria;
import com.algaworks.pedidovenda.model.Produto;
import com.algaworks.pedidovenda.repository.Categorias;
import com.algaworks.pedidovenda.service.CadastroProdutoService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Instancia do meu repositorio
	@Inject
	private Categorias categorias;
	
	@Inject
	private CadastroProdutoService cadastroprodutoservice;
	
		//instancia meu objeto da classe produto
	private Produto produto;
	
	private Categoria categoriaPai;
	
	
	//Minha lista local
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;	
	
	//Metodo construtor que inicia o objeto Produto
	public CadastroProdutoBean() {
		limpar();
	}
	
	//metodo que chama atraves da lista local que é igualada ao repositorio
	//que chama o metodo que retorna todas as categorias raizes 
	
	public void inicializar() {
		
		System.out.println("Inicializando ...");
		
		if(FacesUtil.isNotPostBack()) {
		categoriasRaizes = categorias.raizes();
		}
	}
	
	
	public void carregarSubCategorias() {
		subcategorias = categorias.subcategoriasDe(categoriaPai);
	}
	
	private void limpar() {
		produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}
	
	
	public void salvar() {
		this.produto = cadastroprodutoservice.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso");
	}
	
	//getter e o setter
	
	public Produto getProduto() {
		return produto;
	}
	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	
}