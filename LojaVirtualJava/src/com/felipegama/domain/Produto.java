package com.felipegama.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1413396376011247535L;
	
	private Long idProduto;
	private String descricao;
	private Double preco;
	private String foto;
	private Long quantidade;
	

	private Categoria categoria;
	
	public Produto(){}

	public Produto(Long idProduto, String descricao, Double preco, String foto, Long quantidade, Categoria categoria) {		
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		String saida = idProduto + " - " + descricao;
		return saida;
	}

}
