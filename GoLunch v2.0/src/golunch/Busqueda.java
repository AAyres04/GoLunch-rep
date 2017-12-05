/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package golunch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Esta clase permite la busqueda de los parametros de los objetos de LocalComida.
 * A través del input o seleccion de item que el usuario pueda hacer.
 * @author Zeiruos
 */
public class Busqueda {
    
    protected String input;
    protected ArrayList<String> listaInput;
    
    public Busqueda(){
        this.input = "";
        this.listaInput = new ArrayList<>();
    }
    
    /**
     *Obtiene la entrada del usuario
     * @return input (String)
     */
    
    public String getInput(){
        return this.input;
    }
    
    /**
     *Asigna la entrada del usuario para utilizarla en una instancia de esta clase.
     * @param input Entrada del usuario.
     */
    
    public void setInput(String input){
        this.input = input.toLowerCase();
    }
    
    /*Separa el Input en palabras almacenadas en un ArrayList*/
    
    private void splitInput(){
        String[] splitInput = this.input.split(" ");
        this.listaInput.addAll(Arrays.asList(splitInput));
    }
    
    /**
     * Obtiene la lista de las palbras ingresadas por el usuario 
     * @return listaInput (ArrayList)
    */
    
    public ArrayList getListaInput(){
        return this.listaInput;
    }
    
    /**
     * Compara el input con el valor que se indique del local.
     * Se elige un tipo de buscador (definidios en el metodo opcionBusqueda de esta clase.
     * Se utiliza un objeto Filtrado como parametro el cual tendra la lista de datos que se desea comparar.
     * Este metodo modifica el valor "localBuscado" si este encuentra una coincidencia
     * con el parametro solicitado de la lista de datos encontrada en el filtrado.
     * @param tipoBuscador tipo de Buscador (int)
     * <p>Buscador 1 : Nombre</p>
     * <p>Buscador 2 : Direccion</p>
     * <p>Buscador 3 : Hora Inicio</p>
     * <p>Buscador 4 : Hora Cierre</p>
     * <p>Buscador 5 : Categorias</p>
     * @param objFiltrado Objeto de Filtrado, para el uso de la lista (Filtrado).
     */
    
    public void compararInput(int tipoBuscador, Filtrado objFiltrado){
        String valorComparado;
        this.splitInput();
        if(objFiltrado.getListaLocales() != null){
            for(int i = 0; i < objFiltrado.getListaLocales().size(); i++){
                revisionValorVacio(tipoBuscador, i, objFiltrado);
                for(int c = 0; c < this.listaInput.size(); c++){
                    valorComparado = opcionBusqueda(tipoBuscador, i, objFiltrado).toLowerCase();
                    if(valorComparado.contains(this.listaInput.get(c)) && !"".equals(this.listaInput.get(c))){
                        System.out.println("Usando este metodo para asignar true el valor " + valorComparado + " comparandolo con "+this.listaInput.get(c) );
                        checkValorBuscado(tipoBuscador, i, objFiltrado);
                        //placeHolder
                    }
                }
            }
        }
        this.listaInput.clear();
    }
    
    /**
     * Se definen las opciones de busqueda.
     * @param opcion es el entero que determinara el tipo de buscador.
     * <p>Buscador 1 : Nombre</p>
     * <p>Buscador 2 : Direccion</p>
     * <p>Buscador 3 : Hora Inicio</p>
     * <p>Buscador 4 : Hora Cierre</p>
     * <p>Buscador 5 : Categorias</p>
     * @param indexCiclo determinara la posicion del objeto objFiltrado en la lista.
     * @param objFiltrado Se ocupara para recuperar el parametro solicitado de la lista ubicada en el.
     * @return parametro solicitado (String).
     */
    
    private String opcionBusqueda(int opcion, int indexCiclo, Filtrado objFiltrado){
        switch (opcion){
            case 1:
                return objFiltrado.getListaLocales().get(indexCiclo).getNombre();
            case 2:
                return objFiltrado.getListaLocales().get(indexCiclo).getDireccion();
            case 3:
                return objFiltrado.getListaLocales().get(indexCiclo).getHoraInicio();
            case 4:
                return objFiltrado.getListaLocales().get(indexCiclo).getHoraFinal();
            case 5:
                return objFiltrado.getListaLocales().get(indexCiclo).getCategorias();
            default:
                return "";
        }
    }
    
    /**
     * Marca si el valor fue buscado, dependiendo del caso
     * @param opcion es el entero que determinara el tipo de buscador.
     * <p>Buscador 1 : Nombre</p>
     * <p>Buscador 2 : Direccion</p>
     * <p>Buscador 3 : Hora Inicio</p>
     * <p>Buscador 4 : Hora Cierre</p>
     * <p>Buscador 5 : Categorias</p>
     * @param indexCiclo determinara la posicion del objeto objFiltrado en la lista.
     * @param objFiltrado Se ocupara para recuperar el parametro solicitado de la lista ubicada en el.
     */
    
    private void checkValorBuscado (int opcion, int indexCiclo, Filtrado objFiltrado){
        switch (opcion){
            case 1:
                objFiltrado.getListaLocales().get(indexCiclo).setNombreBuscado(true);
                break;
            case 2:
                objFiltrado.getListaLocales().get(indexCiclo).setDireccionBuscada(true);
                break;
            case 3:
                objFiltrado.getListaLocales().get(indexCiclo).setHoraInicioBuscada(true);
                break;
            case 4:
                objFiltrado.getListaLocales().get(indexCiclo).setHoraFinalBuscada(true);
                break;
            case 5:
                objFiltrado.getListaLocales().get(indexCiclo).setCategoriasBuscada(true);
                break; 
        }
    }
    
    /**
     * Este método revisa el input en caso de que este vacio o tenga una linea especial.
     * Se utilizará en caso de que el usuario no ingrese nada en los campos de texto
     * o si eligio la opcion "Todas" en los comboBox.
     *  @param tipoBuscador es el entero que determinara el tipo de buscador.
     * <p>Buscador 1 : Nombre</p>
     * <p>Buscador 2 : Direccion</p>
     * <p>Buscador 3 : Hora Inicio</p>
     * <p>Buscador 4 : Hora Cierre</p>
     * <p>Buscador 5 : Categorias</p>
     * @param indexCiclo determinara la posicion del objeto objFiltrado en la lista.
     * @param objFiltrado Se ocupara para recuperar el parametro solicitado de la lista ubicada en el.
     */
    
    private void revisionValorVacio(int tipoBuscador, int indexCiclo, Filtrado objFiltrado){
        if(this.input.equals("")&& tipoBuscador == 1){
            objFiltrado.getListaLocales().get(indexCiclo).setNombreBuscado(true);
        } else if (this.input.equals("") && tipoBuscador == 2){
            objFiltrado.getListaLocales().get(indexCiclo).setDireccionBuscada(true);
        } else if (this.input.equals("todas") && tipoBuscador == 3){
            objFiltrado.getListaLocales().get(indexCiclo).setHoraInicioBuscada(true);
        } else if (this.input.equals("todas") && tipoBuscador == 4){
            objFiltrado.getListaLocales().get(indexCiclo).setHoraFinalBuscada(true);
        } else if (this.input.equals("todas") && tipoBuscador == 5){
            objFiltrado.getListaLocales().get(indexCiclo).setCategoriasBuscada(true);
        }
    }
}
