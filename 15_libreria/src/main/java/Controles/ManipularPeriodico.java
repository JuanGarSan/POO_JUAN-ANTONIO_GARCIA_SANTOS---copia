/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

/**
 *
 * @author juan_
 */
import Documentos.Periodico;
import java.util.*;
import java.io.*;
public class ManipularPeriodico implements Serializable{
    
   
    
    private ArrayList<Periodico> listadePeriodicos;
   
    
    private ArchivoP objetoarchivoperiodico = new ArchivoP();
   
    
    public ManipularPeriodico(){
       
        listadePeriodicos = new ArrayList<Periodico>();
        listadePeriodicos = objetoarchivoperiodico.leer();
    }
    
    //crud
    public void agregarPeriodico(){
        Scanner entrada = new Scanner(System.in);
        char resp = 's';
       
        while(resp == 's'){
            
            Periodico objperiodico = new Periodico();
            objperiodico.aceptarDatos();
           
            listadePeriodicos.add(objperiodico);
            System.out.println("¿Deseas agregar otra revista?");
            resp = entrada.next().charAt(0);
        }
    }
    
    
    
    public void consultaGeneral(){
        
        
        if(listadePeriodicos.isEmpty()){
            System.out.println("No hay Revustas nuevas");
        }else{
            
            System.out.println("Las revistas son:");
            
            for(int i = 0; i < listadePeriodicos.size(); i++){
                //System.out.println("El ID del Libro" + listadelibros.get(i));
                System.out.println("Nombre de la revista: " + listadePeriodicos.get(i).getNombre()+"\n");
                System.out.println("Autor de la revista " + listadePeriodicos.get(i).getAutor()+"\n");
                System.out.println("Editorial de la revista: " + listadePeriodicos.get(i).getEditorial()+"\n");
                System.out.println("Precio de la revista: " + listadePeriodicos.get(i).getPrecio()+"\n");
            }
        }
    }
    
    
    private int traePosicion (String buscarNombre){
        int pos = 0;
        boolean existe = false;

        for(int i = 0; i < listadePeriodicos.size(); i++){
           
            if(buscarNombre.equalsIgnoreCase(listadePeriodicos.get(i).getNombre())){
                
                pos = i;
                existe = true;
            }else{
                System.out.println("Revista no encontrado. Favor de ponerse en contacto con el admin");
            }
        }
        
        if(!existe){
            
            System.out.println("No existe registro del periodico");
            pos = -1;
        }
        return pos;
    }
    
    
  
    public int buscar(){
        int posbuscar = 0;
        String nombreBuscar;
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa el nombre de la periodico que desea buscar");
        nombreBuscar = entrada.nextLine();
        
        posbuscar = traePosicion(nombreBuscar);
        
        //visualizo los datos
        
        System.out.println("Nombre del periodico: " + listadePeriodicos.get(posbuscar).getNombre());
        System.out.println("Autor del periodicoa: " + listadePeriodicos.get(posbuscar).getAutor());
        System.out.println("Editorial del periodico: " + listadePeriodicos.get(posbuscar).getEditorial());
        System.out.println("Precio del periodico: " + listadePeriodicos.get(posbuscar).getPrecio());
        
        return posbuscar;
    }
    
    
    public void borrar(){
        
        Scanner entrada = new Scanner(System.in);
        
        String revistaborrar;
        int posborrar;
        
        //verificar que lista de libros no este vacia
        
        if(listadePeriodicos.isEmpty()){
            System.out.println("No hay periodicos registrados");
        }else{
            System.out.println("Ingresa el ID del periodico que vas a eliminar: ");
            posborrar = buscar();
            
            if(posborrar < listadePeriodicos.size()){
                //si esta dentro de la lista
                listadePeriodicos.remove(posborrar);
                System.out.println("Periodicoeliminada");
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
        
        System.out.println("Ingresa el nombre del periodico que deseas modificar: ");
        modificar = entrada.nextLine();
        
        
        while("s".equalsIgnoreCase(opcion)){
            posmodificar = traePosicion(modificar);
            
            //ya se obtuvieron los datos
            System.out.println("¿Que dato deseas modificar del periodico?"
                    + "\n 1.- Autor. "
                    + "\n 2.- Editorial"
                    + "\n 3.- Precio"
                    + "\n");
            
            resmod = entrada.nextInt();
            
            switch (resmod) {
                case 1:
                    //autor
                    System.out.println("El autor es: ");
                    System.out.println("Autor: " + listadePeriodicos.get(posmodificar).getAutor());
                    System.out.println("Ingresa el nuevo actor");
                    listadePeriodicos.get(posmodificar).setAutor(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Autor: " + listadePeriodicos.get(posmodificar).getAutor());
                    
                    break;
                    
                case 2:
                    //editorial
                    System.out.println("La editorial es: ");
                    System.out.println("Editorial: " + listadePeriodicos.get(posmodificar).getEditorial());
                    System.out.println("Ingresa la nueva editorial");
                    listadePeriodicos.get(posmodificar).setEditorial(entrada.next());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Editorial: " + listadePeriodicos.get(posmodificar).getEditorial());
                    
                    break;
                
                case 3: 
                    //precio
                    System.out.println("El precio es: ");
                    System.out.println("Precio: " + listadePeriodicos.get(posmodificar).getPrecio());
                    System.out.println("Ingresa la nueva editorial");
                    listadePeriodicos.get(posmodificar).setPrecio(entrada.nextFloat());
                    System.out.println("El dato a sido modificado");
                    System.out.println("Precio: " + listadePeriodicos.get(posmodificar).getPrecio());
                    
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("¿Quieres cambiar algun otro dato s/n?");
            opcion = entrada.nextLine();
        }
    }
    
   
    
    public void grabar(){
        
        getObjetoarchivoperiodico().serializar(listadePeriodicos);
    }

    public ArrayList<Periodico> getlistadePeriodicos() {
        return listadePeriodicos;
    }

    public void setlistadePeriodicos(ArrayList<Periodico> listadePeriodicos) {
        this.listadePeriodicos = listadePeriodicos;
    }

    public ArchivoP getObjetoarchivoperiodico() {
        return objetoarchivoperiodico;
    }

    public void setObjetoarchivoperiodico(ArchivoP objetoarchivoperiodico) {
        this.objetoarchivoperiodico = objetoarchivoperiodico;
    }
    
    
}  
