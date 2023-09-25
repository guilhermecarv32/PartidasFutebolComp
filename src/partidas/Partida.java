package partidas;

public class Partida implements Comparable<Partida> {
    private String nome;

    public Partida(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Partida outraPartida) {
        return this.getNome().compareTo(outraPartida.getNome());
    }
}