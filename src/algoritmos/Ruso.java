package algoritmos;

import java.util.ArrayList;

public class Ruso implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		int[] copiaArreglo1 = arreglo1;
		int[] copiaArreglo2 = arreglo2;
		multiplicarRuso(copiaArreglo1, copiaArreglo2);
	}

	/*
	 * Metodo que simula la multiplicacion rusa
	 * ADVERTENCIA: este metodo daña el arreglo entrante, ejecutar solo o de ultimo
	 * */
	public static int [] multiplicarRuso(int[] arreglo1, int[] arreglo2) {

		//Asignamos las variables que vamos a utilizar
		int resultado[]= new int [arreglo1.length + arreglo2.length];
		int arreglo2N [] = new int [arreglo1.length + arreglo2.length];
		int num =0;
		int acc =0;
		int sum=0;

		//recorremos con un while hasta que la suma de los valores del arreglo 1 sea 1
		while(sum !=1) {
			//reiniciamos la variable suma para futuras iteraciones
			sum=0;
			//Recorremos el primer arreglo, en esta seccion del codigo es donde dividimos el numero en 2
			for (int j = 0; j < arreglo1.length; j++) {


				num = arreglo1[j]+(acc*10);
				arreglo1[j] = num /2 ;
				acc = num %2;
				sum+=arreglo1[j];
			}
			acc=0; num=0;
			//Recorremos el segundo arreglo, en esta seccion es donde duplicamos el numero
			for(int k = arreglo2.length-1, l= arreglo2N.length-1; k >= 0 ; k--, l--) {

				 num = (arreglo2[k] * 2)+acc;
				 acc = num / 10;
				 arreglo2N[l]= num%10;
			}
			arreglo2= arreglo2N;
			acc =0; num=0;
			//Condicional para verificar si el numero es impar, con el fin de sumarlo al resultado
			if(arreglo1[arreglo1.length-1] %2 !=0) {
				//Ciclo donde se suma el resultado y se tienen en cuenta los acarreos
				for(int j=resultado.length-1; j >= 0;j--) {

					num = resultado[j] + arreglo2[j]+acc;
					resultado[j] = num%10;
					acc = num/10;
				}
			}
			acc=0;
		}
		return resultado;

	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		// TODO Auto-generated method stub

	}

}
