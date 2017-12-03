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
public class ModificarTabla  extends JFrame{
    private JTable Tabla;
    private String NombreColumnas[]={"Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Tipo"};
    private ArrayList<String> Columnas;
    private String Columnas1[][]={{"Pedro Juan Y Diego","Mall","4523525","9:00","22:00","Comida Rapida"},{"Mac","mall","4523525","9:00","22:00","Comida Rapida"}};
    private JPanel panel;
    private JScrollPane Spanel;
    private JButton volver;
    private JButton modificar;
    private JComboBox Cat;
    private JLabel DesMod;
    private JComboBox NF;
    private int NumeroFilas;
    private JLabel Edicion;
    private JTextField value;
    private JLabel N;
    
    public  ModificarTabla(){
        
        Tabla = new JTable(Columnas1,NombreColumnas);
        panel = new JPanel();
        NF = new JComboBox();
        Spanel = new JScrollPane(Tabla);
        volver = new JButton("Volver");
        modificar = new JButton("Modificar");
        Cat = new JComboBox (NombreColumnas);
        DesMod = new JLabel ("Categoria:");
        value = new JTextField ("");
        N = new JLabel ("Numero de fila:");
        Edicion = new JLabel("Nuevo Valor:");
        
        NumeroFilas = Columnas1.length;
        
        setSize(900,400);
        setLocation(300,100);
        panel.setLayout (null); 
        for(int i = 0;i < NumeroFilas;i++){
           NF.addItem(i+1);
    }
        
        Spanel.setBounds(0,0, 700,700);
        volver.setBounds(750,330,100,20);
        N.setBounds(720,30,100,20);
        NF.setBounds(720,75,150,20);
        DesMod.setBounds(720,120,150,20);
        Cat.setBounds(720,165,150 ,20 );
        value.setBounds(720, 230, 150, 20);
        modificar.setBounds(750, 290, 100, 20);
        Edicion.setBounds(720,210,150,20);
        
        Tabla.setEnabled(false);
        Tabla.getTableHeader().setReorderingAllowed(false);
        
        panel.add(Spanel);
        panel.add(volver);
        panel.add(DesMod);
        panel.add(N);
        panel.add(NF);
        panel.add(Cat);
        panel.add(value);
        panel.add(modificar);
        panel.add(Edicion);
         getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        volver.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          new Admin();
      }
      });
        
          modificar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
              String Categoria = Cat.getSelectedItem().toString();
              String Fila = NF.getSelectedItem().toString();
              int Fil = Integer.parseInt(Fila)-1;
              int Colum =0;
              String NombreCat = "";
              for (int i = 0 ;i< NombreColumnas.length;i++ ){
                  NombreCat = NombreColumnas[i];
              if(Categoria.equals(NombreCat)){
                  Colum = i;
              }
              }
              Columnas1[Fil][Colum] = value.getText();
              Tabla.setValueAt(Columnas1[Fil][Colum], Fil, Colum);
      }
      });
    }
    
}
