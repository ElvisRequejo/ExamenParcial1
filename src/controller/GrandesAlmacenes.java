package controller;

import model.Almacen;
import model.Cliente;
import model.Puerta;

public class GrandesAlmacenes {
    public static void main(String[] args) throws InterruptedException {
            final int NUM_CLIENTES  = 300;
            /*Primero definimos como variables finales el numero de cliente
              y el numero total de productos que va haber en un almacen
             */
            final int NUM_PRODUCTOS = 100;
         
            /*Se crean un array de la clase clientes que seran los distitnos clientes
              que habran*/
            Cliente[]   cliente =   new Cliente[NUM_CLIENTES];
            Almacen     almacen =   new Almacen(NUM_PRODUCTOS);
            Puerta      puerta  =   new Puerta();

            Thread[]    hilosAsociados=new Thread[NUM_CLIENTES];

            /* Se recorre un for donde se crara un cliente nueve 
             hasta la cantidad de clientes que pusimos que pusimos al principio */
            for (int i=0; i<NUM_CLIENTES; i++){
            	   
                    String nombreHilo   = "Cliente "+i;
                    cliente[i]          = new Cliente(puerta, almacen, nombreHilo);
                                                                                           
                    hilosAsociados[i]   = new Thread(cliente[i]);
                    /*Intentamos arrancar el hilo*/
                    hilosAsociados[i].start();
            } //Fin del for

            /*Una vez que se arraquen los clientes entonces se le dara un join
             para que estos se ejcuten primero*/
            for (int i=0; i<NUM_CLIENTES; i++){
                    hilosAsociados[i].join();
            } /*Fin del for*/
           
    
}

}