package prueba2.ejercicio2;

import prueba2.ejercicio1.HiloMediaVector;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMERO_HILOS=10;
    public static final int NUMERO_MENSAJES=3;

    public static void main(String[] args) {
        List<Thread>hilos=crearHilos();
        iniciarHilos(hilos);
    }

    private static List<Thread> crearHilos(){
        Comunicacion comunicacion=new Comunicacion();
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloComunicador(comunicacion,i)));
        }
        return hilos;
    }
    private static void iniciarHilos(List<Thread> hilos) {
        for (Thread hilo :
                hilos) {
            hilo.start();
        }
    }
}
