package Model;

public class EBBombeando implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBBombeando();

        return estado;
    }

    public String getNombre(){return "Cargando";}
}
