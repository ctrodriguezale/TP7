package Model;

public class Buque
{
    private IEstadoBuque estado;
    private int cargaRestante;

    public Buque()
    {
        cargaRestante = 0;
        estado = null;
    }

    public Buque(int aCargaInicial, IEstadoBuque aEstadoInicial)
    {
        cargaRestante = aCargaInicial;
        estado = aEstadoInicial;
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





}
