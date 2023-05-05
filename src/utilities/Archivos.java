package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {

	/**
	 * Este metodo recibe una ruta de las matrices de prueba txt y retorna la matriz
	 * de tipo int[][]
	 * @param ruta
	 * @return
	 */
	public static int[][] leerArchivoMatriz(String ruta) {
		int[][] matriz = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			// Primera linea nos dice longitud de la matriz
			String linea = br.readLine();
			int longitud = Integer.parseInt(linea);
			matriz = new int[longitud][longitud];
			// Las siguientes lineas son filas de la matriz
			linea = br.readLine();
			int fila = 0; // Para recorrer las filas de la matriz
			while (linea != null) {
				/*
				 * Tenemos todos los enteros JUNTOS en el String linea. Con
				 * split() los SEPARAMOS en un array donde cada entero es un
				 * String individual. Con un bucle, los parseamos a Integer para
				 * guardarlos en la matriz
				 */
				String[] enteros = linea.split(" ");
				for (int i = 0; i < enteros.length; i++)
					matriz[fila][i] = Integer.parseInt(enteros[i]);

				fila++; // Incrementamos fila para la próxima línea de enteros
				linea = br.readLine(); // Leemos siguiente línea
			}
			br.close(); // Cerramos el lector de ficheros

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("No se pudo convertir a entero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error accediendo al archivo.");
			e.printStackTrace();
		}
		return matriz;
	}

	/**
	 * Este metodo genera una matriz de prueba segun un n indicado por parametro
	 * @param n
	 */
	public static void GenerarTxtMatrizPrueba(int n){
		int[][] matriz = new int[n][n];
		String ruta_nuevo = "./src/matrixes_files/matriz"+n+"x"+n+".txt";

		try {
			FileWriter fw = new FileWriter(ruta_nuevo,false);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(n+"\r\n");
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz.length; j++) {
					matriz[i][j] = (int)(Math.random()*9000+1);
					if (j < matriz.length-1) {
						bw.write(matriz[i][j]+" ");
					}else{
						bw.write(""+matriz[i][j]);
					}
				}
				bw.write("\r\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
