package ArbolBinario;
import java.util.Scanner;

public class App {

    
    public static void main(String[] args) throws Exception {
        
        int lugar = 0, control = 1, bandera=0;
        String name1, name2, name3;

        Scanner scc = new Scanner(System.in);
        ArbolBinario arbol = null;
        Nodo a1,a2,a;
        PilaVector pila = new PilaVector();


        while (control == 1){
            //1er ciclo...
            System.out.println("Ingrese el nombre del SubArbol Izquierdo: \n");
                name1 = scc.nextLine();

            System.out.println("Ingrese el nombre del SubArbol Derecho \n");
                name2 = scc.nextLine();

            System.out.println("Ingrese el nombre del SubArbol Raiz:  \n");
                name3 = scc.nextLine();

                bandera = 1;

                a1 = ArbolBinario.nuevoArbol(null, name1, null);
                a2 = ArbolBinario.nuevoArbol(null, name2, null);
                a = ArbolBinario.nuevoArbol(a1, name3, a2);
                pila.insertar(a);

                //2do ciclo...1

            System.out.println("Ingrese el nombre del SubArbol Izquierdo: \n");
               name1 = scc.nextLine();
//
           System.out.println("Ingrese el nombre del SubArbol Derecho \n");
              name2 = scc.nextLine();
//
           System.out.println("Ingrese el nombre del SubArbol Raiz:  \n");
                name3 = scc.nextLine();

                a1 = ArbolBinario.nuevoArbol(null, name1, null);
                a2 = ArbolBinario.nuevoArbol(null, name2, null);
                a = ArbolBinario.nuevoArbol(a1, name3, a2);
                pila.insertar(a);

                //3er ciclo...

                a2 = (Nodo) pila.quitar();
                a1 = (Nodo) pila.quitar();
                a = ArbolBinario.nuevoArbol(a1, name3, a2);
                arbol = new ArbolBinario(a);

                ArbolBinario.preOrden(arbol.getRaiz());
                System.out.println("------");
                ArbolBinario.inOrden(arbol.getRaiz());
                System.out.println("------");
                ArbolBinario.postOrden(arbol.getRaiz());

                lugar = lugar + 1;

                System.out.println("¿Usted quiere seguir cargando elementos?\n");
                System.out.println("1) Si.\n");
                System.out.println("2) No.\n");
                control = scc.nextInt();
                scc.nextLine();

                if (control == 2){
                    break;
                }
        }


    }
}
