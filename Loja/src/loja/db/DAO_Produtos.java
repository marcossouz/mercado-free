package loja.db;

import loja.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import loja.model.Produto;

public class DAO_Produtos {

    public static void inserirProduto(Produto produto) {

        Connection conn = ConnectionFactory.getConnection();

        String sql = "insert into produto (nome, tipo, valor, cor, garantia) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setDouble(3, produto.getValor());
            stmt.setString(4, produto.getCor());
            stmt.setInt(5, produto.getGarantia());

            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
            
            ConnectionFactory.fechaConexao(conn, stmt);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir contato" + e.getMessage());
        }
    }

    public static ArrayList<Produto> getListProdutos() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<Produto>();

        String sql = "select * from produto";

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            
            while (rs.next()) {

                Produto produto = new Produto();
                
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipo(rs.getString("tipo"));
                produto.setValor(rs.getDouble("valor"));
                produto.setCor(rs.getString("cor"));
                produto.setGarantia(rs.getInt("garantia"));

                produtos.add(produto);
            }

            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar contatos" + e.getMessage());
        }

        return produtos;
    }
}
