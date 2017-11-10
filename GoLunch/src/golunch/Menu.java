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
    private BuscadorDireccion buscador2;
    private BuscadorHora buscador3;
    private BuscadorHora buscador4;
    public Menu(){
        this.hola = new Filtrado();
        this.buscador1 = new BuscadorNombre();
        this.buscador2 = new BuscadorDireccion();
        this.buscador3 = new BuscadorHora("inicio");
        this.buscador4 = new BuscadorHora("final");
        this.hola.rellenarLista();
    }
    private boolean validarHora(){
        boolean formato = false;
        //El formato de la hora debe ser 'NUM':'NUM'
        String[] split = this.input.split(":");
        int entero = 0;
        for (int i = 0; i<split.length;i++){
            try{
                entero = Integer.parseInt(split[i]);
            }catch(NumberFormatException e){
                formato = false;
                break;
            }
            System.out.println("validado");
            formato = true;
        }
        return formato;
    }
    public void imprimirLista(){
        for(int i = 0; i<3 ; i++){
            System.out.println(this.hola.getListaLocales().get(i));
        }
    }
    public void buscarNombre(){//TEST
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        this.buscador1.setInput(this.input);
        this.buscador1.compararInput(this.hola);
    }
    public void buscarDir(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        this.buscador2.setInput(this.input);
        this.buscador2.compararInput(this.hola);
    }
    public void buscarHoraI(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        if(validarHora()){
            this.buscador3.setInput(this.input);
            this.buscador3.compararInput(this.hola);
        }else{
            System.out.println("Nope");
        }
    }
    public void buscarHoraF(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        if(validarHora()){
            this.buscador3.setInput(this.input);
            this.buscador3.compararInput(this.hola);
        }else{
            System.out.println("Nope");
        }
    }
    public void imprimirListaTrue(){//TEST
        for(int i = 0; i<3 ; i++){
            if(this.hola.getListaLocales().get(i).getLocalBuscado()){
                System.out.println(this.hola.getListaLocales().get(i));
            }
        }
        this.hola.limpiarListadoLocal();
    }
}
