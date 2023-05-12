package algoritmos;

import java.util.ArrayList;

public class AmericanoIterativoDinamico implements MetodoAlgoritmo{

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		americanaIterativaList(arreglo1, arreglo2);
	}

	/*
	 * Este metodo realiza una multiplicación americana de forma iterativa con arraylist
	 *
	 * */
	public static ArrayList<Integer> americanaIterativaList(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {


		ArrayList<Integer> resultado = new ArrayList<>();
		//Esta linea se hace para llenar el arraylist con 0's de acuerdo al tamaño
		resultado = llenarArray(resultado, arreglo1.size()+arreglo2.size());
		//En esta variable se guarda el acarreo en caso de que haya
		int acarreo = 0;
	    int result;
	    int mult;

	    //Este ciclo se recorre de derecha a izquierda para simular el metodo de multiplicacion americana
		for (int i = arreglo1.size(); i > 0; i--) {
			//Este ciclo se recorre de derecha a izquierda para simular el metodo de multiplicacion americana
	        for (int j = arreglo2.size(); j > 0 ; j--) {
	        	//Aqui asignamos la multiplicacion de los dos valores de la posición
	        	mult = arreglo1.get(i-1) * arreglo2.get(j-1);
	        	//Aqui sumamos el resultado en la posicion indicada, el resultado de multiplicacion y el acarreo en caso de que haya
	        	result = mult + resultado.get(i+j-1) + acarreo;
	        	//Aqui separamos el primer digito
	        	resultado.set(i+j-1, result%10);
	        	//Aqui separamos el segundo digito en caso de que haya
	            acarreo = result/10;
	            //Este condicional se utiliza en caso de que un numero tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	            if(j==1&&acarreo!=0){
	            	resultado.set(i+j-2, acarreo);
	                acarreo = 0;
	            }
	        }
	    }

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
	}
}
