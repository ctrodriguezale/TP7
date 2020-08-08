package Controller;

import Model.Iteracion;

public class GestorSimulacion
{


    public void simular(double aReloj)
    {
        Iteracion actual = new Iteracion();
        Iteracion anterior = new Iteracion();

        actual.inicializar();
        anterior.inicializar();

        while(aReloj > actual.getReloj())
        {
            actual.setEvento(anterior.siguienteEvento());
        }
    }
}
