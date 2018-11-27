package loja.controller;

import loja.db.DAO_Produtos;
import loja.model.Produto;
import loja.view.CadastroProduto;
import loja.view.ListarProdutos;


public class ControllerProduto {
    public static void telaCadastro(){
        CadastroProduto.telaCadastro();
    }
    
    public static void telaListagem(){
        ListarProdutos lp = new ListarProdutos();
    }
    
    public static void CadastroProduto(Produto produto){
        DAO_Produtos.inserirProduto(produto);
    }
}
