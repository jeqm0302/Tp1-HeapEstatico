package implementaciones;

import interfaces.HeapTDA;

// El cálculo de costos se realizó con esta implementación

public class MaxHeapE implements HeapTDA {

    int[] heap;
    int cant;
    int tamLimite;

    // Costo de O(1) ya que se realizan operaciones de O(1) y su suma es el mismo costo
    public void inicializarHeap() {
        tamLimite = 20;
        heap = new int[tamLimite + 1]; // Se asigna una cantidad de valores limite al heap
        cant = 0; // Heap vacío
    }

    // Costo de O(log n) (ya que usa heapifyUp(), si no sería de O(1))
    public void insertar(int valor) {
        if (cant == tamLimite) {
            System.out.println("Limite del heap alcanzado");
            return;
        }

        cant++; // Se suma 1 a la cantidad de elementos en el heap
        heap[cant] = valor; // Se asigna el valor al elemento del tamaño actual
        
        heapifyUp(); // Se asegura de que el elemento se mueva hacia arriba hasta que sea mayor que su padre
    }
    
    // Costo de O(1) ya que se realizan operaciones de O(1) y su suma es el mismo costo
    public int raiz() { // Se devuelve el valor de la raíz (en este caso el máximo). Si el heap esta vacío, se devuelve -1 
        if (cant == 0) {
            return -1;
        }
        return heap[1];
    }

    // Costo de O(log n) (ya que usa heapifyDown(), si no sería de O(1))
    public void quitar() {
        if (cant == 0) {return;}

        heap[1] = heap[cant];
        cant--; // Se reduce el tamaño del heap
        heapifyDown(); // Se ordena para que se restaure la propiedad de max-heap, asegurando que el elemento sea más grande que sus hijos.
    }

    // Costo de O(1) ya que se realizan operaciones de O(1) y su suma es el mismo costo
    public int padre(int indice) {
        if (indice <= 1 || indice > cant) { return -1; }
        int padreInd = indice / 2; // Calcular el índice del padre
        return heap[padreInd]; // Se devuelve el valor del padre
    }
    
    // Costo de O(1) ya que se realizan operaciones de O(1) y su suma es el mismo costo
    public int hijoIzq(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2; // Calcular el índice del hijo izquierdo
        if (hijo > cant) { return -1; }
        return heap[hijo]; // Se devuelve el valor del hijo izquierdo
    }
    
    // Costo de O(1) ya que se realizan operaciones de O(1) y su suma es el mismo costo
    public int hijoDer(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2 + 1; // Calcular el índice del hijo derecho
        if (hijo > cant) { return -1; }
        return heap[hijo]; // Se devuelve el valor del hijo derecho
    } 
    
    // Costo de O(1) ya que realiza solo una operación de O(1)
    public boolean heapVacio() {
        return (cant == 0); // Solo devuelve true si no hay elementos en el heap
    }
    
    // Costo de O(1) ya que realiza solo una operación de O(1)
    public int tamaño() {
        return cant; // Devuelve la cantidad que se incrementa solo cuando se insertan valores
    } 

    // Costo de O(n) ya que se realizan "n" iteraciones siendo "n" la cantidad de elementos del heap
    public void mostrarHeap() {
        for (int i = 1; i <= cant; i++) {
            System.out.println("[" + i + "] " + heap[i]);
        }
    }

    // Metodos privados que son necesarios para los públicos 

    // Costo de O(log n) ya que, en el peor de los casos,  se recorre el árbol binario completo, siendo log "n" su altura 
    private void heapifyUp() { // Se asegura de que el elemento se mueva hacia arriba hasta que sea mayor que su padre
        int indice = cant;

        while (indice > 1) { // Se recorre el heap hacia arriba desde el elemento recién insertado
            int padreInd = indice / 2; // Se obtiene el indice del padre
    
            if (heap[indice] > heap[padreInd]) { // Se entra al if si el valor del hijo es mayor al del padre y se intercambian
                int aux = heap[indice];
                heap[indice] = heap[padreInd];
                heap[padreInd] = aux;
                indice = padreInd; // El elemento ahora está en la posición del padre, seguimos comparando hacia arriba
            } else {
                break; // Si el elemento ya no es mayor que su padre, el heap ya está ordenado
            }
        }
    }

    // Costo de O(log n) ya que, en el peor de los casos,  se recorre desde la raíz del arbol binario hasta una hoja, siendo log "n" su altura 
    private void heapifyDown() { // Se ordena para que se restaure la propiedad de max-heap, asegurando que el elemento sea más grande que sus hijos.
        int indice = 1;  // Se comienza en la raíz 
        
        while (indice <= cant / 2) {  // Mientras el elemento tenga hijos
            int hijoIzq = indice * 2;  // Índice del hijo izquierdo
            int hijoDer = indice * 2 + 1;  // Índice del hijo derecho
            
            int mayor = hijoIzq; // Se busca el hijo más grande
            if (hijoDer <= cant && heap[hijoDer] > heap[hijoIzq]) {
                mayor = hijoDer;
            }
            
            if (heap[indice] >= heap[mayor]) { // Si el valor del elemento es mayor o igual que el de su hijo más grande, se termina
                break;
            }
            
            int aux = heap[indice]; // Si no, se intercambian
            heap[indice] = heap[mayor];
            heap[mayor] = aux;
            
            indice = mayor; // El nuevo elemento a comprobar es el del anteriormente hijo que subió en el árbol binario
        }
    }
}