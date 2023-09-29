package partidas;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OperacoesImpl implements Operacoes<Partida, Chute> {

    @Override
    public void imprimir(List<Partida> partidas) {
        for (Partida partida : partidas) {
            System.out.println(partida);
        }
    }

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

    @Override
    public double calcularMediaVelocidadesCubico(Map<Partida, List<Chute>> leituras) {
        double somaVelocidades = 0;
        int contador = 0;

        for (Partida partida : leituras.keySet()) {
            List<Chute> leiturasPartida = leituras.get(partida);
            for (Chute chute : leiturasPartida) {
                for (Chute outroChute : leiturasPartida) {
                    // Calcula a média das velocidades de todos os pares de chutes
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
