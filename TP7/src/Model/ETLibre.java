package Model;

public class ETLibre implements IEstadoTanque
{
    private static IEstadoTanque estado;

    public static IEstadoTanque getEstado()
    {
        if (estado == null)
            estado = new ETLibre();

        return estado;
    }


    public String getNombre(){return "Libre";}

    public boolean esLibre(){return true;}
    public boolean esEncendiendo(){return false;}
    public boolean esCargando(){return false;}
    public boolean esDescargando(){return false;}
}
