import interfaces.HeapCPTDA;

import implementaciones.ColaPrioridad;

public class ColaConPrioridad {
    public static void main(String[] args) throws Exception {
        HeapCPTDA ColaP = new ColaPrioridad();

        ColaP.inicializarHeap();
        System.out.println("Vacio: " + ColaP.heapVacio());
        ColaP.insertar(5, 6);
        ColaP.insertar(10, 4);
        ColaP.insertar(3, 5);
        ColaP.insertar(9, 3);
        ColaP.insertar(15, 1);
        ColaP.insertar(12, 2);

        System.out.println("");

        System.out.println("Tamaño: " + ColaP.tamaño());
        System.out.println("Raíz: " + ColaP.raiz());

        System.out.println("");

        ColaP.mostrarHeap();
                
        System.out.println("");

        System.out.println("Vacio: " + ColaP.heapVacio());

        System.out.println("");

        ColaP.quitar();
        System.out.println("Quitando la raiz:");
        System.out.println("");

        System.out.println("Tamaño: " + ColaP.tamaño());
        System.out.println("Raíz: " + ColaP.raiz());
        System.out.println("");
        ColaP.mostrarHeap();

        System.out.println("");

        System.out.println("Valor del hijo izquierdo del indice 2: " + ColaP.hijoIzq(2));
        System.out.println("Valor del hijo derecho del indice 1: " + ColaP.hijoDer(1));
        System.out.println("Valor del padre del indice 5: " + ColaP.padre(5));
    }
}