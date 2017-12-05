/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package golunch;

import gowindow.Login;
import java.util.Scanner;
/**
 * Esta clase contiene todo el programa, aqui se encuentran las intancias de las
 * Ventanas y clases implicadas en su funcionamiento.
 * Ventanas: Login
 * Clases: 
 * Buscador
 * Filtrado (Filtrado de datos).
 * @author AAyres
 */
public class MenuGoLunch {
    
    private Filtrado objFiltrado; //objeto de la clase Filtrado que se utiliazara para manejar los datos
    private Busqueda buscador; //buscador
    
    public MenuGoLunch(){
        this.objFiltrado = new Filtrado();
        this.buscador = new Busqueda();
        this.objFiltrado.rellenarLista(this.objFiltrado.recepcionDatos("Restaurantes.xlsx"));

    }
    /**
     * Ejecuta el programa.
     */
    public void ejecutar(){
        Login login = new Login();
    }
    
    /**
     *Este metodo utiliza la clase Buscador para comparar la entrada del
     *usuario con "Nombre".
     * @param input Entrada del usuario.
     */
    
    public void buscarNombre(String input){
        sendInput(input);
        this.buscador.compararInput(1, this.objFiltrado);
    }
    
    /**
     *Este metodo utiliza la clase Buscador para comparar la entrada del
     *usuario con la "Direccion".
     * @param input Entrada del usuario.
     */
    
    public void buscarDir(String input){
        sendInput(input);
        this.buscador.compararInput(2, this.objFiltrado);
    }
    
    /**
     *Este metodo utiliza la clase Buscador para comparar la entrada del
     *usuario con "Hora Inicio".
     * @param input Entrada del usuario.
     */
    
    public void buscarHoraI(String input){
        sendInput(input);
        this.buscador.compararInput(3, this.objFiltrado);
    }
    
    /**
     *Este metodo utiliza la clase Buscador para comparar la entrada del
     *usuario con "Hora Final".
     * @param input Entrada del usuario.
     */
    
    public void buscarHoraF(String input){
        sendInput(input);
        this.buscador.compararInput(4, this.objFiltrado);
    }
    
    /**
     *Este metodo utiliza la clase Buscador para comparar la entrada del
     *usuario con "Categorías".
     * @param input Entrada del usuario.
     */
    
    public void buscarCategorias(String input){
        sendInput(input);
        this.buscador.compararInput(5, this.objFiltrado);
    }
    
    /**
     * Envia el input ingresado a un objeto de la clase Busqueda.
     * @param input Entrada del usuario.
     */
    
    private void sendInput(String input){
        this.buscador.setInput(input);
    }
    
    /**
     * Limpia todos los booleanos de la coleccion de objetos.
     * Se usa para que el buscador no muestre coincidencias repetidas. 
     * @param objFiltrado objeto de Filtrado que contiene la lista de objetos.
     */
    
    public void clearList(Filtrado objFiltrado){
        for (int i = 0; i < objFiltrado.getListaLocales().size(); i++){
            objFiltrado.getListaLocales().get(i).setNombreBuscado(false);
            objFiltrado.getListaLocales().get(i).setDireccionBuscada(false);
            objFiltrado.getListaLocales().get(i).setHoraInicioBuscada(false);
            objFiltrado.getListaLocales().get(i).setHoraFinalBuscada(false);
            objFiltrado.getListaLocales().get(i).setCategoriasBuscada(false);
        }
        
    }
    
    /**
     *Obtiene el objeto de tipo Filtrado. 
     * Su principal uso consiste en obtener su lista para su manejo en las ventanas
     * @return objFiltrado (Filtrado).
     */
    
    public Filtrado getObjFiltrado(){
        return this.objFiltrado;
    }
}
