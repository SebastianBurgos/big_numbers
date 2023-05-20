package algoritmos;

import java.util.ArrayList;

public class InglesaRecursiva implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		int tama�o = arreglo1.length + arreglo2.length;
	    int resultado[] = new int[tama�o];
	    try {
	    	multiplicarRecursivo(arreglo1, arreglo2, resultado, 0, 0, tama�o);
		} catch (StackOverflowError e) {
			System.out.println("Stack Over Flow, profe necesito mas ram");
		}
	}

	private static void multiplicarRecursivo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int tama�o) {
	    if (j < arreglo2.length) {
	        if (i < arreglo1.length) {
	            resultado[i + j + 1] += arreglo1[i] * arreglo2[j];
	            multiplicarRecursivo(arreglo1, arreglo2, resultado, i + 1, j, tama�o);
	        } else {
	            multiplicarRecursivo(arreglo1, arreglo2, resultado, 0, j + 1, tama�o);
	        }
	    } else {
	        ajustarResultado(resultado, tama�o - 1);
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
