package ArbolBinario;
public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    boolean isVacio() {
        return raiz == null;
    }

    public static Nodo nuevoArbol(Nodo ramaIzq, Object dato, Nodo ramaDer) {
        return new Nodo(ramaIzq, dato, ramaDer);
    }

    // CREACION DE RECORRIDOS

    public static void preOrden(Nodo raiz) {
        if (raiz != null) {
            raiz.visitar();
            preOrden(raiz.getSubArbolIzq());
            preOrden(raiz.getSubArbolDer());
        }
    }

    public static void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.getSubArbolIzq());
            raiz.visitar();
            inOrden(raiz.getSubArbolDer());
        }
    }

    public static void postOrden(Nodo raiz) {
        if (raiz != null) {
            postOrden(raiz.getSubArbolIzq());
            postOrden(raiz.getSubArbolDer());
            raiz.visitar();
        }
    }

    public static int numNodos(Nodo raiz){
        if(raiz == null){
            return 0;
        }
        else{
            return 1 +numNodos(raiz.getSubArbolIzq()) + numNodos(raiz.getSubArbolDer());
        }
    }

}
