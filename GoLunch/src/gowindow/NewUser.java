/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;

/**
 *
 * @author Zeiruos
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.lang.*;


public class NewUser extends JFrame {
  private JLabel creacion;
  private JLabel usuario;
  private JLabel contraseña;
  private JButton create;
  private JButton salir;
  private JPanel newUserPanel;
  private JTextField txuserer;
  private JTextField passer;
  


  public NewUser(){
    super("Registration");

    create = new JButton("Crear");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);
    salir = new JButton("Salir");
    creacion = new JLabel("Nueva Cuenta");
    usuario = new JLabel("      Usuario:");
    contraseña = new JLabel("Contraseña:");
    


    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null); 
    creacion.setBounds(100, 10, 100, 20);
    usuario.setBounds(20,38,80,20);
    contraseña.setBounds(20,73,80,20);
    txuserer.setBounds(90,40,150,20);
    passer.setBounds(90,75,150,20);
    create.setBounds(50,100,80,20);
    salir.setBounds(150,100,80,20);
    
    newUserPanel.add(create);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);
    newUserPanel.add(salir);
    newUserPanel.add(creacion);
    newUserPanel.add(usuario);
    newUserPanel.add(contraseña);
    

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
            String Ultima;
            String IDS="";
            int ID=1;
            File file = new File("userPass.txt");
            Scanner scan = new Scanner(file);;
            Ultima =tail(file);
            ID= Integer.parseInt(Ultima)+1;
            FileWriter filewrite = new FileWriter(file, true);
            String usertxter = " ";
            String passtxter = " ";
            String punamer = txuserer.getText();
            String ppaswder = passer.getText();
            while (scan.hasNext()) {
            usertxter = scan.nextLine();
            passtxter = scan.nextLine();
            IDS = scan.nextLine();
            }
            if(punamer.equals(usertxter) ) {
            JOptionPane.showMessageDialog(null,"Este Usuario ya esta creado");
            txuserer.setText("");
            passer.setText("");
            txuserer.requestFocus();

            } 
        else if(punamer.equals("") && ppaswder.equals("")){
            JOptionPane.showMessageDialog(null,"Porfavor inserte usuario y contraseña");
            }
        else {
            filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n"+ID+"\r\n");
            filewrite.close();
            JOptionPane.showMessageDialog(null,"Tu cuenta se ha creado.");
            dispose();
            Login log = new Login();



        }
        } catch (IOException d) {
      d.printStackTrace();
    }

      }
    });
     salir.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          dispose();
          Login log = new Login();
      }
      });
     
        
    }
  public String tail( File file ) {
    RandomAccessFile fileHandler = null;
    try {
        fileHandler = new RandomAccessFile( file, "r" );
        long fileLength = fileHandler.length() - 1;
        StringBuilder sb = new StringBuilder();

        for(long filePointer = fileLength; filePointer != -1; filePointer--){
            fileHandler.seek( filePointer );
            int readByte = fileHandler.readByte();

            if( readByte == 0xA ) {
                if( filePointer == fileLength ) {
                    continue;
                }
                break;

            } else if( readByte == 0xD ) {
                if( filePointer == fileLength - 1 ) {
                    continue;
                }
                break;
            }

            sb.append( ( char ) readByte );
        }

        String lastLine = sb.reverse().toString();
        return lastLine;
    } catch( java.io.FileNotFoundException e ) {
        e.printStackTrace();
        return null;
    } catch( java.io.IOException e ) {
        e.printStackTrace();
        return null;
    } finally {
        if (fileHandler != null )
            try {
                fileHandler.close();
            } catch (IOException e) {
                /* ignore */
            }
    }
}
 
}
