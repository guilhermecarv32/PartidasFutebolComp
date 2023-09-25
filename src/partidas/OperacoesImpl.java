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
    public boolean procurarPadrao(Map<Partida, List<Chute>> chutesPorPartida, List<Chute> padrao) {
        int totalDeIguais = 0;

        inicioDeProcura:
        for (Partida partida : chutesPorPartida.keySet()) {
            List<Chute> chutes = chutesPorPartida.get(partida);
            for (int i = 0; i < chutes.size() - padrao.size(); i++) {
                for (int j = 0; j < padrao.size(); j++) {
                    Chute chuteAtual = chutes.get(i + j);
                    Chute chutePadrao = padrao.get(j);
                    if (chuteAtual.getVelocidade() == chutePadrao.getVelocidade() &&
                        chuteAtual.getRPM() == chutePadrao.getRPM() &&
                        chuteAtual.getForca() == chutePadrao.getForca()) {
                        totalDeIguais++;

                        if (totalDeIguais == padrao.size()) {
                            break inicioDeProcura;
                        }
                    } else {
                        totalDeIguais = 0;
                        break;
                    }
                }
            }
        }

        return (totalDeIguais == padrao.size());
    }
}