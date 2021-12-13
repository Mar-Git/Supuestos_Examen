package prueba1.ejercicio2;

public class Contador {
    // He incrementado el máximo porque lo hace muy rápido un solo hilo:
    private final int MAXIMO = 10000000;
    private int contador = 0;

    public synchronized boolean incrementar() {
        boolean incrementado = false;
        if (contador < MAXIMO) {
            contador++;
            incrementado = true;
        }
        return incrementado;
    }
}
