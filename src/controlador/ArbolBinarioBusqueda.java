package controlador;

/**
 * Se considera una extensión de un arbol binario, con operaciones adicionales
 * como el borrado y busqueda de un nodo al arbol binario
 * <ul>
 *      <li> Buscar nodos </li>
 *      <li> Agregar nodos </li>
 *      <li> Eliminar nodos </li>
 * </ul>
 * @author Emanuel Martínez Pinzón
 * @version 1.2
 * @since 2016
 */
public class ArbolBinarioBusqueda extends ArbolBinario{
    
    /**
     * Constructor el arbol binario de busqueda con herencia de ArbolBinario
     */
    public ArbolBinarioBusqueda(){
        super();
    }
    
    /**
     * Busca un nodo en el arbol binario de busqueda
     * @param buscado Elemento buscado
     * @return Retorna el Nodo encontrado o null si no se encuentra
     */
    public Nodo buscar(Object buscado){
        Comparador dato;
        dato = (Comparador) buscado;
        
        if(raiz == null)
            return null;
        else
            return localizar(raizArbol(), dato);
    }
    
    /**
     * Localiza un Nodo en el arbol binario de busqueda
     * @param raizSub Raiz del arbol
     * @param buscado Elemento buscado
     * @return Retorna el nodo buscado
     */
    protected Nodo localizar(Nodo raizSub, Comparador buscado){
        if(raizSub == null)
            return null;
        else if(buscado.igualQue(raizSub.valorNodo()))
            return raiz;
        else if(buscado.menorQue(raizSub.valorNodo()))
            return localizar(raizSub.subArbolIzq(), buscado);
        else
            return localizar(raizSub.subArbolDer(), buscado);
    }
    
    /**
     * Itera un arbol de busqueda binario hasta encontrar un nodo o en su defecto
     * terminar el recorrido por las ramas.
     * @param buscado Elemento buscado en el ABB
     * @return Retorna el nodo o null si no encuentra,
     */
    public Nodo buscarIterativo(Object buscado){
        Comparador dato;
        boolean encontrado = false;
        Nodo raizSub = raiz;
        dato = (Comparador) buscado;
        
        while(!encontrado && raizSub != null)
            if(dato.igualQue(raizSub.valorNodo()))
                encontrado = true;
            else if(dato.menorQue(raizSub.valorNodo()))
                raizSub = raizSub.subArbolIzq();
            else 
                raizSub = raizSub.subArbolDer();
        
        return raizSub;
    }
    
    /**
     * Agrega un nodo al arbol binario de busqueda
     * @param valor Valor del Nodo
     * @throws Exception Nodo duplicado
     */
    public void insertar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = insertar(raiz, dato);
    }
    
    /**
     * Metodo descrito para insertar Nodos a un ABB
     * @param raizSub Raiz sub arbol
     * @param dato Dato a agregar
     * @return Retorna el nodo que agrega
     * @throws Exception Nodo duplicado
     */
    protected Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {
        if(raizSub == null)
            raizSub = new Nodo(dato);
        else if(dato.menorQue(raizSub.valorNodo())){
            Nodo iz;
            iz = insertar(raizSub.subArbolIzq(), dato);
            raizSub.ramaIzq(iz);
        }else if(dato.mayorQue(raizSub.valorNodo())){
            Nodo dr;
            dr = insertar(raizSub.subArbolDer(), dato);
            raizSub.ramaDer(dr);
        }else
            throw new Exception("Nodo duplicado");
        
        return raizSub;
    }
    
    /**
     * Elimina un valor de un arbol binario de busqueda
     * @param valor Valor a buscar y eliminar en el arbol
     * @throws Exception "No encontrado el nodo con la clave"
     */
    public void eliminar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = eliminar(raiz, dato);
    }
    
    /**
     * Recorre el arbol binario de busqueda para encontrar el elemento deseado
     * y eliminarlo
     * @param raizSub Raiz sub arbol del arbol
     * @param dato Dato a eliminar
     * @return Retorna el nodo a eliminar
     * @throws Exception "No encontrado el nodo con la clave"
     */
    protected Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
        if(raizSub == null)
            throw new Exception("No encontrado el nodo con la clave");
        else if(dato.menorQue(raizSub.valorNodo())){
            Nodo iz;
            iz = eliminar(raizSub.subArbolIzq(), dato);
            raizSub.ramaIzq(iz);
        }else if(dato.mayorQue(raizSub.valorNodo())){
            Nodo dr;
            dr = eliminar(raizSub.subArbolDer(), dato);
            raizSub.ramaDer(dr);
        }else{
            Nodo q;
            q = raizSub;
            if(q.subArbolIzq() == null)
                raizSub = q.subArbolDer();
            else if(q.subArbolDer() == null)
                raizSub = q.subArbolIzq();
            else
                q = reemplazar(q);
            
            q = null;
        }
        
        return raizSub;
    }
    
    /**
     * Reemplaza el nodo actual con un nodo del arbol binario de busqueda que cumpla
     * con ser raiz digna; mayor que el subarbol izquierdo y menor que el subarbol derecho
     * @param act Elemento actual
     * @return Retorna un nodo
     */
    private Nodo reemplazar(Nodo act){
        Nodo a, p;
        
        p = act;
        a = act.subArbolIzq();
        
        while(a.subArbolDer() != null){
            p = a;
            a = a.subArbolDer();
        }
        
        act.nuevoValor(a.valorNodo());
        
        if(p == act)
            p.ramaIzq(a.subArbolIzq());
        else
            p.ramaDer(a.subArbolIzq());
        
        return a;
    }
}
