package model;

import java.lang.reflect.Method;
import java.util.ArrayList;

import utilities.Archivos;
import utilities.Metodos;

/**
 * La clase sistema será la central para la ejecución de todos los procesos, desde
 * esta clase se tiene acceso a todos los algoritmos y a el mapeo de estos
 * por medio de la lista de AlgoritmosView
 * @author User
 *
 */
public class Sistema {

	private ArrayList<Algoritmo> algoritmosLst = new ArrayList<>();
	private ArrayList<AlgoritmoView> algoritmoViewLst = new ArrayList<>();

	public Sistema() {
		super();
	}

	public ArrayList<Algoritmo> getAlgoritmosLst() {
		return algoritmosLst;
	}

	public void setAlgoritmosLst(ArrayList<Algoritmo> algoritmosLst) {
		this.algoritmosLst = algoritmosLst;
	}

	public ArrayList<AlgoritmoView> getAlgoritmoViewLst() {
		return algoritmoViewLst;
	}

	public void setAlgoritmoViewLst(ArrayList<AlgoritmoView> algoritmoViewLst) {
		this.algoritmoViewLst = algoritmoViewLst;
	}


     /**
      * Este metodo guardarda en una lista el numero y nombre de cada uno
      * de los algoritmos, es muy importante copiar bien el nombre del algoritmo
      * segun el método de la clase Metodos del paquete utilities, ya que
      * al momento de realizar la ejecución del análisis, se irán tomando
      * estos nombres y se irán invocando los métodos con estos nombres
      */
	public void crearAlgoritmos() {
		algoritmosLst.add(new Algoritmo(1, "NaivStandard"));
		algoritmosLst.add(new Algoritmo(2, "NaivOnArray"));
		algoritmosLst.add(new Algoritmo(3, "NaivKhan"));
		algoritmosLst.add(new Algoritmo(4, "NaivLoopUnrollingTwo"));
		algoritmosLst.add(new Algoritmo(5, "NaivLoopUnrollingThree"));
		algoritmosLst.add(new Algoritmo(6, "NaivLoopUnrollingFour"));
		algoritmosLst.add(new Algoritmo(7, "WinogradOriginal"));
		algoritmosLst.add(new Algoritmo(8, "WinogradScaled"));
		algoritmosLst.add(new Algoritmo(9, "StrassenNaiv"));
		algoritmosLst.add(new Algoritmo(10, "StrassenWinograd"));
		algoritmosLst.add(new Algoritmo(11, "III3SequentialBlock"));
		algoritmosLst.add(new Algoritmo(12, "III4ParallelBlock"));
		algoritmosLst.add(new Algoritmo(13, "IV3SequentialBlock"));
		algoritmosLst.add(new Algoritmo(14, "IV4ParallelBlock"));
		algoritmosLst.add(new Algoritmo(15, "V3SequentialBlock"));
		algoritmosLst.add(new Algoritmo(16, "V4ParallelBlock"));
	}

