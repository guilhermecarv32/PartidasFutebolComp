package partidas;

import java.util.ArrayList;
import java.util.List;

public class OrdenadorImpl extends Ordenador<Chute> {

    public OrdenadorImpl(List<Chute> leituras) {
        super(leituras);
    }

    public void ordenar() {
        ordenar(0, leituras.size() - 1);
    }

    public void ordenar(int inicio, int fim) {
        if (inicio < fim && (fim - inicio) >= 1) {
            int meio = (fim + inicio) / 2;

            ordenar(inicio, meio);
            ordenar(meio + 1, fim);

            ordenar(inicio, meio, fim);
        }
    }

    private void ordenar(int inicio, int meio, int fim) {
        List<Chute> leiturasTemp = new ArrayList<>();

        int esquerda = inicio;
        int direita = meio + 1;

        while (esquerda <= meio && direita <= fim) {
            if (leituras.get(esquerda).getVelocidade() <= leituras.get(direita).getVelocidade()) {
                leiturasTemp.add(leituras.get(esquerda));
                esquerda++;
            } else {
                leiturasTemp.add(leituras.get(direita));
                direita++;
            }
        }

        while (esquerda <= meio) {
            leiturasTemp.add(leituras.get(esquerda));
            esquerda++;
        }

        while (direita <= fim) {
            leiturasTemp.add(leituras.get(direita));
            direita++;
        }

        for (int i = 0; i < leiturasTemp.size(); i++) {
            leituras.set(inicio + i, leiturasTemp.get(i));
        }
    }
}