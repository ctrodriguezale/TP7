package Model;

public class ETDescargando implements IEstadoTanque
{
    private static IEstadoTanque estado;

    public static IEstadoTanque getEstado()
    {
        if (estado == null)
            estado = new ETDescargando();

        return estado;
    }


    public String getNombre(){return "Ocupado";}

    public boolean esLibre(){return false;}
    public boolean esEncendiendo(){return false;}
    public boolean esCargando(){return false;}
    public boolean esDescargando(){return true;}
}
