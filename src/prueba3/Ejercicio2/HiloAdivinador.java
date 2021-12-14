package prueba3.Ejercicio2;

public class HiloAdivinador implements Runnable{

    private Secreto s;

    public HiloAdivinador(Secreto s) {
        this.s = s;
    }

    @Override
    public void run() {
        int contador=0;
        int resultadoAdivinacion=s.adivinar(contador);
        while(resultadoAdivinacion==0){
            contador++;
            resultadoAdivinacion=s.adivinar(contador);
        }
        if(resultadoAdivinacion==1){
            System.out.println("He acertado");
        }
        else{
            System.out.println("Juego Finalizado");
        }
    }
}
