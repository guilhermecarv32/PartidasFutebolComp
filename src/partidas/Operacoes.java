package partidas;

import java.util.List;
import java.util.Map;

public interface Operacoes<K, V> {
	
	//d1
    void imprimir(List<K> monitorados);
    
    //d2
    void imprimir(Map<K, List<V>> leituras);

    //d3
    Map<K, List<V>> ordenar(Map<K, List<V>> leituras);

    //d4
    public double calcularMediaVelocidades(Map<Partida, List<Chute>> leituras);
}
