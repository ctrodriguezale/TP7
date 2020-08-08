package Model;

public class EBEncendiendo implements IEstadoBuque
{
    private static IEstadoBuque estado;

    public static IEstadoBuque getEstado()
    {
        if (estado == null)
            estado = new EBEncendiendo();

        return estado;
    }

    public String getNombre(){return "Encendiendo";}
}
