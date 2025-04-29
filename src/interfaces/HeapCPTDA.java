package interfaces;

// Adaptación para insertar colas con prioridad con un Max Heap Estático

public interface HeapCPTDA { // Solo trabaja con numeros enteros
    void inicializarHeap(); // Inicializa variables y array
    void insertar(int valor, int prioridad); // Agrega un número y su prioridad en el heap
    int raiz(); // Devuelve el máximo 
    void quitar(); // Elimina el máximo
    int padre(int indice); // Devuelve el valor del padre de dicho índice
    int hijoIzq(int indice); // Devuelve el valor del hijo izquierdo de dicho índice
    int hijoDer(int indice); // Devuelve el valor del hijo derecho de dicho índice
    boolean heapVacio(); // Verifica si el heap está vacío
    int tamaño(); // Devuelve la cantidad de elementos
    void mostrarHeap(); // Mostrar todos los elementos del heap
}