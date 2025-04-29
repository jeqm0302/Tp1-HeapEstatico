package implementaciones;

import interfaces.HeapTDA;

public class MaxHeapD implements HeapTDA {
    class Nodo {
        int valor;
        Nodo ant;
        Nodo sig;
    }
    Nodo primero;
    int cant;

    public void inicializarHeap() {
        primero = null; // No existe un primer nodo
        cant = 0; // Heap vacío
    }

    public void insertar(int valor) {
        Nodo nuevo = new Nodo(); // Se crea un nodo para el nuevo valor y se asigna a una variable 
        nuevo.valor = valor; 

        if (primero == null) { // Si el heap esta vacío, el nuevo nodo se asigna como primero
            primero = nuevo;
        } else { // Si no, se recorre todo el heap hasta el final mediante un nodo auxiliar 
            Nodo aux = primero;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = nuevo; // Se enlaza el nuevo nodo
            nuevo.ant = aux;
        }
        cant++; // Se suma 1 a la cantidad de nodos en el heap
        heapifyUp(); // Se asegura de que el nodo se mueva hacia arriba hasta que sea mayor que su padre
    }

    public int raiz() { // Se devuelve el valor de la raíz (en este caso el máximo). Si el heap esta vacío, se devuelve -1 
        if (primero != null) { 
            return primero.valor; 
        }
        return -1;
    }

    public void quitar() {
        if (cant == 0) {
            return; // Si el heap está vacío, no hay nada que quitar
        }
    
        if (cant == 1) { // Si el heap tiene solo un elemento, se elimina y se reduce el tamaño
            primero = null;
            cant--;
            return;
        }
    
        Nodo ultimoNodo = obtenerNodoPorIndice(cant); // Se sobrescribe la raíz con el último nodo insertado 
        primero.valor = ultimoNodo.valor;
    
        if (ultimoNodo == primero) { // En caso de que se sustituya la raíz por el último nodo y el último nodo sea igual al primero (el heap tiene un solo nodo), se deja el heap vacío
            primero = null;
        } else {
            ultimoNodo.ant.sig = null; // Se elimina la referencia desde el nodo anterior al último nodo, desconectando el último nodo de la lista y convirtiendo su anterior en el nuevo último
        }

        cant--; // Se reduce el tamaño del heap
        heapifyDown(); // Se ordena para que se restaure la propiedad de max-heap, asegurando que el nodo sea más grande que sus hijos.
    
    }

    public int padre(int indice) {
        if (indice <= 1 || indice > cant) { return -1; }
        int padreInd = indice / 2; // Calcular el índice del padre
        Nodo aux = obtenerNodoPorIndice(padreInd); // Devuelve el nodo en dicho índice
        if (aux == null) { return -1; }
        return aux.valor; // Se devuelve el valor del nodo
    }
    
    public int hijoIzq(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2; // Calcular el índice del hijo izquierdo
        Nodo aux = obtenerNodoPorIndice(hijo); // Devuelve el nodo en dicho índice
        if (aux == null) { return -1; }
        return aux.valor; // Se devuelve el valor del nodo
    }
    
    public int hijoDer(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2 + 1; // Calcular el índice del hijo derecho
        Nodo aux = obtenerNodoPorIndice(hijo); // Devuelve el nodo en dicho índice
        if (aux == null) { return -1; }
        return aux.valor; // Se devuelve el valor del nodo
    } 

    public boolean heapVacio() {
        return (cant == 0); // Solo devuelve true si no hay elementos en el heap
    }
    
    public int tamaño() {
        return cant; // Devuelve la cantidad que se incrementa solo cuando se insertan nodos
    } 

    public void mostrarHeap() {
        Nodo aux = primero;
        int pos = 1;
        while (aux != null) { // Se crea un nodo auxiliar que recorre el heap completo
            System.out.println("[" + pos + "] " + aux.valor); // Muestra cada valor con su respectivo índice
            aux = aux.sig;
            pos++;
        }
    }
    
    // Metodos privados que son necesarios para los públicos 

    private void heapifyUp() { // Se asegura de que el nodo se mueva hacia arriba hasta que sea mayor que su padre
        int indice = cant;

        while (indice > 1) { // Se recorre el heap hacia arriba desde el nodo recién insertado
            int padreInd = indice / 2; // Se obtiene el indice del padre
            Nodo nodo = obtenerNodoPorIndice(indice);
            Nodo padre = obtenerNodoPorIndice(padreInd);
    
            if (nodo.valor > padre.valor) { // Se entra al if si el valor del hijo es mayor al del padre y se intercambian
                int aux = nodo.valor;
                nodo.valor = padre.valor;
                padre.valor = aux;
                indice = padreInd; // El nodo ahora está en la posición del padre, seguimos comparando hacia arriba
            } else {
                break; // Si el nodo ya no es mayor que su padre, el heap ya está ordenado
            }
        }
    }

    private void heapifyDown() { // Se ordena para que se restaure la propiedad de max-heap, asegurando que el nodo sea más grande que sus hijos.
        int indice = 1;  // Se comienza en la raíz 
        
        while (indice <= cant / 2) {  // Mientras el nodo tenga hijos
            int hijoIzq = indice * 2;  // Índice del hijo izquierdo
            int hijoDer = indice * 2 + 1;  // Índice del hijo derecho
            
            int mayor = hijoIzq; // Se busca el hijo más grande
            if (hijoDer <= cant && obtenerNodoPorIndice(hijoDer).valor > obtenerNodoPorIndice(hijoIzq).valor) {
                mayor = hijoDer;
            }
            
            if (obtenerNodoPorIndice(indice).valor >= obtenerNodoPorIndice(mayor).valor) { // Si el valor del nodo es mayor o igual que el de su hijo más grande, se termina
                break;
            }
            
            Nodo nodo = obtenerNodoPorIndice(indice); // Si no, se intercambia el valor del nodo con el de su hijo más grande
            Nodo hijo = obtenerNodoPorIndice(mayor);
            
            int aux = nodo.valor;
            nodo.valor = hijo.valor;
            hijo.valor = aux;
            
            indice = mayor; // El nuevo nodo a comprobar es el del anteriormente hijo que subió en el árbol binario
        }
    }

    private Nodo obtenerNodoPorIndice(int indice) { // Se devuelve un tipo nodo
        Nodo aux = primero; 
        int cont = 1;
        while (cont < indice && aux != null) { // Se incrementa un contador hasta que este sea igual al indice
            aux = aux.sig; // Se itera nodo por nodo hasta encontrar el esperado
            cont++;
        }
        return aux; // Se devuelve el nodo esperado
    }
}