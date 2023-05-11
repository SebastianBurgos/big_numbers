package application;
/*
 * Desarrollado por:
 *  Sebastian Burgos Puentes
 * 	Juan Sebastian Hoyos
 *  Juan Esteban Granda
 *  
 */
import java.io.IOException;
import java.util.ArrayList;

import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Algoritmo;
import model.AlgoritmoView;
import model.Sistema;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Aplicacion extends Application {

	private Stage primaryStage;
	private static Sistema sistema = new Sistema();

	public static void main(String[] args) {
		sistema.crearAlgoritmos();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Aplicacion");
		mostrarVentanaMain();
	}

     // Metodo que nos muestra la interfaz

	private void mostrarVentanaMain() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/view/MainView.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();
			MainController mainController = loader.getController();
			mainController.setAplicacion(this);

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

     //metodo que permite ejecutar el algoritmo de acuerdo al numero que le llegue por parametro

	public void ejecutarAlgoritmo(int numeroAlgoritmo) {
		sistema.ejecutarAlgoritmo(numeroAlgoritmo);
	}

     //metodo que permite capturar la lista de los algortimos

	public ArrayList<Algoritmo> obtenerLstAlgoritmos() {
		return sistema.getAlgoritmosLst();
	}

      // metodo que permite capturar la lista de algoritmos que se visualizan en la interfaz

	public ArrayList<AlgoritmoView> obtenerLstAlgoritmosView() {
		return sistema.getAlgoritmoViewLst();
	}

	/**
	 * Metodo que calcula los datos estadisticos apenas se hunda el boton ejecutar algoritmos
	 */
	public void calcularDatosEstadisticos() {
		sistema.calcularDatosEstadisticos();
	}
}
