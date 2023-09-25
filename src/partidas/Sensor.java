package partidas;

import java.util.List;

public interface Sensor<T> {
    List<T> gerarLeituras(int totalLeituras);
}