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
    private int horaInicio;
    private int horaFinal;
    private boolean localBuscado;
    private int idRest;
    public LocalComida(){
        this.localBuscado = false;
    }
    //TEST
    public LocalComida(String test, int id){
        this.nombre = test;
        this.direccion = "testeo";
        this.horaInicio = 10;
        this.horaFinal = 20;
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
    //Dirección
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    //Hora Inicio
    public int getHoraInicio(){
        return this.horaInicio;
    }
    public void setHoraInicio(int horaInicio){
        this.horaInicio = horaInicio;
    }
    //Hora Final
    public int getHoraFinal(){
        return this.horaFinal;
    }
    public void setHoraFinal(int horaFinal){
        this.horaFinal = horaFinal;
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
