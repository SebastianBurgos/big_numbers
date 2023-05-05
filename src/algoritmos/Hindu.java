package algoritmos;

import java.util.ArrayList;

public class Hindu implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		multiplicarHindu(arreglo1, arreglo2);
	}

	public static int[] multiplicarHindu(int[] arreglo1, int[] arreglo2) {
		int multiplicacion; //aqui guardaremos el producto de las multiplicaciones
		int resultado[] = new int[arreglo1.length+arreglo2.length]; //le damos el tamaño al arreglo resultado

		//recorremos el arreglo de manera normal con los 2 ciclos
		for(int i = 0; i<arreglo1.length; i++) {
			for (int j = 0; j < arreglo2.length; j++) {
				//Hacemos la multiplicacion de las posiciones del arreglo
				multiplicacion = arreglo1[i]*arreglo2[j];
				//acalaracion del metodo con un arreglo unidimensional
				//El metodo hindu utiliza las diagonales para luego sumar los numeros de esas diagonales, con un arreglo
				//unidimensional podemos evitar el paso de recorrer las diagonales y sumar directamente

				//Obtenemos el numero mas significativo y lo insertamos en la diagonal correspondiente
				resultado[i+j] += multiplicacion/10;

				//obtenemos el numero menos significativo y lo insertamos en la siguiente diagonal
				resultado[i+j+1] += multiplicacion%10;
			}
		}
		//Ya estan hechas las multiplicaciones y tenemos los valores de las sumas de las diagonales, ahora hacemos los acarreos
		int valor = 0;
		//Recorremos el arreglo de la suma de las diagonales de izquierda a derecha
		for (int i = resultado.length-1; i > 0 ; i--) {
			valor = resultado[i];
			//Obtenemos el valor menos sigificativo y lo dejamos en el lugar del arreglo
			resultado[i] = valor%10;
			//le sumamos el valor a la izquierda y con esto concluimos el acarreo
			resultado[i-1] += valor/10;
		}


		return resultado;
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j, int acarreo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2, int[] resultado, int i, int j, int acc, int iRes) {
		// TODO Auto-generated method stub

	}

}
