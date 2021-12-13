package prueba1.ejercicio2;
import java.util.ArrayList;
import java.util.List;

public class MainEjercicio2 {
    private static final int NUMERO_HILOS = 10;

    public static void main(String[] args) {
        List<Thread> hilos = crear();
        iniciar(hilos);
    }

    private static List<Thread> crear() {
        Contador contador = new Contador();
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloIncrementador(contador)));
        }
        return hilos;
    }

    private static void iniciar(List<Thread> hilos) {
        for (Thread hilo :
                hilos) {
            hilo.start();
        }
    }
}
