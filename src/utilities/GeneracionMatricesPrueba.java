package utilities;

/**
 * Esta clase permite generar los archivos que van a contener las matrices que vayamos a utilizar
 */

public class GeneracionMatricesPrueba {
	public static void generar(String[] args) {
		int n;

		/**
		 * Se genera por un for cada archivo txt con la matriz
		 * n elevado a la 2 empezando por un i de 2 hasta 13 para completar las 12 matrices
		 */
		for (int i = 2; i <= 4; i++) {
			n = (int)Math.pow(2, i);
			Archivos.GenerarTxtMatrizPrueba(n);
			System.out.println("Archivo txt de matriz: matriz"+n+"x"+n+".txt ha sido generado");
		}
	}
}
