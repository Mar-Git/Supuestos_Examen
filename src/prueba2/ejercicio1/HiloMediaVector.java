package prueba2.ejercicio1;

public class HiloMediaVector implements Runnable{

    private double[] vector;

    public HiloMediaVector(double[] vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        double media=calcularMedia();
        System.out.printf("La media es %f",media);
    }

    private double calcularMedia(){
        double media, aux=0.0;
        for(int i=0; i<vector.length; i++){
            aux+=vector[i];
        }
        media=aux/vector.length;
        return media;
    }
}
