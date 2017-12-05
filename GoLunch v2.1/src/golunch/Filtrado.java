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
 * @author AAyres
 */
public class Filtrado {
    
    private ArrayList<LocalComida> listaLocales;
    private LeerExcel lecturaExcel;
    private ModExcel modificarExcel;
    
    public Filtrado(){
        this.listaLocales = new ArrayList<>();
        this.lecturaExcel = new LeerExcel();
        this.modificarExcel = new ModExcel();
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
    
    public LocalComida asignarDatos(String lineData){
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
            objLocal.setTelefono(splitLineData[5].replace(".", ""));
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
     * Agrega un nuevo local al Excel usando el objeto lecturaExcel.
     * @param nuevoLocal recibe el local que se sumará al EXCEL.
     */
    
    public void agregarLocalExcel(LocalComida nuevoLocal){
        String valor ="";
        String rutaExcel="Restaurantes.xlsx";
        try{
            for(int i = 0; i < 6; i++){
                valor = formatoNombre(i, nuevoLocal);
                this.modificarExcel.modificarCelda(this.lecturaExcel.getValorUltimaFila(), i, valor, rutaExcel);
            }
            this.modificarExcel.modificarCelda(this.lecturaExcel.getValorUltimaFila()+1, 0, "END!", rutaExcel);
        } catch (IOException e) {
            
        }
    }
    
    /**
     * Modifica un valor especifico del EXCEL.
     * @param columna columna de la celda a cambiar
     * @param local local que contiene los datos a modificar
     */
    
    public void modificarValorExcel(int columna, LocalComida local){
        String ID = "#" + local.getIdRest();
        
        for (int i = 0; i < this.lecturaExcel.getValorUltimaFila(); i++){
            try{
                this.lecturaExcel.readContenidoCelda(i, 0, "Restaurantes.xlsx");
                if(this.lecturaExcel.getContenidoCelda().equals(ID)){
                    this.modificarExcel.modificarCelda(i, columna, valorSolicitado(columna, local), "Restaurantes.xlsx");
                }
            }catch (IOException e){
                
            }
        }
    }
    
    /**
     * Borra un local del excel. 
     * En su lugar se deja un "!" en la columna de ID, el cual representa una fila que no contiene
     * datos utiles para el programa.
     * @param oldLocal 
     */
    
    public void borrarLocalExcel(LocalComida oldLocal){
        String ID = "#" + oldLocal.getIdRest();
        for (int i = 0; i < this.lecturaExcel.getValorUltimaFila(); i++){
            try{
                this.lecturaExcel.readContenidoCelda(i, 0, "");
                if (this.lecturaExcel.getContenidoCelda().equals(ID)){
                    for (int j = 0; j < 6; j++){
                        if (j!=0){
                            this.modificarExcel.modificarCelda(i, j, "", "");
                        }else{
                            this.modificarExcel.modificarCelda(i, j, "!", "");
                        }
                    }
                }
            } catch (IOException e){
                
            }
        }
    }
    
    /**
     * Método que entrega el valor que "modificarValorExcel" solicite.
     * 
     * @param opcion Entero que representa las opciones a retornar.
     * <p>Opción 1: Nombre del Local</p>
     * <p>Opción 2: Dirección del Local</p>
     * <p>Opción 3: Horas del local</p>
     * <p>Opción 4: Categorias del Local</p>
     * <p>Opcion 5: Telefonos del Local</p>
     * <p>En caso de que reciba un entero diferente, retorna un String de valor ""</p>
     * @param local Local del cual se obtendran los datos para su manejo.
     * @return el valor solicitado por modificarValorExcel
     */
    
    private String valorSolicitado(int opcion, LocalComida local){
        switch (opcion){
            case 1:
                return local.getNombre();
            case 2:
                return local.getDireccion();
            case 3:
                return local.getHora();
            case 4:
                return local.getCategorias();
            case 5:
                return local.getTelefono();
            default:
                return "";
        }
    }
    
    /**
     * Método que entrega el valor (con su formato) que "agregarLocalExcel" solicite.
     * 
     * @param fila Entero que representa el tipo de fila a retornar.
     * <p>Fila 0: ID del local</p>
     * <p>Fila 1: Nombre del Local</p>
     * <p>Fila 2: Dirección del Local</p>
     * <p>Fila 3: Horas del local</p>
     * <p>Fila 4: Categorias del Local</p>
     * <p>Fila 5: Telefonos del Local</p>
     * <p>En caso de que reciba un entero diferente, retorna un String de valor ""</p>
     * @param local Local del cual se obtendran los datos para su manejo.
     * @return El valor solicitado por modificarValorExcel.
     */
    
    private String formatoNombre(int fila, LocalComida local){
        switch (fila){
            case 0:
                return "#" + local.getIdRest();
            case 1:
                return local.getNombre();
            case 2:
                return local.getDireccion();
            case 3:
                return local.getHora();
            case 4:
                return local.getCategorias();
            case 5:
                return local.getTelefono() + ".";
            default:
                return "";
        }
    }
}
