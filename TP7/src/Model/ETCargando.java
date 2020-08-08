package Model;

public class ETCargando implements IEstadoTanque
{
    private static IEstadoTanque estado;

    public static IEstadoTanque getEstado()
    {
        if (estado == null)
            estado = new ETCargando();

        return estado;
    }


    public String getNombre(){return "Ocupado";}

    public boolean esLibre(){return false;}
    public boolean esEncendiendo(){return false;}
    public boolean esCargando(){return true;}
    public boolean esDescargando(){return false;}
}
