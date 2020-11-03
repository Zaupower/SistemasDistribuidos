package sample;

public class Bicicleta {
    int nrRodas = 4;
    String marca = "Scott";

    public Bicicleta(int nrRodas, String marca) {
        this.nrRodas = nrRodas;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "nrRodas=" + nrRodas +
                ", marca='" + marca + '\'' +
                '}';
    }
}
