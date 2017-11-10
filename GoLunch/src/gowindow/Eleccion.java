/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Vicente
 */
public class Eleccion extends JFrame {
    private JButton admin;
    private JButton principal;
    private JLabel ingreso;
    private JPanel panel;
  
    public Eleccion(){
        
        admin= new JButton("Administrador");
        principal=new JButton("Usuario Normal");
        ingreso = new JLabel("¿Como desea ingresar?");
        panel= new JPanel();
        
        setSize(300,200);
        setLocation(500,280);
        panel.setLayout (null); 
        
        admin.setBounds(150, 80, 130, 20);
        principal.setBounds(10, 80, 130, 20);
        ingreso.setBounds(70, 20, 150, 20);
        
        panel.add(ingreso);
        panel.add(admin);
        panel.add(principal);
        
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        admin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
         
      }
      });
        principal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          //MainMenu men = new MainMenu();
      }
      });
    }
    
}