package Model;

public class EBInterrumpido implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBInterrumpido();

        return estado;
    }


    public String getNombre(){return "Interrumpido";}
}
