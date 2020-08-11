package Model;

public class Buque
{
    private int id;
    private IEstadoBuque estado;
    private int cargaRestante;

    public Buque(int aID)
    {
        id = aID;
        cargaRestante = 0;
        estado = null;
    }

    public Buque(int aID, int aCargaInicial, IEstadoBuque aEstadoInicial)
    {
        this.id = aID;
        cargaRestante = aCargaInicial;
        estado = aEstadoInicial;
    }

    public Buque(Buque buque)
    {
        this.duplicar(buque);
    }

    public IEstadoBuque getEstado() {
        return estado;
    }

    public void setEstado(IEstadoBuque aEstado) {
        this.estado = aEstado;
    }

    public int getCargaRestante() {
        return cargaRestante;
    }

    public void setCargaRestante(int aCargaRestante) {
        this.cargaRestante = aCargaRestante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void duplicar(Buque base)
    {
        if (base != null)
        {
            this.id = base.getId();
            this.estado = base.getEstado();
            this.cargaRestante = base.getCargaRestante();
        }
    }

    public void encolar()
    {
        this.estado = EBEnCola.getEstado();
    }

    public void encendiendoBomba()
    {
        this.estado = EBEncendiendo.getEstado();
    }

    public void bombeando()
    {
        this.estado = EBBombeando.getEstado();
    }

    public void finalizar()
    {
        this.estado = EBFinalizado.getEstado();
    }

    public void interrumpir()
    {
        this.estado = EBInterrumpido.getEstado();
    }

    public boolean esBuque(Buque buque)
    {
        return (this.id != buque.getId());
    }
}
