package prueba3.Ejercicio2;

import prueba2.ejercicio2.Comunicacion;
import prueba2.ejercicio2.HiloComunicador;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUMERO_HILOS=10;

    public static void main(String[] args) {
        List<Thread> hilos=crearHilos();
        iniciarHilos(hilos);
    }

    private static List<Thread> crearHilos(){
        Secreto secreto=new Secreto();
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloAdivinador(secreto)));
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
