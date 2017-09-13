/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categorias;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Vicente
 */
public class Categorias {
    String[] Categorias = {"Todas","Picada","Sushi","China","Italiana",
                          "Peruana","Parrilla","Comida Rapida"};
    String[] Letras = {"Todas","A","B","C","D","H"
                        ,"I","J","K","L","M"
                        ,"N","Ñ","O","P","Q",
                        "R","S","T","U","V",
                        "W","X","Y","Z"};
    JComboBox c = new JComboBox(Letras);
    JComboBox d = new JComboBox(Categorias);
    JButton b = new JButton("Buscar");
    JLabel l = new JLabel("Letra seleccionada");
    JLabel o = new JLabel("Tipo de Restaurant");
    public Categorias(){
        
        Frame();
    }
    
public void Frame(){
    JFrame f = new JFrame();
    f.setVisible(true);
    f.setSize(285,150);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel p = new JPanel();
    p.add(c);
    p.add(d);
    p.add(b);
    p.add(l);
    p.add(o);
    f.add(p);
    b.addActionListener(new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
            String s = c.getSelectedItem().toString();
            String a = d.getSelectedItem().toString();
            l.setText(s);
            o.setText(a);
        }
    });
    



}
}
