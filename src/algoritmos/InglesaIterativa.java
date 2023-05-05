package algoritmos;

import java.util.ArrayList;

public class InglesaIterativa implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		inglesaIterativa(arreglo1, arreglo2);
	}

	/*
	 * Método de multiplicación Inglesa de forma iterariva con arreglos
	 */
	public static int[] inglesaIterativa(int arreglo1[], int arreglo2[]) {

		//Esta linea se hace para establecer el tamaño maximo que elarreglo puede tener
		int resultado[]= new int [arreglo1.length + arreglo2.length];
		int sum = 0;
		int a=0;
		int b=0;
		//En esta variable se va guardando el accarreo resultante
		int acc=0;
		//Se declara una variable axuiliar con el tamaño del arreglo del multiplicando
		int iRes = arreglo1.length;

		//En este ciclo, se recorre el arreglo de izquierda a derecha para simular la multiplicación Inglesa
			for(int i=0; i < arreglo1.length-1; i++) {

				//Se obtiene el valor de cada uno de los posiciones del multiplicando
				a= arreglo2[i];

				//En este ciclo, se recorre el seegundo arreglo de izquierda a derecha para simular la multiplicación Inglesa
				for(int j=arreglo2.length; j >= 0;j--) {

					//Se obtiene el valor de cada uno de los posiciones del multiplicador
					b = arreglo1[j];
					//Se multiplican los dos numeros de ambas posiciones y se le suma el accarreo
					sum = (b*a) +acc;
					acc = 0;

					//Condición establecida para verificar si resulta un accarreo
					if(sum>=10) {

						//Se obtiene el segundo digito del numero que da como resultado un numero con accarreo
						acc = sum/10;
					}
					//Obtenemos el primer digito del numero, el cual es quien se suma
					sum = sum%10;
					resultado[iRes] = sum+resultado[iRes];
					//Condición para asignar las posiciones con el objetivo de no desbordar el arreglo y se procede a realizar la suma
					if(resultado[iRes]>9) {
						resultado[iRes-1] = resultado[iRes-1]+ (resultado[iRes]/10);
						resultado[iRes] = resultado[iRes]%10;
					}
					//Condición para revisar que ya no hay más digitos en el multilpicador y que hay un numero en el accarreo
					if(j==0 && acc!=0) {
						//Se le suma ese ultimo numero del accareo y se le suma a la ultima posición
						resultado[iRes-1] = acc+resultado[iRes-1];
					}
					iRes--;
				}
				//Se reinicia el valor del acarreo a cero
				acc=0;
				//Se le restablece el tamaño a iRes para recorrer el arregloDos adecuadamente.
				iRes = arreglo1.length+(i+1);
			}
		//Se retorna el arreglo con el resultado final
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
