package model;

import java.util.ArrayList;

import algoritmos.MetodoAlgoritmo;

public class Algoritmo {
	private Integer numero;
	private MetodoAlgoritmo metodoAlgoritmo;
	private String nombre;
	private Double mediaTE;
	private Double rangoTE;
	private Double desviacionEstandarTE;
	private Double varianzaTE;
	private Integer numAlgoritmosAnalizados;
	private ArrayList<TiempoEjecucion> tiemposEjecucionLst = new ArrayList<>();

    ////////////////////////////////Contructor de la clase//////////////////////////////


	public Algoritmo(Integer numero, MetodoAlgoritmo metodoAlgoritmo, String nombre) {
		super();
		this.numero = numero;
		this.metodoAlgoritmo = metodoAlgoritmo;
		this.nombre = nombre;
	}

    ////////////////////////////////////// sets y gets//////////////////////////////////

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public MetodoAlgoritmo getMetodoAlgoritmo() {
		return metodoAlgoritmo;
	}

	public void setMetodoAlgoritmo(MetodoAlgoritmo metodoAlgoritmo) {
		this.metodoAlgoritmo = metodoAlgoritmo;
	}

	public Integer getNumAlgoritmosAnalizados() {
		return numAlgoritmosAnalizados;
	}

	public void setNumAlgoritmosAnalizados(Integer numAlgoritmosAnalizados) {
		this.numAlgoritmosAnalizados = numAlgoritmosAnalizados;
	}

	public ArrayList<TiempoEjecucion> getTiemposEjecucionLst() {
		return tiemposEjecucionLst;
	}

	public void setTiemposEjecucionLst(ArrayList<TiempoEjecucion> tiemposEjecucionLst) {
		this.tiemposEjecucionLst = tiemposEjecucionLst;
	}

	public Double getMediaTE() {
		return mediaTE;
	}

	public void setMediaTE(Double mediaTE) {
		this.mediaTE = mediaTE;
	}

	public Double getRangoTE() {
		return rangoTE;
	}

	public void setRangoTE(Double rangoTE) {
		this.rangoTE = rangoTE;
	}

	public Double getDesviacionEstandarTE() {
		return desviacionEstandarTE;
	}

	public void setDesviacionEstandarTE(Double desviacionEstandarTE) {
		this.desviacionEstandarTE = desviacionEstandarTE;
	}

	public Double getVarianzaTE() {
		return varianzaTE;
	}

	public void setVarianzaTE(Double varianzaTE) {
		this.varianzaTE = varianzaTE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void calcularDatosEstadisticos() {
		calcularPromedio();
		calcularRango();
		calcularDesviacionEstandar();
		calcularVarianza();
	}

	/**
	 * Este metodo sirve para calcular y setear las medias de todos los algoritmos segun
	 * su lista de tiempos de ejución generada en el análisis
	 */
	private void calcularPromedio() {
		Double sum = 0.0, promedio = 0.0;
		Integer cant = 0;
		//Se recorre cada tiempo de ejecución de cada algoritmo
		for (TiempoEjecucion tiempoEjecucion : tiemposEjecucionLst) {
			sum += tiempoEjecucion.getTiempoEjecucion();
			cant++;
		}
		this.numAlgoritmosAnalizados = cant;
		promedio = sum / cant;
		//Se setea el promedio
		this.mediaTE = promedio;
	}

	/**
	 * Metodo para calcular el rango y setearselo al algoritmo
	 */
	private void calcularRango() {
        long maximo = tiemposEjecucionLst.get(0).getTiempoEjecucion();
        long minimo = tiemposEjecucionLst.get(0).getTiempoEjecucion();

        for (TiempoEjecucion tiempoEjecucion : tiemposEjecucionLst) {
        	Long te = tiempoEjecucion.getTiempoEjecucion();
            if (te > maximo) {
                maximo = te;
            }

            if (te < minimo) {
                minimo = te;
            }
        }

        Double rango = (double) (maximo - minimo);
        this.rangoTE = rango;
	}

	/**
	 * Metodo para calcular la desviacion estandar de la lista de tiempos de ejecucion
	 * de cada algoritmo
	 */
	private void calcularDesviacionEstandar() {
		double media = this.mediaTE;
        double sumatoria = 0.0;

        for (TiempoEjecucion tiempoEjecucion : tiemposEjecucionLst) {
            sumatoria += Math.pow(tiempoEjecucion.getTiempoEjecucion() - media, 2);
        }

        Double desviacionEstandar = Math.sqrt(sumatoria / this.numAlgoritmosAnalizados);
        this.desviacionEstandarTE = desviacionEstandar;
	}

	/**
	 * Metodo para calcular la varianza de la lista de tiempos de ejecucion de
	 * cada algoritmo
	 */
	private void calcularVarianza() {
		double media = this.mediaTE;
        double sumatoria = 0.0;

        for (TiempoEjecucion tiempoEjecucion : tiemposEjecucionLst) {
            sumatoria += Math.pow(tiempoEjecucion.getTiempoEjecucion() - media, 2);
        }

        Double varianza = sumatoria / this.numAlgoritmosAnalizados;
        this.varianzaTE = varianza;
	}

	@Override
	public String toString() {
		return "Algoritmo [numero=" + numero + ", metodoAlgoritmo=" + metodoAlgoritmo + ", mediaTE=" + mediaTE
				+ ", rangoTE=" + rangoTE + ", desviacionEstandarTE=" + desviacionEstandarTE + ", varianzaTE="
				+ varianzaTE + ", numAlgoritmosAnalizados=" + numAlgoritmosAnalizados + ", tiemposEjecucionLst="
				+ tiemposEjecucionLst + "]";
	}

}
