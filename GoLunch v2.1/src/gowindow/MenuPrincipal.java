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
import java.lang.*;
import golunch.*;
import javax.swing.event.*;
import javax.swing.table.*;
/**
 *Ventanan principal de busqueda de restaurantes.
 * @author Vicente
 */
public class MenuPrincipal extends JFrame {
    
    private JTable tabla;
    private int ID;
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
    private JTextField nombreL;
    private JTextField direccion;
    private JComboBox horaInicio;
    private JButton Admin; 
    private JComboBox horaFinal;
    private JComboBox tipoComida;
    private JScrollPane Spanel;
    private Object Columnas1[][];
    private int s = 0 ;
    
    public MenuPrincipal(int id, MenuGoLunch menu){
        
        super("GoLunch");
        s = 0;
        ID = id;
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
        Object NombreColumnas[]={"ID","Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias","Marcador"};
        String[] tipos = {"Todas","Picada","Sushi","Comida China","Comida Italiana",
                          "Comida Peruana","Parrilla","Comida Rapida", "Gourmet", 
                          "Carnes", "Tradicional", "Cafeteria", "Fuente", "Pizzeria",
                          "Comida Marina"};
        String[] hora = {"Todas","00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30",
                            "05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","10:00",
                            "10:30","11:00","11:30","12:00","12:30","13:00","13:30","14:00","14:30","15:00","15:30",
                            "16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00",
                            "21:30","22:00","22:30","23:00","23:30"};
        Columnas1= new Object[menu.getObjFiltrado().getListaLocales().size()][8];
        for(int j = 0; j< menu.getObjFiltrado().getListaLocales().size(); j++){
            Columnas1[j][0]=menu.getObjFiltrado().getListaLocales().get(j).getIdRest();
            Columnas1[j][1]=menu.getObjFiltrado().getListaLocales().get(j).getNombre();
            Columnas1[j][2]=menu.getObjFiltrado().getListaLocales().get(j).getDireccion();
            Columnas1[j][3]=menu.getObjFiltrado().getListaLocales().get(j).getTelefono();
            Columnas1[j][4]=menu.getObjFiltrado().getListaLocales().get(j).getHoraInicio();
            Columnas1[j][5]=menu.getObjFiltrado().getListaLocales().get(j).getHoraFinal();
            Columnas1[j][6]=menu.getObjFiltrado().getListaLocales().get(j).getCategorias();
            Columnas1[j][7]=compararID(Columnas1[j][0].toString());
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
        Admin = new JButton("Administrador");
        marcadores = new JButton("Marcadores");
        listado = new JButton("Listado");
        buscador= new JButton("Buscador");
        buscar = new JButton ("Buscar");
        nombreLL=new JLabel("Nombre del Local");
        direccionL=new JLabel("Direccion");
        horaInicioL=new JLabel("H.inicial");
        horaFinalL=new JLabel("H. Final");
        tipoComidaL= new JLabel("Tipo de comida");
        tipoComida= new JComboBox(tipos);
        nombreL= new JTextField("");
        direccion=  new JTextField("");
        horaInicio =  new JComboBox(hora);
        horaFinal =  new JComboBox(hora);
        Container cont = new Container();
        Spanel = new JScrollPane(tabla);
        for(int i = 0 ; i < Columnas1.length;i++){
            Object n = Columnas1[i][0];
            Object d = Columnas1[i][1];
            Object te  = Columnas1[i][2];
            Object hi = Columnas1[i][3];
            Object hf = Columnas1[i][4];
            Object ti = Columnas1[i][5];
        }
 

        if (ID!=1){
            Admin.setVisible(false);
        }else{
            Admin.setVisible(true);
        }
        tabla.getTableHeader().setReorderingAllowed(false);
        setResizable(false);
        setSize(555,690);
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
        Admin.setBounds(190,110,150,20);
        buscar.setBounds(400, 110, 80, 20);
        Spanel.setBounds(0, 200, 550,462 );
    
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
        panel.add(Admin);
        panel.add(buscar);
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
        
        listado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Listado(ID, menu);
            }
        });
        
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                menu.buscarNombre(nombreL.getText().trim());
                menu.buscarDir(direccion.getText().trim());
                menu.buscarHoraI(String.valueOf(horaInicio.getSelectedItem()));
                menu.buscarHoraF(String.valueOf(horaFinal.getSelectedItem()));
                menu.buscarCategorias(String.valueOf(tipoComida.getSelectedItem()));
                ArrayList <LocalComida> showLocalesTrue = new ArrayList<>();
                
                for (int i = 0; i < menu.getObjFiltrado().getListaLocales().size(); i++){
                    if (menu.getObjFiltrado().getListaLocales().get(i).getNombreBuscado() && 
                            menu.getObjFiltrado().getListaLocales().get(i).getDireccionBuscada()&&
                                menu.getObjFiltrado().getListaLocales().get(i).getHoraInicioBuscada() && 
                                    menu.getObjFiltrado().getListaLocales().get(i).getHoraFinalBuscada()){ 
                        
                        showLocalesTrue.add(menu.getObjFiltrado().getListaLocales().get(i));
                    }
                }
                Object nombre,direccion,telefono,horai,horaf,categoria,marcador,ID;
                model.setRowCount(0);
                for (int i = 0 ; i< showLocalesTrue.size() ; i++){
                    ID = showLocalesTrue.get(i).getIdRest();
                    nombre = showLocalesTrue.get(i).getNombre();
                    direccion = showLocalesTrue.get(i).getDireccion();
                    telefono = showLocalesTrue.get(i).getTelefono();
                    horai = showLocalesTrue.get(i).getHoraInicio();
                    horaf = showLocalesTrue.get(i).getHoraFinal();
                    categoria  = showLocalesTrue.get(i).getCategorias();
                    marcador = compararID(Integer.toString(showLocalesTrue.get(i).getIdRest())); 
                    Object row[]= {ID,nombre,direccion,telefono,horai,horaf,categoria,marcador};
                    model.addRow(row);
                }
                menu.clearList(menu.getObjFiltrado());
            }
        });
        
        tabla.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent evt) {
                try{
                    int row = evt.getFirstRow();
                    int col = evt.getColumn();
                    TableModel model = (TableModel)evt.getSource();
                    String Fila;
                    Object data = model.getValueAt(row, col).toString();
                    File file = new File("Marcadores"+Integer.toString(ID)+".txt");
                    String IDLocal = " ";
                    Fila = Columnas1[row][0].toString();
                    if (col == 7){
                        if(data.equals("true")){
                            FileWriter filewrite = new FileWriter(file, true);    
                            Scanner scan = new Scanner(file); 
                            while (scan.hasNext()) {
                                IDLocal = scan.nextLine();
                                    if (Fila.equals(IDLocal)){
                                        s=1;
                                        break;
                                        
                                    }else{
                                        s=2;
                                    }
                                
                            }
                            if (s==1){
                                scan.close();
                            }else{
                                filewrite.write(Fila+"\r\n"); 
                                filewrite.close();
                                scan.close();     
                            }
                            
                        }else{
                            removerLinea("Marcadores"+Integer.toString(ID)+".txt",Fila);
                            
                        }
                    }
                }catch(Exception e){
            
                }
            }
        });
        
        Admin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Admin(ID, menu);
            }
        });     
    } 
    /**
     *  Remueve una linea especifica dentro de un archivo txt.
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
     * Metodo que compara el String dado id con cada linea de un archivo txt y
     * si alguna de esas son iguales retorna true, si no es asi retorna false.
     * @param id
     * @return 
     */
    private boolean compararID(String id){
     try{
     File file = new File("Marcadores"+Integer.toString(ID)+".txt");
     Scanner scan = new Scanner(new File("Marcadores"+Integer.toString(ID)+".txt"));   
     String IDLocal="";
     int s = 0 ;
     while (scan.hasNextLine()){
         IDLocal=scan.nextLine();
         if (IDLocal.equals(id)){
             s=1;
             break;
         }else{
             s=0;
         } 
     }
     if(s==1){
            scan.close();
            return true;
     }else{
         scan.close();
         return false;
     }
     }catch(Exception e ){
         return false;
     }

 }
}
