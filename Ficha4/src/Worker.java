import java.lang.reflect.Array;
import java.util.ArrayList;

public class Worker {
    SynchronizedArrayList frases;
    int numero;

    public Worker(SynchronizedArrayList f, int n){
        super();
        this.frases= f;
        this.numero = n;
    }

    public void run(){
        for (int i = 0; i<5; i++){
            frases.add("Frase "+i+" da thread "+ numero);
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "frases=" + frases +
                '}';
    }
}
