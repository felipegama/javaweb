package com.felipegama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.felipegama.domain.Categoria;
import com.felipegama.factory.ConexaoFactory;

public class CategoriaDao {
	public void salvar(Categoria c) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO categoria ");
		sql.append("(descricao) ");
		sql.append("VALUES (?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getDescricao());
		
		comando.executeUpdate();
	}
	
	public void deletar(Categoria c) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE FROM categoria ");		
		sql.append("WHERE idCategoria = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getIdCategoria());
		
		comando.executeUpdate();
	}
	
	public void editar(Categoria c) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE categoria ");	
		sql.append("SET descricao = ? ");
		sql.append("WHERE idCategoria = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getDescricao());
		comando.setLong(2, c.getIdCategoria());
		
		comando.executeUpdate();
	}
	
	public Categoria buscaById(Categoria c) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT idCategoria, descricao ");	
		sql.append("FROM categoria ");		
		sql.append("WHERE idCategoria = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());		
		comando.setLong(1, c.getIdCategoria());
		
		ResultSet resultado = comando.executeQuery();
		
		Categoria retorno = null;
		
		if(resultado.next())
		{
			retorno = new Categoria();
			retorno.setIdCategoia(resultado.getLong("idCategoria"));
			retorno.setDescricao(resultado.getString("descricao"));		
		}
		
		return retorno;
	}
	
	public ArrayList<Categoria> listar() throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT idCategoria, descricao ");	
		sql.append("FROM categoria ");		
		sql.append("ORDER BY descricao ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());		
		//comando.setLong(1, c.getIdCategoria());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		
		while(resultado.next())
		{
			Categoria c = new Categoria();
			c.setIdCategoia(resultado.getLong("idCategoria"));
			c.setDescricao(resultado.getString("descricao"));
			lista.add(c);
		}
		
		return lista;
	}
	
	public static void main(String[] args) {
		Categoria c1 = new Categoria();
		c1.setIdCategoia(2l);
		c1.setDescricao("categoria teste 2");
		
		/*Categoria c2 = new Categoria();
		c2.setDescricao("categoria teste 1");*/
		
		CategoriaDao cDao = new CategoriaDao();
		try {
			cDao.editar(c1);
			//cDao.salvar(c2);
			System.out.println("salvo com sucesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("falha ao gravar");
		}
		
	}

}
