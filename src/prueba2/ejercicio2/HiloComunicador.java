package prueba2.ejercicio2;

public class HiloComunicador implements Runnable{
    private Comunicacion comunicacion;
    private int numHilo;

    public HiloComunicador(Comunicacion comunicacion, int numHilo) {
        this.comunicacion = comunicacion;
        this.numHilo = numHilo;
    }

    @Override
    public void run() {
        String dato;
        for(int i=1; i<=Main.NUMERO_MENSAJES; i++){
            dato=String.format("Datos numero %d del hilo %d",i,numHilo);
            comunicacion.enviar(dato);
        }
    }
}
