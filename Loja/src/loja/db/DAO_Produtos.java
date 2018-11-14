package loja.db;

import loja.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import loja.model.Produto;

public class DAO_Produtos {

    public static void inserirProduto(Produto produto){

        Connection conn = ConnectionFactory.getConnection();

       String sql = "insert into produto (nome, tipo, valor, cor, garantia) values (?,?,?,?,?);";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getCor());
            stmt.setString(5, produto.getGarantia());

            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
