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
import javax.swing.event.*;

/**
 *Ventana la cual imprime los marcadores seleccionados por el usuario.
 * @author Vicente
 */
public class Marcadores extends JFrame {
    private int s;
    private JButton marcadores;
    private JButton listado;
    private JButton buscador;
    private JPanel panel;
    private int ID;

    private Object Columnas1[][];
    private JTable tabla;
    private JScrollPane Spanel;
    public Marcadores(int id, MenuGoLunch menu){
        super("GoLunch");
        ID = id;
        s=0;
        Columnas1= new Object[contador()][8];
        Object NombreColumnas[]={"ID","Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias","Marcador"};

        LeerTxT(menu);
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
                        return int.class;
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
                    case 6:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return columnIndex == 7; //Or whatever column index you want to be editable
            }   
        };
        panel = new JPanel();
        marcadores = new JButton("Marcadores");
        listado = new JButton("Listado");
        buscador= new JButton("Buscador");
    
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
    
        Writer writer = null;
        File check = new File("Marcadores"+Integer.toString(ID)+".txt");
        if(check.exists() ){
            //Checks if the file exists. will not add anything if the file does exist.
        }else{
            try{
                File texting = new File("Marcadores"+Integer.toString(ID)+".txt");
                writer = new BufferedWriter(new FileWriter(texting));
                writer.write("message");
            }catch(IOException e){
                e.printStackTrace();       
            }
        }
        listado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Listado(ID, menu);
            }
        });
          
                
        buscador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPrincipal(ID, menu);
            }
        });
        tabla.getModel().addTableModelListener(new TableModelListener() {
    
            public void tableChanged(TableModelEvent evt) {
                try{
                    int row = evt.getFirstRow();
                    int col = evt.getColumn();
                    String Fila;
                    String Marca = Columnas1[row][col].toString();
                    File file = new File("Marcadores"+Integer.toString(ID)+".txt");
                    String IDLocal = " ";
                    Fila = Columnas1[row][0].toString();
                    if (col == 7){
                        removerLinea("Marcadores"+Integer.toString(ID)+".txt",Fila);
                        ((DefaultTableModel)tabla.getModel()).removeRow(row);
                    }else{
                
                    }                
                }catch(Exception e){
                }
            }
        });
    }
    /**
     * Remueve una linea especifica dentro de un archivo txt.
     * @param Archivo
     * @param Borrar 
     */
    
    private static void removerLinea(String Archivo,String Borrar){
        String tempfile = "temp.txt";
        File oldFile = new File(Archivo);
        File newFile = new File(tempfile);
        String Local;
         
        try{
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            Scanner scan = new Scanner(new File(Archivo));
             
            while(scan.hasNext()){
                Local = scan.nextLine();
                if(!Local.equals(Borrar)){
                    pw.print(Local+"\r\n");
                }
            }
            scan.close();
            pw.flush( );
            pw.close();
            oldFile.delete();
            File dump = new File(Archivo);
            newFile.renameTo(dump);
        }catch(Exception e){
             
        }
    }
    /**
     * Metodo el cual lee un archivo txt y compara cada linea del archivo con
     * el ID de cada uno de los locales y si son iguales, añade datos a la
     * matriz Columnas1[][]
     * @param menuList 
     */
    
    private void LeerTxT(MenuGoLunch menuList){
        try{
            File file = new File("Marcadores"+Integer.toString(ID)+".txt");
            Scanner scan = new Scanner(file);
            String ID;
            String IDLocal ="";
            int j = 0;
            while(scan.hasNext()){
                IDLocal = scan.nextLine();
                for (int i = 0 ; i < menuList.getObjFiltrado().getListaLocales().size();i++){
                    ID =Integer.toString(menuList.getObjFiltrado().getListaLocales().get(i).getIdRest());
                    if(IDLocal.equals(ID)){
                        Columnas1[j][0] =menuList.getObjFiltrado().getListaLocales().get(i).getIdRest();
                        Columnas1[j][1] =menuList.getObjFiltrado().getListaLocales().get(i).getNombre();
                        Columnas1[j][2] =menuList.getObjFiltrado().getListaLocales().get(i).getDireccion();
                        Columnas1[j][3] =menuList.getObjFiltrado().getListaLocales().get(i).getTelefono();
                        Columnas1[j][4] =menuList.getObjFiltrado().getListaLocales().get(i).getHoraInicio();
                        Columnas1[j][5] =menuList.getObjFiltrado().getListaLocales().get(i).getHoraFinal();
                        Columnas1[j][6]=menuList.getObjFiltrado().getListaLocales().get(i).getCategorias();
                        Columnas1[j][7]=true;
                    }  
                }
                j=j+1;
            }
        scan.close();
     
        }catch(Exception e){
         
         
        }
    }
    /**
     * Metodo el cual cuenta la cantidad de lineas que tiene un archivo txt y 
     * regresa un entero con el total.
     * @return 
     */
    private int contador(){
        try{
        File file = new File("Marcadores"+Integer.toString(ID)+".txt");
        Scanner scan = new Scanner(new File("Marcadores"+Integer.toString(ID)+".txt"));   
        int i=0;
        while (scan.hasNextLine()){
            i=i+1;
            scan.nextLine();
        }
        scan.close();
        return i;
        }catch(Exception e ){
            return 0;
        }
    }
}
