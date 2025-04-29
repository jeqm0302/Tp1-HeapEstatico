import implementaciones.MaxHeapE;
import interfaces.HeapTDA;


// Método HeapSort implementado para MaxHeap Estático

public class Heapsort {

    // Costo de O(n log n) ya que se usan los métodos insertar(int x) y quitar() "n" cantidad de veces. Por lo tanto,
    // y teniendo en cuenta que estos usan los métodos heapifyUp() y heapifyDown() (los cuales tienen costos de O(log n)), 
    // estos costos se suman dando como resultado O(n log n)
    public static void heapSort(int[] arr) {
        
        HeapTDA heap = new MaxHeapE(); 
        heap.inicializarHeap(); // Se crea e inicializa un MaxHeap estatico

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            heap.insertar(num); // Agrega todos los elementos del arreglo en el heap (heapify para verificar que sea MaxHeap)
        }
        
        for (int i = arr.length - 1; i >= 0; i--) { // Extrae las raices y las reinserta en el arreglo
            arr[i] = heap.raiz();
            heap.quitar(); // Quita la raiz y aplica heapifydown para reacomodar el MaxHeap
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 15, 20, 0, 7, 8, 2, 3};
        int cantidad = arr.length;

        System.out.println("");
        System.out.print("Arreglo original: [");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        heapSort(arr);

        System.out.println("");
        System.out.print("Arreglo ordenado: [");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(arr[i]);
            if (i < cantidad - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        }
    }