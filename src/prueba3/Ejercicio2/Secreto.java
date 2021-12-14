package prueba3.Ejercicio2;

import java.util.Random;

public class Secreto {

    private int numeroAleatorio=0;
    private final int MAXIMO_ALEATORIO=1000;
    private boolean isAcertado;

    public Secreto() {
        this.numeroAleatorio = aleatorio();
        this.isAcertado=false;
    }

    public synchronized int adivinar(int numero){
        int numAcertado=0;
        //si una vez que ya se ha acertado el numero vuelve a acertarlo entonces devuelve -1
        if(numero==numeroAleatorio) {
            numAcertado = 1;
            if(isAcertado){
                numAcertado=-1;
            }
            isAcertado=true;
        }
        return numAcertado;
    }

    private int aleatorio(){
        Random random =new Random();
        return (int) (random.nextDouble() * MAXIMO_ALEATORIO);
    }
}
