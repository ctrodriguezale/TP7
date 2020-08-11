package Model;

public class ETBombeo implements IEstadoTanque
{
    private static IEstadoTanque estado;

    public static IEstadoTanque getEstado()
    {
        if (estado == null)
            estado = new ETBombeo();

        return estado;
    }


    public String getNombre(){return "Ocupado";}

    public boolean esLibre(){return false;}
    public boolean esEncendiendo(){return false;}
    public boolean esBombeando(){return true;}
    public boolean esDescargando(){return false;}
}
