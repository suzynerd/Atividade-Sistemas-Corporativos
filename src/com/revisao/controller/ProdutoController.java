package com.revisao.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revisao.dao.ProdutoDao;
import com.revisao.model.ProdutoModel;


public class ProdutoController extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT = "/produto.jsp";
	    private static String LIST_PRODUTO = "/listProduto.jsp";
	    private ProdutoDao dao;

	    public ProdutoController() {
	        super();
	        dao = new ProdutoDao();
	    }
	    
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String forward;
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
	    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoModel produto = new ProdutoModel();
        produto.setProdutoNome(request.getParameter("produtonome"));
        produto.setDescricao(request.getParameter("descricao"));
        
        String produtoid = request.getParameter("produtoid");
        if(produtoid == null || produtoid.isEmpty())
        {
            dao.addProduto(produto);
        }
        else
        {
        	produto.setProdutoid(Integer.parseInt(produtoid));
            dao.updateProduto(produto);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUTO);
        request.setAttribute("produtos", dao.getAllProduto());
        view.forward(request, response);
    }

}
