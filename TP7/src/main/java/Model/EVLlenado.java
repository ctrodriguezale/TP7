package Model;

public class EVLlenado implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVLlenado();

        return evento;
    }

    public String getNombre(){return "Tanque Lleno";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        Tanque tanqueActual = aActual.obtenerTanque(aTanque);

        aActual.setEvento(this);
        aActual.setReloj(aAnterior.obtenerTanque(aTanque).getHoraLlenado());

        //Cancelamos el bombeo actual
        aActual.desagotar(tanqueActual);


    }

}
