package model;

import java.util.Random;

public class Cliente implements Runnable{
/*Creamos variables de la clase puerta, almacen, nombre.
	Estas seran recibidas através del constructor*/
        Puerta      puerta;
        Almacen     almacen;
        String      nombre;
        Random      generador;
        final int MAX_INTENTOS  =   10;
        
/*Se reciben los objetos de puerta, almacen y el nombre que se mandaron en el lanzador*/
        public Cliente(Puerta p, Almacen a, String nombre){
                this.puerta     =   p;
                this.almacen    =   a;
                this.nombre     =   nombre;
                generador       =   new Random();
        }

        /*Se crea un metodo void para poder generar el tiempo de espera */
        public void esperar(){
                try {
                        int ms_azar = generador.nextInt(100);
                        Thread.sleep(ms_azar);
                } catch (InterruptedException ex) {
                        System.out.println("Falló la espera");
                }
        }
        @Override
        public void run() {
        	/*Iniciando el hilo se creara un for que se recorrera n veces
        	 el numero maximo de intentos*/
                for (int i=0; i<MAX_INTENTOS; i++){
             
                	/*Tenemos un if que validara que el metodo de puerta creada*/
                        if (!puerta.estaOcupada()){
                    /*Se habre otro if que llamara al metodo intentar entrar que 
                     retorna un valor de  true o falso*/
                                if (puerta.intentarEntrar()){
                                	/*Cuando se pase el if,
                                	  es porque el valor ha regrasado como true*/
                                        puerta.liberarPuerta();
                                        /*Al entrar a la puerta se llamara al
                                         metodo de almacen que devuelve un booleano
                                         true o false */
                                        if (almacen.cogerProducto()){
                                        	/*Si se consigue un true entonces se
                                        	retornara una respuesta exitosa, en caso de cuzar
                                        	se devolvera que no se pudo adquirir un producto*/
                                                System.out.println(
                                                                this.nombre + ": cogí un producto!");
                                                return ;
                                        }
                                        else {
                                                System.out.println(
                                                           this.nombre+
                                                           ": ops, crucé pero no cogí nada");
                                                return ;
                                        } /*Fin del else*/
                                } /*Fin del if*/
                        } else{
                           esperar();
                        }

                } 
                
                System.out.println(this.nombre+
                                ": lo intenté muchas veces y no pude");
        }

}