/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura_de_datos;
import Estructura_de_datos.Lista;

/**
 * Representa un patrón de ADN (triplete) con su información asociada.
 * Almacena la secuencia del triplete, su frecuencia, las posiciones donde aparece,
 * y el aminoácido que codifica junto con sus abreviaturas.
 *
 * @author vyckh y Diego Arreaza
 */

public class patronADN {
   
    private String triplete;       
    private int frecuencia;        
    private Lista posiciones;       
    private String aminoacido;      
    private String abreviatura3;   
    private String abreviatura1;  
    
    /**
     * Constructor principal para un nuevo patrón de ADN.
     * Inicializa la frecuencia en 1 y agrega la primera posición.
     *
     * @param triplete La secuencia de 3 nucleótidos del patrón.
     * @param posicionInicial La primera posición (índice) donde se encuentra este triplete.
     */
    public patronADN(String triplete, int posicionInicial) {
        this.triplete = triplete;
        this.frecuencia = 1; 
        this.posiciones = new Lista(); 
        this.posiciones.Insertar(posicionInicial); 
        this.convertirAaminoacido(triplete); 
    }
    
    /**
     * Constructor alternativo, útil si ya tienes la frecuencia calculada
     * o si solo necesitas el triplete y la frecuencia para el BST.
     * Puede que no se usen las 'posiciones' en todos los contextos con este constructor.
     * @param triplete La secuencia del triplete.
     * @param frecuencia La frecuencia predefinida del triplete.
     */

