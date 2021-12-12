/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controles;

/**
 *
 * @author juan_
 */
import Documentos.Clibro;
import java.util.*;
import java.io.*;

class ArchivoL implements Serializable{
    ArrayList<Clibro> listarecuperada = new ArrayList<Clibro>();
    
    public ArrayList<Clibro> leer(){
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("libro.txt"));
            listarecuperada = (ArrayList<Clibro>)in.readObject();
            in.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("Se origino: " + e.getStackTrace());
            
        }
        return listarecuperada;
    }
    
    void serializar(ArrayList<Clibro> listaserializada){
        try{
            FileOutputStream salida = new FileOutputStream("libro.txt");
            ObjectOutputStream salidaobjeto = new ObjectOutputStream(salida);
            salidaobjeto.writeObject(listaserializada);
            salidaobjeto.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            System.out.println("Se origino: " + e.getStackTrace());
        }
    }
}
