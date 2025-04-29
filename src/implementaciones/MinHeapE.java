package implementaciones;

import interfaces.HeapTDA;

public class MinHeapE implements HeapTDA {

    int[] heap;
    int cant;
    int tamLimite;

    public void inicializarHeap() {
        tamLimite = 20;
        heap = new int[tamLimite + 1]; // Se asigna una cantidad de valores limite al heap
        cant = 0; // Heap vacío
    }

    public void insertar(int valor) {
        if (cant == tamLimite) {
            System.out.println("Limite del heap alcanzado");
            return;
        }

        cant++; // Se suma 1 a la cantidad de elementos en el heap
        heap[cant] = valor; // Se asigna el valor al elemento del tamaño actual
        
        heapifyUp(); // Se asegura de que el elemento se mueva hacia arriba hasta que sea menor que su padre
    }
    
    public int raiz() { // Se devuelve el valor de la raíz (en este caso el mínimo). Si el heap esta vacío, se devuelve -1 
        if (cant == 0) {
            return -1;
        }
        return heap[1];
    }

    public void quitar() {
        if (cant == 0) {return;}

        heap[1] = heap[cant];
        cant--; // Se reduce el tamaño del heap
        heapifyDown(); // Se ordena para que se restaure la propiedad de min-heap, asegurando que el elemento sea más pequeño que sus hijos.
    }

    public int padre(int indice) {
        if (indice <= 1 || indice > cant) { return -1; }
        int padreInd = indice / 2; // Calcular el índice del padre
        return heap[padreInd]; // Se devuelve el valor del padre
    }
    
    public int hijoIzq(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2; // Calcular el índice del hijo izquierdo
        if (hijo > cant) { return -1; }
        return heap[hijo]; // Se devuelve el valor del hijo izquierdo
    }
    
    public int hijoDer(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2 + 1; // Calcular el índice del hijo derecho
        if (hijo > cant) { return -1; }
        return heap[hijo]; // Se devuelve el valor del hijo derecho
    } 
    
    public boolean heapVacio() {
        return (cant == 0); // Solo devuelve true si no hay elementos en el heap
    }
    
    public int tamaño() {
        return cant; // Devuelve la cantidad que se incrementa solo cuando se insertan valores
    } 

    public void mostrarHeap() {
        for (int i = 1; i <= cant; i++) {
            System.out.println("[" + i + "] " + heap[i]);
        }
    }

    // Metodos privados que son necesarios para los públicos 

    private void heapifyUp() { // Se asegura de que el elemento se mueva hacia arriba hasta que sea menor que su padre
        int indice = cant;

        while (indice > 1) { // Se recorre el heap hacia arriba desde el elemento recién insertado
            int padreInd = indice / 2; // Se obtiene el indice del padre
    
            if (heap[indice] < heap[padreInd]) { // Se entra al if si el valor del hijo es menor al del padre y se intercambian
                int aux = heap[indice];
                heap[indice] = heap[padreInd];
                heap[padreInd] = aux;
                indice = padreInd; // El elemento ahora está en la posición del padre, seguimos comparando hacia arriba
            } else {
                break; // Si el elemento ya no es menor que su padre, el heap ya está ordenado
            }
        }
    }

    private void heapifyDown() { // Se ordena para que se restaure la propiedad de min-heap, asegurando que el elemento sea más pequeño que sus hijos.
        int indice = 1;  // Se comienza en la raíz 
        
        while (indice <= cant / 2) {  // Mientras el elemento tenga hijos
            int hijoIzq = indice * 2;  // Índice del hijo izquierdo
            int hijoDer = indice * 2 + 1;  // Índice del hijo derecho
            
            int menor = hijoIzq; // Se busca el hijo más pequeño
            if (hijoDer <= cant && heap[hijoDer] < heap[hijoIzq]) {
                menor = hijoDer;
            }
            
            if (heap[indice] <= heap[menor]) { // Si el valor del elemento es menor o igual que el de su hijo más pequeño, se termina
                break;
            }
            
            int aux = heap[indice]; // Si no, se intercambian
            heap[indice] = heap[menor];
            heap[menor] = aux;
            
            indice = menor; // El nuevo elemento a comprobar es el del anteriormente hijo que subió en el árbol binario
        }
    }
}