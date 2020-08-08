package Model;

public class ETEncendiendo implements IEstadoTanque
{
    private static IEstadoTanque estado;

    public static IEstadoTanque getEstado()
    {
        if (estado == null)
            estado = new ETEncendiendo();

        return estado;
    }


    public String getNombre(){return "Ocupado";}

    public boolean esLibre(){return false;}
    public boolean esEncendiendo(){return true;}
    public boolean esCargando(){return false;}
    public boolean esDescargando(){return false;}

}
