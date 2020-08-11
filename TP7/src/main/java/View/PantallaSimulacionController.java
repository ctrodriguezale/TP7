package View;


import Controller.GestorSimulacion;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;

import java.util.HashMap;
import java.util.Map;

public class PantallaSimulacionController {
    @FXML
    private Label lblMaxCola;

    @FXML
    private Label lblTotalDescargado;

    @FXML
    private Button btnSimular;

    @FXML
    private TextField txtTiempo;

    @FXML
    private TableView<Map> tblTabla;

    @FXML
    private TableColumn<Map, String> colEvento;

    @FXML
    private TableColumn<Map, String> colReloj;

    @FXML
    private TableColumn<Map, String> colRndTiempoLlegada;

    @FXML
    private TableColumn<Map, String> colTiempoLlegadas;

    @FXML
    private TableColumn<Map, String> colProxLlegada;

    @FXML
    private TableColumn<Map, String> colCola;

    @FXML
    private TableColumn<Map, String> colTanque1;

    @FXML
    private TableColumn<Map, String> colEstado1;

    @FXML
    private TableColumn<Map, String> colEncendido1;

    @FXML
    private TableColumn<Map, String> colTiempoEncendido1;

    @FXML
    private TableColumn<Map, String> colFinEncendido1;


    @FXML
    private TextField txtLlegada;

    @FXML
    private TextField txtTiempoBombeo;

    @FXML
    private TextField txtTiempoDescarga;

    @FXML
    private TableColumn<Map, String> colBombeo1;

    @FXML
    private TableColumn<Map, String> colRndTamañoBuque1;

    @FXML
    private TableColumn<Map, String> colTamaño1;

    @FXML
    private TableColumn<Map, String> colTiempoBombeo1;

    @FXML
    private TableColumn<Map, String> colFinBombeo1;

    @FXML
    private TableColumn<Map, String> colLlenadoTanque1;

    @FXML
    private TableColumn<Map, String> colEspacioDisponible1;

    @FXML
    private TableColumn<Map, String> colHoraLlenado1;

    @FXML
    private TableColumn<Map, String> colDescarga1;

    @FXML
    private TableColumn<Map, String> colTiempoDescarga1;

    @FXML
    private TableColumn<Map, String> colFinDescarga1;

    @FXML
    private TableColumn<Map, String> colTanque2;

    @FXML
    private TableColumn<Map, String> colEstado2;

    @FXML
    private TableColumn<Map, String> colEncendido2;

    @FXML
    private TableColumn<Map, String> colTiempoEncendido2;

    @FXML
    private TableColumn<Map, String> colFinEncendido2;

    @FXML
    private TableColumn<Map, String> colBombeo2;

    @FXML
    private TableColumn<Map, String> colRndTamañoBuque2;

    @FXML
    private TableColumn<Map, String> colTamaño2;

    @FXML
    private TableColumn<Map, String> colTiempoBombeo2;

    @FXML
    private TableColumn<Map, String> colFinBombeo2;

    @FXML
    private TableColumn<Map, String> colLlenadoTanque2;

    @FXML
    private TableColumn<Map, String> colEspacioDisponible2;

    @FXML
    private TableColumn<Map, String> colHoraLlenado2;

    @FXML
    private TableColumn<Map, String> colDescarga2;

    @FXML
    private TableColumn<Map, String> colTiempoDescarga2;

    @FXML
    private TableColumn<Map, String> colFinDescarga2;

    @FXML
    private TableColumn<Map, String> colTanque3;

    @FXML
    private TableColumn<Map, String> colEstado3;

    @FXML
    private TableColumn<Map, String> colEncendido3;

    @FXML
    private TableColumn<Map, String> colTiempoEncendido3;

    @FXML
    private TableColumn<Map, String> colFinEncendido3;

    @FXML
    private TableColumn<Map, String> colBombeo3;

    @FXML
    private TableColumn<Map, String> colRndTamañoBuque3;

