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
public abstract class Buscador {
    protected String input;
    protected ArrayList<String> listaInput;
    public Buscador(){
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
    public abstract void compararInput(Filtrado objFiltrado);
}
