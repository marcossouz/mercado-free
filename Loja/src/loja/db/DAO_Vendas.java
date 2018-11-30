/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import loja.model.Venda;

/**
 *
 * @author marco
 */
public class DAO_Vendas {

    public static void salvarVendas(ArrayList<Venda> vendas) {

        String sql = "insert into venda (valor_venda, desconto, id_produto, quantidade) values (?,?,?,?)";

        for (Iterator iterator = vendas.iterator(); iterator.hasNext();) {
            Venda v = new Venda();
            try {
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);

                v = (Venda) iterator.next();
                stmt.setFloat(1, v.getValor_venda());
                stmt.setFloat(2, v.getDesconto());
                stmt.setInt(3, v.getId_produto());
                stmt.setInt(4, v.getQuantidade());

                stmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso!");

                ConnectionFactory.fechaConexao(conn, stmt);
            } catch (SQLException e) {
                System.out.println("Erro ao salvar vendas" + e.getMessage());
            }
        }
    }
}