    @FXML
    private TableColumn<Map, String> colTamaño3;

    @FXML
    private TableColumn<Map, String> colTiempoBombeo3;

    @FXML
    private TableColumn<Map, String> colFinBombeo3;

    @FXML
    private TableColumn<Map, String> colTiempoLlenado1;

    @FXML
    private TableColumn<Map, String> colTiempoLlenado2;

    @FXML
    private TableColumn<Map, String> colTiempoLlenado3;

    @FXML
    private TableColumn<Map, String> colTiempoLlenado4;

    @FXML
    private TableColumn<Map, String> colTiempoLlenado5;

    @FXML
    private TableColumn<Map, String> colLlenadoTanque3;

    @FXML
    private TableColumn<Map, String> colEspacioDisponible3;

    @FXML
    private TableColumn<Map, String> colHoraLlenado3;

    @FXML
    private TableColumn<Map, String> colDescarga3;

    @FXML
    private TableColumn<Map, String> colTiempoDescarga3;

    @FXML
    private TableColumn<Map, String> colFinDescarga3;

    @FXML
    private TableColumn<Map, String> colTanque4;

    @FXML
    private TableColumn<Map, String> colEstado4;

    @FXML
    private TableColumn<Map, String> colEncendido4;

    @FXML
    private TableColumn<Map, String> colTiempoEncendido4;

    @FXML
    private TableColumn<Map, String> colFinEncendido4;

    @FXML
    private TableColumn<Map, String> colBombeo4;

    @FXML
    private TableColumn<Map, String> colRndTamañoBuque4;

    @FXML
    private TableColumn<Map, String> colTamaño4;

    @FXML
    private TableColumn<Map, String> colTiempoBombeo4;

    @FXML
    private TableColumn<Map, String> colFinBombeo4;

    @FXML
    private TableColumn<Map, String> colLlenadoTanque4;

    @FXML
    private TableColumn<Map, String> colEspacioDisponible4;

    @FXML
    private TableColumn<Map, String> colHoraLlenado4;

    @FXML
    private TableColumn<Map, String> colDescarga4;

    @FXML
    private TableColumn<Map, String> colTiempoDescarga4;

    @FXML
    private TableColumn<Map, String> colFinDescarga4;

    @FXML
    private TableColumn<Map, String> colTanque5;

    @FXML
    private TableColumn<Map, String> colEstado5;

    @FXML
    private TableColumn<Map, String> colEncendido5;

    @FXML
    private TableColumn<Map, String> colTiempoEncendido5;

    @FXML
    private TableColumn<Map, String> colFinEncendido5;

    @FXML
    private TableColumn<Map, String> colBombeo5;

    @FXML
    private TableColumn<Map, String> colRndTamañoBuque5;

    @FXML
    private TableColumn<Map, String> colTamaño5;

    @FXML
    private TableColumn<Map, String> colTiempoBombeo5;

    @FXML
    private TableColumn<Map, String> colFinBombeo5;

    @FXML
    private TableColumn<Map, String> colLlenadoTanque5;

    @FXML
    private TableColumn<Map, String> colEspacioDisponible5;

    @FXML
    private TableColumn<Map, String> colHoraLlenado5;

    @FXML
    private TableColumn<Map, String> colDescarga5;

    @FXML
    private TableColumn<Map, String> colTiempoDescarga5;

    @FXML
    private TableColumn<Map, String> colFinDescarga5;

    @FXML
    private TableColumn<Map, String> colAcumuladores;

    @FXML
    private TableColumn<Map, String> colMaxCola;

    @FXML
    private TableColumn<Map, String> colDescargados;

    private ObservableList<Map> listaIteraciones = FXCollections.observableArrayList();


