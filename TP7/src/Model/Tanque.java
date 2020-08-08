package Model;

public class Tanque
{
    private int id;

    private IEstadoTanque estado;
    private double finEncendido;

    private double rndTamañoBuque;
    private int tamañoBuque;
    private double tiempoBombeo;
    private double finBombeo;

    private int espacioDisponible;
    private double tiempoLlenado;
    private double horaLlenado;

    private double tiempoDesagote;
    private double finDesagote;

    private Buque buque;

    public Tanque (int aID, IEstadoTanque aEstadoInicial, double aFinEncendido, double aFinBombeo, int aEspacioDisponible, double aHoraLlenado, double aFinDesagote)
    {
        id = aID;
        estado = aEstadoInicial;

        finEncendido = aFinEncendido;

        rndTamañoBuque = 0;
        tamañoBuque = 0;
        tiempoBombeo = 0;
        finBombeo = aFinBombeo;

        tiempoLlenado = 0;
        if (aHoraLlenado != 0)
        {
            horaLlenado = aHoraLlenado;
            espacioDisponible = 0;
        } else {
            horaLlenado = 0;
            if(espacioDisponible == 0)
                espacioDisponible = CAPACIDAD;
            else
                espacioDisponible = aEspacioDisponible;
        }

        tiempoDesagote = 0;
        finDesagote = aFinDesagote;
        buque = null;
    }

    public Tanque(int aID)
    {
        id = aID;
        estado = ETLibre.getEstado();

        finEncendido = 0;

        rndTamañoBuque = 0;
        tamañoBuque = 0;
        tiempoBombeo = 0;
        finBombeo = 0;

        tiempoLlenado = 0;
        espacioDisponible = CAPACIDAD;

        tiempoDesagote = 0;
        finDesagote = 0;

        buque = null;
    }

    public String getNombre() {
        return "Tanque " + id;
    }

    public double getFinEncendido() {
        return finEncendido;
    }

    public void setFinEncendido(double finEncendido) {
        this.finEncendido = finEncendido;
    }

    public IEstadoTanque getEstado() {
        return estado;
    }

    public void setEstado(IEstadoTanque estado) {
        this.estado = estado;
    }

    public double getRndTamañoBuque() {
        return rndTamañoBuque;
    }

    public void setRndTamañoBuque(double rndTamañoBuque) {
        this.rndTamañoBuque = rndTamañoBuque;
    }

    public int getTamañoBuque() {
        return tamañoBuque;
    }

    public void setTamañoBuque(int tamañoBuque) {
        this.tamañoBuque = tamañoBuque;
    }

    public double getTiempoBombeo() {
        return tiempoBombeo;
    }

    public void setTiempoBombeo(double tiempoBombeo) {
        this.tiempoBombeo = tiempoBombeo;
    }

    public double getFinBombeo() {
        return finBombeo;
    }

    public void setFinBombeo(double finBombeo) {
        this.finBombeo = finBombeo;
    }

    public int getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(int espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }

    public double getTiempoLlenado() {
        return tiempoLlenado;
    }

    public void setTiempoLlenado(double tiempoLlenado) {
        this.tiempoLlenado = tiempoLlenado;
    }

    public double getHoraLlenado() {
        return horaLlenado;
    }

    public void setHoraLlenado(double horaLlenado) {
        this.horaLlenado = horaLlenado;
    }

    public double getTiempoDesagote() {
        return tiempoDesagote;
    }

    public void setTiempoDesagote(double tiempoDesagote) {
        this.tiempoDesagote = tiempoDesagote;
    }

    public double getFinDesagote() {
        return finDesagote;
    }

    public void setFinDesagote(double finDesagote) {
        this.finDesagote = finDesagote;
    }





    private final double TIEMPO_ENCENDIDO = 0.5;
    private final int TIEMPO_CARGA = 10000;
    private final int TIEMPO_DESCARGA = 4000;
    private final int CAPACIDAD = 70000;

    public boolean finEncendidoEsAntes(double aHoraProximoLlenado)
    {
        if (estaLibre())
            return false;
        else
        {
            if (estaEncendiendo())
            {

            }
        }
    }

    private boolean estaEncendiendo(){return estado.esEncendiendo();}

    private boolean estaLibre()
    {
        return estado.esLibre();
    }
}
