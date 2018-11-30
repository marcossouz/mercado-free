package loja.db;

import loja.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import loja.model.Produto;
import loja.model.Venda;

public class DAO_Produtos {

    public static void inserirProduto(Produto produto) {

        Connection conn = ConnectionFactory.getConnection();

        String sql = "insert into produto (nome, tipo, valor, cor, garantia) values (?,?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setFloat(3, produto.getValor());
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
                produto.setValor(rs.getFloat("valor"));
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

    public static ArrayList<Venda> getListVendas() {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Venda> vendas = new ArrayList<Venda>();

        String sql = "select * from venda";

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                Venda venda = new Venda();

                venda.setId(rs.getInt("id"));
                venda.setData(rs.getString("data"));
                venda.setValor_venda(rs.getFloat("valor_venda"));
                venda.setDesconto(rs.getFloat("desconto"));
                venda.setId_produto(rs.getInt("id_produto"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setProduto(getProdutoById(venda.getId_produto()));

                vendas.add(venda);
            }

            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas" + e.getMessage());
        }

        return vendas;
    }

    public static Produto getProdutoById(int id) {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Produto produto = new Produto();
        String sql = "select * from produto where id =?";

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTipo(rs.getString("tipo"));
                produto.setValor(rs.getFloat("valor"));
                produto.setCor(rs.getString("cor"));
                produto.setGarantia(rs.getInt("garantia"));

            }

            ConnectionFactory.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto por id" + e.getMessage());
        }

        return produto;
    }

    public static void deleteById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        Produto produto = new Produto();
        String sql = "delete from produto where id =?";

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();

            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (Exception e) {
            System.out.println("Erro ao excluir produto por id" + e.getMessage());
        }
    }
    
    public static void atualizarById(int id, Produto p) {
        Connection conn = null;
        PreparedStatement pstm = null;
        Produto produto = new Produto();
        String sql = "update produto set nome = ?, tipo = ?, valor = ?, cor = ?, garantia = ? where id = ?";

        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);

            
            pstm.setInt(1, id);
            pstm.execute();

            ConnectionFactory.fechaConexao(conn, pstm);
        } catch (Exception e) {
            System.out.println("Erro ao excluir produto por id" + e.getMessage());
        }
    }
}
