import Implementaciones.AABB;
import Interfaces.ArbolesTDA;


public class prueba {
    
    public static void preOrder(ArbolesTDA a) {
		if(!a.arbolVacio()) {
			System.out.print(a.raiz() + " ");
			preOrder(a.hijoIzq());
			preOrder(a.hijoDer());
		}
	}
	
	public static void inOrder(ArbolesTDA a) {
		if(!a.arbolVacio()) {
			inOrder(a.hijoIzq());
			System.out.print(a.raiz() + " ");
			inOrder(a.hijoDer());
		}
	}
	
	public static void postOrder(ArbolesTDA a) {
		if(!a.arbolVacio()) {
			postOrder(a.hijoIzq());
			postOrder(a.hijoDer());
			System.out.print(a.raiz() + " ");
		}
	}
    public static void main(String[] args) {
       ArbolesTDA arbol = new ABB();
		arbol.inicializarArbol();
		arbol.agregarElem(17);
		arbol.agregarElem(8);
		arbol.agregarElem(48);
		arbol.agregarElem(27);
		arbol.agregarElem(55);
		arbol.agregarElem(22);
		arbol.agregarElem(39);
		arbol.agregarElem(35);
		arbol.agregarElem(40);
		
		preOrder(arbol);
		System.out.println();
		inOrder(arbol);
		System.out.println();
		postOrder(arbol); 
    }

}
