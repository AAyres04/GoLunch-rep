
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
public class Agregar extends JFrame{
    private JLabel nombre;
    private JLabel direccion;
    private JLabel telefono;
    private JLabel HoraI;
    private JLabel HoraF;
    private JLabel Categorias;
    private JTextField nombre1;
    private JTextField direccion1;
    private JTextField telefono1;
    private JTextField HoraI1;
    private JTextField HoraI2;
    private JTextField HoraF1;
    private JTextField HoraF2;
    private JTextField Categorias1;
    private JButton Agregar;
    private JPanel Panel;
    private JButton volver;
    static ArrayList<LocalComida> Locales;
    public static Filtrado Lista;
    static LocalComida Local;
    public Agregar(){
        super("Agregar Local");
        Locales = new ArrayList<LocalComida>();
        direccion = new JLabel("Direccion:");
        telefono = new JLabel("Telefono:");
        HoraI = new JLabel("Hora Inicial:");
        HoraF = new JLabel("Hora Final:");
        nombre = new JLabel("Nombre: ");
        Categorias= new JLabel ("Categorias: ");
        direccion1= new JTextField();
        nombre1 = new JTextField();
        telefono1 = new JTextField();
        HoraI1 = new JTextField();
        HoraI2 = new JTextField();
        HoraF1 = new JTextField();
        HoraF2 = new JTextField();
        Categorias1 = new JTextField();
        Agregar = new JButton("Agregar");
        Panel = new JPanel();
        volver = new JButton("Volver");
       // Locales = Lista.getListaLocales();
             Panel.setLayout(null);
     setSize(300,360);
     setLocation(500,280);
     setResizable(false);

     
        nombre.setBounds(10, 20, 150, 20);
        nombre1.setBounds(120, 20, 150, 20);
        direccion.setBounds(10, 60, 100, 20);
        direccion1.setBounds(120, 60, 150, 20);
        telefono.setBounds(10, 100, 100, 20);
        telefono1.setBounds(120, 100, 150,20);
        HoraI.setBounds(10,140,100,20);
        HoraI1.setBounds(120, 140, 150, 20);

        HoraF.setBounds(10, 180, 100, 20);
        HoraF1.setBounds(120, 180, 150, 20);
        Categorias.setBounds(10,220,100,20);
        Categorias1.setBounds(120,220,150,20);
        Agregar.setBounds(180, 280, 100, 20);
        volver.setBounds(10,280,100,20);
        
        Panel.add(volver);
        Panel.add(telefono);
        Panel.add(telefono1);
        Panel.add(nombre);
        Panel.add(nombre1);
        Panel.add(direccion);
        Panel.add(direccion1);
        Panel.add(HoraI);
        Panel.add(HoraF);
        Panel.add(HoraI1);

        Panel.add(HoraF1);

        Panel.add(Categorias);
        Panel.add(Categorias1);
        Panel.add(Agregar);
        
            getContentPane().add(Panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
     
           volver.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          dispose();
          new Admin();
      }
      });
           
        Agregar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Local = new LocalComida(0);
            Local.setNombre(nombre1.getText());
            Local.setDireccion(direccion1.getText());
            Local.setTelefono(telefono1.getText());
            Local.setHoraInicio(HoraI1.getText());
            Local.setHoraFinal(HoraF1.getText());
            Local.setCategorias(Categorias1.getText());
            Local.setLocalBuscado(false);
            Local.setIdRest(0);
            Locales.add(Local);
            Lista.setListaLocales(Locales);
      }
      });
    }
}