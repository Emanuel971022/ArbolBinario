package controlador;

/**
 * Clase ArbolBinario, contiene toda la estructura para actuar sobre el arbol;
 * <ul>
 *      <li> Agregar nodos </li>
 *      <li> Buscar nodos </li>
 *      <li> Eliminar nodos </li>
 *      <li> Recorrer de distintos modos el arbol </li>
 * </ul>
 * 
 * @author Emanuel Martínez Pinzón
 * @version 1.0
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
    
    private void agregarNodo(Nodo nodo, Nodo raiz){
        //Partiendo de una raiz se comprueba si esta es diferente de null
        
        if(raiz == null)
            /*
            En caso de ser null se pasa a ingresar la raiz del arbol
            */
            this.ingresarRaiz(nodo);
        else{
            if(nodo.valorNodo() <= raiz.valorNodo()){
                
            }
        }
    }
}
