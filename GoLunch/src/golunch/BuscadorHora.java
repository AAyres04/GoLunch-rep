/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.util.Arrays;

/**
 *
 * @author Zeiruos
 */
public class BuscadorHora extends Buscador {
    private String  hora;
    public BuscadorHora(String hora){
        super();
        this.hora = hora;
    }
    @Override
    protected void splitInput(){
        String[] splitInput = this.input.split(":");
        this.listaInput.addAll(Arrays.asList(splitInput));
    }
    @Override
    public void compararInput(Filtrado objFiltrado) {
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
            System.out.println("Entre");
            if(this.hora.equals("inicio")){
                for(int i=0;i<objFiltrado.getListaLocales().size(); i++){
                    for(int c=0; c<this.listaInput.size(); c++){
                        if(objFiltrado.getListaLocales().get(i).getHoraInicio().contains(this.listaInput.get(c))){
                            System.out.println("YES!");
                            objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                        }
                    }
                }
            }else if(this.hora.equals("final")){
                System.out.println("Entre");
                for(int i=0;i<objFiltrado.getListaLocales().size(); i++){
                    for(int c=0; c<this.listaInput.size(); c++){
                        if(objFiltrado.getListaLocales().get(i).getHoraFinal().contains(this.listaInput.get(c))){
                            System.out.println("YES!");
                            objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                        }
                    }
                }
            }
        }
    }
}