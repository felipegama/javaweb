package com.felipegama.rest;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.felipegama.dao.PedidoDao;
import com.felipegama.domain.Pedido;
import com.felipegama.domain.Produto;

@WebServlet @Path("/adicionaPedido")
public class AdicionaPedido extends HttpServlet  {
	
	@GET
	public String getProdutos(){
		
		//listaProduto = listaProdutos();
		return "fefefe";
	}
	
	@POST
	public String getProdutos2(HttpServletRequest request){
		 String nome = request.getParameter("nome");
		    
	        String email = request.getParameter("email");
	        
		
		return "GAMA="+nome;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		//response.setHeader("Location", "http://www.google.com/");
        PrintWriter out = response.getWriter();
                        
        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
    
        String email = request.getParameter("email");
        
        out.println("Erro de conversão da data"+email);
/*
        List<String> listaIdProduto = new ArrayList<String>(); //idproduto[] = request.getParameter("idProduto");
        listaIdProduto.add(request.getParameter("idProduto"));
        
        //String dataEmTexto = request.getParameter("dataNascimento");
      //  Calendar dataNascimento = null;
        
        // fazendo a conversão da data
        /*try {
            Date date = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (ParseException e) {
            out.println("Erro de conversão da data");
            return; //para a execução do método
        }*/
      //  Date date = new Date();
       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      /*  java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        // monta um objeto contato
        Pedido pedido = new Pedido();
        pedido.setCliente(nome);
        //contato.setEndereco(endereco);
        pedido.setCliente_email(email);
        pedido.setData(date);
        
        // salva o contato
        PedidoDao dao = new PedidoDao();
        try {
			dao.salvar(pedido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // Console.log("fefefefefefe jajajajaja");
       // response.sendRedirect( "http://www.google.com/");
      //  System.out.println("teste fefefefe le");
        //out.println("felipe gama");
        // imprime o nome do contato que foi adicionado
        out.println("<html xmlns='http://www.w3.org/1999/xhtml' xml:lang='pt-br' lang='pt-br'>");
        out.println("<body>");
        out.println("Contato " + pedido.getCliente() + 
                " adicionado com sucesso");    
        out.println("</body>");
        out.println("</html>");*/
    }

}
