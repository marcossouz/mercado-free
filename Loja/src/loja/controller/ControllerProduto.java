package loja.controller;

import loja.db.DAO_Produtos;
import loja.model.Produto;
import loja.view.CadastroProduto;


public class ControllerProduto {
    public static void telaCadastro(){
        CadastroProduto.telaCadastro();
    }
    
    public static void telaListagem(){
//        CadastroProduto.telaListagem();
    }
    
    public static void CadastroProduto(Produto produto){
        DAO_Produtos.inserirProduto(produto);
    }
}
