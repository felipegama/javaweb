package com.felipegama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.felipegama.domain.Categoria;
import com.felipegama.domain.Produto;
import com.felipegama.factory.ConexaoFactory;

public class ProdutoDao {
	public ProdutoDao(){}
	
	public void salvar(Produto p) throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO produto ");
		sql.append("(descricao, preco, foto, Categoria_idCategoria) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getPreco());
		comando.setString(3, p.getFoto());
		comando.setLong(4, p.getCategoria().getIdCategoria());
		
		comando.executeUpdate();
	}
	
	public ArrayList<Produto> listar() throws SQLException
	{
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT idProduto, descricao, preco, foto ");	
		sql.append("FROM produto ");		
		sql.append("ORDER BY idProduto ASC ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());		
		//comando.setLong(1, c.getIdCategoria());
		
		ResultSet resultado = comando.executeQuery();
		
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		while(resultado.next())
		{
			Produto p = new Produto();
			p.setIdProduto(resultado.getLong("idProduto"));
			p.setDescricao(resultado.getString("descricao"));
			p.setPreco(resultado.getDouble("preco"));
			p.setFoto(resultado.getString("foto"));
			//p.setCategoria(resultado.getLong("Categoria_idCategoria"));
			lista.add(p);
		}
		
		return lista;
	}
	
	public static void main(String[] args) {
		//categorias
		/*Categoria cat1 = new Categoria();
		cat1.setIdCategoia(1L);
		
		Categoria cat2 = new Categoria();
		cat2.setIdCategoia(2L);
		
		Produto p1 = new Produto();		
		p1.setDescricao("produto 1");
		p1.setPreco(150.00D);
		p1.setFoto("img/prod1.jpg");
		p1.setCategoria(cat1);
		
		Produto p2 = new Produto();		
		p2.setDescricao("produto 2");
		p2.setPreco(160.00D);
		p2.setFoto("img/prod2.jpg");
		p2.setCategoria(cat1);
		
		Produto p3 = new Produto();		
		p3.setDescricao("produto 3");
		p3.setPreco(170.00D);
		p3.setFoto("img/prod3.jpg");
		p3.setCategoria(cat2);
		
		Produto p4 = new Produto();		
		p4.setDescricao("produto 4");
		p4.setPreco(180.00D);
		p4.setFoto("img/prod4.jpg");
		p4.setCategoria(cat2);*/
		
		ProdutoDao pDao = new ProdutoDao();
		try {
			
			/*pDao.salvar(p1);
			pDao.salvar(p2);
			pDao.salvar(p3);
			pDao.salvar(p4);*/
			ArrayList<Produto> lista = pDao.listar();
			for(Produto prod : lista)
			{
				System.out.println("resultado: = "+ prod);
			}
			//System.out.println("salvo com sucesso");
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("falha ao mostra lista");
		}
		
	}

}
