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
public class BuscadorNombre extends Buscador {
    public BuscadorNombre(){
        super();
    }
    /*
    *Metodos:
    getInput
    setInput
    splitinput
    getlistainput
    */
    @Override
    public void compararInput(Filtrado objFiltrado) {
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
}
