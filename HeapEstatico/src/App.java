

public class App {
    private int[] heap;
    private int tamaño;
    private static final int CAPACIDAD = 10; // Tamaño fijo del heap

    public App() {
        heap = new int[CAPACIDAD];
        tamaño = 0;
    }

    private void heapifyUp(int index) {
        int padre = (index - 1) / 2;
        if (index > 0 && heap[index] > heap[padre]) {
            intercambiar(index, padre);
            heapifyUp(padre);
        }
    }


    private void heapifyDown(int index) {
        int izquierda = 2 * index + 1;
        int derecha = 2 * index + 2;
        int mayor = index;

        if (izquierda < size && heap[izquierda] > heap[mayor]) mayor = izquierda;
        if (derecha < size && heap[derecha] > heap[mayor]) mayor = derecha;

        if (mayor != index) {
            intercambiar(index, mayor);
            heapifyDown(mayor);
        }
    }

    private void intercambiar(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insertar(int valor) {
        if (tamaño < CAPACIDAD) {
            heap[tamaño] = valor;
            heapifyUp(tamaño);
            tamaño++;
        } else {
            System.out.println("Heap lleno, no se pueden insertar más elementos.");
        }
    }
    
    public int extraerMax() {
        if (size == 0) return -1;
        int maximo = heap[0];
        heap[0] = heap[--size];
        heapifyDown(0);
        return maximo;
    }

    public void mostrar() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();i 
    }

    public static void main(String[] args) {
        App heap = new App();
        heap.insertar(10);
        heap.insertar(20);
        heap.insertar(5);
        heap.insertar(30);
        heap.mostrar();

        System.out.println("Elemento máximo extraído: " + heap.extraerMax());
        heap.mostrar();
    }
    
}