    @FXML
    void simularOnAction(ActionEvent event) {
        int tiempo = Integer.parseInt(txtTiempo.getText());
        int descarga = Integer.parseInt(txtTiempoDescarga.getText());
        int bombeo = Integer.parseInt(txtTiempoBombeo.getText());
        double media = Double.parseDouble(txtLlegada.getText());

        Tanque.setParametro(bombeo, descarga);
        EVLlegada.setMediaLlegada(media);
       // EVLlegada.getEvento().

        listaIteraciones = FXCollections.observableArrayList();

        gestor.simular(tiempo);
    }

    GestorSimulacion gestor = null;

    public void iniciar(GestorSimulacion gestorSimulacion) {
        this.gestor = gestorSimulacion;
    }

    public void mostrarIteracion(Iteracion iteracion, Iteracion anterior) {
        Map<String, String> dataRow;
        IEvento evento = iteracion.getEvento();

        String tipo = "---";

        dataRow = new HashMap<>();


        if (evento instanceof EVInicial) {
            dataRow.put(EVENTO, "" + iteracion.getEvento().getNombre());
            dataRow.put(RELOJ, "" + Math.floor(iteracion.getReloj() * 10000) / 10000);
            dataRow.put(RND_LLEGADA, "" + Math.floor(iteracion.getRndProxLlegada() * 10000) / 10000);
            dataRow.put(TIEMPO_LLEGADA, "" + Math.floor(iteracion.getTiempoEntreLlegadas() * 10000) / 10000);
            dataRow.put(PROX_LLEGADA, "" + Math.floor(iteracion.getProximaLlegada() * 10000) / 10000);
            dataRow.put(COLA, "" + iteracion.getColaEspera().size());

            for (int i = 0; i < 5; i++) {
                dataRow.put("T" + (i + 1) + ESTADO, "" + iteracion.getTanque(i).getEstado().getNombre());
                dataRow.put("T" + (i + 1) + TIEMPO_ENCENDIDO, "" + iteracion.getTanque(i).getTiempoEncendido());
                dataRow.put("T" + (i + 1) + FIN_ENCENDIDO, "" + Math.floor(iteracion.getTanque(i).getFinEncendido() * 10000) / 10000);
                dataRow.put("T" + (i + 1) + RND_TAMAÑO, "" + iteracion.getTanque(i).getRndTamañoBuque());
                dataRow.put("T" + (i + 1) + TAMAÑO, "" + iteracion.getTanque(i).getTamañoBuque());
                dataRow.put("T" + (i + 1) + TIEMPO_BOMBEO, "" + iteracion.getTanque(i).getTiempoBombeo());
                dataRow.put("T" + (i + 1) + FIN_BOMBEO, "" + iteracion.getTanque(i).getFinBombeo());
                dataRow.put("T" + (i + 1) + DISPONIBLE, "" + iteracion.getTanque(i).getEspacioDisponible());
                dataRow.put("T" + (i + 1) + TIEMPO_LLENADO, "" + iteracion.getTanque(i).getTiempoLlenado());
                dataRow.put("T" + (i + 1) + HORA_LLENADO, "" + iteracion.getTanque(i).getHoraLlenado());
                dataRow.put("T" + (i + 1) + TIEMPO_DESCARGA, "" + iteracion.getTanque(i).getTiempoDesagote());
                dataRow.put("T" + (i + 1) + FIN_DESCARGA, "" + iteracion.getTanque(i).getFinDesagote());
            }
        } else {
            dataRow.put(EVENTO, "" + iteracion.getEvento().getNombre());
            dataRow.put(RELOJ, "" + Math.floor(iteracion.getReloj() * 10000) / 10000);

            //Se muestra solo cuando se produce una llegada
            if (evento instanceof EVLlegada) {
                dataRow.put(RND_LLEGADA, "" + Math.floor(iteracion.getRndProxLlegada() * 10000) / 10000);
                dataRow.put(TIEMPO_LLEGADA, "" + Math.floor(iteracion.getTiempoEntreLlegadas() * 10000) / 10000);
            }
            dataRow.put(PROX_LLEGADA, "" + Math.floor(iteracion.getProximaLlegada() * 10000) / 10000);
            dataRow.put(COLA, "" + iteracion.getColaEspera().size());

            for (int i = 0; i < 5; i++) {
                dataRow.put("T" + (i + 1) + ESTADO, "" + iteracion.getTanque(i).getEstado().getNombre());
                //Se muestra tiempoEncendido cuando se inicia el evento, el tiempo siempre que este encendiendose
                if (iteracion.getTanque(i).getEstado() instanceof ETEncendiendo) {
                    if (iteracion.getTanque(i).getFinEncendido() != anterior.getTanque(i).getFinEncendido())
                        dataRow.put("T" + (i + 1) + TIEMPO_ENCENDIDO, "" + iteracion.getTanque(i).getTiempoEncendido());
                    dataRow.put("T" + (i + 1) + FIN_ENCENDIDO, "" + Math.floor(iteracion.getTanque(i).getFinEncendido() * 10000) / 10000);
                }
                if (iteracion.getTanque(i).getEstado() instanceof ETBombeo) {
                    if (evento instanceof EVFinEncendido) {
                        dataRow.put("T" + (i + 1) + RND_TAMAÑO, "" + Math.floor(iteracion.getTanque(i).getRndTamañoBuque() * 10000) / 10000);
                        dataRow.put("T" + (i + 1) + TAMAÑO, "" + iteracion.getTanque(i).getTamañoBuque());
                        dataRow.put("T" + (i + 1) + TIEMPO_BOMBEO, "" + Math.floor(iteracion.getTanque(i).getTiempoBombeo() * 10000) / 10000);
                    }
                    dataRow.put("T" + (i + 1) + FIN_BOMBEO, "" + Math.floor(iteracion.getTanque(i).getFinBombeo() * 10000) / 10000);
                }
                dataRow.put("T" + (i + 1) + DISPONIBLE, "" + iteracion.getTanque(i).getEspacioDisponible());

                if (iteracion.getTanque(i).getEspacioDisponible() == 0)
                {
                    if(iteracion.getTanque(i).getEstado() instanceof ETBombeo)
                    {
                        if(evento instanceof EVFinEncendido)
                            dataRow.put("T" + (i + 1) + TIEMPO_LLENADO, "" + Math.floor(iteracion.getTanque(i).getTiempoLlenado() * 10000) / 10000);
                        dataRow.put("T" + (i + 1) + HORA_LLENADO, "" + Math.floor(iteracion.getTanque(i).getHoraLlenado() * 10000) / 10000);
                    }
                }

                if (iteracion.getTanque(i).getEstado() instanceof ETDescargando) {
                    if (evento instanceof EVLlenado) {
                        dataRow.put("T" + (i + 1) + TIEMPO_DESCARGA, "" + Math.floor(iteracion.getTanque(i).getTiempoDesagote() * 10000) / 10000);
                    }
                    dataRow.put("T" + (i + 1) + FIN_DESCARGA, "" + Math.floor(iteracion.getTanque(i).getFinDesagote() * 10000) / 10000);
                }
            }

            lblMaxCola.setText("Tamaño máximo de cola: " + iteracion.getTamañoMaximoCola());
            lblTotalDescargado.setText("Total descargados: " + iteracion.getAcumuladoDescargados());
        }

        dataRow.put(MAX_COLA, "" + iteracion.getTamañoMaximoCola());
        dataRow.put(DESCARGADO, "" + iteracion.getAcumuladoDescargados());

        for (int i = 0; i < 5; i++)
        {
            if ((anterior.getTanque(i).getBuque() != null) && (iteracion.getTanque(i).getBuque().esBuque(anterior.getTanque(i).getBuque())))
                agregarBuque(anterior.getTanque(i).getBuque(), dataRow);
            agregarBuque(iteracion.getTanque(i).getBuque(), dataRow);
        }

        for (Buque buque : iteracion.getColaEspera())
            agregarBuque(buque, dataRow);

        for (Buque buque : iteracion.getColaInterrumpidos())
            agregarBuque(buque, dataRow);

        listaIteraciones.addAll(dataRow);
        tblTabla.setItems(listaIteraciones);

        colEvento.setCellValueFactory(new MapValueFactory<>(EVENTO));
        colReloj.setCellValueFactory(new MapValueFactory<>(RELOJ));
        colRndTiempoLlegada.setCellValueFactory(new MapValueFactory<>(RND_LLEGADA));
        colTiempoLlegadas.setCellValueFactory(new MapValueFactory<>(TIEMPO_LLEGADA));
        colProxLlegada.setCellValueFactory(new MapValueFactory<>(PROX_LLEGADA));
        colCola.setCellValueFactory(new MapValueFactory<>(COLA));

        colEstado1.setCellValueFactory(new MapValueFactory<>("T1" + ESTADO));
        colTiempoEncendido1.setCellValueFactory(new MapValueFactory<>("T1" + TIEMPO_ENCENDIDO));
        colFinEncendido1.setCellValueFactory(new MapValueFactory<>("T1" + FIN_ENCENDIDO));
        colRndTamañoBuque1.setCellValueFactory(new MapValueFactory<>("T1" + RND_TAMAÑO));
        colTamaño1.setCellValueFactory(new MapValueFactory<>("T1" + TAMAÑO));
        colTiempoBombeo1.setCellValueFactory(new MapValueFactory<>("T1" + TIEMPO_BOMBEO));
        colFinBombeo1.setCellValueFactory(new MapValueFactory<>("T1" + FIN_BOMBEO));
        colEspacioDisponible1.setCellValueFactory(new MapValueFactory<>("T1" + DISPONIBLE));
        colHoraLlenado1.setCellValueFactory(new MapValueFactory<>("T1" + HORA_LLENADO));
        colTiempoLlenado1.setCellValueFactory(new MapValueFactory<>("T1" + TIEMPO_LLENADO));
        colTiempoDescarga1.setCellValueFactory(new MapValueFactory<>("T1" + TIEMPO_DESCARGA));
        colFinDescarga1.setCellValueFactory(new MapValueFactory<>("T1" + FIN_DESCARGA));

        colEstado2.setCellValueFactory(new MapValueFactory<>("T2" + ESTADO));
        colTiempoEncendido2.setCellValueFactory(new MapValueFactory<>("T2" + TIEMPO_ENCENDIDO));
        colFinEncendido2.setCellValueFactory(new MapValueFactory<>("T2" + FIN_ENCENDIDO));
        colRndTamañoBuque2.setCellValueFactory(new MapValueFactory<>("T2" + RND_TAMAÑO));
        colTamaño2.setCellValueFactory(new MapValueFactory<>("T2" + TAMAÑO));
        colTiempoBombeo2.setCellValueFactory(new MapValueFactory<>("T2" + TIEMPO_BOMBEO));
        colFinBombeo2.setCellValueFactory(new MapValueFactory<>("T2" + FIN_BOMBEO));
        colEspacioDisponible2.setCellValueFactory(new MapValueFactory<>("T2" + DISPONIBLE));
        colTiempoLlenado2.setCellValueFactory(new MapValueFactory<>("T2" + TIEMPO_LLENADO));
        colHoraLlenado2.setCellValueFactory(new MapValueFactory<>("T2" + HORA_LLENADO));
        colTiempoDescarga2.setCellValueFactory(new MapValueFactory<>("T2" + TIEMPO_DESCARGA));
        colFinDescarga2.setCellValueFactory(new MapValueFactory<>("T2" + FIN_DESCARGA));

        colEstado3.setCellValueFactory(new MapValueFactory<>("T3" + ESTADO));
        colTiempoEncendido3.setCellValueFactory(new MapValueFactory<>("T3" + TIEMPO_ENCENDIDO));
        colFinEncendido3.setCellValueFactory(new MapValueFactory<>("T3" + FIN_ENCENDIDO));
        colRndTamañoBuque3.setCellValueFactory(new MapValueFactory<>("T3" + RND_TAMAÑO));
        colTamaño3.setCellValueFactory(new MapValueFactory<>("T3" + TAMAÑO));
        colTiempoBombeo3.setCellValueFactory(new MapValueFactory<>("T3" + TIEMPO_BOMBEO));
        colFinBombeo3.setCellValueFactory(new MapValueFactory<>("T3" + FIN_BOMBEO));
        colEspacioDisponible3.setCellValueFactory(new MapValueFactory<>("T3" + DISPONIBLE));
        colTiempoLlenado3.setCellValueFactory(new MapValueFactory<>("T3" + TIEMPO_LLENADO));
        colHoraLlenado3.setCellValueFactory(new MapValueFactory<>("T3" + HORA_LLENADO));
        colTiempoDescarga3.setCellValueFactory(new MapValueFactory<>("T3" + TIEMPO_DESCARGA));
        colFinDescarga3.setCellValueFactory(new MapValueFactory<>("T3" + FIN_DESCARGA));

        colEstado4.setCellValueFactory(new MapValueFactory<>("T4" + ESTADO));
        colTiempoEncendido4.setCellValueFactory(new MapValueFactory<>("T4" + TIEMPO_ENCENDIDO));
        colFinEncendido4.setCellValueFactory(new MapValueFactory<>("T4" + FIN_ENCENDIDO));
        colRndTamañoBuque4.setCellValueFactory(new MapValueFactory<>("T4" + RND_TAMAÑO));
        colTamaño4.setCellValueFactory(new MapValueFactory<>("T4" + TAMAÑO));
        colTiempoBombeo4.setCellValueFactory(new MapValueFactory<>("T4" + TIEMPO_BOMBEO));
        colFinBombeo4.setCellValueFactory(new MapValueFactory<>("T4" + FIN_BOMBEO));
        colEspacioDisponible4.setCellValueFactory(new MapValueFactory<>("T4" + DISPONIBLE));
        colTiempoLlenado4.setCellValueFactory(new MapValueFactory<>("T4" + TIEMPO_LLENADO));
        colHoraLlenado4.setCellValueFactory(new MapValueFactory<>("T4" + HORA_LLENADO));
        colTiempoDescarga4.setCellValueFactory(new MapValueFactory<>("T4" + TIEMPO_DESCARGA));
        colFinDescarga4.setCellValueFactory(new MapValueFactory<>("T4" + FIN_DESCARGA));

        colEstado5.setCellValueFactory(new MapValueFactory<>("T5" + ESTADO));
        colTiempoEncendido5.setCellValueFactory(new MapValueFactory<>("T5" + TIEMPO_ENCENDIDO));
        colFinEncendido5.setCellValueFactory(new MapValueFactory<>("T5" + FIN_ENCENDIDO));
        colRndTamañoBuque5.setCellValueFactory(new MapValueFactory<>("T5" + RND_TAMAÑO));
        colTamaño5.setCellValueFactory(new MapValueFactory<>("T5" + TAMAÑO));
        colTiempoBombeo5.setCellValueFactory(new MapValueFactory<>("T5" + TIEMPO_BOMBEO));
        colFinBombeo5.setCellValueFactory(new MapValueFactory<>("T5" + FIN_BOMBEO));
        colEspacioDisponible5.setCellValueFactory(new MapValueFactory<>("T5" + DISPONIBLE));
        colTiempoLlenado5.setCellValueFactory(new MapValueFactory<>("T5" + TIEMPO_LLENADO));
        colHoraLlenado5.setCellValueFactory(new MapValueFactory<>("T5" + HORA_LLENADO));
        colTiempoDescarga5.setCellValueFactory(new MapValueFactory<>("T5" + TIEMPO_DESCARGA));
        colFinDescarga5.setCellValueFactory(new MapValueFactory<>("T5" + FIN_DESCARGA));

        colMaxCola.setCellValueFactory(new MapValueFactory<>(MAX_COLA));
        colDescargados.setCellValueFactory(new MapValueFactory<>(DESCARGADO));

    }

