package Model;

public class EVFinEncendido implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVFinEncendido();

        return evento;
    }

    public String getNombre(){return "Fin Encendido";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        aActual.setEvento(this);
        aActual.setReloj(aAnterior.obtenerTanque(aTanque).getFinEncendido());

        aActual.bombearBuque(aActual, aTanque);
    }
}
