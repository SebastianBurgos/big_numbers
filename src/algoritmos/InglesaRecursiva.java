package algoritmos;

import java.util.ArrayList;

public class InglesaRecursiva implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		int numeroDigitosResultado = arreglo1.length + arreglo2.length;
		inglesaRecursivo(arreglo1, arreglo2, new int[numeroDigitosResultado], 0, 0, 0, 0);
	}

	/*
	 * Metodo que simula la multiplicación inglesa de manera recursiva
	 * */
	public static int[] inglesaRecursivo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acc, int iRes) {

		int sum = 0;
		//Caso base donde se termina cuanto termina de multiplicar los numeros del arreglo1
		if (i>=arreglo1.length-1) {

			return resultado;
		}
		//Caso recursivo donde es una simulacion de iteracion
		if(j>=0) {

			//Se multiplican los numeros y se tiene en cuenta el acarreo
			sum = (arreglo1[j]*arreglo2[i]) +acc;
			acc = 0;
			//En caso de que la suma sea mayor a 10, es porque tiene acarreo, entonces se tiene en cuenta
			if(sum>=10) {

				acc = sum/10;
			}
			sum = sum%10;
			//Se asigna la suma al resultado y se le suma lo que haya ahí
			resultado[iRes] = sum+resultado[iRes];
			//Esta parte del codigo es donde se hacen las sumas despues de multiplicar
			if(resultado[iRes]>9) {
				resultado[iRes-1] = resultado[iRes-1]+ (resultado[iRes]/10);
				resultado[iRes] = resultado[iRes]%10;
			}
			//Esta parte del codigo es para tener en cuenta el acarreo final
			if(j==0 && acc!=0) {
				resultado[iRes-1] = acc+resultado[iRes-1];
			}

			iRes--;
			//Se llama otra vez el metodo disminuyendo i para simular un ciclo
			return inglesaRecursivo(arreglo1, arreglo2, resultado, i, j-1, acc, iRes);
		}else {
			acc=0;
			iRes = arreglo1.length+(i+1);
			//Se llama otra vez el metodo aumentando la i y reiniciando la j
			return inglesaRecursivo(arreglo1, arreglo2, resultado, i+1, arreglo2.length, acc, iRes);
		}
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// TODO Auto-generated method stub

	}

}
