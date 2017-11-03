/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.util.Scanner;
/**
 *
 * @author Zeiruos
 */
public class Menu {
    private String input;
    private Filtrado hola;
    private BuscadorNombre buscador1;
    public Menu(){
        this.hola = new Filtrado();
        this.buscador1 = new BuscadorNombre();
        this.hola.rellenarLista();
    }
    public void imprimirLista(){
        for(int i = 0; i<3 ; i++){
            System.out.println(this.hola.getListaLocales().get(i));
        }
    }
    public void buscarInput(){//TEST
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        this.buscador1.setInput(this.input);
        this.buscador1.compararInput(this.hola);
    }
    public void imprimirListaTrue(){//TEST
        for(int i = 0; i<3 ; i++){
            if(this.hola.getListaLocales().get(i).getLocalBuscado()){
                System.out.println(this.hola.getListaLocales().get(i));
            }
        }
    }
}
