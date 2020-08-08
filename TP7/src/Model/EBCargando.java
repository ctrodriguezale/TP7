package Model;

public class EBCargando implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBCargando();

        return estado;
    }

    public String getNombre(){return "Cargando";}
}
