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
/**
 *Ventana la cual imprime la lista completa.
 * @author Vicente
 */
public class Listado extends JFrame {
    
    private JButton marcadores;
    private JButton listado;
    private JButton buscador;
    private JPanel panel;
    private int ID;
    private Object Columnas1[][];
    private JTable tabla;
    private JScrollPane Spanel;
    
    public Listado(int id, MenuGoLunch menu){
        
        super("GoLunch");
        
        Object[] NombreColumnas={"ID","Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias",};
        Columnas1 = new Object[menu.getObjFiltrado().getListaLocales().size()][7];
        for(int j = 0; j< menu.getObjFiltrado().getListaLocales().size(); j++){
            Columnas1[j][0] = menu.getObjFiltrado().getListaLocales().get(j).getIdRest();
            Columnas1[j][1] = menu.getObjFiltrado().getListaLocales().get(j).getNombre();
            Columnas1[j][2] = menu.getObjFiltrado().getListaLocales().get(j).getDireccion();
            Columnas1[j][3] = menu.getObjFiltrado().getListaLocales().get(j).getTelefono();
            Columnas1[j][4] = menu.getObjFiltrado().getListaLocales().get(j).getHoraInicio();
            Columnas1[j][5] = menu.getObjFiltrado().getListaLocales().get(j).getHoraFinal();
            Columnas1[j][6] = menu.getObjFiltrado().getListaLocales().get(j).getCategorias();
        }
        tabla = new JTable(Columnas1,NombreColumnas);
        panel = new JPanel();
        marcadores = new JButton("Marcadores");
        listado = new JButton("Listado");
        buscador= new JButton("Buscador");
        ID = id;
        Spanel = new JScrollPane(tabla);
        setSize(555,700);
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
    
        marcadores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Marcadores(ID, menu);
            }
        });
      
        buscador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPrincipal(ID, menu);
            }
        });
    }
}