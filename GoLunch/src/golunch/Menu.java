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
    private Filtrado objFiltrado;
    private BuscadorGamma master;
    /*private BuscadorNombre buscador1;
    private BuscadorDireccion buscador2;
    private BuscadorHora buscador3;
    private BuscadorHora buscador4;*/
    public Menu(){
        this.objFiltrado = new Filtrado();
        this.master = new BuscadorGamma();
        /*this.buscador1 = new BuscadorNombre();
        this.buscador2 = new BuscadorDireccion();
        this.buscador3 = new BuscadorHora("inicio");
        this.buscador4 = new BuscadorHora("final");*/
        this.objFiltrado.rellenarLista(this.objFiltrado.recepcionDatos());
    }
    /*private boolean validarHora(){
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
    }*/
    public void imprimirLista(){
        for(int i = 0; i<this.objFiltrado.getListaLocales().size() ; i++){
            System.out.println(this.objFiltrado.getListaLocales().get(i));
        }
    }
    public void buscarNombre(){//TEST
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        this.master.setInput(this.input);
        this.master.compararNombre(this.objFiltrado);
    }
    public void buscarDir(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        this.master.setInput(this.input);
        this.master.compararDireccion(this.objFiltrado);
    }
    /*public void buscarHoraI(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        if(validarHora()){
            this.buscador3.setInput(this.input);
            this.buscador3.compararInput(this.objFiltrado);
        }else{
            System.out.println("Nope");
        }
    }
    public void buscarHoraF(){
        Scanner scan = new Scanner(System.in);
        this.input = scan.nextLine();
        if(validarHora()){
            this.buscador3.setInput(this.input);
            this.buscador3.compararInput(this.objFiltrado);
        }else{
            System.out.println("Nope");
        }
    }¨*/
    public void imprimirListaTrue(){//TEST
        for(int i = 0; i<this.objFiltrado.getListaLocales().size() ; i++){
            if(this.objFiltrado.getListaLocales().get(i).getLocalBuscado()){
                System.out.println(this.objFiltrado.getListaLocales().get(i));
            }
        }
        this.objFiltrado.limpiarListadoLocal();
    }
}
