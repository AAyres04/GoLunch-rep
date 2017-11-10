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
 private JButton marcadores;
 private JButton listado;
 private JButton buscador;
 private JButton buscar;
 private JLabel nombreLL;
 private JLabel direccionL;
 private JLabel horaInicioL;
 private JLabel horaFinalL;
 private JLabel tipoComidaL;
 private JLabel zonaL;
 private JTextField nombreL;
 private JTextField direccion;
 private JTextField horaInicio;
 private JTextField horaFinal;
 private JComboBox tipoComida;
 private String[] tipos = {"Todas","Picada","Sushi","China","Italiana",
                          "Peruana","Parrilla","Comida Rapida"};
 private String[] zonas = {"Todas","Ufro","Av.Alemana","Centro"};
 private JComboBox zona;
public MenuPrincipal(){
    panel = new JPanel();
    marcadores = new JButton("Marcadores");
    listado = new JButton("Listado");
    buscador= new JButton("Buscador");
    buscar = new JButton ("Buscar");
    nombreLL=new JLabel("Nombre del Local");
    direccionL=new JLabel("Direccion");
    horaInicioL=new JLabel("H.inicial");
    horaFinalL=new JLabel("H. Final");
    tipoComidaL= new JLabel("Tipo de comida");
    zonaL=new JLabel("Zonas");
    tipoComida= new JComboBox(tipos);
    zona= new JComboBox(zonas);
    nombreL= new JTextField("");
    direccion=  new JTextField("");
    horaInicio =  new JTextField("");
   horaFinal =  new JTextField("");
   
    setSize(550,700);
    setLocation(500,0);
    panel.setLayout (null);
    buscador.setBounds(0, 0, 183, 20);
    marcadores.setBounds(366, 0, 184, 20);
    listado.setBounds(183,0,183,20);
    nombreLL.setBounds(30, 40, 150, 20);
    nombreL.setBounds(10,60,150,20);
    direccionL.setBounds(210, 40, 150, 20);
    direccion.setBounds(170,60,150,20);
    horaInicioL.setBounds(345,40,80,20);
    horaFinalL.setBounds(435,40,80,20);
    horaInicio.setBounds(330, 60, 80, 20);
    horaFinal.setBounds(420, 60, 80, 20);
    tipoComidaL.setBounds(30, 90, 150, 20);
    tipoComida.setBounds(10, 110, 150, 20);
    zonaL.setBounds(210, 90, 150, 20);
    zona.setBounds(190,110,150,20);
    buscar.setBounds(400, 110, 80, 20);
    
    panel.add(buscador);
    panel.add(listado);
    panel.add(marcadores);
    panel.add(nombreLL);
    panel.add(nombreL);
    panel.add(direccionL);
    panel.add(direccion);
    panel.add(horaInicioL);
    panel.add(horaInicio);
    panel.add(horaFinalL);
    panel.add(horaFinal);
    panel.add(tipoComidaL);
    panel.add(tipoComida);
    panel.add(zonaL);
    panel.add(zona);
    panel.add(buscar);
    
    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
} 
    
    
}
