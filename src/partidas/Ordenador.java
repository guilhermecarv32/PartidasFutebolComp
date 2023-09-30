package partidas;

import java.util.List;

public abstract class Ordenador<T> {
	
	/*
	classe que determina as funcionalidades do ordenador, 
	cuja complexidade é constante, O(1)
	*/
	
    protected List<T> leituras = null;

    public Ordenador(List<T> leituras) {
        this.leituras = leituras;
    }

    public abstract void ordenar();
}
