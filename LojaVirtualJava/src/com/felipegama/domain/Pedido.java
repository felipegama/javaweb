package com.felipegama.domain;

import java.sql.Date;

public class Pedido {
	private Long idPedido;
	private Date data;
	private String cliente;
	private String cliente_email;
	
	public Pedido(){}

	public Pedido(Long idPedido, Date data, String cliente, String cliente_email) {		
		this.idPedido = idPedido;
		this.data = data;
		this.cliente = cliente;
		this.cliente_email = cliente_email;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCliente_email() {
		return cliente_email;
	}

	public void setCliente_email(String cliente_email) {
		this.cliente_email = cliente_email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((cliente_email == null) ? 0 : cliente_email.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (cliente_email == null) {
			if (other.cliente_email != null)
				return false;
		} else if (!cliente_email.equals(other.cliente_email))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}

}
