/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectocaseta;

import javax.swing.JOptionPane;

/**
 *
 * @author juan_
 */
public class Caseta {
String tipo, ingreso;
int tipo1, cambio, cobro;
   
    public void SeleccionTipo() {

        tipo = JOptionPane.showInputDialog("Seleciona Tipo \n 1:Auto \n 2:Moto \n 3:Truck");

        tipo1 = Integer.parseInt(tipo);
        switch (tipo1) {
            case 1:
                cobro = 50;
                break;
            case 2:
                cobro = 25;
                break;
            case 3:
                cobro = 75;
                break;
            default:
                System.out.println("opcion invalida");

        }

    }

    public void CalcularCambio() {
        ingreso = JOptionPane.showInputDialog("¿Cuanto Ingreso?");
        cambio = Integer.parseInt(ingreso);
        int cambio1 = cambio - cobro;
        System.out.println("El cambio es de: " + cambio1);
    }

    public void imprimirTicket() {
        System.out.println("Caseta Acolman");
        System.out.println("Tipo auto: " + tipo);
        System.out.println("Cantidad de ingreso: " + cobro);

    }

}
