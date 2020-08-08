package Model;

public class EVFinBombeo implements IEvento
{
    private static IEvento evento;

    public static IEvento getEvento()
    {
        if (evento == null)
            evento = new EVFinBombeo();

        return evento;
    }

    public String getNombre(){return "Fin Bombeo";}
}
