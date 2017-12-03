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
import javax.swing.table.*;
/**
 *Ventana la cual imprime los marcadores seleccionados por el usuario.
 * @author Vicente
 */
public class Marcadores extends JFrame {
 private JButton marcadores;
 private JButton listado;
 private JButton buscador;
 private JPanel panel;
 private int ID;
private Object NombreColumnas[]={"Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias","Marcador"};
  private Object Columnas1[][];/*={{"Pedro Juan Y Diego","Mall","4523525","9:00","22:00","Comida Rapida",true},
      {"Mac","mall","4523525","9:00","22:00","Comida Rapida",true}};*/
 private JTable tabla;
 private JScrollPane Spanel;
 public Marcadores(int id){
     super("GoLunch");
             Columnas1= new Object[30][7];
    for(int j = 0;j<30;j++){
        Columnas1[j][0]="Pedro Juan Y Diego";
        Columnas1[j][1]="Mall";
        Columnas1[j][2]="3982091";
        Columnas1[j][3]="19:00";
        Columnas1[j][4]="19:00";
        Columnas1[j][5]="Comida Rapida";
        Columnas1[j][6]=true;
    }
         DefaultTableModel model = new DefaultTableModel(Columnas1,NombreColumnas);
     tabla = new JTable(model){
         

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
            public boolean isCellEditable(int rowIndex, int columnIndex){
    return columnIndex == 6; //Or whatever column index you want to be editable
    }   
     };
    panel = new JPanel();
    marcadores = new JButton("Marcadores");
    listado = new JButton("Listado");
    buscador= new JButton("Buscador");
    ID = id;
    Spanel = new JScrollPane(tabla);
    setSize(555,690);
    setLocation(500,0);
    setResizable(false);
    tabla.getTableHeader().setReorderingAllowed(false);
    panel.setLayout (null);
    buscador.setBounds(0, 0, 183, 20);
    marcadores.setBounds(366, 0, 184, 20);
    listado.setBounds(183,0,183,20);
    Spanel.setBounds(0,30,550,700);
    
    panel.add(buscador);
    panel.add(listado);
    panel.add(marcadores);
     panel.add(Spanel);
    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
    
        listado.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          new Listado(ID);
      }
      });
          
                
      buscador.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new MenuPrincipal(ID);
      }
      });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tabla.rowAtPoint(evt.getPoint());
        int col = tabla.columnAtPoint(evt.getPoint());
        System.out.println(row);
        System.out.println(col);
        }
    
});
 }
}
