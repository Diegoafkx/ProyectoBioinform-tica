/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura_de_datos;
/**
 * Árbol binario de búsqueda para organizar patrones de ADN por frecuencia.
 * @author Diego Arreaza y Vyckhy Sarmiento
 */
public class ArbolBinarioDeBusqueda {
    //atributos
    private Nodo root;
    private int size;
    
    /**
     * Constructor de la clase ArbolBinarioDeBusqueda.
     * Inicializa un árbol vacío con la raíz nula y tamaño cero.
     */
    public ArbolBinarioDeBusqueda() {
        this.root = null;
        this.size = 0;
    }
    /**
    * Establece una nueva raíz para el árbol.
    * 
    * @param root Nuevo nodo raíz.
    * @throws IllegalArgumentException Si root es null y el árbol no está vacío.
    */
    public void setRoot(Nodo root) {
        this.root = root;
    }
/**
 * Obtiene el número de nodos en el árbol.
 * 
 * @return Tamaño actual del árbol (número de patrones almacenados).
 */
    public int getSize() {
        return size;
    }

 /**
 * Verifica si el árbol está vacío.
 * 
 * @return true si no contiene nodos, false en caso contrario.
 */
     public boolean EsVacio(){
        return this.root == null;
    }
 
    /**
     * Método auxiliar recursivo para insertar un nodo en el árbol.
     * Los nodos se ordenan primero por frecuencia (menor a la izquierda, mayor a la derecha),
     *
     * @param actual El nodo actual que se está evaluando en la recursión.
     * @param nuevoNodo El nodo que se desea insertar.
     * @return El nodo actual después de la inserción, o el nuevo nodo si el lugar es nulo.
     */
    private Nodo insertarRecursivo(Nodo actual, Nodo nuevoNodo) {
        if (actual == null) {
            return nuevoNodo;
        }
        patronADN patronActual = (patronADN) actual.getData();
        patronADN patronNuevo = (patronADN) nuevoNodo.getData();
        if (patronNuevo.getFrecuencia() < patronActual.getFrecuencia()) {
            actual.setIzq(insertarRecursivo(actual.getIzq(), nuevoNodo));
        } else if (patronNuevo.getFrecuencia() > patronActual.getFrecuencia()) {
            actual.setDer(insertarRecursivo(actual.getDer(), nuevoNodo));
        } else {
            int comparacionTriplete = patronNuevo.getTriplete().compareTo(patronActual.getTriplete());
            if (comparacionTriplete < 0) { 
                actual.setIzq(insertarRecursivo(actual.getIzq(), nuevoNodo));
            } else if (comparacionTriplete > 0) { 
                actual.setDer(insertarRecursivo(actual.getDer(), nuevoNodo));
            } else {
                return actual; 
            }
        }
        return actual;
    }
    
    /**
     * Inserta un nuevo patrón de ADN en el árbol.
     * Si el patrón ya existe con la misma frecuencia y triplete, no se inserta duplicado.
     *
     * @param nuevoPatron El objeto patronADN a insertar.
     */
    public void insertar(patronADN nuevoPatron) {
        Nodo nuevoNodo = new Nodo(nuevoPatron);
        this.root = insertarRecursivo(this.root, nuevoNodo);
    }

    /**
     * Encontrar el patrón más frecuente (el elemento con la mayor frecuencia, que debería ser el máximo en el árbol).
     * @return El objeto patronADN más frecuente, o null si el árbol está vacío.
     */
    public patronADN patronMasFrecuente() {
        if (root == null) return null;
        return (patronADN) encontrarMaximo(root).getData();
    }

    /**
     * Encontrar el patrón menos frecuente (el elemento con la menor frecuencia, que debería ser el mínimo en el árbol).
     * @return El objeto patronADN menos frecuente, o null si el árbol está vacío.
     */
    public patronADN patronMenosFrecuente() {
        if (root == null) return null;
        return (patronADN) encontrarMinimo(root).getData();
    }

    /**
     * Método auxiliar privado para encontrar el nodo con el valor mínimo (más a la izquierda).
     * @param nodo El nodo desde el cual comenzar la búsqueda.
     * @return El nodo con el valor mínimo.
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getIzq() != null) {
            nodo = nodo.getIzq();
        }
        return nodo;
    }

    /**
     * Método auxiliar privado para encontrar el nodo con el valor máximo (más a la derecha).
     * @param nodo El nodo desde el cual comenzar la búsqueda.
     * @return El nodo con el valor máximo.
     */
    private Nodo encontrarMaximo(Nodo nodo) {
        while (nodo.getDer() != null) {
            nodo = nodo.getDer();
        }
        return nodo;
    }

    /**
     * Realiza un recorrido en orden del árbol y devuelve una lista de patrones de ADN ordenados por frecuencia.
     * @return Una Lista de objetos patronADN en orden ascendente de frecuencia.
     */
    public Lista recorridoInOrden() {
        Lista resultado = new Lista();
        recorridoInOrdenRecursivo(root, resultado);
        return resultado;
    }

    /**
     * Método auxiliar recursivo para el recorrido en orden.
     * @param nodo El nodo actual en el recorrido.
     * @param resultado La lista donde se añadirán los patrones.
     */
    private void recorridoInOrdenRecursivo(Nodo nodo, Lista resultado) {
        if (nodo != null) {
            recorridoInOrdenRecursivo(nodo.getIzq(), resultado);
            Nodo aux =new Nodo(nodo.data);
            aux.Valor = nodo.Valor;
            resultado.Insertar(aux); 
            recorridoInOrdenRecursivo(nodo.getDer(), resultado);
        }
    }

}

