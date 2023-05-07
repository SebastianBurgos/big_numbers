package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Algoritmo;
import model.AlgoritmoView;
import model.TiempoEjecucion;


public class MainController {
	Aplicacion main;

	ObservableList<AlgoritmoView> lstAlgoritmosViewData = FXCollections.observableArrayList();
	ObservableList<Algoritmo> lstAlgoritmosSorted = FXCollections.observableArrayList();
	ObservableList<Algoritmo> listaAlgoritmos = FXCollections.observableArrayList();
	ArrayList<Algoritmo> lstAlgoritmos = new ArrayList<>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	////////////////// PESTA�A ANALISIS DE TIEMPOS DE EJECUCION ////////////////////

    @FXML
    private TableView<AlgoritmoView> tableTiemposEjecucion;

	@FXML
    private TableColumn<AlgoritmoView, Integer> colN1, colN2, colN3, colN4,
    colN5, colN6, colN7, colN8, colN9, colN10, colN11, colN12;

    @FXML
    private TableColumn<AlgoritmoView, ?> col1, col2, col3, col4, col5, col6,
    col7, col8, col9, col10, col11, col12;

    @FXML
    private TableColumn<AlgoritmoView, Long> colTE1, colTE2, colTE3, colTE4, colTE5,
    colTE6, colTE7, colTE8, colTE9, colTE10, colTE11, colTE12;

    ////////////////// PESTA�A DE ESTAD�STICAS Y GRAFICAS ////////////////////////////

    @FXML
    private BarChart<String, Long> barChartPromedios, barChartPromediosOrdenados;

    @FXML
    private LineChart<String, Long> lineChart;

    @FXML
    private CategoryAxis xAxisPromedios, xAxisPromediosOrdenados, xAxisLineChart;

    @FXML
    private TableView<Algoritmo> tableEstadisticas;

    @FXML
    private TableColumn<Algoritmo, Double> tEstadisticascolPromedio, tEstadisticascolRango, tEstadisticascolVarianza, tEstadisticascolDesvEstandar;

    @FXML
    private TableColumn<Algoritmo, String> tEstadisticascolNombreAlgoritmo;

    @FXML
    private TableColumn<Algoritmo, Integer> tEstadisticascolNumeroAlgoritmo;

    //Para inicializar el eje X de la grafica de promedios de TE de algoritmos
	private ObservableList<String> numerosEjeX = FXCollections.observableArrayList();

	//Para inicializar el eje X de la grafica de Puntos TE vs Tama�os de matriz
  	private ObservableList<String> numerosTamaniosMatrizX = FXCollections.observableArrayList();

    /**
     * Cuando se clickea el boton de ejecutar comienzan a ejecutarse hilos para cada algoritmo
     * @param event
     */
    @FXML
    void ejecutarAlgoritmos(ActionEvent event) {
    	mostrarVentanaEmergente("Los resultados de la ejecuci�n los podr� ver en unos segundos"
    			+ "\nPor favor espere un momento y tomese una arom�tica");
    	//Se crea ejecuta cada algoritmo
    	for (int i = 0; i < 16; i++) {
    		main.ejecutarAlgoritmo(i);
    	}
    	//Se actualiza la tabla
    	refrescarTabla();
    	//Se actualizan los datos para la siguiente pesta�a de estad�sticas
		refrescarDatos();
		main.calcularDatosEstadisticos();
		inicializarTablaEstadisticas();
    }

	/**
     * Metodo para mostrar un mensaje en una ventanita emergente
     * @param msg
     */
    private void mostrarVentanaEmergente(String msg) {
    	 JOptionPane.showMessageDialog(null, msg);
	}

	/**
      * Este metodo permite refrescar la tabla donde se muestran los tiempos de ejecucion de cada algoritmo
      */
    void refrescarTabla(){
    	tableTiemposEjecucion.getItems().clear();
    	tableTiemposEjecucion.setItems(getListaAlgoritmosViewData());
    }

     /**
      * Este metodo permite limpiar y capturar los nuevos valores
      * de la lista de los tiempos de ejecucucion de los algoritmos
      */
	private ObservableList<AlgoritmoView> getListaAlgoritmosViewData() {
		 lstAlgoritmosViewData.clear();
		 lstAlgoritmosViewData.addAll(main.obtenerLstAlgoritmosView());
		 return lstAlgoritmosViewData;
	}

    private void inicializarTablaEstadisticas() {
    	refrescarDatos();
    	refrescarTablaEstadisticas();

    }

	private void refrescarTablaEstadisticas() {
		tableEstadisticas.getItems().clear();
		tableEstadisticas.setItems(listaAlgoritmos);
		tableEstadisticas.refresh();
	}

	@FXML
	void graficarPromedios(){
		barChartPromedios.getData().clear();
		if (lstAlgoritmos.isEmpty()) {
			mostrarVentanaEmergente("Primero ejecute los an�lisis en la pesta�a anterior");
		}else{

			XYChart.Series<String, Long> series = new XYChart.Series<>();

			for (Algoritmo algoritmo : lstAlgoritmos) {
				series.getData().add(new XYChart.Data<>(algoritmo.getNumero()+"", Double.valueOf(algoritmo.getMediaTE()).longValue()));
			}

			barChartPromedios.getData().add(series);
		}
	}

	private void refrescarDatos() {
		 lstAlgoritmos.clear();
		 lstAlgoritmos.addAll(main.obtenerLstAlgoritmos());
		 listaAlgoritmos.clear();
		 listaAlgoritmos.addAll(lstAlgoritmos);
	}

