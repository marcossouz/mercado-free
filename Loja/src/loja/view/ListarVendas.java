/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import loja.db.DAO_Produtos;
import loja.model.Produto;
import loja.model.Venda;

/**
 *
 * @author marco
 */
public class ListarVendas extends JFrame implements ActionListener{
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btnVoltar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarVendas() {
        CriarTable();
        CriarJanela();
    }

    public void CriarJanela() {
        btnVoltar = new JButton("Voltar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btnVoltar);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
        btnVoltar.addActionListener(this);

    }

    private void CriarTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Data");
        modelo.addColumn("Valor");
        modelo.addColumn("Desconto");
        modelo.addColumn("Produto");
        modelo.addColumn("codProduto");
        modelo.addColumn("quantidade");
        modelo.addColumn("Preco");
        
        ArrayList vendas = new ArrayList();
              
        vendas = DAO_Produtos.getListVendas();
        Venda v = new Venda();
        
        for (Iterator iterator = vendas.iterator(); iterator.hasNext(); ) {
            
            v = (Venda) iterator.next();
            modelo.addRow(new Object[]{v.getId(),v.getData(), v.getValor_venda(), v.getDesconto(), v.getProduto().getNome(), v.getProduto().getId(), v.getQuantidade(), v.getProduto().getValor()});
    
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Voltar")) {
            this.setVisible(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Menu.Menu();
        }
    }
}
