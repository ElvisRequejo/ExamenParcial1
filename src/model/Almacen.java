package model;

public class Almacen {
    private int numProductos;
    public Almacen(int nProductos){
            this.numProductos=nProductos;
    }
    /*Al crear el objeto almacen se le pone el numero de productos disponibles,
     al llamarse el metodo cogerProductos se restara al total -1
    y se devolvera un true, pero si ya no hay productos entonces se devolvera un false*/
    public boolean cogerProducto(){
            if (this.numProductos>0){
                    this.numProductos--;
                    return true;
            }
            return false;
    }
}
