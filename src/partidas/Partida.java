package partidas;

public class Partida implements Comparable<Partida> {
	
	/*
	classe para simular a coisa monitorada, uma partida de futebol,
	cuja complexidade é constante, O(1)
	*/
	
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
