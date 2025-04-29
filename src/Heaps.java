import interfaces.HeapTDA;
import implementaciones.MaxHeapD;
import implementaciones.MinHeapD;
import implementaciones.MinHeapE;
import implementaciones.MaxHeapE;

public class Heaps {
    public static void main(String[] args) throws Exception {
        //HeapTDA heap = new MinHeapD();
        HeapTDA heap = new MaxHeapD();
        //HeapTDA heap = new MinHeapE();
        //HeapTDA heap = new MaxHeapE();

        heap.inicializarHeap();
        System.out.println("Vacio: " + heap.heapVacio());
        heap.insertar(5);
        heap.insertar(10);
        heap.insertar(3);
        heap.insertar(9);
        heap.insertar(15);
        heap.insertar(12);

        System.out.println("");

        System.out.println("Tamaño: " + heap.tamaño());
        System.out.println("Raíz: " + heap.raiz());

        System.out.println("");

        heap.mostrarHeap();
                
        System.out.println("");

        System.out.println("Vacio: " + heap.heapVacio());

        System.out.println("");

        heap.quitar();
        System.out.println("Quitando la raiz:");
        System.out.println("");

        System.out.println("Tamaño: " + heap.tamaño());
        System.out.println("Raíz: " + heap.raiz());
        System.out.println("");
        heap.mostrarHeap();

        System.out.println("");

        System.out.println("Hijo izquierdo de indice 2: " + heap.hijoIzq(2));
        System.out.println("Hijo derecho de indice 1: " + heap.hijoDer(1));
        System.out.println("Padre de indice 5: " + heap.padre(5));
    }
}
