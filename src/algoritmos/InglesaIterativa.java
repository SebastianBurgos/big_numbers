package algoritmos;

import java.util.ArrayList;

public class InglesaIterativa implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		inglesaIterativa(arreglo1, arreglo2);
	}

	/*
	 * Método de multiplicación Inglesa de forma iterativa con arreglos
	 */
	public static int[] inglesaIterativa(int arreglo1[], int arreglo2[]) {

		int tamaño = arreglo1.length + arreglo2.length;
		int resultado[] = new int [tamaño];

		for (int i = 0; i < arreglo2.length; i++) {
			for (int j = 0; j < arreglo1.length; j++) {
				resultado[i+j+1] += arreglo1[j]	* arreglo2[i];
			}
		}

		for (int k = tamaño-1; k > 0; k--) {
			resultado[k-1] += resultado[k]/10;
			resultado[k] %= 10;
		}

		return resultado;
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// TODO Auto-generated method stub

	}

}
