package controlador;

/**
 * Clase ArbolBinario, contiene toda la estructura para actuar sobre el arbol;
 * <ul>
 *      <li> Agregar nodos </li>
 *      <li> Recorrer los arboles </li>
 * </ul>
 * 
 * @author Emanuel Martínez Pinzón
 * @version 1.1
 * @since 2016
 */
public class ArbolBinario {
    private Nodo raiz;
    
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
     * Agrega un nodo al arbol binario de busqueda
     * @param nodo Nodo a agregar al arbol
     * @param raiz Raiz del arbol para iniciar busqueda de espacio
     */
    private void agregarNodo(Nodo nodo, Nodo raiz){
        //Partiendo de una raiz se comprueba si esta es diferente de null
        
        if(raiz == null)
            /*
            En caso de ser null se pasa a ingresar la raiz del arbol
            */
            this.ingresarRaiz(nodo);
        else
            if(nodo.valorNodo() <= raiz.valorNodo())
                /*
                Si el valor del nodo es menor al valor del nodo raiz, 
                mira si el siquiente nodo es nulo a la izquierda
                */
                if(raiz.subArbolIzq() == null)
                    /*
                    En caso de ser nulo, agrega el nodo como hijo a la izquierda
                    */
                    raiz.ramaIzq(nodo);
                else
                    /*
                    Si no es nulo, intentará buscando mas profundamente un espacio a la izquierda
                    */
                    agregarNodo(nodo, raiz.subArbolIzq());
            else
                /*
                En caso de ser mayor el nodo pasa a la derecha
                */
                if(raiz.subArbolDer() == null)
                    /*
                    En caso de ser nulo, agrega el nodo hijo a la derecha
                    */
                    raiz.ramaDer(nodo);
                else
                    /*
                    Si no es nulo, intentará buscando mas profundamente un espacio a la derecha
                    */
                    agregarNodo(nodo, raiz.subArbolDer());
    }
    
    /**
     * Agrega un nodo al arbol binario
     * @param nodo Nodo a agregar al arbol
     */
    public void agregarNodo(Nodo nodo){
        this.agregarNodo(nodo, this.raiz);
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
}
