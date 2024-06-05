package ArbolBinario;
    import ArbolBinario.*;

    import ArbolBinario.*;

public class ArbolBinarioBusqueda extends ArbolBinario{

    public ArbolBinarioBusqueda(){
        super();
    }

    public ArbolBinarioBusqueda(Nodo raiz){
        super(raiz);
    }

    public Nodo buscar(Object buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        if (raiz == null) {
            return null;
        } else {
            return localizar(getRaiz(), dato);
        }
    }

    protected Nodo localizar(Nodo raizSub, Comparador buscado) {
        if (raizSub == null) {
            return null;
        } else if (buscado.igualQue(raizSub.valorNodo())) {
            return raiz;
        } else if (buscado.menorQue(raizSub.valorNodo())) {
            return localizar(raizSub.subarbolIzdo(), buscado);
        } else {
            return localizar(raizSub.subarbolDcho(), buscado);
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
        } else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;//nodo izquierdo
            iz = insertar(raizSub.subarbolIzdo(), dato);
            raizSub.ramaIzdo(iz);
        } else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;//nodo derecho
            dr = insertar(raizSub.subarbolDcho(), dato);
            raizSub.ramaDcho(dr);
        } else {
            throw new Exception("Nodo duplicado");
        }
        return raizSub;
    }

    public void eliminar(Object valor) throws Exception {
        Comparador dato;
        dato = (Comparador) valor;
        raiz = eliminar(raiz, dato);
    }

  
    protected Nodo eliminar(Nodo raizSub, Comparador dato) throws Exception {
        
        if (raizSub == null) {
            throw new Exception("No encontrado el nodo con la clave");
        } else if (dato.menorQue(raizSub.valorNodo())) {
            Nodo iz;
            iz = eliminar(raizSub.subarbolIzdo(), dato);
            raizSub.ramaIzdo(iz);
        } else if (dato.mayorQue(raizSub.valorNodo())) {
            Nodo dr;
            dr = eliminar(raizSub.subarbolDcho(), dato);
            raizSub.ramaDcho(dr);
        } else {
            
            Nodo q;
            q = raizSub; 
            if (q.subarbolIzdo() == null) {
                raizSub = q.subarbolDcho();
            } else if (q.subarbolDcho() == null) {
                raizSub = q.subarbolIzdo();
            } else { 
                q = reemplazar(q);
            }
            q = null;
        }
        return raizSub;
    }

   
    private Nodo reemplazar(Nodo act) {
        Nodo a, p;
        p = act;
        a = act.subarbolIzdo(); 
        while (a.subarbolDcho() != null) {
            p = a;
            a = a.subarbolDcho();
        }
        act.nuevoValor(a.valorNodo());
        if (p == act) {
            p.ramaIzdo(a.subarbolIzdo());
        } else {
            p.ramaDcho(a.subarbolIzdo());
        }
        return a;
    }

}
    
