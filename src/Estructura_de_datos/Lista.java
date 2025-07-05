/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura_de_datos;

/**
 * Implementación de lista enlazada simple para manejar colecciones de nodos.
 * Utilizada como cubeta en la tabla hash y para almacenar posiciones de patrones.
 * @author Vyckhy Sarmiento y Diego Arreaza
 */
public class Lista {
    
     /**
     * Referencia al primer nodo de la lista.
     */
    private Nodo pFirst;
      /**
     * Cantidad de elementos en la lista.
     */
    private int size;
    
       /**
     * Constructor que inicializa una lista vacía.
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }
    
    /**
     * Obtiene el tamaño actual de la lista.
     * 
     * @return Número de elementos en la lista.
     */
    public int getSize() {
        return size;
    }
    /**
     * Obtiene el primer nodo de la lista.
     * 
     * @return Referencia al primer nodo, o null si la lista está vacía.
     */
    public Nodo getpFirst(){
        return pFirst;
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean EsVacio(){
        return this.pFirst == null;
    }
    /**
     * Accede al nodo en una posición específica.
     * 
     * @param posicion Índice del nodo a recuperar (0-based).
     * @return El nodo en la posición solicitada, o null si la posición es inválida.
     */
    public Nodo AccederAlValor(int posicion){
        if(posicion>=0 && posicion<size){
            if (posicion == 0) {
                return pFirst;
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getpNext();
                }
                return aux;
            }
        }
        return null;
    }

        /**
     * Inserta un nuevo nodo al final de la lista.
     * 
     * @param nodo Nodo a insertar en la lista.
     */
    public void Insertar(Nodo nodo){
        if (EsVacio()){
            pFirst = nodo;
        }else{
            Nodo aux = pFirst;
            while (aux.getpNext() != null){
                aux = aux.getpNext();
            }aux.setpNext(nodo);
        }
        size++;
    }

      /**
     * Busca un elemento en la lista comparando claves.
     * 
     * @param referencia Clave a buscar en los nodos de la lista.
     * @return true si encuentra un nodo con la clave especificada, false en caso contrario.
     */
    public boolean buscar(String referencia){
        Nodo aux = pFirst;
        while(aux != null){
            if (referencia.equals(aux.clave) ){ 
                return true;
            }
            aux = aux.pNext;
        }
        return false;
    }

}
