/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;
import golunch.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Vicente
 */
public class Listado extends JFrame {
 private JButton marcadores;
 private JButton listado;
 private JButton buscador;
 private JPanel panel;
 private int ID ; 
 public Listado(int id){
     super("GoLunch");
    panel = new JPanel();
    marcadores = new JButton("Marcadores");
    listado = new JButton("Listado");
    buscador= new JButton("Buscador");
    ID = id;
    setSize(555,700);
    setLocation(500,0);
    setResizable(false);
    panel.setLayout (null);
    buscador.setBounds(0, 0, 183, 20);
    marcadores.setBounds(366, 0, 184, 20);
    listado.setBounds(183,0,183,20);
    
    
    panel.add(buscador);
    panel.add(listado);
    panel.add(marcadores);
    
    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
      marcadores.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new Marcadores(ID);
      }
      });
      
      buscador.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new MenuPrincipal(ID);
      }
      });
 }
}
