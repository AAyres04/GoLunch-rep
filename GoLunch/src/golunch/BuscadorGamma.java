/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Zeiruos
 */
public class BuscadorGamma {
    
    protected String input;
    protected ArrayList<String> listaInput;
    
    public BuscadorGamma(){
        this.listaInput = new ArrayList<>();
    }
    public String getInput(){
        return this.input;
    }
    public void setInput(String input){
        this.input = input;
    }
    protected void splitInput(){
        String[] splitInput = this.input.split(" ");
        this.listaInput.addAll(Arrays.asList(splitInput));
    }
    public ArrayList getListaInput(){
        int hola=2;
        return this.listaInput;
    }
    /*Seccion Nombre*/
    public void compararNombre(Filtrado objFiltrado) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
            for(int i=0;i<objFiltrado.getListaLocales().size(); i++){
                for(int c=0; c<this.listaInput.size(); c++){
                    if(objFiltrado.getListaLocales().get(i).getNombre().contains(this.listaInput.get(c))){
                        System.out.println("YES!");
                        objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                    }
                }
            }
        }
    }
     /*Seccion Direccion*/
    public void compararDireccion(Filtrado objFiltrado) {
        String direccion = "";
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
        for(int i = 0; i < objFiltrado.getListaLocales().size(); i++){
            for(int c = 0; c < this.listaInput.size(); c++){
                direccion = objFiltrado.getListaLocales().get(i).getDireccion();
                if(direccion.contains(this.listaInput.get(c))){
                        System.out.println("YES!");
                        objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                    }
                }
            }
        }
    }
    /*Seccion Hora*/
    public void compararHoraInicio(Filtrado objFiltrado) {
        String horaI = "";
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
        for(int i = 0; i < objFiltrado.getListaLocales().size(); i++){
            for(int c = 0; c < this.listaInput.size(); c++){
                horaI = objFiltrado.getListaLocales().get(i).getHoraInicio();
                if(horaI.contains(this.listaInput.get(c))){
                        System.out.println("YES!");
                        objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                    }
                }
            }
        }
    }
    
    public void compararHoraFinal(Filtrado objFiltrado){
        String horaF = "";
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
        for(int i = 0; i < objFiltrado.getListaLocales().size(); i++){
            for(int c = 0; c < this.listaInput.size(); c++){
                horaF = objFiltrado.getListaLocales().get(i).getHoraInicio();
                if(horaF.contains(this.listaInput.get(c))){
                        System.out.println("YES!");
                        objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                    }
                }
            }
        }
    }
    //public void compararInput(Filtrado objFiltrado);
}
