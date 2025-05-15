package Implementaciones;

import Interfaces.ConjuntoTDA;
import Interfaces.GrafoTDA;

public class AlgoritrmoD implements GrafoTDA{

    @Override
    public void inicializarGrafo() {
        
    }

    @Override
    public ConjuntoTDA vertices() {
        return null;
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
    }

    @Override
    public boolean existeArista(int origen, int destino) {
        return false;
        
    }

    @Override
    public int pesoArista(int origen, int destino) {
        return destino;
        
    }



 } 
