package br.univel.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.univel.dao.PetDao;
import br.univel.model.Pet;

/**
 * Servlet implementation class TesteInsert
 */
@WebServlet("/TesteInsert")
public class TesteInsert extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private PetDao dao;

	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Request  - Recebe a requisição qque veio do navegador. 
		// Response - Envia coisas para o cliente.
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try(PrintWriter writer = response.getWriter()){
			writer.println("Inserindo 1000 registro");
			
			for(int i = 0; i < 1000; i ++){
				Pet a = new Pet();
				a.setNome("TESTE "+ i);
				a.setEspecie("Cachorro");
				
				//writer.println(a.toString());
				
				Pet aRetorno = dao.salvar(a);
				writer.println("Inserido: " + aRetorno.getId());
			}
			writer.flush();
		} 
	}

}
