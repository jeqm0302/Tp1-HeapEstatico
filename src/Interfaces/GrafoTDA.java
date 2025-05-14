package Interfaces;

public interface GrafoTDA {
	void inicializarGrafo();					
	ConjuntoTDA vertices();			
	void agregarArista(int origen, int destino, int peso);				
	boolean existeArista(int origen, int destino);			
	int pesoArista(int origen, int destino);
}

