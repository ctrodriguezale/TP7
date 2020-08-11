package Model;

public class EBFinalizado implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBFinalizado();

        return estado;
    }

    public String getNombre(){return "Finalizado";}
}

