package model;

public class TiempoEjecucion {
	private Integer nTamaņoMatriz;
	private Long tiempoEjecucion;


      //////////////////////// Constructor de la clase //////////////////////

	public TiempoEjecucion(Integer nTamaņoMatriz, Long tiempoEjecucion) {
		super();
		this.nTamaņoMatriz = nTamaņoMatriz;
		this.tiempoEjecucion = tiempoEjecucion;
	}

      ///////////////////////// gets y sets /////////////////////////////////

	public Integer getnTamaņoMatriz() {
		return nTamaņoMatriz;
	}

	public void setnTamaņoMatriz(Integer nTamaņoMatriz) {
		this.nTamaņoMatriz = nTamaņoMatriz;
	}

	public Long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(Long TiempoEjecucion) {
		this.tiempoEjecucion = TiempoEjecucion;
	}

	@Override
	public String toString() {
		return "TiempoEjecucion [nTamaņoMatriz=" + nTamaņoMatriz + ", tiempoEjecucion=" + tiempoEjecucion + "]";
	}
}
