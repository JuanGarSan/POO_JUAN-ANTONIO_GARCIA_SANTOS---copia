/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

/**
 *
 * @author juan_
 */

import Documentos.Clibro;
import java.util.*;
import java.io.*;

public class ManipularLibros implements Serializable{
    
   
    
    private ArrayList<Clibro> listadelibros;
   
    
    private ArchivoL objetoarchivolibros = new ArchivoL();
   
    
    public ManipularLibros(){
       
        listadelibros = new ArrayList<Clibro>();
        listadelibros = objetoarchivolibros.leer();
    }
    
    //crud
    public void agregarLibro(){
        Scanner entrada = new Scanner(System.in);
        char resp = 's';
       
        while(resp == 's'){
            
            Clibro objlibro = new Clibro();
            objlibro.aceptarDatos();
           
            listadelibros.add(objlibro);
            System.out.println("¿Deseas agregar otro libro?");
            resp = entrada.next().charAt(0);
        }
    }
    
    
    
    public void consultaGeneral(){
        
        
        if(listadelibros.isEmpty()){
            System.out.println("No hay libros agregados");
        }else{
            
            System.out.println("Los libros son:");
            
            for(int i = 0; i < listadelibros.size(); i++){
                //System.out.println("El ID del Libro" + listadelibros.get(i));
                System.out.println("Nombre del Libro: " + listadelibros.get(i).getNombre()+"\n");
                System.out.println("Autor del Libro: " + listadelibros.get(i).getAutor()+"\n");
                System.out.println("Editorial del Libro: " + listadelibros.get(i).getEditorial()+"\n");
                System.out.println("Precio del Libro: " + listadelibros.get(i).getPrecio()+"\n");
            }
        }
    }
    
    
    private int traePosicion (String buscarNombre){
        int pos = 0;
        boolean existe = false;

        for(int i = 0; i < listadelibros.size(); i++){
           
            if(buscarNombre.equalsIgnoreCase(listadelibros.get(i).getNombre())){
                
                pos = i;
                existe = true;
            }else{
                System.out.println("Libro no encontrado. Favor de ponerse en contacto con el admin");
            }
        }
        
        if(!existe){
            
            System.out.println("No existe registro del Libro");
            pos = -1;
        }
        return pos;
    }
    
    
  
    public int buscar(){
        int posbuscar = 0;
        String nombreBuscar;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre del libro que desea buscar");
        nombreBuscar = entrada.nextLine();
        
        posbuscar = traePosicion(nombreBuscar);
        
        //visualizo los datos
        
        System.out.println("Nombre del Libro: " + listadelibros.get(posbuscar).getNombre());
        System.out.println("Autor del Libro: " + listadelibros.get(posbuscar).getAutor());
        System.out.println("Editorial del Libro: " + listadelibros.get(posbuscar).getEditorial());
        System.out.println("Precio del Libro: " + listadelibros.get(posbuscar).getPrecio());
        
        return posbuscar;
    }
    
    
    public void borrar(){
        
        Scanner entrada = new Scanner(System.in);
        
        String libroborrar;
        int posborrar;
        
        //verificar que lista de libros no este vacia
        
        if(listadelibros.isEmpty()){
            System.out.println("No hay libros registrados");
        }else{
            System.out.println("Ingresa el ID del libro que vas a eliminar: ");
            posborrar = buscar();
            
            if(posborrar < listadelibros.size()){
                //si esta dentro de la lista
                listadelibros.remove(posborrar);
                System.out.println("Libro eliminado");
            }else{
                //esta afuera del rango
                System.out.println("Imposible elminar ese registro");
            }
        }
        
        
    }
    
    //modificar
    // autor, editorial, precio
    
    public void modificar(){
        int posmodificar = 0;
        int resmod = 0;
        String modificar;
        String opcion = "s";
        
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre del libro que deseas modificar: ");
        modificar = entrada.nextLine();
        
        
        while("s".equalsIgnoreCase(opcion)){
            posmodificar = traePosicion(modificar);
            
            //ya se obtuvieron los datos
            System.out.println("¿Que dato deseas modificar del libro?"
                    + "\n 1.- Autor. "
                    + "\n 2.- Editorial"
                    + "\n 3.- Precio"
                    + "\n");
            
            resmod = entrada.nextInt();
            
            switch (resmod) {
                case 1:
                    //autor
                    System.out.println("El autor es: ");
                    System.out.println("Autor: " + listadelibros.get(posmodificar).getAutor());
                    System.out.println("Ingresa el nuevo actor");
                    listadelibros.get(posmodificar).setAutor(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Autor: " + listadelibros.get(posmodificar).getAutor());
                    
                    break;
                    
                case 2:
                    //editorial
                    System.out.println("La editorial es: ");
                    System.out.println("Editorial: " + listadelibros.get(posmodificar).getEditorial());
                    System.out.println("Ingresa la nueva editorial");
                    listadelibros.get(posmodificar).setEditorial(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Editorial: " + listadelibros.get(posmodificar).getEditorial());
                    
                    break;
                
                case 3: 
                    //precio
                    System.out.println("El precio es: ");
                    System.out.println("Precio: " + listadelibros.get(posmodificar).getPrecio());
                    System.out.println("Ingresa la nueva editorial");
                    listadelibros.get(posmodificar).setPrecio(entrada.nextFloat());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Precio: " + listadelibros.get(posmodificar).getPrecio());
                    
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("¿Quieres cambiar algun otro dato s/n?");
            opcion = entrada.nextLine();
        }
    }
    
   
    
    public void grabar(){
        
        getObjetoarchivolibros().serializar(listadelibros);
    }

    public ArrayList<Clibro> getListadelibros() {
        return listadelibros;
    }

    public void setListadelibros(ArrayList<Clibro> listadelibros) {
        this.listadelibros = listadelibros;
    }

    public ArchivoL getObjetoarchivolibros() {
        return objetoarchivolibros;
    }

    public void setObjetoarchivolibros(ArchivoL objetoarchivolibros) {
        this.objetoarchivolibros = objetoarchivolibros;
    }
    
    
}  