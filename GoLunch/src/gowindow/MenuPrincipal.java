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
import javax.swing.table.*;
/**
 *Ventanan principal de busqueda de restaurantes.
 * @author Vicente
 */
public class MenuPrincipal extends JFrame {
 private JTable tabla;
 private Login Login;
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
 private Object NombreColumnas[]={"Nombre","Direccion","Telefono","Hora Inicial","Hora Final","Categorias","Marcador"};
 private String[] tipos = {"Todas","Picada","Sushi","China","Italiana",
                          "Peruana","Parrilla","Comida Rapida"};
 private String[] hora = {"Todas","00:00","01:00","02:00","03:00","04:00","05:00","06:00","07:00","08:00","09:00","10:00","11:00","12:00",
                            "13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
 private String[] zonas = {"Todas","Ufro","Av.Alemana","Centro"};
 private JScrollPane Spanel;
 /* private Object Columnas1[][]={{"Pedro Juan Y Diego","Mall","4523525","9:00","22:00","Comida Rapida",false},
      {"Mac","mall","4523525","9:00","22:00","Comida Rapida",false}};*/
 private Object Columnas1[][];
 private int s = 0 ;
public MenuPrincipal(int id){
    super("GoLunch");
    Admin = new JButton("Administrador");
        Columnas1= new Object[30][7];
    for(int j = 0;j<30;j++){
        Columnas1[j][0]="Pedro Juan Y Diego";
        Columnas1[j][1]="Mall";
        Columnas1[j][2]="3982091";
        Columnas1[j][3]="19:00";
        Columnas1[j][4]="19:00";
        Columnas1[j][5]="Comida Rapida";
        Columnas1[j][6]=false;
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
    System.out.println(Columnas1.length);
   for(int i = 0 ; i < Columnas1.length;i++){
           Object n = Columnas1[i][0];
           Object d = Columnas1[i][1];
           Object te  = Columnas1[i][2];
           Object hi = Columnas1[i][3];
           Object hf = Columnas1[i][4];
           Object ti = Columnas1[i][5];
   }
 
   ID = id;
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
    
         marcadores.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new Marcadores(ID);
      }
      });
      listado.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new Listado(ID);
      }
      });
      
       buscar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Object nombre,direccion,telefono,horai,horaf,categoria,marcador;
            model.setRowCount(0);
            for (int i = 0 ; i< 30 ; i++){
                nombre = "Master roll";
                direccion = "uruaguay";
                telefono = "129810984";
                horai = "17:00";
                horaf = "24:00";
                categoria  = "Sushi";
                marcador = false; 
                Object row[]= {nombre,direccion,telefono,horai,horaf,categoria,marcador};
                model.addRow(row);
            }
        }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            try{
            int row = tabla.rowAtPoint(evt.getPoint());
            int col = tabla.columnAtPoint(evt.getPoint());
            System.out.println(row);
            System.out.println(col);
            String Fila;
            String Marca = Columnas1[row][col].toString();
            System.out.println(Marca);
            File file = new File("Marcadores"+Integer.toString(ID)+".txt");
            String IDLocal = " ";
            Fila = Integer.toString(row);
            if (col == 6){
            if(!Marca.equals("true")){
            FileWriter filewrite = new FileWriter(file, true);    
            Scanner scan = new Scanner(file); 
            while (scan.hasNext()) {
            IDLocal = scan.nextLine();
                System.out.println(Fila);
                System.out.println(IDLocal);
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
            Columnas1[row][col]=true;
            }else{
                
                removerLinea("Marcadores"+Integer.toString(ID)+".txt",Fila);
                Columnas1[row][col]=false;
            }
            }
            
        }catch(Exception e){
            
        }

 
        }
    
});
          Admin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          new Admin(ID);
      }
      });
          
         
} 
    /**
     *  Remueve una linea especifica dentro de un archivo txt.
     * @param Archivo
     * @param Borrar 
     */
     public static void removerLinea(String Archivo,String Borrar){
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
                 System.out.println(Local);
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
}
