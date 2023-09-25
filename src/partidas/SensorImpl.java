package partidas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SensorImpl implements Sensor<Chute> {

    private static final int VELOCIDADE_MEDIA = 80;
    private static final int RPM_MEDIO = 500;
    private static final int FORCA_MEDIA = 200;
    private static final int OSCILACAO_MAXIMA = 10;

    @Override
    public List<Chute> gerarLeituras(int totalLeituras) {
        List<Chute> leituras = new ArrayList<>();

        Random randomizador = new Random();
        for (int i = 0; i < totalLeituras; i++) {
            int oscilacaoVelocidade = VELOCIDADE_MEDIA * randomizador.nextInt(OSCILACAO_MAXIMA) / 100;
            int oscilacaoRPM = RPM_MEDIO * randomizador.nextInt(OSCILACAO_MAXIMA) / 100;
            int oscilacaoForca = FORCA_MEDIA * randomizador.nextInt(OSCILACAO_MAXIMA) / 100;

            int velocidade = (randomizador.nextBoolean() ? VELOCIDADE_MEDIA + oscilacaoVelocidade : VELOCIDADE_MEDIA - oscilacaoVelocidade);
            int rpm = (randomizador.nextBoolean() ? RPM_MEDIO + oscilacaoRPM : RPM_MEDIO - oscilacaoRPM);
            int forca = (randomizador.nextBoolean() ? FORCA_MEDIA + oscilacaoForca : FORCA_MEDIA - oscilacaoForca);

            Chute leitura = new Chute(velocidade, rpm, forca);
            leituras.add(leitura);
        }

        return leituras;
    }
}