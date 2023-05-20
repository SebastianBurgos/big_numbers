package algoritmos;

import java.util.ArrayList;

public class InglesaIterativaDinamica implements MetodoAlgoritmo{

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		inglesaIterativaList(arreglo1, arreglo2);
	}

	/*
	 * Método de multiplicación Inglesa de forma iterariva de forma dinámica
	 */
	public static ArrayList<Integer> inglesaIterativaList(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {

		//Esta linea se hace para llenar el arraylist con 0's de acuerdo al tamaño
		ArrayList<Integer> resultado = new ArrayList<>();
		resultado = llenarArray(resultado, arreglo1.size()+arreglo2.size());
//		int sum = 0;
//		int a=0;
//		int b=0;
//		//En esta variable se guarda el acarreo en caso de que haya
//		int acc=0;
//		//Se declara una variable axuiliar con el tamaño del arreglo del multiplicando
//		int iRes = arreglo1.size();
//
//		//En este ciclo, se recorre el arreglo de izquierda a derecha para simular la multiplicación Inglesa
//		for(int i=0; i < arreglo1.size()-1; i++) {
//
//			//Se obtiene los valores de los digitos del multiplicador
//			a= arreglo2.get(i);
//
//			//En este ciclo, se recorre el segundo arreglo de izquierda a derecha para simular la multiplicación Inglesa
//			for(int j=arreglo2.size(); j >= 0;j--) {
//
//				//Obtiene los valores de los digitos del multiplicando
//				b= arreglo1.get(j);
//
//				//Realiza la suma de la multiplicación de ambos números más el número que se encuentra acarreado.
//				sum = (b*a) +acc;
//				//Se reinicia el valor acarreado
//				acc = 0;
//
//				//Condición establecida para verificar si resulta un accarreo
//				if(sum>=10) {
//
//					//Se obtiene el segundo digito del numero que da como resultado un numero con accarreo
//					acc = sum/10;
//				}
//				//Obtenemos el primer digito del numero, el cual es quien se suma
//				sum = sum%10;
//				//Asignamos a la posicion iRes de la posicion mas el resultado de la operacion almacenada en sum
//				resultado.set(iRes, sum+resultado.get(iRes));
//				//Si el numero es mayor que nueve necesita acarreo
//				if(resultado.get(iRes)>9) {
//					//sumamos el acarreo
//					resultado.set(iRes-1, resultado.get(iRes-1)+(resultado.get(iRes)/10));
//					resultado.set(iRes, resultado.get(iRes)%10);
//				}
//				//Si terminamos el ciclo y queda algo dentro del acarreo asignamos el ultimo acarreo
//				if(j==0 && acc!=0) {
//					//se asigna en la posicion mas externa el acarreo restante
//					resultado.set(iRes-1, acc+resultado.get(iRes-1));
//				}
//
//				iRes--;
//			}
//			//reiniciamos el acarreo
//			acc=0;
//			//reiniciamos el valor de iRes
//			iRes = arreglo1.size()+(i+1);
//		}
		//Se retorna el resultado
		return resultado;
	}

	public static ArrayList<Integer> llenarArray(ArrayList<Integer> arreglo, int n){

		for(int i=0; i<n;  i++) {

			arreglo.add(0);
		}
		return arreglo;
	}

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		// TODO Auto-generated method stub

	}

}
