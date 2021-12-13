package prueba1.ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MainEjercicio1 {

    private static final int NUMERO_HILOS = 10;
    private static final int MAXIMO_ALEATORIO = 20;

    public static void main(String[] args) {
        List<Thread> hilos = crear();
        iniciar(hilos);
        esperarFinalización(hilos);
        System.out.println("Hilos finalizados.");
    }

    private static List<Thread> crear() {
        Random random = new Random();
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloFactorial((int) (random.nextDouble() * MAXIMO_ALEATORIO))));
        }
        return hilos;
    }

    private static void iniciar(List<Thread> hilos) {
        for (Thread hilo :
                hilos) {
            hilo.start();
        }
    }

    private static void esperarFinalización(List<Thread> hilos) {
        for (Thread hilo :
                hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
