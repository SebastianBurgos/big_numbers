package model;

import java.util.ArrayList;

import algoritmos.AmericanoIterativo;
import algoritmos.AmericanoIterativoDinamico;
import algoritmos.AmericanoRecursivo;
import algoritmos.AmericanoRecursivoDinamico;
import algoritmos.DivideVenceras1;
import algoritmos.DivideVenceras2;
import algoritmos.Egipcio;
import algoritmos.Hindu;
import algoritmos.InglesaIterativa;
import algoritmos.InglesaIterativaDinamica;
import algoritmos.InglesaRecursiva;
import algoritmos.InglesaRecursivaDinamica;
import algoritmos.Karatsuba;
import algoritmos.MetodoAlgoritmo;
import algoritmos.MultiplicacionRepresentadaCadenas;
import algoritmos.Ruso;
import utilities.Archivos;

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
		algoritmosLst.add(new Algoritmo(1, new AmericanoIterativo()));
		algoritmosLst.add(new Algoritmo(2, new AmericanoIterativoDinamico()));
		algoritmosLst.add(new Algoritmo(3, new AmericanoRecursivo()));
		algoritmosLst.add(new Algoritmo(4, new AmericanoRecursivoDinamico()));
		algoritmosLst.add(new Algoritmo(5, new InglesaIterativa()));
		algoritmosLst.add(new Algoritmo(6, new InglesaIterativaDinamica()));
		algoritmosLst.add(new Algoritmo(7, new InglesaRecursiva()));
		algoritmosLst.add(new Algoritmo(8, new InglesaRecursivaDinamica()));
		algoritmosLst.add(new Algoritmo(9, new Ruso()));
		algoritmosLst.add(new Algoritmo(10, new Hindu()));
		algoritmosLst.add(new Algoritmo(11, new Egipcio()));
		algoritmosLst.add(new Algoritmo(12, new Karatsuba()));
		algoritmosLst.add(new Algoritmo(13, new MultiplicacionRepresentadaCadenas()));
		algoritmosLst.add(new Algoritmo(14, new DivideVenceras1()));
		algoritmosLst.add(new Algoritmo(15, new DivideVenceras2()));
	}

	/**
	 *
	 * @param numeroAlgoritmo
	 */
	public void ejecutarAlgoritmo (int numeroAlgoritmo) {
		//Para refrescar tabla con valores nuevos
		refrescarValoresUsadosTabla(numeroAlgoritmo);
		int nDigitos, numeroTE = 0;
		Long tiempoEjecucion;
		ArrayList<TiempoEjecucion> lstTEAux = new ArrayList<>();

		/**CAMBIAR i<=n para cambiar la cantidad de archivos ejecutados
		 * MAXIMO = i <= 10
		 */
		for (int i = 3; i <= 6; i++) {
			nDigitos = (int)Math.pow(3, i);
			String ruta = obtenerRuta(nDigitos);

			//Numero para realizar metodos estaticos
			int[] numeroEstatico = Archivos.leerArchivoPruebaArregloEstatico(ruta);
			//Numero apra realizar metodos dinamicos
			ArrayList<Integer> numeroDinamico = Archivos.leerArchivoPruebaArregloDinamico(ruta);

			//Datos necesarios para el calculo de los tiempos de ejecucion
			Long tiempoInicio = (long) 0;
			Long tiempoFinal = (long) 0;

			//Los que reciben dos listas estaticas int[]
			if (numeroAlgoritmo == 0 || numeroAlgoritmo == 4 || numeroAlgoritmo == 8 || numeroAlgoritmo == 9
					|| numeroAlgoritmo == 2 || numeroAlgoritmo == 6) {
				MetodoAlgoritmo metodo = algoritmosLst.get(numeroAlgoritmo).getMetodoAlgoritmo();
				//En este momento se calcula exactamente el tiempo en nanosegundos de la invocacion
				tiempoInicio = System.nanoTime();
				metodo.multiplicar(numeroEstatico, numeroEstatico);
				tiempoFinal = System.nanoTime();
			}
			//Los que reciben dos listas dinamicas ArrayList
			if (numeroAlgoritmo == 1 || numeroAlgoritmo == 3) {
				MetodoAlgoritmo metodo = algoritmosLst.get(numeroAlgoritmo).getMetodoAlgoritmo();
				//En este momento se calcula exactamente el tiempo en nanosegundos de la invocacion
				tiempoInicio = System.nanoTime();
				metodo.multiplicar(numeroDinamico, numeroDinamico);
				tiempoFinal = System.nanoTime();
			}

			//Se obtiene el tiempo de ejecucion mediante la resta
			tiempoEjecucion = tiempoFinal - tiempoInicio;

			//Se crea la variable TiempoEjecucion para saber de que tamaño de matriz fue
			//hallado ese te
	        TiempoEjecucion te = new TiempoEjecucion(nDigitos, tiempoEjecucion);

	        //Se agrega a la lista auxiliar, la cual al finalizar de agregar todos
	        //Se insertara completa en el algoritmo indicado
	        lstTEAux.add(numeroTE, te);
			System.out.println("Multiplicacion "+nDigitos+" x "+nDigitos+" Realizada: "+te+" ms");
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
	 * @param nDigitos
	 * @return
	 */
	private String obtenerRuta(int nDigitos) {
		return "./src/test_files/numero-"+nDigitos+"-digitos.txt";
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
