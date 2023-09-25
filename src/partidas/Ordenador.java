package partidas;

import java.util.List;

public abstract class Ordenador<T> {
    protected List<T> leituras = null;

    public Ordenador(List<T> leituras) {
        this.leituras = leituras;
    }

    public abstract void ordenar();
}