package algoritmos;

import java.util.ArrayList;

public class InglesaRecursiva implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		int tamaño = arreglo1.length + arreglo2.length;
	    int resultado[] = new int[tamaño];
	    try {
	    	multiplicarRecursivo(arreglo1, arreglo2, resultado, 0, 0, tamaño);
		} catch (StackOverflowError e) {
			System.out.println("Stack Over Flow, profe necesito mas ram");
		}
	}

	private static void multiplicarRecursivo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int tamaño) {
	    if (j < arreglo2.length) {
	        if (i < arreglo1.length) {
	            resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
	            multiplicarRecursivo(arreglo1, arreglo2, resultado, i + 1, j, tamaño);
	        } else {
	            multiplicarRecursivo(arreglo1, arreglo2, resultado, 0, j + 1, tamaño);
	        }
	    } else {
	        ajustarResultado(resultado, tamaño - 1);
	    }
	}

	private static void ajustarResultado(int resultado[], int k) {
	    if (k > 0) {
	        resultado[k - 1] += resultado[k] / 10;
	        resultado[k] %= 10;
	        ajustarResultado(resultado, k - 1);
	    }
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// TODO Auto-generated method stub

	}

}
