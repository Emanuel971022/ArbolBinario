package controlador;

/**
 * Clase ArbolBinario, contiene toda la estructura para actuar sobre el arbol;
 * <ul>
 *      <li> Recorrer los arboles </li>
 *      <li> Conocer su peso </li>
 * </ul>
 * 
 * @author Emanuel Martínez Pinzón
 * @version 1.1
 * @since 2016
 */
public class ArbolBinario {
    protected Nodo raiz;
    
    /**
     * Contructor de un arbol binario vacio.
     * <br>
     * Inicializa el nodo Raiz como Null
     */
    public ArbolBinario(){
        raiz = null;
    }
    
    /**
     * Contructor de un arbol binacio
     * <br>
     * Inicializa el arbol con un Nodo raiz
     * @param raiz Nodo raiz del arbol
     */
    public ArbolBinario(Nodo raiz){
        this.raiz = raiz;
    }
    
    /**
     * Obtiene el nodo raiz del arbol
     * <br>
     * Actua como getRaiz()
     * @return Retorna el nodo raiz del arbol
     */
    public Nodo raizArbol(){
        return raiz;
    }
    
    /**
     * Ingresa una nueva raiz al arbol
     * <br>
     * Actua como setRaiz()
     * @param raiz Nueva raiz del arbol
     */
    public void ingresarRaiz(Nodo raiz){
        this.raiz = raiz;
    }
    
    /**
     * Comprueba si el arbol esta vacio
     * @return Retorna true si el arbol esta vacio, false si no lo esta
     */
    public boolean esVacio(){
        return raiz == null;
    }
    
    /**
     * Recorre el arbol binario en preorden
     * <ul>
     *      <li> Visita el nodo raiz </li>
     *      <li> Recorre el subarbol izquierdo en preorden </li>
     *      <li> Recorre el subarbol derecho en preorden </li>
     * </ul>
     * 
     * @param nodo Nodo del arbol en donde inicia el recorrido. (Generalmente la raiz)
     */
    public static void preorden(Nodo nodo){
        if(nodo != null){
            nodo.visistar();
            preorden(nodo.subArbolIzq());
            preorden(nodo.subArbolDer());
        }
    }
    
    /**
     * Se recorre el arbol binario en inorden
     * <ul>
     *      <li> Recorre el subarbol izquierdo en orden </li>
     *      <li> Visita el nodo raiz </li>
     *      <li> Recorre el subarbol derecho en orden </li>
     * </ul>
     * @param nodo Nodo del arbol en donde inicia el recorrido. (Generalmente la raiz)
     */
    public static void inorden(Nodo nodo){
        if(nodo != null){
            inorden(nodo.subArbolIzq());
            nodo.visistar();
            inorden(nodo.subArbolDer());
        }
    }
    
    /**
     * Se recorre el arbol binario en postorden
     * <ul>
     *      <li> Recorre el subarbol izquierdo en postorden </li>
     *      <li> Recorre el subarbol derecho en postorden</li>
     *      <li> Visita el nodo raiz </li>
     * </ul>
     * @param nodo Nodo del arbol en donde inicia el recorrido. (Generalmente la raiz)
     */
    public static void postorden(Nodo nodo){
        if(nodo != null){
            postorden(nodo.subArbolIzq());
            postorden(nodo.subArbolDer());
            nodo.visistar();
        }
    }
    
    /**
     * Recorre el arbol contando la cantidad de nodos que tiene el arbol
     * @param raiz Nodo raiz del arbol en donde inicia el conteo
     * @return Retorna un entero con la cantidad de nodos del arbol o su peso
     */
    public static int numNodos(Nodo raiz){
        if(raiz == null)
            return 0;
        else
            return 1 + numNodos(raiz.subArbolDer())+ numNodos(raiz.subArbolIzq());
    }
}
