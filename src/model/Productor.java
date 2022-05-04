package model;

import java.util.Random;

import controller.Cola;

public class Productor implements Runnable{

	 Cola colaCompartida;
	 Random numAzar;
	 
     public Productor(Cola cola){
             this.colaCompartida=cola;
             this.numAzar =  new Random();
     }
     @Override
     public void run() {
        while (true){
                int num=numAzar.nextInt(10);
                while (colaCompartida.encolar(num)==false){
                	try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
                }/*Fin del while*/

                System.out.println("Productor encoló el numero:"+num);
        } /*Fin del while externo*/
     } /*Fin de run()*/
} /*Fin de la clase*/