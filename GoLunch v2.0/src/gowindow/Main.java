/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gowindow;

import golunch.MenuGoLunch;

/**
 *
 * @author Zeiruos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuGoLunch menu = new MenuGoLunch();
        new MenuPrincipal(1, menu);   
    }
}
