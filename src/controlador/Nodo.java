package controlador;

/**
 * Nodo de un arbol binario
 * <br>
 * Contiene la información del Nodo así como la referencia a sus hijos.
 * @author Emanuel Martínez Pinzón
 * @version 1.1
 * @since 2016
 */
public class Nodo {
    private int dato;
    private Nodo izq;
    private Nodo der;

    /**
     * Constructor del Nodo Hoja
     * @param dato Dato para construir un Nodo de tipo Hoja
     */
    public Nodo(int dato) {
        this.dato = dato;
        izq = der = null;
    }
    
    /**
     * Contructor de un nodo hijo con referencias a dos Nodos hijos (Opcionales)
     * @param dato Dato que almacena el Nodo
     * @param izq Referencia al hijo a la izquierda
     * @param der Referencia al hijo a la derecha
     */
    public Nodo(int dato, Nodo izq, Nodo der){
        this(dato);
        this.izq = izq;
        this.der = der;
    }
    
    /**
     * Obtiene el dato guardado en el nodo
     * <br>
     * Actua como un getDato
     * @return Retorna el dato del Nodo
     */
    public int valorNodo(){
        return dato;
    }
    
    /**
     * Obtiene el Nodo referente a la izquierda
     * <br>
     * Actua como un getNodoIzq
     * @return Retorna un Nodo hijo izquierdo del Nodo x
     */
    public Nodo subArbolIzq(){
        return izq;
    }
    
    /**
     * Obtiene el Nodo referente a la derecha
     * <br>
     * Actua como getNodoDet
     * @return Retorna un Nodo hijo derecho del Nodo x
     */
    public Nodo subArbolDer(){
        return der;
    }
    
    /**
     * Ingresa un nuevo dato al Nodo
     * <br>
     * Actua como un setDato
     * @param dato Dato a guardar
     */
    public void nuevoValor(int dato){
        this.dato = dato;
    }
    
    /**
     * Ingresa una nueva referencia a la izquierda
     * <br>
     * Actua como setIzq
     * @param izq Nodo referencia izquierda
     */
    public void ramaIzq(Nodo izq){
        this.izq = izq;
    }
    
    /**
     * Ingresa una nueva referencia a la derecha
     * <br>
     * Actua como setDer
     * @param der Nodo referencia derecha
     */
    public void ramaDer(Nodo der){
        this.der = der;
    }
    
    /**
     * Se imprime el dato del nodo
     */
    public void visistar(){
        System.out.print(dato+" ");
    }
}
