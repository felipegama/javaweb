package com.felipegama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.felipegama.domain.Pedido;
import com.felipegama.factory.ConexaoFactory;

public class PedidoDao {
	public void salvar(Pedido p) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO pedido ");
		sql.append("(data, cliente, cliente_email) ");
		sql.append("VALUES (?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setDate(1, p.getData());
		comando.setString(2, p.getCliente());
		comando.setString(3, p.getCliente_email());
				
		comando.executeUpdate();
	}

}
