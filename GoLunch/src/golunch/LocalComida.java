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
public class LocalComida {
    private String nombre;
    private String direccion;
    private String telefono;
    private String hora;
    private String horaInicio;
    private String horaFinal;
    private String categorias;
    private boolean localBuscado;
    private int idRest;
    public LocalComida(int id){
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.horaInicio = "";
        this.horaFinal = "";
        this.categorias ="";
        this.localBuscado = false;
        this.idRest = id;
    }
    //Nombre
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //Telefono
    public String getTelefono(){
        return this.telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono ;
    }
    //Dirección
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    //Hora
    public void setHora(String hora){
        this.hora = hora;
        formatHora();
    }
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
    //Hora Inicio
    public String getHoraInicio(){
        return this.horaInicio;
    }
    public void setHoraInicio(String horainicio){
        this.horaInicio = horainicio;
    }
    //Hora Final
    public String getHoraFinal(){
        return this.horaFinal;
    }
        public void setHoraFinal(String horafinal){
        this.horaFinal = horafinal;
    }
   
    //Check local buscado
    public boolean getLocalBuscado(){
        return this.localBuscado;
    }
    public void setLocalBuscado(boolean localBuscado){
        this.localBuscado = localBuscado;
    }
    //ID
    public int getIdRest(){
        return this.idRest;
    }
    public void setIdRest(int idRest){
        this.idRest = idRest;
    }
    //Categorias
    public String getCategorias(){
        return this.categorias;
    }
    public void setCategorias(String categorias){
        this.categorias = categorias;
    }
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + "\n"
                +"Dirección: " + this.direccion+ "\n"
                +"Hora Inicio: " + this.horaInicio+ "\n"
                +"Hora Final: " + this.horaFinal+ "\n"
                +"buscado? " + this.localBuscado + "\n"
                +"ID REST: " + this.idRest;
    }
}
