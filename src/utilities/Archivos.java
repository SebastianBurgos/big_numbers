package utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Archivos {

	/**
	 * Este metodo recibe una ruta de las matrices de prueba txt y retorna la matriz
	 * de tipo int[][]
	 * @param ruta
	 * @return
	 */
	public static int[] leerArchivoPruebaArregloEstatico(String ruta) {
		int[] numero = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			// Primera linea nos dice longitud de la matriz
			String linea = br.readLine();
			int longitud = Integer.parseInt(linea);
			numero = new int[longitud];
			// Las siguientes lineas son el numero
			linea = br.readLine();
			while (linea != null) {
				/*
				 * Tenemos todos los enteros JUNTOS en el String linea. Con
				 * split() los SEPARAMOS en un array donde cada entero es un
				 * String individual. Con un bucle, los parseamos a Integer para
				 * guardarlos en el numero
				 */
				String[] digitos = linea.split(" ");
				for (int i = 0; i < digitos.length; i++)
					numero[i] = Integer.parseInt(digitos[i]);

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
		return numero;
	}

	/**
	 * Este metodo recibe una ruta de las matrices de prueba txt y retorna la matriz
	 * de tipo int[][]
	 * @param ruta
	 * @return
	 */
	public static ArrayList<Integer> leerArchivoPruebaArregloDinamico(String ruta) {
		ArrayList<Integer> numero = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			// Primera linea nos dice longitud de la matriz
			String linea = br.readLine();
			// Las siguientes lineas son el numero
			linea = br.readLine();
			while (linea != null) {
				/*
				 * Tenemos todos los enteros JUNTOS en el String linea. Con
				 * split() los SEPARAMOS en un array donde cada entero es un
				 * String individual. Con un bucle, los parseamos a Integer para
				 * guardarlos en el numero
				 */
				String[] digitos = linea.split(" ");
				for (int i = 0; i < digitos.length; i++){
					int digito = Integer.parseInt(digitos[i]);
					numero.add(digito);
				}

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
		return numero;
	}

	/**
	 * Este metodo genera una matriz de prueba segun un n indicado por parametro
	 * @param n
	 */
	public static void generarTxtNumerosPrueba(int n){
		String ruta_nuevo = "./src/test_files/numero-"+n+"-digitos.txt";
		int numero_agregar = 0;

		try {
			FileWriter fw = new FileWriter(ruta_nuevo,false);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(n+"\r\n");
			for (int i = 0; i < n; i++) {
				numero_agregar = (int)(Math.random()*9+1);
				bw.write(numero_agregar+" ");
			}

			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
