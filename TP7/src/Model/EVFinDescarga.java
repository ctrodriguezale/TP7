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
}
