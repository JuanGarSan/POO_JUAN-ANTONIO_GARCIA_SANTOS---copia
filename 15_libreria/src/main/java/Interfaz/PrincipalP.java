/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

/**
 *
 * @author juan_
 */
import Controles.ManipularPeriodico;
import java.io.*;
import java.util.*;

public class PrincipalP {
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        ManipularPeriodico listadePeriodicosobj = new ManipularPeriodico();
        int opcion;
        
        do{
            System.out.println("Bienvenido a la Biblioteca del Multiverso");
            System.out.println("Ingresa la opcion deseada: ");
            System.out.println("1.- Agregar la opcion deseada ");
            System.out.println("2.- Consultar Periodico");
            System.out.println("3.- Consultar todos los Periodicos");
            System.out.println("4.- Borrar un libro");
            System.out.println("5.- Modificar los datos de un Periodico");
            System.out.println("6.- Salir");
             
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    listadePeriodicosobj.agregarPeriodico();
                    
                    break;
                case 2:
                    listadePeriodicosobj.buscar();
                    break;
                case 3:
                    listadePeriodicosobj.consultaGeneral();
                    break;
                case 4:
                    listadePeriodicosobj.borrar();
                    break;
                case 5:
                    listadePeriodicosobj.modificar();
                    break;
                case 6:
                    System.out.println("Ingresa la opcion deseada: ");
                    listadePeriodicosobj.grabar();
                    
                default:
                    System.out.println("Error ingrese una opcion valida");
                    
            }
            
        }while((opcion >= 1)&&(opcion < 6));
    }
}