	@FXML
	void graficarOrdenCreciente(){
		if (lstAlgoritmos.isEmpty()) {
			mostrarVentanaEmergente("Primero ejecute los an�lisis en la pesta�a anterior");
		}else{
			ArrayList<Algoritmo> lstAlgoritmosOrdenados = new ArrayList<>();
			lstAlgoritmosOrdenados.addAll(lstAlgoritmos);
			Collections.sort(lstAlgoritmosOrdenados, new Comparator<Algoritmo>() {
			    @Override
			    public int compare(Algoritmo o1, Algoritmo o2) {
			        return o1.getMediaTE().compareTo(o2.getMediaTE());
			    }
			});
			lstAlgoritmosSorted.clear();
			lstAlgoritmosSorted.addAll(lstAlgoritmosOrdenados);

			ObservableList<String> numerosEjeX = FXCollections.observableArrayList();
			for (Algoritmo algoritmo : lstAlgoritmosOrdenados) {
				numerosEjeX.add(algoritmo.getNumero()+"");
			}
			xAxisPromediosOrdenados.setCategories(numerosEjeX);

			barChartPromediosOrdenados.getData().clear();

			XYChart.Series<String, Long> series = new XYChart.Series<>();

			for (Algoritmo algoritmo : lstAlgoritmosOrdenados) {
				series.getData().add(new XYChart.Data<>(algoritmo.getNumero()+"", Double.valueOf(algoritmo.getMediaTE()).longValue()));
			}

			barChartPromediosOrdenados.getData().add(series);
		}
	}

	/**
	 * Se inicializan las celdas de la tabla para que se puedan usar y
	 * se pone el nombre exacto del atributo espec�fico de la clase AlgoritmoView
	 */
	@FXML
	void initialize() {
		//Para la tabla de la primera pesta�a
		this.colN1.setCellValueFactory(new PropertyValueFactory<>("n1"));
		this.colTE1.setCellValueFactory(new PropertyValueFactory<>("te1"));
		this.colN2.setCellValueFactory(new PropertyValueFactory<>("n2"));
		this.colTE2.setCellValueFactory(new PropertyValueFactory<>("te2"));
		this.colN3.setCellValueFactory(new PropertyValueFactory<>("n3"));
		this.colTE3.setCellValueFactory(new PropertyValueFactory<>("te3"));
		this.colN4.setCellValueFactory(new PropertyValueFactory<>("n4"));
		this.colTE4.setCellValueFactory(new PropertyValueFactory<>("te4"));
		this.colN5.setCellValueFactory(new PropertyValueFactory<>("n5"));
		this.colTE5.setCellValueFactory(new PropertyValueFactory<>("te5"));
		this.colN6.setCellValueFactory(new PropertyValueFactory<>("n6"));
		this.colTE6.setCellValueFactory(new PropertyValueFactory<>("te6"));
		this.colN7.setCellValueFactory(new PropertyValueFactory<>("n7"));
		this.colTE7.setCellValueFactory(new PropertyValueFactory<>("te7"));
		this.colN8.setCellValueFactory(new PropertyValueFactory<>("n8"));
		this.colTE8.setCellValueFactory(new PropertyValueFactory<>("te8"));
		this.colN9.setCellValueFactory(new PropertyValueFactory<>("n9"));
		this.colTE9.setCellValueFactory(new PropertyValueFactory<>("te9"));
		this.colN10.setCellValueFactory(new PropertyValueFactory<>("n10"));
		this.colTE10.setCellValueFactory(new PropertyValueFactory<>("te10"));
		this.colN11.setCellValueFactory(new PropertyValueFactory<>("n11"));
		this.colTE11.setCellValueFactory(new PropertyValueFactory<>("te11"));
		this.colN12.setCellValueFactory(new PropertyValueFactory<>("n12"));
		this.colTE12.setCellValueFactory(new PropertyValueFactory<>("te12"));

		//Para inicializar la tabla de las estadisticas
    	this.tEstadisticascolNombreAlgoritmo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	this.tEstadisticascolNumeroAlgoritmo.setCellValueFactory(new PropertyValueFactory<>("numero"));
    	this.tEstadisticascolPromedio.setCellValueFactory(new PropertyValueFactory<>("mediaTE"));
    	this.tEstadisticascolDesvEstandar.setCellValueFactory(new PropertyValueFactory<>("desviacionEstandarTE"));
    	this.tEstadisticascolRango.setCellValueFactory(new PropertyValueFactory<>("rangoTE"));
    	this.tEstadisticascolVarianza.setCellValueFactory(new PropertyValueFactory<>("varianzaTE"));

		for (int i = 1; i <= 16; i++) {
			numerosEjeX.add(i+"");
		}
		xAxisPromedios.setCategories(numerosEjeX);

		for (int i = 2; i <= 13; i++) {
			int num = (int)Math.pow(2, i);
			numerosTamaniosMatrizX.add(num+"");
		}
		xAxisLineChart.setCategories(numerosTamaniosMatrizX);

		// Escucha los cambios de seleccion de elementos en la tabla de estad�sticas.
        tableEstadisticas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> generarGraficaAlgoritmoSeleccionado(newValue));
	}

	private void generarGraficaAlgoritmoSeleccionado(Algoritmo algoritmoSeleccionado) {
		lineChart.getData().clear();

		XYChart.Series<String, Long> series = new XYChart.Series<>();

		for (Algoritmo algoritmo : lstAlgoritmos) {
			if (algoritmo == algoritmoSeleccionado) {
				int i = 0;
				for (TiempoEjecucion te : algoritmo.getTiemposEjecucionLst()) {
					series.getData().add(new XYChart.Data<>(numerosTamaniosMatrizX.get(i)+"", te.getTiempoEjecucion()));
					i++;
				}
			}
		}

		lineChart.getData().add(series);

	}

	public void setAplicacion(Aplicacion main) {
		this.main = main;
	}
}
