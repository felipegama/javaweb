package com.felipegama.rest;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.felipegama.dao.PedidoDao;
import com.felipegama.domain.Pedido;
import com.felipegama.domain.Produto;
import com.felipegama.factory.EmailJava;

@Path("/adicionaPedido")
public class AdicionaPedido {
//public class AdicionaPedido extends HttpServlet  {	
	
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public void testeJson(String pedido)
	{
		
	}
	
	/*public void adicionaPedido(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {		
      
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
        // monta um objeto pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(nome);        
        pedido.setCliente_email(email);
        pedido.setData(date);
        
        // salva pedido
        PedidoDao dao = new PedidoDao();
        try {
			dao.salvar(pedido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//envia email
		 EmailJava.enviarEmail(nome, email);
        
        response.sendRedirect( "http://localhost:8080/LojaVirtualJava/");
	}*/

}
