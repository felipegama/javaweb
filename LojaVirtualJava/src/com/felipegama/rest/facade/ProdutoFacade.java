package com.felipegama.rest.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felipegama.dao.ProdutoDao;
import com.felipegama.domain.Categoria;
import com.felipegama.domain.Produto;

@Path("/produtos")
@Produces({MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoFacade {
	
	static List<Produto> listaProduto = new ArrayList<Produto>();
	
//	ProdutoDao pDao = new ProdutoDao();
	//ArrayList<Produto> lista = pDao.listar();
	static {
		Categoria cat1 = new Categoria();
		cat1.setIdCategoia(10L);
		cat1.setDescricao("cat1");
		
		listaProduto.add(new Produto(10L,"produto felipe 1", 260.00D,"img/prod1.jpg",1L,cat1));
		listaProduto.add(new Produto(11L,"produto felipe 2", 360.00D,"img/prod2.jpg",1L,cat1));
	}
	
	public void listaProdutos(){
		ProdutoDao pDao = new ProdutoDao();
		try {
			ArrayList<Produto> lista = pDao.listar();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@GET
	public List<Produto> getProdutos(){
		
		//listaProduto = listaProdutos();
		return listaProduto;
	}
	
	@POST
	public void finalizarCompra(){
		
	}
}