    private void agregarBuque(Buque buque, Map<String, String> dataRow) {
        String nombre = "";
        TableColumn columnaBuque = null;
        TableColumn columnaDato = null;

        if (buque != null) {
            nombre = "Buque " + buque.getId();

            for (TableColumn<Map, ?> column : tblTabla.getColumns()) {
                if (column.getText().equalsIgnoreCase(nombre)) {
                    columnaBuque = column;
                    break;
                }
            }

            if (columnaBuque != null) {
                columnaDato = encontrarColumnaDato(columnaBuque, ESTADO_BUQUE);
                dataRow.put(ESTADO_BUQUE + buque.getId(), buque.getEstado().getNombre());
                columnaDato.setCellValueFactory(new MapValueFactory<>(ESTADO_BUQUE + buque.getId()));

                columnaDato = encontrarColumnaDato(columnaBuque, CARGA_RESTANTE);
                dataRow.put(CARGA_RESTANTE + buque.getId(), "" + buque.getCargaRestante());
                columnaDato.setCellValueFactory(new MapValueFactory<>(CARGA_RESTANTE + buque.getId()));
            } else {
                TableColumn colBuque = new TableColumn(nombre);
                TableColumn colEstadoBuque = new TableColumn(ESTADO_BUQUE);
                TableColumn colCargaRestante = new TableColumn(CARGA_RESTANTE);

                colBuque.getColumns().addAll(colEstadoBuque, colCargaRestante);
                tblTabla.getColumns().addAll(colBuque);

                dataRow.put(ESTADO_BUQUE + buque.getId(), buque.getEstado().getNombre());
                colEstadoBuque.setCellValueFactory(new MapValueFactory<>(ESTADO_BUQUE + buque.getId()));

                dataRow.put(CARGA_RESTANTE + buque.getId(), "" + buque.getCargaRestante());
                colCargaRestante.setCellValueFactory(new MapValueFactory<>(CARGA_RESTANTE + buque.getId()));

            }
        } else {
            dataRow.put(ESTADO_BUQUE, "");
            dataRow.put(CARGA_RESTANTE, "");
        }
    }

