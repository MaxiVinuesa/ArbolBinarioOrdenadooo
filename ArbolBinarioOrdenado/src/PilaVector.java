
import java.util.Vector;

public class PilaVector {
    private static final int Inicial = 19;
    private int cima;
    private Vector listaPila;



    public PilaVector(){
        cima = -1;
        listaPila = new Vector(Inicial);
    }

    public boolean isPVacia(){
        return cima == -1;
    }

    public void insertar(Object elemento){
        cima++;
        listaPila.addElement(elemento);
    }

    public Object quitar(){
        Object aux;
        if (isPVacia()){
            System.out.println("Pila vacía, no se puede extraer.");
        }
        aux = listaPila.elementAt(cima);
        listaPila.removeElementAt(cima);
        cima--;
        return aux;
    }

    public Object cimaPila(){
        if (isPVacia()){
            System.out.println("Pila vacía, no se puede extraer.");
        }
        return listaPila.elementAt(cima);
    }

    public void limpiarPila(){
        while (!isPVacia()){
            quitar();
        }
    }


}