	/**
	 *
	 * @param numeroAlgoritmo
	 */
	public void ejecutarAlgoritmo (int numeroAlgoritmo) {
		//Para refrescar tabla con valores nuevos
		refrescarValoresUsadosTabla(numeroAlgoritmo);

		int nTamanioMatriz, numeroTE = 0;
		ArrayList<TiempoEjecucion> lstTEAux = new ArrayList<>();

		/**CAMBIAR i<=n para cambiar la cantidad de matrices ejecutadas
		 * Ojo: aquí solo se ejecuta hasta la matriz de tamaño 512x512
		 * ya que las siguientes matrices se demoran bastante tiempo en
		 * multiplicarse
		 */
		for (int i = 2; i <= 9; i++) {
			nTamanioMatriz = (int)Math.pow(2, i);
			String ruta = obtenerRuta(nTamanioMatriz);
			int[][] matrizA = Archivos.leerArchivoMatriz(ruta);
			int[][] matrizB = matrizA;
			//Matriz resultado
			int[][] matrizC = new int[nTamanioMatriz][nTamanioMatriz];
			//Datos necesarios para el calculo de los tiempos de ejecucion
			Long tiempoInicio = (long) 0;
			Long tiempoFinal = (long) 0;

			//Obtenemos el nombre del metodo a usar segun el nombre del algoritmo
			String nombreMetodo = algoritmosLst.get(numeroAlgoritmo).getNombre();
			System.out.println(nombreMetodo);
			//Se inicia una variable de tipo Method que servirá para invocar
			//la función segun el nombre del algoritmo
			Method metodo;
			try {
				//Se obtiene la variable de tipo Mhetod por medio del nombre y sus atributos con la
				//funcion propia de java getMethod()
				metodo = Metodos.class.getMethod(nombreMetodo, int[][].class, int[][].class, int[][].class, int.class, int.class, int.class);

				//Justo acá se calcula sólo la invocación de cada método sin
				//ningún proceso adicional lo que no afecta al rendimiento real
		        tiempoInicio = System.nanoTime();
		        metodo.invoke(null, matrizA, matrizB, matrizC, nTamanioMatriz, nTamanioMatriz, nTamanioMatriz);
		        tiempoFinal = System.nanoTime();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Se obtiene el te mediante la resta
			Long tiempoEjecucion = tiempoFinal - tiempoInicio;

			//Se crea la variable TiempoEjecucion para saber de que tamaño de matriz fue
			//hallado ese te
	        TiempoEjecucion te = new TiempoEjecucion(nTamanioMatriz, tiempoEjecucion);

	        //Se agrega a la lista auxiliar, la cual al finalizar de agregar todos
	        //Se insertara completa en el algoritmo indicado
	        lstTEAux.add(numeroTE, te);
			System.out.println("Multiplicacion "+nTamanioMatriz+" x "+nTamanioMatriz+" Realizada: "+te+" ms");
			//Aumentamos el numero de tiempo de ejecucion
			numeroTE++;
		}
		//Agregamos al algoritmo seleccionado la lista auxiliar de Tiempos de Ejecucion
		algoritmosLst.get(numeroAlgoritmo).setTiemposEjecucionLst(lstTEAux);

		//Creamos el mapeo de algoritmos para la tabla
		AlgoritmoView algoritmoViewNuevo = new AlgoritmoView(algoritmosLst.get(numeroAlgoritmo));
		algoritmoViewLst.add(algoritmoViewNuevo);
		System.out.println("ALGORITMO VIEW: "+algoritmoViewLst);
	}

	/**
	 * Metodo para obtener la ruta de cada archivo de matriz segun el tamaño
	 * @param nTamanioMatriz
	 * @return
	 */
	private String obtenerRuta(int nTamanioMatriz) {
		return "./src/matrixes_files/matriz"+nTamanioMatriz+"x"+nTamanioMatriz+".txt";
	}

	/**
	 * Este metodo verifica si ya se ha ejecutado el sistema anteriormente
	 * y se limpian los datos para que se puedan realizar nuevas ejecuciones
	 * y obtener nuevos tiempos de ejecución cada vez que se presione
	 * el boton
	 * @param numeroAlgoritmo
	 */
	private void refrescarValoresUsadosTabla(int numeroAlgoritmo) {
		//Se mira si el numero del algoritmo vuelve a ser 0 es porque comenzo
		//una nueva ejecución, y si el tamaño de la lista de algoritmos view ya tiene
		//los 16 algoritmos
		if (numeroAlgoritmo == 0 && algoritmoViewLst.size() == 16) {
			algoritmosLst.get(numeroAlgoritmo).setTiemposEjecucionLst(new ArrayList<TiempoEjecucion>());;
			algoritmoViewLst.clear();
		}
	}

	/**
	 * Este metodo sirve para calcular los datos estadisticos de todos los algoritmos
	 * se recorre cada uno y se invoca al metodo para cada uno
	 * si su lista de tiempos de ejecucion no esta vacía
	 */
	public void calcularDatosEstadisticos() {
		for (Algoritmo algoritmo : algoritmosLst) {
			if (!algoritmo.getTiemposEjecucionLst().isEmpty()) {
				algoritmo.calcularDatosEstadisticos();
			}
		}
	}

}
