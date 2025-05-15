package Interfaces;

public interface ArbolesTDA {
    void inicializarArbol();
    void agregarelem(int x);
    void eliminarElem(int x);
    int raiz();
    boolean arbolesVacio();
    ArbolesTDA hijoIzq();
    ArbolesTDA hijoDer();
}
