/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;
/**
 *
 * @author Zeiruos
 */
public class GoLunch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        menu.imprimirLista();
        menu.buscarNombre();
        menu.imprimirListaTrue();
        menu.buscarDir();
        menu.imprimirListaTrue();
        menu.buscarHoraI();
        menu.imprimirListaTrue();
        menu.buscarHoraF();
        menu.imprimirListaTrue();
    }
}
