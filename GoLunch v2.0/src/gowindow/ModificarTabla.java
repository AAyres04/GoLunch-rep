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
 *Ventana la cual modifica datos del excel.Solamente puede ingresar el administrador del programa
 * @author Vicente
 */
public class ModificarTabla  extends JFrame{
    private JTable Tabla;
    private String NombreColumnas[]={"Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias"};
    private ArrayList<String> Columnas;
    private String Columnas1[][];
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
    static ArrayList<LocalComida> Locales;
    static Filtrado Lista;
    private int ID;
    public  ModificarTabla(int id, MenuGoLunch menu){
        ID= id;
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
 /*       Locales = Lista.getListaLocales();
        Columnas1 = new String[Locales.size()][6];
        for(int j = 0;j < Locales.size();j++ ){
            Columnas1[0][j]=Locales.get(j).getNombre();
            Columnas1[1][j]=Locales.get(j).getDireccion();
            Columnas1[2][j]=Locales.get(j).getTelefono();
            Columnas1[3][j]=Locales.get(j).getHoraInicio();
            Columnas1[4][j]=Locales.get(j).getHoraFinal();
            Columnas1[5][j]=Locales.get(j).getCategorias();
           
        }*/
        Tabla = new JTable(Columnas1,NombreColumnas);
        setSize(890,390);
        setLocation(300,100);
        setResizable(false);
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
          new Admin(ID, menu);
      }
      });
        
          modificar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
              String Categoria = Cat.getSelectedItem().toString();
              String Fila = NF.getSelectedItem().toString();
              int Fil = Integer.parseInt(Fila)-1;
              int Colum =0;
              String NombreCat = "";
              if (!value.getText().equals("")){
                for (int i = 0 ;i< NombreColumnas.length;i++ ){
                     NombreCat = NombreColumnas[i];
                if(Categoria.equals(NombreCat)){
                    Colum = i;
                }
                }
                Columnas1[Fil][Colum] = value.getText();
                Tabla.setValueAt(Columnas1[Fil][Colum], Fil, Colum);
                if (Colum == 0){
                     Locales.get(Fil).setNombre(value.getText());
                 }else if (Colum == 1 ){
                     Locales.get(Fil).setDireccion(value.getText());
                 }else if (Colum == 2 ){
                    Locales.get(Fil).setTelefono(value.getText());
                }else if(Colum == 3){
                     Locales.get(Fil).setHoraInicio(value.getText());
                }else if(Colum == 4){
                     Locales.get(Fil).setHoraFinal(value.getText());
                }else if(Colum == 5){
                     Locales.get(Fil).setCategorias(value.getText());
                }
                 Lista.setListaLocales(Locales);
         }else{
              JOptionPane.showMessageDialog(null, "No se ingreso nombre");
              }
        }
      });
    }
    
}
