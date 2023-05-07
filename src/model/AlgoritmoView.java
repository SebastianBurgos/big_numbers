package model;

public class AlgoritmoView {
	private Algoritmo algoritmo;
	public Integer n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12;
	public Long te1, te2, te3, te4, te5, te6, te7, te8, te9, te10, te11, te12;


      /////////////////////// Constructor de la clase //////////////////////////

	public AlgoritmoView(Algoritmo algoritmo) {
		super();
		this.algoritmo = algoritmo;
		asignar();
	}

      /////////////////////////// gets y sets /////////////////////////////////

	public Algoritmo getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(Algoritmo algoritmo) {
		this.algoritmo = algoritmo;
	}

	public Integer getN1() {
		return n1;
	}

	public void setN1(Integer n1) {
		this.n1 = n1;
	}

	public Integer getN2() {
		return n2;
	}

	public void setN2(Integer n2) {
		this.n2 = n2;
	}

	public Integer getN3() {
		return n3;
	}

	public void setN3(Integer n3) {
		this.n3 = n3;
	}

	public Integer getN4() {
		return n4;
	}

	public void setN4(Integer n4) {
		this.n4 = n4;
	}

	public Integer getN5() {
		return n5;
	}

	public void setN5(Integer n5) {
		this.n5 = n5;
	}

	public Integer getN6() {
		return n6;
	}

	public void setN6(Integer n6) {
		this.n6 = n6;
	}

	public Integer getN7() {
		return n7;
	}

	public void setN7(Integer n7) {
		this.n7 = n7;
	}

	public Integer getN8() {
		return n8;
	}

	public void setN8(Integer n8) {
		this.n8 = n8;
	}

	public Integer getN9() {
		return n9;
	}

	public void setN9(Integer n9) {
		this.n9 = n9;
	}

	public Integer getN10() {
		return n10;
	}

	public void setN10(Integer n10) {
		this.n10 = n10;
	}

	public Integer getN11() {
		return n11;
	}

	public void setN11(Integer n11) {
		this.n11 = n11;
	}

	public Integer getN12() {
		return n12;
	}

	public void setN12(Integer n12) {
		this.n12 = n12;
	}

	public Long getTe1() {
		return te1;
	}

	public void setTe1(Long te1) {
		this.te1 = te1;
	}

	public Long getTe2() {
		return te2;
	}

	public void setTe2(Long te2) {
		this.te2 = te2;
	}

	public Long getTe3() {
		return te3;
	}

	public void setTe3(Long te3) {
		this.te3 = te3;
	}

	public Long getTe4() {
		return te4;
	}

	public void setTe4(Long te4) {
		this.te4 = te4;
	}

	public Long getTe5() {
		return te5;
	}

	public void setTe5(Long te5) {
		this.te5 = te5;
	}

	public Long getTe6() {
		return te6;
	}

	public void setTe6(Long te6) {
		this.te6 = te6;
	}

	public Long getTe7() {
		return te7;
	}



	public void setTe7(Long te7) {
		this.te7 = te7;
	}



	public Long getTe8() {
		return te8;
	}



	public void setTe8(Long te8) {
		this.te8 = te8;
	}



	public Long getTe9() {
		return te9;
	}



	public void setTe9(Long te9) {
		this.te9 = te9;
	}



	public Long getTe10() {
		return te10;
	}



	public void setTe10(Long te10) {
		this.te10 = te10;
	}



	public Long getTe11() {
		return te11;
	}



	public void setTe11(Long te11) {
		this.te11 = te11;
	}



	public Long getTe12() {
		return te12;
	}



	public void setTe12(Long te12) {
		this.te12 = te12;
	}


      /**
       * Esta metodo permite asignar los valores obtenidos del tiempo de ejecucion de los algoritmos
       * para asi poder mostrar de forma organizada uno a uno de acuerdo a la matriz implementada
       */
	private void asignar() {
		try {
			n1 = algoritmo.getTiemposEjecucionLst().get(0).getnTamanioMatriz();
			te1 = algoritmo.getTiemposEjecucionLst().get(0).getTiempoEjecucion();

			n2 = algoritmo.getTiemposEjecucionLst().get(1).getnTamanioMatriz();
			te2 = algoritmo.getTiemposEjecucionLst().get(1).getTiempoEjecucion();

			n3 = algoritmo.getTiemposEjecucionLst().get(2).getnTamanioMatriz();
			te3 = algoritmo.getTiemposEjecucionLst().get(2).getTiempoEjecucion();

			n4 = algoritmo.getTiemposEjecucionLst().get(3).getnTamanioMatriz();
			te4 = algoritmo.getTiemposEjecucionLst().get(3).getTiempoEjecucion();

			n5 = algoritmo.getTiemposEjecucionLst().get(4).getnTamanioMatriz();
			te5 = algoritmo.getTiemposEjecucionLst().get(4).getTiempoEjecucion();

			n6 = algoritmo.getTiemposEjecucionLst().get(5).getnTamanioMatriz();
			te6 = algoritmo.getTiemposEjecucionLst().get(5).getTiempoEjecucion();

			n7 = algoritmo.getTiemposEjecucionLst().get(6).getnTamanioMatriz();
			te7 = algoritmo.getTiemposEjecucionLst().get(6).getTiempoEjecucion();

			n8 = algoritmo.getTiemposEjecucionLst().get(7).getnTamanioMatriz();
			te8 = algoritmo.getTiemposEjecucionLst().get(7).getTiempoEjecucion();

			n9 = algoritmo.getTiemposEjecucionLst().get(8).getnTamanioMatriz();
			te9 = algoritmo.getTiemposEjecucionLst().get(8).getTiempoEjecucion();

			n10 = algoritmo.getTiemposEjecucionLst().get(9).getnTamanioMatriz();
			te10 = algoritmo.getTiemposEjecucionLst().get(9).getTiempoEjecucion();

			n11 = algoritmo.getTiemposEjecucionLst().get(10).getnTamanioMatriz();
			te11 = algoritmo.getTiemposEjecucionLst().get(10).getTiempoEjecucion();

			n12 = algoritmo.getTiemposEjecucionLst().get(11).getnTamanioMatriz();
			te12 = algoritmo.getTiemposEjecucionLst().get(11).getTiempoEjecucion();

		} catch (Exception e) {

		}
	}

	@Override
	public String toString() {
		return "AlgoritmoView [n1=" + n1 + ", n2=" + n2 + ", n3=" + n3 + ", n4=" + n4 + ", n5=" + n5 + ", n6=" + n6
				+ ", n7=" + n7 + ", n8=" + n8 + ", n9=" + n9 + ", n10=" + n10 + ", n11=" + n11 + ", n12=" + n12
				+ ", te1=" + te1 + ", te2=" + te2 + ", te3=" + te3 + ", te4=" + te4 + ", te5=" + te5 + ", te6=" + te6
				+ ", te7=" + te7 + ", te8=" + te8 + ", te9=" + te9 + ", te10=" + te10 + ", te11=" + te11 + ", te12="
				+ te12 + "] \n";
	}
}
