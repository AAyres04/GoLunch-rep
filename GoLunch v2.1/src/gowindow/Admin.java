/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;
import golunch.MenuGoLunch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *Ventana  para la administracion de datos.
 * @author Vicente
 */
public class Admin  extends JFrame{

    private JTable Tabla;
    private Object[][] Columnas1;
    private JPanel panel;
    private JScrollPane Spanel;
    private JButton volver;
    private JButton modificar;
    private JButton agregar;
    private JButton eliminar;
    private JButton cancelar;
    private JButton GoLunch;
    private JOptionPane eliminar1;
    private JComboBox NF;
    private JPanel Ad;
    private JLabel Adm;
    private JDialog diag;
    private JButton ok;
    int ID;
    
    public  Admin(int id, MenuGoLunch menu){
        super("Admin");
        Object[] options = new Object[] {};
        Object[] nombreColumnas={"ID","Nombre","Direccion","Telefono","Hora","Categorias"};
        Columnas1 = new Object[menu.getObjFiltrado().getListaLocales().size()][6];
        for(int j = 0; j< menu.getObjFiltrado().getListaLocales().size(); j++){
            Columnas1[j][0] = menu.getObjFiltrado().getListaLocales().get(j).getIdRest();
            Columnas1[j][1] = menu.getObjFiltrado().getListaLocales().get(j).getNombre();
            Columnas1[j][2] = menu.getObjFiltrado().getListaLocales().get(j).getDireccion();
            Columnas1[j][3] = menu.getObjFiltrado().getListaLocales().get(j).getTelefono();
            Columnas1[j][4] = menu.getObjFiltrado().getListaLocales().get(j).getHora();
            Columnas1[j][5] = menu.getObjFiltrado().getListaLocales().get(j).getCategorias();
        }
        DefaultTableModel model = new DefaultTableModel(Columnas1,nombreColumnas);
        Tabla = new JTable(model);
        panel = new JPanel();
        Spanel = new JScrollPane(Tabla);
        volver = new JButton("Salir");
        modificar = new JButton("Editar");
        GoLunch = new JButton("GoLunch");
        agregar = new JButton ("Agregar");
        eliminar = new JButton("Eliminar");
        ok = new JButton("OK");
        cancelar = new JButton("Cancelar");
        ID = id;
        eliminar1 = new JOptionPane("Elige Numero de fila",JOptionPane.QUESTION_MESSAGE,
                                    JOptionPane.DEFAULT_OPTION,
                                    null,options, null);
        diag = new JDialog();
        
        
        Ad = new JPanel();
        Adm = new JLabel("Administador");
        NF= new JComboBox();
        
        eliminar1.add(NF);
        eliminar1.add(cancelar);
        eliminar1.add(ok);
        
        Tabla.setEnabled(false);
        Tabla.getTableHeader().setReorderingAllowed(false);
        
        setSize(835,390);
        setLocation(300,100);
        setResizable(false);
        panel.setLayout (null); 
        for(int i = 0;i < menu.getObjFiltrado().getListaLocales().size() ;i++){
           NF.addItem(menu.getObjFiltrado().getListaLocales().get(i).getIdRest());
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
            new MenuPrincipal(ID, menu);
            }
        });
        
        agregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Agregar(ID, menu);
            }
        });
        
        modificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ModificarTabla(ID, menu);
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
                String ID = NF.getSelectedItem().toString();
                for (int i = 0; i < menu.getObjFiltrado().getListaLocales().size() ; i++){
                    if (ID.equals(Integer.toString(menu.getObjFiltrado().getListaLocales().get(i).getIdRest()))){
                        menu.getObjFiltrado().borrarLocalExcel(menu.getObjFiltrado().getListaLocales().get(i));
                        menu.getObjFiltrado().getListaLocales().remove(menu.getObjFiltrado().getListaLocales().get(i));
                        break;
                    }
                }
            Object nombre,direccion,telefono,hora,categoria,id;
            
                model.setRowCount(0);
                for (int i = 0 ; i< menu.getObjFiltrado().getListaLocales().size() ; i++){
                    id = menu.getObjFiltrado().getListaLocales().get(i).getIdRest();
                    nombre = menu.getObjFiltrado().getListaLocales().get(i).getNombre();
                    direccion = menu.getObjFiltrado().getListaLocales().get(i).getDireccion();
                    telefono = menu.getObjFiltrado().getListaLocales().get(i).getTelefono();
                    hora = menu.getObjFiltrado().getListaLocales().get(i).getHora();
                    categoria  = menu.getObjFiltrado().getListaLocales().get(i).getCategorias();
                    Object row[]= {id,nombre,direccion,telefono,hora,categoria};
                    model.addRow(row);
                }
            }
        });
          
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                diag.setVisible(false);
            }
        });
    }
    
}
