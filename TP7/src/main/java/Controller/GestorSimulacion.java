package Controller;

import Model.*;
import View.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;

public class GestorSimulacion
{
    private PantallaSimulacionController pantallaSimulacionController = null;
    private Iteracion actual = new Iteracion();
    private Iteracion anterior = new Iteracion();




    public void simular(double aReloj)
    {
        actual.inicializar();
        anterior.inicializar();
        actual.simular(anterior);
        pantallaSimulacionController.mostrarIteracion(actual, anterior);



        while(aReloj > actual.getReloj())
        {
            anterior.duplicar(actual);
            siguienteEvento();
            pantallaSimulacionController.mostrarIteracion(actual, anterior);
        }
    }


    public void test(double aReloj)
    {
        actual.inicializar();
        anterior.inicializar();
        actual.simular(anterior);

        while(aReloj > actual.getReloj())
        {
            anterior.duplicar(actual);
            siguienteEvento();
        }
    }

    public void siguienteEvento()
    {
        IEvento proximoEvento = EVLlegada.getEvento();
        double relojAnterior = anterior.getReloj();
        double relojProxEvento = anterior.getProximaLlegada();
        Tanque tanqueCandidato = null;
        Tanque tanqueEvento = null;
        double relojCandidato;

        //
        tanqueCandidato = anterior.proximoLlenado();
        if (tanqueCandidato != null)
        {
            relojCandidato = tanqueCandidato.getHoraLlenado();
            if ((relojCandidato >= relojAnterior) && (relojCandidato < relojProxEvento))
            {
                proximoEvento = EVLlenado.getEvento();
                relojProxEvento = relojCandidato;
                tanqueEvento = tanqueCandidato;
            }
        }



        //
        tanqueCandidato = anterior.proximoFinEncendido();
        if (tanqueCandidato != null)
        {
            relojCandidato = tanqueCandidato.getFinEncendido();
            if ((relojCandidato >= relojAnterior) && (relojCandidato < relojProxEvento))
            {
                proximoEvento = EVFinEncendido.getEvento();
                relojProxEvento = relojCandidato;
                tanqueEvento = tanqueCandidato;
            }
        }

        //
        tanqueCandidato = anterior.proximoFinBombeo();
        if (tanqueCandidato != null)
        {
            relojCandidato = tanqueCandidato.getFinBombeo();
            if ((relojCandidato >= relojAnterior) && (relojCandidato < relojProxEvento))
            {
                proximoEvento = EVFinBombeo.getEvento();
                relojProxEvento = relojCandidato;
                tanqueEvento = tanqueCandidato;
            }
        }

        //
        tanqueCandidato = anterior.proximoFinDescarga();
        if (tanqueCandidato != null)
        {
            relojCandidato = tanqueCandidato.getFinDesagote();
            if ((relojCandidato > anterior.getReloj()) && (relojCandidato < relojProxEvento))
            {
                proximoEvento = EVFinDescarga.getEvento();
                relojProxEvento = relojCandidato;
                tanqueEvento = tanqueCandidato;
            }
        }


        proximoEvento.simular(actual, anterior, tanqueEvento);
    }

    public void ejecutar()
    {
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL urlLocation = getClass().getResource("/PantallaSimulacion.fxml");
        fxmlLoader.setLocation(urlLocation);
        try {
            AnchorPane root = fxmlLoader.load();
            //Cargamos el controller de la prox ventana
            pantallaSimulacionController = (PantallaSimulacionController) fxmlLoader.getController();
            pantallaSimulacionController.iniciar(this);
            Stage stage = new Stage();
            stage.setTitle("Trabajo práctico N7");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(true);
            stage.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
