package com.revisao.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revisao.dao.ProdutoDao;


public class ProdutoController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/produto.jsp";
	    private static String LIST_PRODUTO = "/listproduto.jsp";
	    private ProdutoDao dao;

	    public ProdutoController() {
	        super();
	        dao = new ProdutoDao();
	    }
	    
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			int produtoid = Integer.parseInt(request.getParameter("produtoid"));
			dao.deleteProduto(produtoid);
			forward = LIST_PRODUTO;
			request.setAttribute("produtos", dao.getAllProduto());
			
		} else if (action.equalsIgnoreCase("listProdutos")) {
			forward = LIST_PRODUTO;
			request.setAttribute("produtos", dao.getAllProduto());
			
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	    


}
