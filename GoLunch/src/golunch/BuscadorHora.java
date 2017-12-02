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
public class BuscadorHora extends Buscador {
    private String hora;
    private String input2;
    private ArrayList<String> listaInput2; 
    public BuscadorHora(String hora){
        super();
        this.hora = hora;
        this.listaInput2 = new ArrayList<>();
    }
    @Override
    protected void splitInput(){
        String[] splitInput = this.input.split(";");
        this.listaInput.addAll(Arrays.asList(splitInput));
    }
    private void splitInput2(){
        String[] splitInput2 = this.input2.split(";");
        this.listaInput2.addAll(Arrays.asList(splitInput2));
    }
    @Override
    public void compararInput(Filtrado objFiltrado) {
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
            System.out.println("Entre");
            if(this.hora.equals("inicio")){
                
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
    private void compararInput1(Filtrado objFiltrado){
        for(int i=0;i<objFiltrado.getListaLocales().size(); i++){
            for(int c=0; c<this.listaInput.size(); c++){
                if(objFiltrado.getListaLocales().get(i).getHoraInicio().contains(this.listaInput.get(c))){
                    System.out.println("YES!");
                    objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                }
            }
        }
    }
    private void compararInput2(Filtrado objFiltrado){
        for(int i=0;i<objFiltrado.getListaLocales().size(); i++){
            for(int c=0; c<this.listaInput2.size(); c++){
                if(objFiltrado.getListaLocales().get(i).getHoraInicio().contains(this.listaInput2.get(c))){
                    System.out.println("YES!");
                    objFiltrado.getListaLocales().get(i).setLocalBuscado(true);
                }
            }
        }
    }
}