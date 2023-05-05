package model;

public class TiempoEjecucion {
	private Integer nTamañoMatriz;
	private Long tiempoEjecucion;


      //////////////////////// Constructor de la clase //////////////////////

	public TiempoEjecucion(Integer nTamañoMatriz, Long tiempoEjecucion) {
		super();
		this.nTamañoMatriz = nTamañoMatriz;
		this.tiempoEjecucion = tiempoEjecucion;
	}

      ///////////////////////// gets y sets /////////////////////////////////

	public Integer getnTamañoMatriz() {
		return nTamañoMatriz;
	}

	public void setnTamañoMatriz(Integer nTamañoMatriz) {
		this.nTamañoMatriz = nTamañoMatriz;
	}

	public Long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(Long TiempoEjecucion) {
		this.tiempoEjecucion = TiempoEjecucion;
	}

	@Override
	public String toString() {
		return "TiempoEjecucion [nTamañoMatriz=" + nTamañoMatriz + ", tiempoEjecucion=" + tiempoEjecucion + "]";
	}
}
