package Model;

import java.util.ArrayList;
import java.util.List;

public class Iteracion
{
    private IEvento evento;
    private double reloj;
    private int contadorBuques;

    private double rndProxLlegada;
    private double tiempoEntreLlegadas;
    private double proximaLlegada;
    private List<Buque> colaEspera;

    private Tanque[] tanques;

    private int tamañoMaximoCola;
    private int acumuladoDescargados;

    private List<Buque> colaInterrumpidos;

    public void duplicar(Iteracion base)
    {
        this.evento = base.getEvento();
        this.reloj = base.getReloj();

        this.contadorBuques = base.getContadorBuques();

        this.rndProxLlegada = base.getRndProxLlegada();
        this.tiempoEntreLlegadas = base.getTiempoEntreLlegadas();
        this.proximaLlegada = base.getProximaLlegada();

        this.tamañoMaximoCola = base.getTamañoMaximoCola();
        this.acumuladoDescargados = getAcumuladoDescargados();


        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            tanques[i].duplicar(base.getTanque(i));
        }

        this.colaEspera = new ArrayList<Buque>();
        for (Buque buque: base.getColaEspera())
        {
            this.colaEspera.add(new Buque(buque));
        }
    }

    public Tanque getTanque(int aID)
    {
        return tanques[aID];
    }

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

    public int getContadorBuques() {
        return contadorBuques;
    }

    public void setContadorBuques(int contadorBuques) {
        this.contadorBuques = contadorBuques;
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

        tanques[0] = new Tanque(1, ETDescargando.getEstado(), 0, 0, null, 0, 0, 8);
        tanques[1] = new Tanque(2, ETBombeo.getEstado(), 0, 12, new Buque(proximoIDBuque(),0, EBBombeando.getEstado()), 45000, 0, 0);
        tanques[2] = new Tanque(3, ETBombeo.getEstado(), 0, 3.5, new Buque(proximoIDBuque(), 0, EBBombeando.getEstado()), 25000, 0, 0);
        tanques[3] = new Tanque(4);
        tanques[4] = new Tanque(5);

        tamañoMaximoCola = 0;
        acumuladoDescargados = 0;
    }




    public Tanque proximoFinDescarga()
    {
        double proximoReloj = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinDesagote();
            if (candidato > reloj)
            {
                if ((candidato < proximoReloj) || (resultado ==  null)) {
                    proximoReloj = candidato;
                    resultado = tanques[i];
                }
            }
        }
        return resultado;
    }

    public Tanque proximoFinBombeo()
    {
        double proximoReloj = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinBombeo();
            if (candidato > reloj)
            {
                if ((candidato < proximoReloj) || (resultado ==  null))
                {
                    proximoReloj = candidato;
                    resultado = tanques[i];
                }
            }
        }
        return resultado;
    }

    public Tanque proximoFinEncendido()
    {
        double proximoFinEncendido = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getFinEncendido();
            if (candidato > reloj) {
                if ((candidato < proximoFinEncendido) || (resultado == null)) {
                    proximoFinEncendido = candidato;
                    resultado = tanques[i];
                }
            }
        }
        return resultado;
    }

    public Tanque proximoLlenado()
    {
        double proximaHoraLlenado = 0;
        double candidato = 0;
        Tanque resultado = null;

        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            candidato = tanques[i].getHoraLlenado();
            if (candidato > reloj) {
                if ((candidato < proximaHoraLlenado) || (resultado == null)) {
                    proximaHoraLlenado = candidato;
                    resultado = tanques[i];
                }
            }
        }
        return resultado;
    }


    public final int CANTIDAD_TANQUES = 5;

    public void simular(Iteracion anterior)
    {
        this.evento.simular(this, anterior, null);
    }

    public boolean iniciarCarga(Buque aBuque)
    {
        boolean resultado = false;
        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            if(tanques[i].estaLibre())
            {
                tanques[i].iniciarCarga(aBuque, this.reloj);
                resultado = true;
                break;
            }

        }
        return resultado;
    }

    public void ponerEnEspera(Buque aBuque)
    {
        colaEspera.add(aBuque);
        aBuque.encolar();
        this.validarTamañoMaximoCola();
    }

    private void validarTamañoMaximoCola()
    {
        if (colaEspera.size() > tamañoMaximoCola)
            tamañoMaximoCola = colaEspera.size();
    }


    public void bombearBuque(Iteracion aActual, Tanque aTanque)
    {
        Tanque tanque = obtenerTanque(aTanque);

        tanque.bombear(this.reloj, tanque.getBuque());
    }

    public Tanque obtenerTanque(Tanque aTanque)
    {
        for (int i = 0; i < CANTIDAD_TANQUES; i++)
        {
            if (esTanque(tanques[i], aTanque))
                return tanques[i];
        }

        return null;
    }

    private boolean esTanque(Tanque aTanque2,Tanque aTanque1)
    {
        return (aTanque2.getId() == aTanque1.getId());
    }


    public boolean continuarInterrumpido(Tanque aTanque)
    {
        Buque interrumpido = null;
        boolean resultado = false;
        if (colaInterrumpidos.size() != 0)
        {
            interrumpido = this.colaInterrumpidos.get(0);
            aTanque.iniciarCarga(interrumpido, this.reloj);
            this.colaInterrumpidos.remove(interrumpido);
            resultado = true;
        }

        return resultado;
    }

    public boolean bombearProximoEnCola(Tanque aTanque)
    {
        boolean resultado = false;
        Buque proximo = null;
        if (this.colaEspera.size() != 0)
        {
            proximo = this.colaEspera.get(0);
            aTanque.iniciarCarga(proximo, this.reloj);
            this.colaEspera.remove(0);
            resultado = true;
        }
        return resultado;
    }

    public void liberarTanque(Tanque aTanque)
    {
        Tanque actual = this.obtenerTanque(aTanque);

        actual.liberar();
    }

    public void acumularDescargados(int aCantidadDescargada)
    {
        this.acumuladoDescargados += aCantidadDescargada;
    }

    public void desagotar(Tanque aTanque)
    {
        if(aTanque.getBuque().getCargaRestante() != 0)
            this.colaInterrumpidos.add(aTanque.getBuque());
        aTanque.desagotar(this.reloj);
    }

    public int proximoIDBuque()
    {
        this.contadorBuques ++;
        return this.contadorBuques;
    }

    public void acumularDescargados(Tanque aTanque)
    {
        this.acumuladoDescargados += aTanque.getCapacidad();
    }
}
