package com.revisao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revisao.model.ProdutoModel;
import com.revisao.util.Conexao;

public class ProdutoDao {
	private Connection connection;

    public ProdutoDao() {
        connection = Conexao.getConnection();
    }
    
    public void addProduto(ProdutoModel produto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into produtos(produtoid,produtonome,descricao) values (?, ?, ? )");

            preparedStatement.setInt(1, produto.getProdutoid());
            preparedStatement.setString(2, produto.getProdutoNome());
            preparedStatement.setString(3, produto.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduto(int produtoid) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from produtos where produtoid=?");

            preparedStatement.setInt(1, produtoid);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduto(ProdutoModel produto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update produtos set produtoid=?, produtonome=?, descricao=?" +
                            "where produtoid=?");
      
            preparedStatement.setInt(1, produto.getProdutoid());
            preparedStatement.setString(2, produto.getProdutoNome());
            preparedStatement.setString(3, produto.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ProdutoModel> getAllProduto() {
        List<ProdutoModel> produtos = new ArrayList<ProdutoModel>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from produtos");
            while (rs.next()) {
            	ProdutoModel produto = new ProdutoModel();
            	produto.setProdutoid(rs.getInt("produtoid"));
            	produto.setProdutoNome(rs.getString("produtonome"));
            	produto.setDescricao(rs.getString("descricao"));
   
            	produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
    
    public ProdutoModel getProdutoById(int produtoId) {
    	ProdutoModel produto = new ProdutoModel();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from produtos where produtoid=?");
            preparedStatement.setInt(1, produtoId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	produto.setProdutoid(rs.getInt("produtoid"));
            	produto.setProdutoNome(rs.getString("produtonome"));
            	produto.setDescricao(rs.getString("descricao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

}
