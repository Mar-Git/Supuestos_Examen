package prueba3.Ejercicio1;

import prueba1.ejercicio1.HiloFactorial;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMERO_HILOS = 10;

    public static void main(String[] args) {
        List<Thread> hilos = crear();
        iniciar(hilos);
        if(!esperarFinalización(hilos)){
            System.out.println("Hilos finalizados.");
        }
        else{
            System.out.println("Hilos demasiado lentos");
        }
    }

    private static List<Thread> crear() {
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloEsperador()));
        }
        return hilos;
    }

    private static void iniciar(List<Thread> hilos) {
        for (Thread hilo :hilos) {
            hilo.start();
        }
    }

    private static boolean esperarFinalización(List<Thread> hilos) {
        boolean isVivo=false;
        for (Thread hilo : hilos) {
            try {
                hilo.join(1000);
                isVivo=isVivo||hilo.isAlive();//actualiza isVivo a true si algun hilo no ha finalizado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isVivo;
    }
}
