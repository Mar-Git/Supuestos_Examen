package prueba2.ejercicio1;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {

    private static final int NUMERO_HILOS=10;
    private static final int LONGITUD_VECTOR=1000;

    public static void main(String[] args) {
        //crear vector, si hay que poner 10 vectores haria una lista de vectores y le daria uno a c/hilo
        double[] vector= crearVector();
        List<Thread>hilos=crearHilos(vector);
        iniciarHilos(hilos);
        esperarFinalización(hilos);
        System.out.println("Hilos Finalizados");
    }
    private static double[] crearVector(){
        double[] vector=new double[LONGITUD_VECTOR];
        Random random=new Random();
        for (int i = 0; i < LONGITUD_VECTOR; i++) {
            vector[i]=random.nextDouble();//da un valor entre 0 y 1
        }
        return vector;
    }
    private static List<Thread> crearHilos(double[] vector){
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new HiloMediaVector(vector)));
        }
        return hilos;
    }
    private static void iniciarHilos(List<Thread> hilos) {
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
