package Model;

public class Tanque {
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

public static void setParametro(int tiempoBombeo, int tiempoDescarga)
{
    TIEMPO_DESCARGA = tiempoDescarga;
    TIEMPO_BOMBEO = tiempoBombeo;
}
    static final double TIEMPO_ENCENDIDO = 0.5;
    static int TIEMPO_BOMBEO = 10000;
    static  int TIEMPO_DESCARGA = 4000;
    static final int CAPACIDAD = 70000;

    public Tanque(int aID, IEstadoTanque aEstadoInicial, double aFinEncendido, double aFinBombeo, Buque aBuque, int aEspacioDisponible, double aHoraLlenado, double aFinDesagote) {
        id = aID;
        estado = aEstadoInicial;

        finEncendido = aFinEncendido;

        rndTamañoBuque = 0;
        tamañoBuque = 0;
        tiempoBombeo = 0;
        finBombeo = aFinBombeo;

        tiempoLlenado = 0;
        if (aHoraLlenado != 0) {
            horaLlenado = aHoraLlenado;
            espacioDisponible = 0;
        } else {
            horaLlenado = 0;
            espacioDisponible = aEspacioDisponible;
        }

        tiempoDesagote = 0;
        finDesagote = aFinDesagote;
        buque = aBuque;
    }

    public Tanque(int aID) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buque getBuque() {
        return buque;
    }

    public void setBuque(Buque buque) {
        this.buque = buque;
    }

    private boolean estaEncendiendo() {
        return estado.esEncendiendo();
    }

    public boolean estaLibre() {
        return estado.esLibre();
    }

    public void duplicar(Tanque base)
    {
        id = base.getId();
        estado = base.getEstado();

        finEncendido = base.getFinEncendido();

        rndTamañoBuque = base.getRndTamañoBuque();
        tamañoBuque = base.getTamañoBuque();
        tiempoBombeo = base.getTiempoBombeo();
        finBombeo = base.getFinBombeo();

        tiempoLlenado = base.getTiempoLlenado();
        espacioDisponible = base.getEspacioDisponible();
        horaLlenado = base.getHoraLlenado();

        tiempoDesagote = base.getTiempoDesagote();
        finDesagote = base.getFinDesagote();

        if (base.getBuque() != null) {
            if (buque != null)
                buque.duplicar(base.getBuque());
            else
                buque = new Buque(base.getBuque());
        } else
            buque = null;
    }

    public void iniciarCarga(Buque aBuque, double aHoraActual) {
        this.buque = aBuque;
        this.buque.encendiendoBomba();
        this.calcularFinEncendido(aHoraActual);
        this.estado = ETEncendiendo.getEstado();
    }

    private void calcularFinEncendido(double aHoraActual)
    {
        this.finEncendido = aHoraActual + TIEMPO_ENCENDIDO;
    }

    public void bombear(double aReloj, Buque aBuque)
    {
        this.buque = aBuque;

        if (this.buque.getCargaRestante() == 0)
        {
            this.rndTamañoBuque = Math.random();
            this.tamañoBuque = this.obtenerTamañoBuque();
            this.tiempoBombeo = this.calcularTiempoBombeo();
        } else
        {
            this.tamañoBuque = this.buque.getCargaRestante();
            this.tiempoBombeo = ((double) this.tamañoBuque) / TIEMPO_BOMBEO;
        }

        this.calcularEspacioDisponible(this.tamañoBuque, aReloj);

        this.finBombeo = aReloj + this.tiempoBombeo;
        this.buque.bombeando();

        this.estado = ETBombeo.getEstado();
    }

    private void calcularEspacioDisponible(int aTamañoBuque, double aReloj)
    {
        if (aTamañoBuque >= this.espacioDisponible)
            llenarTanque(aTamañoBuque, aReloj);
        else
            cargarTanque(aTamañoBuque);
    }

    private void llenarTanque(int aTamañoBuque, double aReloj)
    {
        this.tiempoLlenado = ((double)espacioDisponible) / TIEMPO_BOMBEO;
        this.horaLlenado = aReloj + this.tiempoLlenado;

        this.buque.setCargaRestante(this.tamañoBuque - this.espacioDisponible);

        this.espacioDisponible = 0;
    }

    private void cargarTanque(int aTamañoBuque)
    {
        this.espacioDisponible -= aTamañoBuque;
    }

    private double calcularTiempoBombeo()
    {
        double tamañoBuqueDouble = (double) tamañoBuque;

        return tamañoBuqueDouble / TIEMPO_BOMBEO;
    }

    private int obtenerTamañoBuque()
    {
        double aleatorio = rndTamañoBuque;
        if (aleatorio < (1.0/3))
            return 15000;
        else
            if (aleatorio < (2.0/3))
                return 20000;
            else
                return 25000;
    }


    public void liberar()
    {
        this.buque = null;
        this.estado = ETLibre.getEstado();

        this.tamañoBuque = 0;
        this.tiempoBombeo = 0;
        this.finBombeo = 0;
        this.rndTamañoBuque = 0;

    }

    public void desagotar(double aReloj)
    {
        this.tiempoDesagote = ((double) CAPACIDAD) / TIEMPO_DESCARGA;
        this.finDesagote = aReloj + this.tiempoDesagote;
        this.finBombeo = 0;
        this.buque.interrumpir();
        this.estado = ETDescargando.getEstado();
    }

    public double getTiempoEncendido()
    {
        return TIEMPO_ENCENDIDO;
    }

    public void tanqueVacio()
    {
        this.espacioDisponible = CAPACIDAD;
    }

    public int getCapacidad() { return CAPACIDAD;
    }
}
