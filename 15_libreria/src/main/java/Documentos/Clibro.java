/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Documentos;

/**
 *
 * @author juan_
 */


import java.io.*;
import java.util.*;

public class Clibro {
    
    private String nombre;
    private String autor;
    private String editorial;
    private float precio;
    
    
    public Clibro(){
        
    }

    public Clibro(String nombre, String autor, String editorial, float precio) {
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.editorial = editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public void aceptarDatos(){
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre del documento: ");
        nombre = entrada.nextLine();
        System.out.println("Ingresa el nombre del autor: ");
        autor = entrada.nextLine();
        System.out.println("Ingresa la editorial del documento: ");
        editorial = entrada.nextLine();
        System.out.println("Ingresa el precio del documento: ");
        precio = entrada.nextFloat();
        
    }
    
}
