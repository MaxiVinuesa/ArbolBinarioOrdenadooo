package ArbolBinarioOrdenado;

import ArbolBinario.*;

public class Main {


    public static void Insertar(){
        String name1, name2, name3;
        Nodo a1,a2,a;

        Scanner scc = new Scanner(System.in);

        try{
            System.out.println("Ingrese el nombre del SubArbol Izquierdo: \n");
                name1 = scc.nextLine();

            System.out.println("Ingrese el nombre del SubArbol Derecho \n");
                name2 = scc.nextLine();

            System.out.println("Ingrese el nombre del SubArbol Raiz:  \n");
                name3 = scc.nextLine();

                a1 = ArbolBinario.nuevoArbol(null, name1, null);
                a2 = ArbolBinario.nuevoArbol(null, name2, null);
                a = ArbolBinario.nuevoArbol(a1, name3, a2);
                pila.insertar(a);
        } 
        catch (Exception e){
            System.out.println("No se pudo insertar" + e.getCause());
        }
    }


    public static void Buscar(){

        try{
            Estudiante estudianteBuscado;
            Nodo n = ArbolBinarioBusqueda.buscar(new Estudiante(10));

            if ((n != null) && (n.valorNodo() instanceof Estudiante)){
                estudianteBuscado = (Estudiante) n.valorNodo();
                System.out.println("Buscado: " + estudianteBuscado.toString());
            } else {
                System.out.println("Buscado: NO ENCONTRADO");
            }
        } catch (Exception e) {
            System.out.println("Error al Buscar! " + e.getMessage());
        }

        try{
            arbolBinarioBusqueda.eliminar(new Estudiante(15));
        }catch(Exception e){
            System.out.println("Error al Eliminar! " + e.getMessage());
        }

    }

    public static void Recorrido(){
        try {
            //Recorrido
            System.out.println("\nPreorden");
            ArbolBinario.preorden(arbolBinarioBusqueda.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            //Recorrido
            System.out.println("\nInorden");
            ArbolBinario.inorden(arbolBinarioBusqueda.raizArbol());
            

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
        
        try {
            System.out.println("\nPostorden");
            ArbolBinario.postorden(arbolBinarioBusqueda.raizArbol());

        } catch (Exception e) {
            System.out.println("Error al recorrer! " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int opc;
        Scanner scc = new Scanner(System.in);
        
        System.out.println("Bienvenido!\n");


        do{
            System.out.println("Insertar\n");
            System.out.println("2) Buscar / Eliminar\n");
            System.out.println("3) Mostrar Recorridos\n");
            opc = scc.nextLine();


            switch (opc){

                case 1:
                    Insertar();
                    break;

                case 2:
                    Buscar();
                    break;

                case 3:
                    Recorrido();
                    break;
            }


        }while(opc == 5);

    }

}
