/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Documentos;

/**
 *
 * @author juan_
 */
import java.util.*;
public class Periodico extends Clibro{
    
    private Date fecha = new Date();
    private String fecha2;
    
    public Periodico(){
        
    }
    public Periodico(String nombre, String autor, String editorial, float precio){
        super(nombre, autor, editorial, precio);
        this.fecha2 = fecha2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }
    
    
    
    public void agregarPeriodico(){
        
        Clibro datoslibro = new Clibro();
        
        Scanner entrada = new Scanner(System.in);
        datoslibro.aceptarDatos();
        fecha2 = entrada.nextLine();
        System.out.println("Ingresa la fecha de publicacion");
        System.out.println("Año :" + fecha.getYear());
        System.out.println("Mes:"  + fecha.getMonth());
        System.out.println("Dia :" + fecha.getDay());
    }
    
}
