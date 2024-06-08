public class ArbolBinarioBusqueda extends ArbolBinario{

    public ArbolBinarioBusqueda(){
        super();
    }

    public ArbolBinarioBusqueda(Nodo raiz){
        super(raiz);
    }

    public static Nodo buscar(Object buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        if (raiz == null) {
            return null;
        } else {
            return localizar(getRaiz(), dato);
        }
    }

    protected static Nodo localizar(Nodo raizSub, Comparador buscado) {
        if (raizSub == null) {
            return null;
        } else if (buscado.igualQue(raizSub.getNodo())) {
            return raiz;
        } else if (buscado.menorQue(raizSub.getNodo())) {
            return localizar(raizSub.getSubArbolIzq(), buscado);
        } else {
            return localizar(raizSub.getSubArbolDer(), buscado);
        }
    }

    public void insertar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = insertar(raiz, dato);
    }

    
    protected Nodo insertar(Nodo raizSub, Comparador dato) throws Exception {

        if (raizSub == null) {
            raizSub = new Nodo(dato);
        } else if (dato.menorQue(raizSub.getNodo())) {
            Nodo iz;
            iz = insertar(raizSub.getSubArbolIzq(), dato);
            raizSub.setRamaIzq(raizSub);
        } else if (dato.mayorQue(raizSub.getNodo())) {
            Nodo dr;//nodo derecho
            dr = insertar(raizSub.getSubArbolDer(), dato);
            raizSub.setRamaDer(dr);
        } else {
            throw new Exception("Nodo duplicado");
        }
        return raizSub;
    }

    public static void eliminar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = eliminar(raiz, dato);
    }

  
    protected static Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
        
        if (raizSub == null) {
            throw new Exception("No encontrado el nodo con la clave");
        } else if (dato.menorQue(raizSub.getNodo())) {
            Nodo iz;
            iz = eliminar(raizSub.getSubArbolIzq(), dato);
            raizSub.setRamaIzq(raizSub);
        } else if (dato.mayorQue(raizSub.getNodo())) {
            Nodo dr;
            dr = eliminar(raizSub.getSubArbolDer(), dato);
            raizSub.setRamaDer(dr);
        } else {
            
            Nodo q;
            q = raizSub; 
            if (q.getSubArbolIzq() == null) {
                raizSub = q.getSubArbolDer();
            } else if (q.getSubArbolDer() == null) {
                raizSub = q.getSubArbolIzq();
            } else { 
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

   
    private static Nodo reemplazar(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.getSubArbolIzq(); 
        while (a.getSubArbolDer() != null) {
            p = a;
            a = a.getSubArbolDer();
        }
        act.nuevoValor(a.getNodo());
        if (p == act) {
            p.setRamaIzq(a.getSubArbolIzq());
        } else {
            p.setRamaDer(a.getSubArbolIzq());
        }
        return a;
    }

}
    
