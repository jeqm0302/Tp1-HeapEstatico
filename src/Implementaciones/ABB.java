package Implementaciones;

import Interfaces.ArbolesTDA;

public class ABB implements ArbolesTDA {
    class NodoABB {
        int info;
        ArbolesTDA hijoIzq;
        ArbolesTDA hijoDer;
    }
    
    NodoABB raiz;

    @Override
    public void inicializarArbol() {
        raiz = null; 
    }

    @Override
    public void agregarelem(int x) {
        if (raiz == null){
			raiz = new NodoABB();
			raiz.info = x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.inicializarArbol();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.inicializarArbol();
		} else if (raiz.info > x ) {
			raiz.hijoIzq.agregarelem(x);
		} else if (raiz.info < x) {
			raiz.hijoDer.agregarelem(x);
		}
    }

    @Override
    public void eliminarElem(int x) {
       if (raiz != null) {
			if (raiz.info == x && raiz.hijoIzq.arbolesVacio() && raiz.hijoDer.arbolesVacio()) {
				raiz = null;
			} else if (raiz.info == x && !raiz.hijoIzq.arbolesVacio()) {
				raiz.info = this.mayor(raiz.hijoIzq);
				raiz.hijoIzq.eliminarElem(raiz.info);
			} else if (raiz.info == x && raiz.hijoIzq.arbolesVacio()) {
				raiz.info = this.menor(raiz.hijoDer);
				raiz.hijoDer.eliminarElem(raiz.info);
			} else if (raiz.info < x) {
				raiz.hijoDer.eliminarElem(x);
			} else {
				raiz.hijoIzq.eliminarElem(x);
			}
		}
    }

    @Override
    public int raiz() {
        return raiz.info;
    }

    @Override
    public boolean arbolesVacio() {
        return (raiz == null);
    }

    @Override
    public ArbolesTDA hijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public ArbolesTDA hijoDer() {
        return raiz.hijoDer;
    }

    private int mayor(ArbolesTDA a){
		if (a.hijoDer().arbolesVacio())
			return a.raiz();
		else
			return mayor(a.hijoDer());
		}
    
    private int menor(ArbolesTDA a){
		if (a.hijoIzq().arbolesVacio())
			return a.raiz();
		else
			return mayor(a.hijoIzq());
		}
    

}
