
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
    private JLabel Tipo;
    private JTextField nombre1;
    private JTextField direccion1;
    private JTextField telefono1;
    private JTextField HoraI1;
    private JTextField HoraI2;
    private JTextField HoraF1;
    private JTextField HoraF2;
    private JTextField Tipo1;
    private JButton Agregar;
    private JPanel Panel;
    private JButton volver;
    
    public Agregar(){
        super("Agregar Local");
        direccion = new JLabel("Direccion:");
        telefono = new JLabel("Telefono:");
        HoraI = new JLabel("Hora Inicial:");
        HoraF = new JLabel("Hora Final:");
        nombre = new JLabel("Nombre: ");
        Tipo = new JLabel ("Tipo: ");
        direccion1= new JTextField();
        nombre1 = new JTextField();
        telefono1 = new JTextField();
        HoraI1 = new JTextField();
        HoraI2 = new JTextField();
        HoraF1 = new JTextField();
        HoraF2 = new JTextField();
        Tipo1 = new JTextField();
        Agregar = new JButton("Agregar");
        Panel = new JPanel();
        volver = new JButton("Volver");
        
             Panel.setLayout(null);
     setSize(300,360);
     setLocation(500,280);

     
        nombre.setBounds(10, 20, 150, 20);
        nombre1.setBounds(120, 20, 150, 20);
        direccion.setBounds(10, 60, 100, 20);
        direccion1.setBounds(120, 60, 150, 20);
        telefono.setBounds(10, 100, 100, 20);
        telefono1.setBounds(120, 100, 150,20);
        HoraI.setBounds(10,140,100,20);
        HoraI1.setBounds(120, 140, 40, 20);
        HoraI2.setBounds(180, 140, 40, 20);
        HoraF.setBounds(10, 180, 100, 20);
        HoraF1.setBounds(120, 180, 40, 20);
        HoraF2.setBounds(180, 180, 40, 20);
        Tipo.setBounds(10,220,100,20);
        Tipo1.setBounds(120,220,150,20);
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
        Panel.add(HoraI2);
        Panel.add(HoraF1);
        Panel.add(HoraF2);
        Panel.add(Tipo);
        Panel.add(Tipo1);
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
    }
}