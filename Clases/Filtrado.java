/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.util.ArrayList;

/**
 *
 * @author Zeiruos
 */
public class Filtrado {
    private ArrayList<LocalComida> listaLocales;
    private int lecturaExcel; //placeHolder
    public Filtrado(){
        this.listaLocales = new ArrayList<>();
    }
    public ArrayList<LocalComida> getListaLocales(){
        return this.listaLocales;
    }
    public void setListaLocales(ArrayList listaLocales){
        this.listaLocales = listaLocales;
    }
    public LocalComida asignarDatos(int n){//parametro prueba
        String test = "test" + n; 
        LocalComida objLocal = new LocalComida(test, n);
        return objLocal;
    }
    public void rellenarLista(){
        for(int i = 0; i<3 ; i++){
            this.listaLocales.add(asignarDatos(i));
        }
    }
    public void limpiarListadoLocal(){
        
    }
    //TEST
}
