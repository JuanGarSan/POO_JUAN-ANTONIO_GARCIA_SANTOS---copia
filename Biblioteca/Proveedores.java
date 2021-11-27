import java.util.*;
import javax.swing.*;
import java.lang.Math;
import java.text.StringCharacterIterator;

public class Proveedores(){

    private String nombre_cliente;
    private String producto[] = new String[10];
    private int costo[] = new int[10];
    private int producto_existente[] = new int[10];


    public Proveedores(){
        //esto es un constructor
        /*
        Podemos inicializar las variables
        Podemos aplicar la sobrecarga        
        */ 
    }

    public Proveedores(String nombre_cliente, String producto, String costo, int producto_existente {
       
        this.nombre_cliente = nombre_cliente;
        this.producto = producto;
        this.costo = costo;
        this.producto_existente = producto_existente;
        
    }


    public void MenuProveedores(){


        String text;
        //try catch para el manejo de errores
        // un ciclo do while para repetir las opciones
        text = JOptionPane.showInputDialog("Seleccione la funcion deseada: "
                                            + "\n 1.- Suma total de costos"
                                            + "\n 2.- Costo Mayor"
                                            + "\n 3.- Costo Menor"
                                            + "\n 4.- Costo Promedio"
                                            + "\n 5.- Costo Total del Producto");
                                            
        int opcion;

        switch (opcion) {
            case 1:
                SumaTotal();
                System.out.println("Suma total");
                    System.out.println("Ingresar el primer precio");
                    a = entrada.nextInt();
                    System.out.println("Ingresa el segundo precio");
                    b = entrada.nextInt();
                    System.out.println("Ingresa el tipo de operacion que deseas realizar : (+)");
                    operacion = entrada.next().charAt(0);

                    switch(operacion){

                        case '+' :
                            resultado = a+b;
                            System.out.println("La suma es de: " + resultado);
                            break;
                    }                        
                break;
            case 2:
                CostoMayor();

                break;
            case 3:
                CostoMenor();
                break;
            case 4:
                CostoPromedio();
                break;
                CostoTotal();
            case 5:
                
                break;
        
            default:
                
                break;
        }
    }
 
}