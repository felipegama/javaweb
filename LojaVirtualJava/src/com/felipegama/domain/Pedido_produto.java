package com.felipegama.domain;

public class Pedido_produto {
	private Long idPedido_produto;
	private Long quantidade_produto;
	private Produto produto;
	private Pedido pedido;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Long getIdPedido_produto() {
		return idPedido_produto;
	}

	public void setIdPedido_produto(Long idPedido_produto) {
		this.idPedido_produto = idPedido_produto;
	}

	public Long getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(Long quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
