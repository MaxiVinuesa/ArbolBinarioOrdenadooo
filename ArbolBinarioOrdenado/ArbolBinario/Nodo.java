package ArbolBinario;

public class Nodo {
    protected Object dato;
    protected Nodo izq;
    protected Nodo der;

    public Nodo(Object dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }

    public Nodo(Nodo ramaIzq, Object dato, Nodo ramaDer) {
        this(dato);
        izq = ramaIzq;
        der = ramaDer;
    }

    public Object getNodo() {
        return dato;
    }

    public Nodo getSubArbolIzq() {
        return izq;
    }

    public Nodo getSubArbolDer() {
        return der;
    }

    public void setDato(Object d) {
        dato = d;
    }

    public void setRamaIzq(Nodo n) {
        izq = n;
    }

    public void setRamaDer(Nodo n) {
        der = n;
    }

    public void visitar() {
        System.out.print(dato + " ");
    }


}
