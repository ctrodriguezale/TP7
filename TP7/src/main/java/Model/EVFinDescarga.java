package Model;

public class EVFinDescarga implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVFinDescarga();

        return evento;
    }

    public String getNombre(){return "Fin Descarga";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        Tanque tanqueActual = aActual.obtenerTanque(aTanque);

        aActual.setEvento(this);
        aActual.setReloj(aAnterior.obtenerTanque(aTanque).getFinDesagote());

        tanqueActual.tanqueVacio();
        if (!aActual.continuarInterrumpido(tanqueActual))
        {
            if(!aActual.bombearProximoEnCola(tanqueActual))
                aActual.liberarTanque(tanqueActual);
        }
        aActual.acumularDescargados(tanqueActual);
    }
}
