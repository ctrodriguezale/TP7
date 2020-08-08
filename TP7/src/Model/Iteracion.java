package Model;

import java.util.ArrayList;
import java.util.List;

public class Iteracion
{
    private IEvento evento;
    private double reloj;

    private double rndProxLlegada;
    private double tiempoEntreLlegadas;
    private double proximaLlegada;
    private List<Buque> colaEspera;

    private Tanque[] tanques;

    private int tamañoMaximoCola;
    private int acumuladoDescargados;

    private List<Buque> colaInterrumpidos;

    public IEvento getEvento() {
        return evento;
    }

    public void setEvento(IEvento evento) {
        this.evento = evento;
    }

    public double getReloj() {
        return reloj;
    }

    public void setReloj(double reloj) {
        this.reloj = reloj;
    }

    public double getRndProxLlegada() {
        return rndProxLlegada;
    }

    public void setRndProxLlegada(double rndProxLlegada) {
        this.rndProxLlegada = rndProxLlegada;
    }

    public double getTiempoEntreLlegadas() {
        return tiempoEntreLlegadas;
    }

    public void setTiempoEntreLlegadas(double tiempoEntreLlegadas) {
        this.tiempoEntreLlegadas = tiempoEntreLlegadas;
    }

    public double getProximaLlegada() {
        return proximaLlegada;
    }

    public void setProximaLlegada(double proximaLlegada) {
        this.proximaLlegada = proximaLlegada;
    }

    public List<Buque> getColaEspera() {
        return colaEspera;
    }

    public void setColaEspera(List<Buque> colaEspera) {
        this.colaEspera = colaEspera;
    }

    public Tanque[] getTanques() {
        return tanques;
    }

    public void setTanques(Tanque[] tanques) {
        this.tanques = tanques;
    }

    public int getTamañoMaximoCola() {
        return tamañoMaximoCola;
    }

    public void setTamañoMaximoCola(int tamañoMaximoCola) {
        this.tamañoMaximoCola = tamañoMaximoCola;
    }

    public int getAcumuladoDescargados() {
        return acumuladoDescargados;
    }

    public void setAcumuladoDescargados(int acumuladoDescargados) {
        this.acumuladoDescargados = acumuladoDescargados;
    }

    public List<Buque> getColaInterrumpidos() {
        return colaInterrumpidos;
    }

    public void setColaInterrumpidos(List<Buque> colaInterrumpidos) {
        this.colaInterrumpidos = colaInterrumpidos;
    }

    public void inicializar()
    {
        evento = EVInicial.getEvento();
        reloj = 0;

        rndProxLlegada = 0;
        tiempoEntreLlegadas = 0;
        proximaLlegada = 0;

        colaEspera = new ArrayList<Buque>();
        colaInterrumpidos = new ArrayList<Buque>();

        tanques = new Tanque[CANTIDAD_TANQUES];

        tanques[0] = new Tanque(1, ETEncendiendo.getEstado(), 0, 0, 0, 0, 8);
        tanques[1] = new Tanque(2, ETEncendiendo.getEstado(), 0, 0, 45000, 0, 12);
        tanques[2] = new Tanque(3, ETEncendiendo.getEstado(), 0, 0, 25000, 0, 3.5);
        tanques[3] = new Tanque(4);
        tanques[4] = new Tanque(5);

        tamañoMaximoCola = 0;
        acumuladoDescargados = 0;
    }



    public IEvento siguienteEvento()
    {
        IEvento proximoEvento = EVLlegada.getEvento();
        double relojProxEvento = proximaLlegada;
        Tanque tanqueEvento = null;
        double candidato;

        //
        tanqueEvento = proximoFinEncendido();
        if (tanqueEvento != null)
        {
            candidato = tanqueEvento.getFinEncendido();
            if ((candidato > reloj) && (candidato < relojProxEvento))
            {
                proximoEvento = EVFinEncendido.getEvento();
                relojProxEvento = candidato;
            }
        }

        //
        tanqueEvento = proximoFinBombeo();
        if (tanqueEvento != null)
        {
            candidato = tanqueEvento.getFinBombeo();
            if ((candidato > reloj) && (candidato < relojProxEvento))
            {
                proximoEvento = EVFinBombeo.getEvento();
                relojProxEvento = candidato;
            }
        }

        //
        tanqueEvento = proximoFinDescarga();
        if (tanqueEvento != null)
        {
            candidato = tanqueEvento.getFinBombeo();
            if ((candidato > reloj) && (candidato < relojProxEvento))
            {
                proximoEvento = EVFinBombeo.getEvento();
                relojProxEvento = candidato;
            }
        }
        return proximoEvento;
    }

    private Tanque proximoFinDescarga()
    {
        double proximoReloj = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinDesagote();
            if ((candidato > reloj)&&(candidato < proximoReloj))
            {
                proximoReloj = candidato;
                resultado = tanques[i];
            }
        }
        return resultado;
    }

    private Tanque proximoFinBombeo()
    {
        double proximoReloj = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinBombeo();
            if ((candidato > reloj)&&(candidato < proximoReloj))
            {
                proximoReloj = candidato;
                resultado = tanques[i];
            }
        }
        return resultado;
    }

    private Tanque proximoFinEncendido()
    {
        double proximoFinEncendido = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinEncendido();
            if ((candidato > reloj)&&(candidato < proximoFinEncendido))
            {
                proximoFinEncendido = candidato;
                resultado = tanques[i];
            }
        }
        return resultado;
    }


    public final int CANTIDAD_TANQUES = 5;
}
