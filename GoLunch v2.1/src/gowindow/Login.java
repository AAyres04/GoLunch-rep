/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;

/**
 *Ventana de inicio de sesion de usuario.
 * @author Vicente
 */
import golunch.MenuGoLunch;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Login extends JFrame {
    private int s;
    private int ID;
    private JButton blogin;
    private JPanel loginpanel;
    private JTextField inputNuevoUsuario;
    private JTextField inputContraseñaNuevoUsuario;
    private JButton newUSer;
    private JLabel username;
    private JLabel password;
    private JButton Salir;

    public Login(){
        super("Iniciar Sesion");
        ID = 1;
        s=0;
        blogin = new JButton("Iniciar sesion");
        loginpanel = new JPanel();
        inputNuevoUsuario = new JTextField(15);
        inputContraseñaNuevoUsuario = new JPasswordField(15);
        newUSer = new JButton("Crear Usuario");
        username = new JLabel("   Usuario: ");
        password = new JLabel("Contraseña:");
        Salir = new JButton("Salir");

        setSize(340,190);
        setLocation(500,280);
        setResizable(false);
        loginpanel.setLayout (null); 


        inputNuevoUsuario.setBounds(90,30,150,20);
        inputContraseñaNuevoUsuario.setBounds(90,65,150,20);
        blogin.setBounds(20,100,80,20);
        newUSer.setBounds(120,100,80,20);
        username.setBounds(20,28,80,20);
        password.setBounds(20,63,80,20);
        Salir.setBounds(220,100, 80, 20);

        loginpanel.add(blogin);
        loginpanel.add(inputNuevoUsuario);
        loginpanel.add(inputContraseñaNuevoUsuario);
        loginpanel.add(newUSer);
        loginpanel.add(username);
        loginpanel.add(password);
        loginpanel.add(Salir);

        getContentPane().add(loginpanel);
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
        
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String IDS="";
                    File file = new File("userPass.txt");
                    Scanner scan = new Scanner(file);
                    String line = null;
                    FileWriter filewrite = new FileWriter(file, true);
                    String usertxt = " ";
                    String passtxt = " ";
                    String puname = inputNuevoUsuario.getText();
                    String ppaswd = inputContraseñaNuevoUsuario.getText();
                    while (scan.hasNext()) {
                        usertxt = scan.nextLine();
                        passtxt = scan.nextLine();
                        IDS=scan.nextLine();
                        if(puname.equals("User") && ppaswd.equals("Admin")){
                            s=3;
                        } else if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
                            s=1;
                            ID = Integer.parseInt(IDS);
                        } else if(puname.equals("") && ppaswd.equals("")){
                            s=2;
                        }   
                    }
                    if (s==1){
                        dispose(); 
                        JOptionPane.showMessageDialog(null,"Has iniciado sesion correctamente.");
                        MenuGoLunch menuGo = new MenuGoLunch();
                        MenuPrincipal menu =new MenuPrincipal(ID, menuGo);
             
                    } else if(s==2){
                        JOptionPane.showMessageDialog(null,"Porfavor inserte Usuario");
                        s=0;
                    } else if (s==0){
                        JOptionPane.showMessageDialog(null,"Usuario/Contraseña Equivocada");
                        inputNuevoUsuario.setText("");
                        inputContraseñaNuevoUsuario.setText("");
                        inputNuevoUsuario.requestFocus();
                    }else if (s==3){
                        dispose();
                        JOptionPane.showMessageDialog(null,"Usted a ingresado como Administrador");
                        MenuGoLunch menuGo = new MenuGoLunch();
                        MenuPrincipal menu =new MenuPrincipal(ID, menuGo);
                    }
                } catch (IOException d) {
                    d.printStackTrace();
                }
            }
        });

        newUSer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                NewUser user = new NewUser();
                dispose();
            }
        });
    
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null,"Hasta luego.");
            }
        });    
    } 
}