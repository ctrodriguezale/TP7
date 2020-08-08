package Model;

public class EVInicial implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVInicial();

        return evento;
    }

    public String getNombre(){return "Inicial";}
}
