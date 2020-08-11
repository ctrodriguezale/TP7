package Model;

public class EVInicial implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVInicial();

        return evento;
    }

    public String getNombre(){return "Inicial";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        aActual.setEvento(this);
        aActual.setReloj(0);

        //calculamos atributos propios del evento
        generarProximaLlegada(aActual);
    }

    private void generarProximaLlegada(Iteracion aActual)
    {
        double random = Math.random();
        double tiempoEntreLlegadas = calcularTiempoEntreLLegadas(random);

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


    private final double MEDIA_LLEGADAS = 0.125;
    private final double LAMBDA_LLEGADAS = 1.0 / MEDIA_LLEGADAS;
}
