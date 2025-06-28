/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura_de_datos;

/**
 *hola
 * @author Diego Arreaza y Vyckhy Sarmiento
 */
public class Nodo {
  
    //atributos para la lista
    private Object dato;
    private Nodo pNext;
    
    //atributos para el arbol
    private patronADN data;
    private Nodo izq;
    private Nodo der;
    private int frecuencia;
    private String[] ub = new String[100];
    
    
    //constructor para el arbol
    public Nodo(patronADN data, int ub) {
        this.data = data;
        this.izq = null;
        this.der = null;
        this.frecuencia = 1;
        int aux = 0;
        while(this.ub[aux]!= null){
            ub++;
        }
        this.ub[aux] = Integer.toString(ub);
        
    }
    
    //gettters y setters para el arbol

    public patronADN getData() {
        return data;
    }

    public void setData(patronADN data) {
        this.data = data;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
    
    
    
    //constructor vacio
    public Nodo() {
        this.dato = null;
        this.pNext = null;
    }

    public Nodo(Object dato) {
        this.dato = dato;
        this.pNext = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }   
}
