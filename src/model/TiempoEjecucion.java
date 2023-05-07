package model;

public class TiempoEjecucion {
	private Integer nTamanioMatriz;
	private Long tiempoEjecucion;


      //////////////////////// Constructor de la clase //////////////////////

	public TiempoEjecucion(Integer nTamanioMatriz, Long tiempoEjecucion) {
		super();
		this.nTamanioMatriz = nTamanioMatriz;
		this.tiempoEjecucion = tiempoEjecucion;
	}

      ///////////////////////// gets y sets /////////////////////////////////

	public Integer getnTamanioMatriz() {
		return nTamanioMatriz;
	}

	public void setnTamanioMatriz(Integer nTamanioMatriz) {
		this.nTamanioMatriz = nTamanioMatriz;
	}

	public Long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(Long TiempoEjecucion) {
		this.tiempoEjecucion = TiempoEjecucion;
	}

	@Override
	public String toString() {
		return "TiempoEjecucion [nTama�oMatriz=" + nTamanioMatriz + ", tiempoEjecucion=" + tiempoEjecucion + "]";
	}
}
