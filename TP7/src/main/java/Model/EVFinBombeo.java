package Model;

public class EVFinBombeo implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVFinBombeo();

        return evento;
    }

    public String getNombre(){return "Fin Bombeo";}

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque)
    {
        Tanque tanqueActual = aActual.obtenerTanque(aTanque);

        aActual.setEvento(this);
        aActual.setReloj(aAnterior.obtenerTanque(aTanque).getFinBombeo());

        tanqueActual.getBuque().finalizar();

        if (!aActual.continuarInterrumpido(tanqueActual))
        {
            if(!aActual.bombearProximoEnCola(tanqueActual))
                aActual.liberarTanque(tanqueActual);
        }

//        aActual.acumularDescargados(aAnterior.obtenerTanque(tanqueActual).getTamañoBuque());
    }


}
