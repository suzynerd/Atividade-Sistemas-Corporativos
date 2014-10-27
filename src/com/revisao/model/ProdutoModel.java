package com.revisao.model;

public class ProdutoModel {

    private int produtoid;
    private String descricao,produtonome;

    
    public int getProdutoid() {
        return produtoid;
    }
    public void setProdutoid(int produtoid) {
        this.produtoid = produtoid;
    }
    
    public String getProdutoNome() {
        return produtonome;
    }
    public void setProdutoNome(String produtonome) {
        this.produtonome = produtonome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produtos [produtoid=" + produtoid + ", descricao=" + descricao+ "]";
    }    
}
