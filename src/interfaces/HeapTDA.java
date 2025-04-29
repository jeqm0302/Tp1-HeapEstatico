package interfaces;

public interface HeapTDA { // Solo trabaja con numeros enteros
    void inicializarHeap(); // Inicializa variables y nodos
    void insertar(int valor); // Agrega un numero en el heap
    int raiz(); // Devuelve el máximo o el mínimo de un heap (según que se este usando)
    void quitar(); // Elimina la raíz de un heap (puede ser máximo o mínimo)
    int padre(int indice); // Devuelve el valor del padre de dicho índice
    int hijoIzq(int indice); // Devuelve el valor del hijo izquierdo de dicho índice
    int hijoDer(int indice); // Devuelve el valor del hijo derecho de dicho índice
    boolean heapVacio(); // Verifica si el heap está vacío
    int tamaño(); // Devuelve la cantidad de elementos
    void mostrarHeap(); // Mostrar todos los elementos del heap
}