    // --- Getters (métodos para obtener los valores de los atributos) ---
    public String getTriplete() {
        return triplete;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public Lista getPosiciones() {
        return posiciones;
    }

    public String getAminoacido() {
        return aminoacido;
    }

    public String getAbreviatura3() {
        return abreviatura3;
    }

    public String getAbreviatura1() {
        return abreviatura1;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setAminoacido(String aminoacido) {
        this.aminoacido = aminoacido;
    }

    public void setAbreviatura3(String abreviatura3) {
        this.abreviatura3 = abreviatura3;
    }

    public void setAbreviatura1(String abreviatura1) {
        this.abreviatura1 = abreviatura1;
    }
    /**
     * Incrementa la frecuencia de este patrón en uno.
     * Se usa cuando se encuentra una nueva aparición de un patrón ya registrado.
     */
    public void incrementarFrecuencia() {
        this.frecuencia++;
    }
    
    /**
     * Agrega una nueva posición a la lista de ocurrencias de este patrón.
     * @param posicion La nueva posición (índice) donde se encontró el patrón.
     */
    public void agregarPosicion(int posicion) {
        this.posiciones.Insertar(posicion); 
    }
    
    /**
     * Método crucial para convertir un triplete de ADN en su aminoácido correspondiente
     * y rellenar los atributos 'aminoacido', 'abreviatura3' y 'abreviatura1'.
     *
     * @param tripleteADN El triplete de ADN (ej. "GTT").
     */
    private void convertirAaminoacido(String tripleteADN) {
        String codonARN = tripleteADN.toUpperCase().replace('T', 'U');
        switch (codonARN) {
            // Fenilalanina (Phenylalanine)
            case "UUU": 
            case "UUC":
                this.aminoacido = "Fenilalanina";
                this.abreviatura3 = "Phe"; 
                this.abreviatura1 = "F"; 
                break; 
            
            // Leucina (Leucine)
            case "UUA": 
            case "UUG":
            case "CUU": 
            case "CUC": 
            case "CUA": 
            case "CUG":
                this.aminoacido = "Leucina";
                this.abreviatura3 = "Leu"; 
                this.abreviatura1 = "L"; 
                break;
            
            // Isoleucina (Isoleucine)
            case "AUU":
            case "AUC":
            case "AUA":
                this.aminoacido = "Isoleucina";
                this.abreviatura3 = "Ile";
                this.abreviatura1 = "I";
                break;
            
            // Metionina (Methionine) 
            case "AUG":
                this.aminoacido = "Metionina";
                this.abreviatura3 = "Met";
                this.abreviatura1 = "M";
                break;
            
            // Valina (Valine)
            case "GUU":
            case "GUC":
            case "GUA":
            case "GUG":
                this.aminoacido = "Valina";
                this.abreviatura3 = "Val";
                this.abreviatura1 = "V";
                break;
            
            // Serina (Serine)
            case "UCU": case "UCC": case "UCA": case "UCG":
            case "AGU": case "AGC":
                this.aminoacido = "Serina";
                this.abreviatura3 = "Ser";
                this.abreviatura1 = "S";
                break;

            // Prolina (Proline)
            case "CCU": case "CCC": case "CCA": case "CCG":
                this.aminoacido = "Prolina";
                this.abreviatura3 = "Pro";
                this.abreviatura1 = "P";
                break;

            // Treonina (Threonine)
            case "ACU": case "ACC": case "ACA": case "ACG":
                this.aminoacido = "Treonina";
                this.abreviatura3 = "Thr";
                this.abreviatura1 = "T";
                break;

            // Alanina (Alanine)
            case "GCU": case "GCC": case "GCA": case "GCG":
                this.aminoacido = "Alanina";
                this.abreviatura3 = "Ala";
                this.abreviatura1 = "A";
                break;

            // Tirosina (Tyrosine)
            case "UAU": case "UAC":
                this.aminoacido = "Tirosina";
                this.abreviatura3 = "Tyr";
                this.abreviatura1 = "Y";
                break;

            // Histidina (Histidine)
            case "CAU": case "CAC":
                this.aminoacido = "Histidina";
                this.abreviatura3 = "His";
                this.abreviatura1 = "H";
                break;

            // Glutamina (Glutamine)
            case "CAA": case "CAG":
                this.aminoacido = "Glutamina";
                this.abreviatura3 = "Gln";
                this.abreviatura1 = "Q";
                break;

            // Asparagina (Asparagine)
            case "AAU": case "AAC":
                this.aminoacido = "Asparagina";
                this.abreviatura3 = "Asn";
                this.abreviatura1 = "N";
                break;

            // Lisina (Lysine)
            case "AAA": case "AAG":
                this.aminoacido = "Lisina";
                this.abreviatura3 = "Lys";
                this.abreviatura1 = "K";
                break;

            // Ácido Aspártico (Aspartic Acid)
            case "GAU": case "GAC":
                this.aminoacido = "Ácido Aspártico";
                this.abreviatura3 = "Asp";
                this.abreviatura1 = "D";
                break;

            // Ácido Glutámico (Glutamic Acid)
            case "GAA": case "GAG":
                this.aminoacido = "Ácido Glutámico";
                this.abreviatura3 = "Glu";
                this.abreviatura1 = "E";
                break;

            // Cisteína (Cysteine)
            case "UGU": case "UGC":
                this.aminoacido = "Cisteína";
                this.abreviatura3 = "Cys";
                this.abreviatura1 = "C";
                break;

            // Triptófano (Tryptophan)
            case "UGG":
                this.aminoacido = "Triptófano";
                this.abreviatura3 = "Trp";
                this.abreviatura1 = "W";
                break;

            // Arginina (Arginine)
            case "CGU": case "CGC": case "CGA": case "CGG":
            case "AGA": case "AGG":
                this.aminoacido = "Arginina";
                this.abreviatura3 = "Arg";
                this.abreviatura1 = "R";
                break;

            // Glicina (Glycine)
            case "GGU": case "GGC": case "GGA": case "GGG":
                this.aminoacido = "Glicina";
                this.abreviatura3 = "Gly";
                this.abreviatura1 = "G";
                break;
           
            case "UAA":
            case "UAG":
            case "UGA":
                this.aminoacido = "Parada";
                this.abreviatura3 = "STOP"; 
                this.abreviatura1 = "*"; 
                break;
            
            default:
                this.aminoacido = "Desconocido";
                this.abreviatura3 = "N/A";
                this.abreviatura1 = "?";
                break;
        }
    }
}