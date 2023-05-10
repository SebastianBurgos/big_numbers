package utilities;

/**
 * Esta clase permite generar los archivos que van a contener las matrices que vayamos a utilizar
 */

public class GeneracionArchivosPrueba {
	public static void generarArchivos() {
		int n;

		/**
		 * Se genera cada archivo txt con los digitos del numero, de una cantidad
		 * 3 elevado a la n empezando por un n de 4 elevado a la 3 hasta 13 para completar los 8 archivos de prueba
		 */
		for (int i = 3; i <= 10; i++) {
			n = (int)Math.pow(4, i);
			Archivos.generarTxtNumerosPrueba(n);
			System.out.println("Archivo txt de prueba: numero-"+n+"-digitos.txt ha sido generado");
		}
	}
}
