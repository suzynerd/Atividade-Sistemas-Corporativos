package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Itens")
public class Itens extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String text = request.getParameter("nome");
		
		HttpSession session = request.getSession();
		List<String> lista = (List<String>) session.getAttribute("lista");
		
		if(lista == null){
			lista = new ArrayList<String>();
			session.setAttribute("lista", lista);
		}
		
		lista.add(text);
		request.setAttribute("lista", lista);
		
		request.getRequestDispatcher("ListaItens.jsp").forward(request, response);
	}
	
}
