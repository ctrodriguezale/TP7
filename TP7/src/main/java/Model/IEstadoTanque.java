package Model;

public interface IEstadoTanque
{
    public static IEstadoTanque getEstado()
    {
        return null;
    }

    public String getNombre();

    public boolean esLibre();
    public boolean esEncendiendo();
    public boolean esBombeando();
    public boolean esDescargando();

}
