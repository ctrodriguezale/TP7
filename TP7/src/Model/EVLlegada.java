package Model;

public class EVLlegada implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVLlegada();

        return evento;
    }

    public String getNombre(){return "Llegada";}

}
