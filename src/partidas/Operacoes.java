package partidas;

import java.util.List;
import java.util.Map;

public interface Operacoes<K, V> {
    void imprimir(List<K> monitorados);

    void imprimir(Map<K, List<V>> leituras);

    Map<K, List<V>> ordenar(Map<K, List<V>> leituras);

    public double calcularMediaVelocidadesCubico(Map<Partida, List<Chute>> leituras);
}
