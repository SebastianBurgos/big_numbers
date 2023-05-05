package model;

public class TiempoEjecucion {
	private Integer nTama�oMatriz;
	private Long tiempoEjecucion;


      //////////////////////// Constructor de la clase //////////////////////

	public TiempoEjecucion(Integer nTama�oMatriz, Long tiempoEjecucion) {
		super();
		this.nTama�oMatriz = nTama�oMatriz;
		this.tiempoEjecucion = tiempoEjecucion;
	}

      ///////////////////////// gets y sets /////////////////////////////////

	public Integer getnTama�oMatriz() {
		return nTama�oMatriz;
	}

	public void setnTama�oMatriz(Integer nTama�oMatriz) {
		this.nTama�oMatriz = nTama�oMatriz;
	}

	public Long getTiempoEjecucion() {
		return tiempoEjecucion;
	}

	public void setTiempoEjecucion(Long TiempoEjecucion) {
		this.tiempoEjecucion = TiempoEjecucion;
	}

	@Override
	public String toString() {
		return "TiempoEjecucion [nTama�oMatriz=" + nTama�oMatriz + ", tiempoEjecucion=" + tiempoEjecucion + "]";
	}
}
