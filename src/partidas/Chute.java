package partidas;

public class Chute {
	
	/*
	classe para simular o valor monitorado, chute,
	cuja complexidade é constante, O(1)
	*/
	
    private int velocidade;
    private int rpm;
    private int forca;

    public Chute(int velocidade, int rpm, int forca) {
        this.velocidade = velocidade;
        this.rpm = rpm;
        this.forca = forca;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getRPM() {
        return rpm;
    }

    public int getForca() {
        return forca;
    }

    @Override
    public String toString() {
        return "Chute [Velocidade = " + velocidade + ", RPM = " + rpm + ", Força = " + forca + "]";
    }
}
