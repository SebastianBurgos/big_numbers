package utilities;

/**
 * Esta clase permite generar los archivos que van a contener las matrices que vayamos a utilizar
 */

public class GeneracionArchivosPrueba {
	public static void generarArchivos() {
		int n;

		/**
		 * Se genera cada archivo txt con los digitos del numero, de una cantidad
		 * 2 elevado a la n empezando por un 2 elevado a la 8 hasta 15 para completar los 8 archivos de prueba
		 */
		for (int i = 8; i <= 15; i++) {
			n = (int)Math.pow(2, i);
			Archivos.generarTxtNumerosPrueba(n);
			System.out.println("Archivo txt de prueba: numero-"+n+"-digitos.txt ha sido generado");
		}
	}
}
