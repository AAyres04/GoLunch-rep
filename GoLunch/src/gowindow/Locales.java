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
import golunch.*;
/**
 *
 * @author Vicente
 */
public class Locales extends JPanel {
    private JLabel Nombre;
    private JLabel Direccion;
    private JLabel Telefono;
    private JLabel HoraI;
    private JLabel HoraF;
    private JLabel Tipo;
    public Locales(){
        Nombre = new JLabel();
        Direccion = new JLabel();
        Telefono = new JLabel();
        HoraI = new JLabel();
        HoraF = new JLabel();
        Tipo = new JLabel();
        
        setSize(490,90);
        setVisible(true);

        
        Nombre.setBounds(10,10 , 100, 20);
        Direccion.setBounds(10,30, 100 ,20);
        Telefono.setBounds(120,30,100,20);
        HoraI.setBounds(230, 30, 100, 20);
        HoraF.setBounds(330,30,100,20);
        Tipo.setBounds(330,10,100,20);
        
        add(Nombre);
        add(Direccion);
        add(Telefono);
        add(HoraI);
        add(HoraF);
        add(Tipo);
        
    }
    public void setNombre(String nombre){
        Nombre.setText(nombre);
    }
    
    public String getNombre(){
        return Nombre.getText();
    }
    public void setDireccion(String direccion){
        Direccion.setText(direccion);
    }
    
    public String getDireccion(){
        return Direccion.getText();
    }
        public void setTelefono(String telefono){
        Telefono.setText(telefono);
    }
    
    public String getTelefono(){
        return Telefono.getText();
    }
        public void setHoraI(String horai){
        HoraI.setText(horai);
    }
    
    public String getHoraI(){
        return HoraI.getText();
    }
        public void setHoraF(String horaf){
        HoraF.setText(horaf);
    }
    
    public String getHoraF(){
        return HoraF.getText();
    }
    public void setTipo(String tipo){
        Tipo.setText(tipo);
    }
    
    public String getTipo(){
        return Tipo.getText();
    }
}

/*public class Locales extends JPanel {
    private JLabel Nombre;
    private JLabel Direccion;
    private JLabel Telefono;
    private JLabel HoraI;
    private JLabel HoraF;
    private JLabel Tipo;
    public Locales(){
        Nombre = new JLabel();
        Direccion = new JLabel();
        Telefono = new JLabel();
        HoraI = new JLabel();
        HoraF = new JLabel();
        Tipo = new JLabel();
        
        setSize(500,100);
        setVisible(true);

        
        Nombre.setBounds(10,10 , 100, 20);
        Direccion.setBounds(10,30, 100 ,20);
        Telefono.setBounds(120,30,100,20);
        HoraI.setBounds(230, 30, 100, 20);
        HoraF.setBounds(330,30,100,20);
        Tipo.setBounds(330,10,100,20);
        
        add(Nombre);
        add(Direccion);
        add(Telefono);
        add(HoraI);
        add(HoraF);
        add(Tipo);
        
    }
    public void setNombre(String nombre){
        Nombre.setText(nombre);
    }
    
    public String getNombre(){
        return Nombre.getText();
    }
    public void setDireccion(String direccion){
        Direccion.setText(direccion);
    }
    
    public String getDireccion(){
        return Direccion.getText();
    }
        public void setTelefono(String telefono){
        Telefono.setText(telefono);
    }
    
    public String getTelefono(){
        return Telefono.getText();
    }
        public void setHoraI(String horai){
        HoraI.setText(horai);
    }
    
    public String getHoraI(){
        return HoraI.getText();
    }
        public void setHoraF(String horaf){
        HoraF.setText(horaf);
    }
    
    public String getHoraF(){
        return HoraF.getText();
    }
    public void setTipo(String tipo){
        Tipo.setText(tipo);
    }
    
    public String getTipo(){
        return Tipo.getText();
    }
}*/