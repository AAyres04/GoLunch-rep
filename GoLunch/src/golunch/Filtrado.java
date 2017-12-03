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
        String[] splitLineData;
        System.out.println(lineData);
        if (lineData.contains("!") || lineData.isEmpty()){
            return null;
        } else{
            splitLineData = lineData.split(";");
            objLocal.setNombre(splitLineData[1]);
            objLocal.setDireccion(splitLineData[2]);
            objLocal.setHora(splitLineData[3]);
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
        splitData = data.split("%");
        for(int i=0; i<splitData.length;  i++){
            System.out.println(splitData[i]);
        }
        return splitData;
    }
    
    public void rellenarLista(String[] allData){
        LocalComida local;
        for(int i = 0; i < allData.length ; i++){
            local = asignarDatos(i, allData[i]);
            if (local != null){
                this.listaLocales.add(local);
                System.out.println(local);
            }
        }
    }
    
    public void limpiarListadoLocal(){
        for(int i = 0; i<this.listaLocales.size();i++){
            this.listaLocales.get(i).setLocalBuscado(false);
        }
    }
}
