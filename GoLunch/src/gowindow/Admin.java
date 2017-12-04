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
import javax.swing.table.*;
/**
 *Ventana  para la administracion de datos.
 * @author Vicente
 */
public class Admin  extends JFrame{

    private JTable Tabla;
    private String NombreColumnas[]={"Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Tipo"};
    private Object Columnas1[][];//={{"Pedro Juan Y Diego","Mall","4523525","9:00","22:00","Comida Rapida"},{"Mac","mall","4523525","9:00","22:00","Comida Rapida"}};
    private JPanel panel;
    private JScrollPane Spanel;
    private JButton volver;
    private JButton modificar;
    private JButton agregar;
    private JButton eliminar;
    private JButton GoLunch;
    private int NumeroFilas;
    private JOptionPane eliminar1;
    private JComboBox NF;
    private JPanel Ad;
    private JLabel Adm;
    private JDialog diag;
    private JButton ok;
    private JButton cancelar;
    int ID;
    public  Admin(int id){
       super("Admin");
        Columnas1= new Object[30][6];
        for(int j = 0;j<30;j++){
        Columnas1[j][0]="Pedro Juan Y Diego";
        Columnas1[j][1]="Mall";
        Columnas1[j][2]="3982091";
        Columnas1[j][3]="19:00";
        Columnas1[j][4]="19:00";
        Columnas1[j][5]="Comida Rapida";
        }
        Object[] options = new Object[] {};
        DefaultTableModel model = new DefaultTableModel(Columnas1,NombreColumnas);
        Tabla = new JTable(model);
        panel = new JPanel();
        Spanel = new JScrollPane(Tabla);
        volver = new JButton("Salir");
        modificar = new JButton("Editar");
        GoLunch = new JButton("GoLunch");
        agregar = new JButton ("Agregar");
        eliminar = new JButton("Eliminar");
        ok = new JButton("Aceptar");
        cancelar = new JButton ("Cancelar");
        ID = id;
        eliminar1 = new JOptionPane("Elige Numero de fila",JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.DEFAULT_OPTION,
                                        null,options, null);
        diag = new JDialog();
        Ad = new JPanel();
        Adm = new JLabel("Administador");
        NF= new JComboBox();
        
        NumeroFilas = Columnas1.length;
        eliminar1.add(NF);
        eliminar1.add(ok);
        eliminar1.add(cancelar);
   
        
        Tabla.setEnabled(false);
        Tabla.getTableHeader().setReorderingAllowed(false);
        
        setSize(835,390);
        setLocation(300,100);
        setResizable(false);
        panel.setLayout (null); 
        for(int i = 0;i < NumeroFilas;i++){
           NF.addItem(i+1);
        }
        diag.getContentPane().add(eliminar1);
        Ad.setBounds(0,0,845,29);
        Adm.setBounds(400,10,150,20);
        Spanel.setBounds(0,30, 700,331);
        volver.setBounds(699,340,130,20);
        agregar.setBounds(699,30,130,20);
        modificar.setBounds(699,110,130,20);
        eliminar.setBounds(699,190,130,20);
        GoLunch.setBounds(699,270,130,20);
        
        Ad.add(Adm);
        panel.add(Ad);
        panel.add(Spanel);
        panel.add(volver);
        panel.add(agregar);
        panel.add(modificar);
        panel.add(eliminar);
        panel.add(GoLunch);
        
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
      volver.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          JOptionPane.showMessageDialog(null,"Hasta luego.");
      }
      });
             
      GoLunch.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          new MenuPrincipal(ID);
      }
      });
      agregar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          new Agregar(ID);
      }
      });
      modificar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new ModificarTabla(ID);
      }
      });
     eliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        diag.pack();
        diag.setVisible(true);
      }
      });
        ok.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        
        diag.setVisible(false);
        String get = NF.getSelectedItem().toString();
        int fila = Integer.parseInt(get);
        ((DefaultTableModel)Tabla.getModel()).removeRow(fila-1);
        NF.removeItem(NF.getItemCount());
        }
        });
       cancelar.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
        
       diag.setVisible(false);
      }
      });
    }
    
}
