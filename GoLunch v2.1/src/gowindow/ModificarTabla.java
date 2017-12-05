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
import javax.swing.table.DefaultTableModel;
/**
 *Ventana la cual modifica datos del excel.Solamente puede ingresar el administrador del programa
 * @author Vicente
 */
public class ModificarTabla  extends JFrame{
    
    private JTable Tabla;
    private Object Columnas1[][];
    private JPanel panel;
    private JScrollPane Spanel;
    private JButton volver;
    private JButton modificar;
    private JComboBox Cat;
    private JLabel DesMod;
    private JComboBox NF;
    private JLabel Edicion;
    private JTextField value;
    private JLabel N;
    private int ID;
    
    public  ModificarTabla(int id, MenuGoLunch menu){
        super("Modificar");
        Object[] NombreColumnas={"ID","Nombre","Direccion","Telefono","Hora","Categorias"};
        Columnas1 = new Object[menu.getObjFiltrado().getListaLocales().size()][7];
        for(int j = 0; j< menu.getObjFiltrado().getListaLocales().size(); j++){
            Columnas1[j][0] = menu.getObjFiltrado().getListaLocales().get(j).getIdRest();
            Columnas1[j][1] = menu.getObjFiltrado().getListaLocales().get(j).getNombre();
            Columnas1[j][2] = menu.getObjFiltrado().getListaLocales().get(j).getDireccion();
            Columnas1[j][3] = menu.getObjFiltrado().getListaLocales().get(j).getTelefono();
            Columnas1[j][4] = menu.getObjFiltrado().getListaLocales().get(j).getHora();
            Columnas1[j][5] = menu.getObjFiltrado().getListaLocales().get(j).getCategorias();
        }
        DefaultTableModel model = new DefaultTableModel(Columnas1,NombreColumnas);
        ID= id;
        panel = new JPanel();
        NF = new JComboBox();
        Tabla = new JTable(model);
        Spanel = new JScrollPane(Tabla);
        volver = new JButton("Volver");
        modificar = new JButton("Modificar");
        Cat = new JComboBox (NombreColumnas);
        DesMod = new JLabel ("Categoria:");
        value = new JTextField ("");
        N = new JLabel ("Numero de ID:");
        Edicion = new JLabel("Nuevo Valor:");
        
        setSize(890,390);
        setLocation(300,100);
        setResizable(false);
        panel.setLayout (null); 
        for(int i = 0;i < menu.getObjFiltrado().getListaLocales().size() ;i++){
           NF.addItem(menu.getObjFiltrado().getListaLocales().get(i).getIdRest());
        }
        Spanel.setBounds(0,30, 700,331);
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
              
                String Categoria =Cat.getSelectedItem().toString();
                String IDLocal = String.valueOf(NF.getSelectedItem());
                String ID = "";
                if (!value.getText().equals("")){
                    for (int i = 0 ; i < menu.getObjFiltrado().getListaLocales().size();i++){
                        ID =Integer.toString(menu.getObjFiltrado().getListaLocales().get(i).getIdRest());
             
                    if(IDLocal.equals(ID)){
                        switch(Categoria){
                            case "ID":
                                JOptionPane.showMessageDialog(null, "No es posible cambiar la ID");
                            case "Nombre":
                                menu.getObjFiltrado().getListaLocales().get(i).setNombre(value.getText());
                                menu.getObjFiltrado().modificarValorExcel(1, menu.getObjFiltrado().getListaLocales().get(i));
                                break;
                            case "Direccion":
                                menu.getObjFiltrado().getListaLocales().get(i).setDireccion(value.getText());
                                menu.getObjFiltrado().modificarValorExcel(2, menu.getObjFiltrado().getListaLocales().get(i));
                                break;
                            case "Telefono":
                                menu.getObjFiltrado().getListaLocales().get(i).setTelefono(value.getText());
                                menu.getObjFiltrado().modificarValorExcel(5, menu.getObjFiltrado().getListaLocales().get(i));
                                break;
                            case "Hora":
                                menu.getObjFiltrado().getListaLocales().get(i).setHora(value.getText());
                                menu.getObjFiltrado().modificarValorExcel(3, menu.getObjFiltrado().getListaLocales().get(i));
                                break;
                            case "Categorias":
                                menu.getObjFiltrado().getListaLocales().get(i).setCategorias(value.getText());
                                menu.getObjFiltrado().modificarValorExcel(4, menu.getObjFiltrado().getListaLocales().get(i));
                                break;
                            }
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
                }else{
                    JOptionPane.showMessageDialog(null, "No se ingreso un valor valido");
                }
            }
        });
    }  
}
