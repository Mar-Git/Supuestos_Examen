package prueba1.ejercicio2;

public class HiloIncrementador implements Runnable{
    private int incrementos = 0;
    private final Contador contador;

    public HiloIncrementador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        while (contador.incrementar()) {
            incrementos++;
        }
        System.out.println(String.format("El número de incrementos realizados es %d",
                incrementos));
    }
}
