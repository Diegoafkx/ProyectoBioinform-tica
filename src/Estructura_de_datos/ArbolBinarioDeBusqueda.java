
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura_de_datos;

/**
 *
 * @author vyckh
 */
public class ArbolBinarioDeBusqueda {
    //atributos
    private Nodo root;
    private int size;
    
    //constructor
    public ArbolBinarioDeBusqueda(Nodo root) {
        this.root = null;
        this.size = 0;
    }

    public Nodo getRoot() {
        return root;
    }

    public void setRoot(Nodo root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
     public boolean EsVacio(){
        return this.root == null;
    }
    
    public void Vaciar(){
        this.root = null;
    }
}
