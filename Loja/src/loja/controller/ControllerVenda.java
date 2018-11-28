/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.controller;

import loja.view.ListarVendas;
import loja.view.RealizarVendas;

/**
 *
 * @author marco
 */
public class ControllerVenda {
    
    
    public static void realizarVenda(){
        RealizarVendas realizarVendas = new RealizarVendas();
        realizarVendas.setVisible(true);
    }
    
    public static void listarVendas(){
        ListarVendas listarVendas = new ListarVendas();
    }
    
}