    private TableColumn encontrarColumnaDato(TableColumn columnaBuque, String nombreColumna)
    {
        TableColumn columna = null;
        ObservableList<TableColumn> ol = null;
        ol = columnaBuque.getColumns();

        for (int i = 0; i < ol.size(); i++)
        {
            if (ol.get(i).getText().equalsIgnoreCase(nombreColumna))
            {
                columna = ol.get(i);
            }
        }

        return columna;
    }



    private final String EVENTO = "Evento";
    private final String RELOJ = "Reloj";
    private final String RND_LLEGADA = "RndLlegada";
    private final String TIEMPO_LLEGADA = "TiempoLlegada";
    private final String PROX_LLEGADA = "ProxLlegada";
    private final String COLA = "Cola";

    private final String ESTADO = "Estado";
    private final String TIEMPO_ENCENDIDO = "TiempoEncendido";
    private final String FIN_ENCENDIDO = "FinEncendido";
    private final String RND_TAMAÑO = "RndTamaño";
    private final String TAMAÑO = "Tamaño";
    private final String TIEMPO_BOMBEO = "TiempoBombeo";
    private final String FIN_BOMBEO = "FinBombeo";
    private final String DISPONIBLE = "Disponible";
    private final String TIEMPO_LLENADO = "TiempoLlenado";
    private final String HORA_LLENADO = "HoraLlenado";
    private final String TIEMPO_DESCARGA = "TiempoDescarga";
    private final String FIN_DESCARGA = "FinDescarga";

    private final String MAX_COLA = "MaxCola";
    private final String DESCARGADO = "Descargado";

    private final String ESTADO_BUQUE = "EstadoBuque";
    private final String CARGA_RESTANTE = "CargaRestante";

}
