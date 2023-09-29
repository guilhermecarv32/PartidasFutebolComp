package partidas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {

    private static final int TOTAL_DE_PARTIDAS = 10;
    private static final int TOTAL_DE_CHUTES_POR_PARTIDA = 3;

    public static void main(String[] args) {
        Operacoes<Partida, Chute> operacoes = new OperacoesImpl();
        Sensor<Chute> sensor = new SensorImpl();

        Map<Partida, List<Chute>> chutesPorPartida = new TreeMap<>();
        for (int i = 0; i < TOTAL_DE_PARTIDAS; i++) {
            String id = "Partida #" + (i + 1);
            chutesPorPartida.put(new Partida(id), sensor.gerarLeituras(TOTAL_DE_CHUTES_POR_PARTIDA));
        }

        // Testando as operações
        System.out.println("****************************************");
        System.out.println("Dados das Partidas:");
        operacoes.imprimir(new ArrayList<Partida>(chutesPorPartida.keySet()));

        System.out.println("****************************************");
        System.out.println("\nDados dos Chutes por Partida:");
        operacoes.imprimir(chutesPorPartida);
        
        System.out.println("****************************************");
        System.out.println("\nOrdenando os Chutes por Partida:");
        Map<Partida, List<Chute>> chutesOrdenados = operacoes.ordenar(chutesPorPartida);
        operacoes.imprimir(chutesOrdenados);

        List<Chute> padrao = new ArrayList<>();
        padrao.add(new Chute(80, 500, 200)); // Exemplo de um padrão de chute

        double mediaVelocidadesCubico = operacoes.calcularMediaVelocidadesCubico(chutesPorPartida);
        System.out.println("****************************************");
        System.out.println("");
        System.out.println("Média das velocidades: " + mediaVelocidadesCubico);
    }
}
