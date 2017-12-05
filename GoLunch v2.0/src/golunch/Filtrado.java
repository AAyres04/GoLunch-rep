/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package golunch;

import godata.*;
import java.util.ArrayList;
import java.io.IOException;

/**
 *Esta clase Filtra los datos para su uso en otras instancias.
 * Los almacena en una coleccion objetos "LocalComida", con el objetivo de hacer
 * más facil el uso de datos dentro del programa.
 * @author Zeiruos
 */
public class Filtrado {
    
    private ArrayList<LocalComida> listaLocales;
    private LeerExcel lecturaExcel;
    private ModExcel modificarExcel;
    
    public Filtrado(){
        this.listaLocales = new ArrayList<>();
        this.lecturaExcel = new LeerExcel();
        //this.modificarExcel = new ModExcel();
    }
    
    /**
     * Obtiene la Lista de los locales de comida.
     * Nota: Esta lista no su utiliza directamente. Para su implementacion en el codigo,
     * se debe utilizar un objeto de esta clase (Filtrado).
     * @return listaLocales (ArrayList). 
     */
    
    public ArrayList<LocalComida> getListaLocales(){
        return this.listaLocales;
    }
    
    /**
     * Asigna la Lista de los locales de comida.
     * @param listaLocales Lista de los locales.
     */
    
    public void setListaLocales(ArrayList listaLocales){
        this.listaLocales = listaLocales;
    }
    
    /*Se asignan los datos de un local comida, utilizando una linea de datos.
    Se debe utilizar junto con el metodo "recepcionDatos"de esta clase (Filtrado).
    El excel no debe ser modificado directamnete para su correcto funcionamiento*/
    
    public LocalComida asignarDatos( String lineData){//parametro prueba
        LocalComida objLocal = new LocalComida();
        String[] splitLineData;
        if (lineData.contains("!") || lineData.isEmpty()){
            return null;
        } else{
            splitLineData = lineData.split(";");
            objLocal.setIdRest(Integer.parseInt(splitLineData[0].replace("#", "")));
            objLocal.setNombre(splitLineData[1]);
            objLocal.setDireccion(splitLineData[2]);
            objLocal.setHora(splitLineData[3]);
            objLocal.setCategorias(splitLineData[4]);
            objLocal.setTelefono(splitLineData[5]);
        }
        return objLocal;
    }
    
    /**
     * Recibe los datos de la lectura de excel y los retorna por linea.
     * Al final, se usa el método split para separar por linea, la cual cada una
     * representa 1 local.
     * @param ruta Contiene la ruta del archivo.
     * @return splitData (String[])
     */
    
    public String[] recepcionDatos(String ruta){
        String data;
        String[] splitData;
        try{
            this.lecturaExcel.readExcel(ruta, "Hoja1");
        }catch(IOException e){
            System.out.println("ERROR-READEXCEL");
            System.exit(0);
        }
        data = this.lecturaExcel.getData();
        splitData = data.split("%");
        return splitData;
    }
    
    /**
     * Se rellena la lista de los locales, utilizando los datos ya filtrados.
     * Este metodo recibe los resultados de la asignacion de datos en un objeto,
     * y si este fue exitoso lo añade a la listaLocales.
     * @param allData Datos almacenados en un array.
     */
    
    public void rellenarLista(String[] allData){
        LocalComida local;
        for(int i = 0; i < allData.length ; i++){
            local = asignarDatos(allData[i]);
            if (local != null){
                this.listaLocales.add(local);
                System.out.println(local);
            }
        }
    }
    
    /**
     * Asigna el valor "false" al boolean "localBuscado" de todos los objetos ubicados en la lista.
     */
    
    public void limpiarListadoLocal(){
        for(int i = 0; i<this.listaLocales.size();i++){
            this.listaLocales.get(i).setNombreBuscado(false);
        }
    }
    
    /**
     * 
     * 
     */
    /*public void agregarLocal(int fila, int columna, String valor, String rutaExcel){
        try{
            for(int i = 0; i < this.listaLocales.size(); i++){
                //this.modificarExcel.modCelda(fila, columna, valor, rutaExcel);
            }
        } catch (IOException e) {
            
        }
    }*/
}
