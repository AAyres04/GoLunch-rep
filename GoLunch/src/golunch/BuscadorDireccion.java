/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

/**
 *
 * @author Zeiruos
 */
public class BuscadorDireccion extends Buscador {
    public BuscadorDireccion(){
        super();
    }
    @Override
    public void compararInput(Filtrado objFiltrado) {
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
