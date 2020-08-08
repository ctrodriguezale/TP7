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
}
