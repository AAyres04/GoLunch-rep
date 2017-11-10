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
public class MenuPrincipal extends JFrame {
 
 private JPanel panel;
   
public MenuPrincipal(){
    panel = new JPanel();
    
    setSize(500,700);
    setLocation(500,0);
    panel.setLayout (null); 
    
    
    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
} 
    
    
}
