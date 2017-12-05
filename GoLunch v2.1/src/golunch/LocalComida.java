/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package golunch;

/**
 *Esta Clase establece una plantilla para todos los locales existentes en el excel.
 * Su instancia sera utilizada para:
 * Poder buscar alguno de los parámetros que el usuario este interesado en comnocer.
 * Mostrar sus elementos en una ventana
 * Modificar/Agregar o elimar estos datos si se tienen los permisos adecuados.
 * @author AAyres
 */
public class LocalComida {
    
    private String nombre;
    private String direccion;
    private String telefono;
    private String hora;
    private String horaInicio;
    private String horaFinal;
    private String categorias;
    private boolean nombreBuscado;
    private boolean direccionBuscada;
    private boolean horaInicioBuscada;
    private boolean horaFinalBuscada;
    private boolean categoriasBuscadas;
    private int idRest;
    
    public LocalComida(){
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.horaInicio = "";
        this.horaFinal = "";
        this.categorias = "";
        this.nombreBuscado = false;
        this.direccionBuscada = false;
        this.horaInicioBuscada = false;
        this.horaFinalBuscada = false;
        this.categoriasBuscadas = false;
        this.idRest = 0;
    }
    
    /**
     *Obtiene el Nombre del Local.
     * @return nombre (String)
     */
    
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     *Asigna un nuevo Nombre del Local.
     * @param nombre Nombre del Local.
     */
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     *Obtiene el Telefono del Local.
     * @return telefono (String)
     */
    
    public String getTelefono(){
        return this.telefono;
    }
    
    /**
     *Asigna un nuevo Teléfono del Local.
     * @param telefono Teléfono del Local.
     */
    
    public void setTelefono(String telefono){
        this.telefono = telefono ;
    }
    
    /**
     *Obtiene la Dirección del Local.
     * @return direccion (String)
     */
    
    public String getDireccion(){
        return this.direccion;
    }
    
    /**
     *Asigna una nueva Dirección
     * @param direccion Dirección del Local (String) .
     */
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    /**
     * Obtiene la linea de "Hora" (sin formateo).
     * @return 
     */
    
    public String getHora() {
        return this.hora;
    }
    
    /**
     *Asigna una nueva linea de Hora (sin formateo).
     * @param hora linea de Hora (String).
     */
    
    
    public void setHora(String hora){
        this.hora = hora;
        formatHora();
    }
    /**
     * Formatea la hora para su uso pesterior en el manejo de informacion a la hora de buscarla o mostrarla.
     */
    private void formatHora(){
        String[] splitHora;
        String[] splitSeccion = this.hora.split(",");
        for (int i = 0; i < splitSeccion.length; i++){
            splitHora = splitSeccion[i].split("-");
            this.horaInicio += splitHora[0] + ";";
            this.horaFinal += splitHora[1] + ";";  
        }
        this.horaFinal = this.horaFinal.replace(".", "");
    }
    
    /**
     *Obtiene la(s) hora(s) de inicio del Local.
     * @return horaInicio (String)
     */
    
    public String getHoraInicio(){
        return this.horaInicio;
    }
    
    /**
     *Asigna la(s) hora(s) de inicio del Local.
     * @param horaInicio hora(s) de inicio del Local.
     */
    
    public void setHoraInicio(String horaInicio){
        this.horaInicio = horaInicio;
    }
    
    /**
     *Obtiene la(s) hora(s) de cierre del Local.
     * @return horaFinal (String)
     */
    
    public String getHoraFinal(){
        return this.horaFinal;
    }
    
    /**
     *Asigna la(s) hora(s) de cierre del Local.
     * @param horafinal hora(s) de cierre del Local.
     */
    
    
    public void setHoraFinal(String horafinal){
        this.horaFinal = horafinal;
    }
   
    /**
     *Obtiene el valor de "nombreBuscado".
     * @return nombreBuscado (boolean)
     */
    
    public boolean getNombreBuscado(){
        return this.nombreBuscado;
    }
    
    /**Marca si el local tiene un parametro (nombre) que coincide con la entrada del usuario.
     * Este metodo se utiliza en caso de utilizar coincidencias de la clase Busqueda.
     * @param nombreBuscado Nombre del local buscado.
     */
    
    public void setNombreBuscado(boolean nombreBuscado){
        this.nombreBuscado = nombreBuscado;
    }
    
    /**
     *Obtiene el valor de "direccionBuscada".
     * @return direccionBuscada (boolean)
     */
    
    public boolean getDireccionBuscada(){
        return this.direccionBuscada;
    }
    
    /**Marca si el local tiene un parametro (direccion) que coincide con la entrada del usuario.
     * Este metodo se utiliza en caso de utilizar coincidencias de la clase Busqueda.
     * @param direccionBuscada Direccion del local buscado.
     */
    
    public void setDireccionBuscada(boolean direccionBuscada){
        this.direccionBuscada = direccionBuscada;
    }
    
    /**
     * Obtiene el valor de "horaInicialBuscada".
     * @return horaInicioBuscada (boolean).
     */
    
    public boolean getHoraInicioBuscada(){
        return this.horaInicioBuscada;
    }
    
     /**Marca si el local tiene un parametro (horaInicioBuscada) que coincide con la entrada del usuario.
     * Este metodo se utiliza en caso de utilizar coincidencias de la clase Busqueda.
     * @param horaInicioBuscada Hora de inicio del local buscado.
     */
    
    public void setHoraInicioBuscada(boolean horaInicioBuscada){
        this.horaInicioBuscada = horaInicioBuscada;
    }
    
    /**
     * Obtiene el valor de "horaFinalBuscada".
     * @return horaInicioBuscada (boolean).
     */
    
    public boolean getHoraFinalBuscada(){
        return this.horaFinalBuscada;
    }
    
    /**Marca si el local tiene un parametro (horaFinalBuscada) que coincide con la entrada del usuario.
     * Este metodo se utiliza en caso de utilizar coincidencias de la clase Busqueda.
     * @param horaFinalBuscada Hora de inicio del local buscado (boolean).
     */
    
    public void setHoraFinalBuscada(boolean horaFinalBuscada){
        this.horaFinalBuscada = horaFinalBuscada;
    }
    
    /**
     *Obtiene el ID de un Local.
     * @return horaFinal (String)
     */
    
    public int getIdRest(){
        return this.idRest;
    }
    
    /**
     *Asigna el ID de un Local.
     * @param idRest
     */
    
    public void setIdRest(int idRest){
        this.idRest = idRest;
    }
    
    /**
     *Obtiene la(s) Categoría(s) de un Local
     * @return categorias (String)
     */
    
    public String getCategorias(){
        return this.categorias;
    }
    
    /**
     *Asigna la(s) Categoría(s) de un Local
     * @param categorias Categoría(s) de un Local (String)
     */
    
    public void setCategorias(String categorias){
        this.categorias = categorias;
    }
    
    /**
     * Obtiene el valor de "categoriasBuscadas".
     * @return categoríasBuscadas (boolean).
     */
    
    public boolean getCategoriasBuscada(){
        return this.categoriasBuscadas;
    }
    
    /**Marca si el local tiene un parametro (categoriasBuscadas) que coincide con la entrada del usuario.
     * Este metodo se utiliza en caso de utilizar coincidencias de la clase Busqueda.
     * @param categoriasBuscadas categiras del local buscado (boolean).
     */
    
    public void setCategoriasBuscada(boolean categoriasBuscadas) {
        this.categoriasBuscadas = categoriasBuscadas;
    }

    

    
}
