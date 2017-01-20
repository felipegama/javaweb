package com.felipegama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.felipegama.domain.Pedido_produto;
import com.felipegama.factory.ConexaoFactory;

public class Pedido_produtoDao {
	public void salvar(Pedido_produto p) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO pedido_produto ");
		sql.append("(quantidade_produto, Produto_idProduto, pedido_idPedido) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getQuantidade_produto());
		comando.setLong(2, p.getProduto().getIdProduto());
		comando.setLong(3, p.getPedido().getIdPedido());		
		
		comando.executeUpdate();
	}

}
