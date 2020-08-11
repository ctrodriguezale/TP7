package Model;

public interface IEvento
{
    public static IEvento getEvento()
    {
        return null;
    }

    public String getNombre();

    public void simular(Iteracion aActual, Iteracion aAnterior, Tanque aTanque);
}
