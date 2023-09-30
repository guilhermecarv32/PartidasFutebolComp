package partidas;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OperacoesImpl implements Operacoes<Partida, Chute> {

	/*
     * retorna as partidas
     * 
     * a complexidade deste metodo é linear, O(N), porque o total de passos de execução
     * cresce linearmente em relação ao tamanho da entrada de dados(total de partidas)
     */
	
    @Override
    public void imprimir(List<Partida> partidas) {
        for (Partida partida : partidas) {
            System.out.println(partida);
        }
    }

    /**
     * retorna as informações dos chutes de cada partida
     * 
     * a complexidade é quadrática, O(N^2), porque existe um loop aninhado em
     * um mais externo
     */
    
    @Override
    public void imprimir(Map<Partida, List<Chute>> chutesPorPartida) {
        for (Partida partida : chutesPorPartida.keySet()) {
        	System.out.println();
            System.out.println("Chutes na partida: " + partida.getNome());
            System.out.println();
            for (Chute chute : chutesPorPartida.get(partida)) {
                System.out.println(chute);
            }
        }
    }
    
    /**
     * ordena os chutes de cada partida com base na velocidade
     * 
     * a complexidade deste metodo é, N^2LOGN, porque existe um loop neste metodo,
     * mas ele realiza uma chamada ao algoritmo de ordenacao cuja complexidade é
     * NLogN
     */

    @Override
    public Map<Partida, List<Chute>> ordenar(Map<Partida, List<Chute>> chutesPorPartida) {
        Map<Partida, List<Chute>> chutesOrdenados = new TreeMap<>();

        for (Partida partida : chutesPorPartida.keySet()) {
            List<Chute> chutesParaOrdenar = chutesPorPartida.get(partida);
            Ordenador<Chute> ordenador = new OrdenadorImpl(chutesParaOrdenar);
            ordenador.ordenar();

            chutesOrdenados.put(partida, chutesParaOrdenar);
        }

        return chutesOrdenados;
    }

    /**
     * este método serve para calcular a média das velocidades dos chutes
     * 
     * a complexidade é O(N^3), portanto, cúbica, porque existem 3 loops aninhados
     * 
     * este algoritmo pode tender a ser uma execucao de brute force caso
     * sejam muitas partidas sendo monitoradas e o total de chutes
     * coletados for uma entrada de dados muito grande
     **/
    
    @Override
    public double calcularMediaVelocidades(Map<Partida, List<Chute>> leituras) {
        double somaVelocidades = 0;
        int contador = 0;

        for (Partida partida : leituras.keySet()) {
            List<Chute> leiturasPartida = leituras.get(partida);
            for (Chute chute : leiturasPartida) {
                for (Chute outroChute : leiturasPartida) {
                    somaVelocidades += (chute.getVelocidade() + outroChute.getVelocidade()) / 2;
                    contador++;
                }
            }
        }

        if (contador == 0) {
            return 0;
        }

        return somaVelocidades / contador;
    }

}
