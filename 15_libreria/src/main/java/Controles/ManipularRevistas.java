/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

/**
 *
 * @author juan_
 */
import Documentos.Revista;
import java.util.*;
import java.io.*;
public class ManipularRevistas implements Serializable{
    
   
    
    private ArrayList<Revista> listadeRevistas;
   
    
    private ArchivoR objetoarchivorevista = new ArchivoR();
   
    
    public ManipularRevistas(){
       
        listadeRevistas = new ArrayList<Revista>();
        listadeRevistas = objetoarchivorevista.leer();
    }
    
    //crud
    public void agregarRevita(){
        Scanner entrada = new Scanner(System.in);
        char resp = 's';
       
        while(resp == 's'){
            
            Revista objrevista = new Revista();
            objrevista.aceptarDatos();
           
            listadeRevistas.add(objrevista);
            System.out.println("¿Deseas agregar otra revista?");
            resp = entrada.next().charAt(0);
        }
    }
    
    
    
    public void consultaGeneral(){
        
        
        if(listadeRevistas.isEmpty()){
            System.out.println("No hay Revustas nuevas");
        }else{
            
            System.out.println("Las revistas son:");
            
            for(int i = 0; i < listadeRevistas.size(); i++){
                //System.out.println("El ID del Libro" + listadelibros.get(i));
                System.out.println("Nombre de la revista: " + listadeRevistas.get(i).getNombre()+"\n");
                System.out.println("Autor de la revista " + listadeRevistas.get(i).getAutor()+"\n");
                System.out.println("Editorial de la revista: " + listadeRevistas.get(i).getEditorial()+"\n");
                System.out.println("Precio de la revista: " + listadeRevistas.get(i).getPrecio()+"\n");
            }
        }
    }
    
    
    private int traePosicion (String buscarNombre){
        int pos = 0;
        boolean existe = false;

        for(int i = 0; i < listadeRevistas.size(); i++){
           
            if(buscarNombre.equalsIgnoreCase(listadeRevistas.get(i).getNombre())){
                
                pos = i;
                existe = true;
            }else{
                System.out.println("Revista no encontrado. Favor de ponerse en contacto con el admin");
            }
        }
        
        if(!existe){
            
            System.out.println("No existe registro de ña revista");
            pos = -1;
        }
        return pos;
    }
    
    
  
    public int buscar(){
        int posbuscar = 0;
        String nombreBuscar;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre de la revista que desea buscar");
        nombreBuscar = entrada.nextLine();
        
        posbuscar = traePosicion(nombreBuscar);
        
        //visualizo los datos
        
        System.out.println("Nombre de la revista: " + listadeRevistas.get(posbuscar).getNombre());
        System.out.println("Autor de la revista: " + listadeRevistas.get(posbuscar).getAutor());
        System.out.println("Editorial de la revista: " + listadeRevistas.get(posbuscar).getEditorial());
        System.out.println("Precio de la revista: " + listadeRevistas.get(posbuscar).getPrecio());
        
        return posbuscar;
    }
    
    
    public void borrar(){
        
        Scanner entrada = new Scanner(System.in);
        
        String revistaborrar;
        int posborrar;
        
        //verificar que lista de libros no este vacia
        
        if(listadeRevistas.isEmpty()){
            System.out.println("No hay Revistas registradas");
        }else{
            System.out.println("Ingresa el ID de la revista que vas a eliminar: ");
            posborrar = buscar();
            
            if(posborrar < listadeRevistas.size()){
                //si esta dentro de la lista
                listadeRevistas.remove(posborrar);
                System.out.println("Revista eliminada");
            }else{
                //esta afuera del rango
                System.out.println("Imposible elminar este registro");
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
        
        System.out.println("Ingresa el nombre de la revista que deseas modificar: ");
        modificar = entrada.nextLine();
        
        
        while("s".equalsIgnoreCase(opcion)){
            posmodificar = traePosicion(modificar);
            
            //ya se obtuvieron los datos
            System.out.println("¿Que dato deseas modificar de la revista?"
                    + "\n 1.- Autor. "
                    + "\n 2.- Editorial"
                    + "\n 3.- Precio"
                    + "\n");
            
            resmod = entrada.nextInt();
            
            switch (resmod) {
                case 1:
                    //autor
                    System.out.println("El autor es: ");
                    System.out.println("Autor: " + listadeRevistas.get(posmodificar).getAutor());
                    System.out.println("Ingresa el nuevo actor");
                    listadeRevistas.get(posmodificar).setAutor(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Autor: " + listadeRevistas.get(posmodificar).getAutor());
                    
                    break;
                    
                case 2:
                    //editorial
                    System.out.println("La editorial es: ");
                    System.out.println("Editorial: " + listadeRevistas.get(posmodificar).getEditorial());
                    System.out.println("Ingresa la nueva editorial");
                    listadeRevistas.get(posmodificar).setEditorial(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Editorial: " + listadeRevistas.get(posmodificar).getEditorial());
                    
                    break;
                
                case 3: 
                    //precio
                    System.out.println("El precio es: ");
                    System.out.println("Precio: " + listadeRevistas.get(posmodificar).getPrecio());
                    System.out.println("Ingresa la nueva editorial");
                    listadeRevistas.get(posmodificar).setPrecio(entrada.nextFloat());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Precio: " + listadeRevistas.get(posmodificar).getPrecio());
                    
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("¿Quieres cambiar algun otro dato s/n?");
            opcion = entrada.nextLine();
        }
    }
    
   
    
    public void grabar(){
        
        getObjetoarchivorevista().serializar(listadeRevistas);
    }

    public ArrayList<Revista> getlistadeRevistas() {
        return listadeRevistas;
    }

    public void setlistadeRevistas(ArrayList<Revista> listadeRevistas) {
        this.listadeRevistas = listadeRevistas;
    }

    public ArchivoR getObjetoarchivorevista() {
        return objetoarchivorevista;
    }

    public void setObjetoarchivorevista(ArchivoR objetoarchivorevista) {
        this.objetoarchivorevista = objetoarchivorevista;
    }

    public void agregarRevista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}  
