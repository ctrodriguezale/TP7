
package Model;


public class EVLlegada implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVLlegada();

        return evento;
    }

    public String getNombre(){return "Llegada";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        Buque nuevo = new Buque(aActual.proximoIDBuque());

        aActual.setEvento(this);
        aActual.setReloj(aAnterior.getProximaLlegada());

        //calculamos atributos propios del evento
        generarProximaLlegada(aActual);

        //Defino destino
        if (!aActual.iniciarCarga(nuevo))
            aActual.ponerEnEspera(nuevo);

    }

    private void generarProximaLlegada(Iteracion aActual)
    {
        double random = Math.random();
        double tiempoEntreLlegadas = calcularTiempoEntreLLegadas(random);


        //prox llegada
        aActual.setRndProxLlegada(random);
        aActual.setTiempoEntreLlegadas(tiempoEntreLlegadas);
        aActual.setProximaLlegada(aActual.getReloj() + tiempoEntreLlegadas);
    }

    private double calcularTiempoEntreLLegadas(double random)
    {
        double tiempo = 0;

        tiempo = Math.log(1.0-random) * (-1/LAMBDA_LLEGADAS);

        return tiempo;
    }

    public static void setMediaLlegada(double tiempo) {MEDIA_LLEGADAS = tiempo;}

    static double MEDIA_LLEGADAS = 0.5;
    private final double LAMBDA_LLEGADAS = 1.0 / MEDIA_LLEGADAS;
}

