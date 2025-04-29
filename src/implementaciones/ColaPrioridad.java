package implementaciones;

import interfaces.HeapCPTDA;

// Adaptación para insertar colas con prioridad mediante un Max Heap Estático

public class ColaPrioridad implements HeapCPTDA {
    
    // Inicializa todas las variables y clases que vamos a utilizar 
    int[] valores; // Array que almacena los valores
    int[] prioridades; // Array que almacena los numeros de prioridad que tienen cada nro.
    int cant; // Cont. de elementos que tiene el heap 
    int tamLimite; // Tamaño maximo que tiene el heap

    // Metodos a utilizar 
    public void inicializarHeap() { // Es donde se inicializa el heap 
        tamLimite = 20; // Establecemos el tamaño que va a tener el heap 
        valores = new int[tamLimite + 1]; // Asignacion de cant de valores limite al heap
        prioridades = new int[tamLimite + 1]; //  Crea el array para las prioridades
        // tamLimite + 1 Se utiliza para establcecer el indice en 1 y no en cero
        cant = 0; //  Valor inicial del heap (Heap vacío)
    }

    public void insertar(int valor, int prioridad) {
        if (cant == tamLimite) { // En este verifica que la cantidad de elementos que se estan ingresando al heap no 
            // superen el tamaño del heap
            System.out.println("Limite del heap alcanzado");
            // Muestra un mensaje donde (Cant == tamLimite)
            return;
        }

        cant++; // Se suma 1 a la cantidad de elementos en el heap
        valores[cant] = valor; // Se asigna el valor al elemento del tamaño actual
        prioridades[cant] = prioridad; // Se asigna la prioridad de dicho valor a su mismo índice pero en otro array
        
        //Metodo privado que restaura la propiedad del Max heaps
        heapifyUp(); // Se asegura de que el elemento y su prioridad se mueva hacia arriba hasta que sea mayor que su padre
    }
    
    
    public int raiz() { // Se devuelve el valor de la raíz (en este caso el máximo). Si el heap esta vacío, se devuelve -1 
        if (cant == 0) {
            return -1;
        }
        return valores[1];
    }

    public void quitar() {
        if (cant == 0) {return;}

        valores[1] = valores[cant];
        prioridades[1] = prioridades[cant];

        cant--; // Se reduce el tamaño del heap
        heapifyDown(); // Se ordena para que se restaure la propiedad de max-heap, asegurando que la prioridad del elemento sea más grande que sus hijos
    }

    public int padre(int indice) {
        if (indice <= 1 || indice > cant) { return -1; }
        int padreInd = indice / 2; // Calcular el índice del padre
        return valores[padreInd]; // Se devuelve el valor del padre
    }
    
    public int hijoIzq(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2; // Calcular el índice del hijo izquierdo
        if (hijo > cant) { return -1; }
        return valores[hijo]; // Se devuelve el valor del hijo izquierdo
    }
    
    public int hijoDer(int indice) {
        if ( indice <= 0 || indice > cant) { return -1; }
        int hijo = indice * 2 + 1; // Calcular el índice del hijo derecho
        if (hijo > cant) { return -1; }
        return valores[hijo]; // Se devuelve el valor del hijo derecho
    } 
    
    public boolean heapVacio() {
        return (cant == 0); // Solo devuelve true si no hay elementos en el heap
    }
    
    public int tamaño() {
        return cant; // Devuelve la cantidad que se incrementa solo cuando se insertan valores
    } 

    public void mostrarHeap() {
        for (int i = 1; i <= cant; i++) {
            System.out.println("[" + i + "] Número: " + valores[i] + " - Prioridad: " + prioridades[i]);
        }
    }

    // Metodos privados que son necesarios para los públicos 

    private void heapifyUp() { // Se asegura de que el elemento se mueva hacia arriba hasta que sea mayor que su padre segun su prioridad
        int indice = cant;

        while (indice > 1) { // Se recorre el heap hacia arriba desde el elemento recién insertado
            int padreInd = indice / 2; // Se obtiene el indice del padre
    
            if (prioridades[indice] < prioridades[padreInd]) { // Se entra al if si la prioridad del hijo es mayor (en números sería menor) al del padre y se intercambian en ambos arrays
                int aux = valores[indice];
                valores[indice] = valores[padreInd];
                valores[padreInd] = aux;

                aux = prioridades[indice];
                prioridades[indice] = prioridades[padreInd];
                prioridades[padreInd] = aux;

                indice = padreInd; // El elemento ahora está en la posición del padre, seguimos comparando hacia arriba
            } else {
                break; // Si el elemento ya no es mayor que su padre, el heap ya está ordenado
            }
        }
    }

    private void heapifyDown() { // Se ordena para que se restaure la propiedad de max-heap, asegurando que el elemento tenga mayor prioridad que sus hijos.
        int indice = 1;  // Se comienza en la raíz 
        
        while (indice <= cant / 2) {  // Mientras el elemento tenga hijos
            int hijoIzq = indice * 2;  // Índice del hijo izquierdo
            int hijoDer = indice * 2 + 1;  // Índice del hijo derecho
            
            int mayor = hijoIzq; // Se busca el hijo con mayor prioridad (en números sería menor)
            if (hijoDer <= cant && prioridades[hijoDer] < prioridades[hijoIzq]) {
                mayor = hijoDer;
            }
            
            if (prioridades[indice] <= prioridades[mayor]) { // Si la prioridad del elemento es mayor (en números sería menor) o igual que el de su hijo más grande, se termina
                break;
            }
            
            int aux = valores[indice]; // Si no, se intercambian
            valores[indice] = valores[mayor];
            valores[mayor] = aux;

            aux = prioridades[indice];
            prioridades[indice] = prioridades[mayor];
            prioridades[mayor] = aux;
            
            indice = mayor; // El nuevo elemento a comprobar es el del anteriormente hijo que subió en el árbol binario
        }
    }
}