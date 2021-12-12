/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author juan_
 */
import Controles.ManipularRevistas;
import java.io.*;
import java.util.*;

public class PrincipalR {
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        ManipularRevistas listadelibrosobj = new ManipularRevistas();
        int opcion;
        
        do{
            System.out.println("Bienvenido a la Biblioteca del Multiverso");
            System.out.println("Ingresa la opcion deseada: ");
            System.out.println("1.- Agregar la opcion deseada ");
            System.out.println("2.- Consultar Revista");
            System.out.println("3.- Consultar todas las Revistas");
            System.out.println("4.- Borrar una Revista");
            System.out.println("5.- Modificar los datos de una Revista");
            System.out.println("6.- Salir");
             
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    listadelibrosobj.agregarRevista();
                    
                    break;
                case 2:
                    listadelibrosobj.buscar();
                    break;
                case 3:
                    listadelibrosobj.consultaGeneral();
                    break;
                case 4:
                    listadelibrosobj.borrar();
                    break;
                case 5:
                    listadelibrosobj.modificar();
                    break;
                case 6:
                    System.out.println("Ingresa la opcion deseada: ");
                    listadelibrosobj.grabar();
                    
                default:
                    System.out.println("Error ingrese una opcion valida");
                    
            }
            
        }while((opcion >= 1)&&(opcion < 6));
    }
}