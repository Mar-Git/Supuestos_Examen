package prueba3.Ejercicio1;

public class HiloEsperador implements Runnable{
    private final int PAUSA_MILISEGUNDOS = 2000;

    public HiloEsperador() {
    }

    @Override
    public void run() {
        hacerPausa();
    }

    private void hacerPausa() {
        try {
            Thread.sleep(PAUSA_MILISEGUNDOS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
