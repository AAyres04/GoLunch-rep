/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.util.ArrayList;
import java.io.IOException;

/**
 *
 * @author Zeiruos
 */
public class Filtrado {
    
    private ArrayList<LocalComida> listaLocales;
    private LeerExcel lecturaExcel;
    
    public Filtrado(){
        this.listaLocales = new ArrayList<>();
        this.lecturaExcel = new LeerExcel();
    }
    public ArrayList<LocalComida> getListaLocales(){
        return this.listaLocales;
    }
    public void setListaLocales(ArrayList listaLocales){
        this.listaLocales = listaLocales;
    }
    public LocalComida asignarDatos(int id, String lineData){//parametro prueba
        LocalComida objLocal = new LocalComida(id);
        if (lineData.contains("!")){
            
        } else {
            
        }
        return objLocal;
    }
    public String[] recepcionDatos(){
        String data;
        String[] splitData;
        try{
            this.lecturaExcel.readExcel("", "", "Hoja1");
        }catch(IOException e){
            System.out.println("ERROR-READEXCEL");
            System.exit(0);
        }
        data = this.lecturaExcel.getData();
        splitData = data.split("|");
        return splitData;
    }
    public void rellenarLista(String[] allData){
        for(int i = 0; i < allData.length ; i++){
            this.listaLocales.add(asignarDatos(i, allData[i]));
        }
    }
    public void limpiarListadoLocal(){
        for(int i = 0; i<this.listaLocales.size();i++){
            this.listaLocales.get(i).setLocalBuscado(false);
        }
    }
}
