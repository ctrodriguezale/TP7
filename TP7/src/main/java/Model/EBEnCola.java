package Model;

public class EBEnCola implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBEnCola();

        return estado;
    }

    public String getNombre(){return "En Cola";}
}
