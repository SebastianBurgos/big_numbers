package algoritmos;

import java.util.ArrayList;

public class AmericanoRecursivo implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		int i = arreglo1.length;
		int j = arreglo2.length;
		int numeroDigitosResultado = arreglo1.length + arreglo2.length;
		americanoRecursivoo(arreglo1, arreglo2, new int[numeroDigitosResultado], i, j, 0);
	}

	/*
	 * Metodo de multiplicacion americana de manera recursiva
	 * */
	public static int[] americanoRecursivo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acarreo) {

	    int result;
	    int mult;
	    //Caso base que devuelve el resultado de las recursiones
	    if(i<=0){
	    	return resultado;
	    }
	    //Condicional para iterar recursivamente los arreglos
	    if(j>0) {
	    	//Aqui asignamos la multiplicacion de los dos valores de la posici�n
            mult = arreglo1[i-1]*arreglo2[j-1];
            //Aqui sumamos el resultado en la posicion indicada, el resultado de multiplicacion y el acarreo en caso de que haya
            result = mult+resultado[i+j-1]+acarreo;
            //Aqui separamos el primer digito
            resultado[i+j-1] = result%10;
            //Aqui separamos el segundo digito en caso de que haya
            acarreo = result/10;
            //Este condicional se utiliza en caso de que un numero tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
            if(j==1&&acarreo!=0){
                resultado[i+j-2] = acarreo;
                acarreo = 0;
            }
            //se llama recursivamente el metodo disminuyendo la j
            return americanoRecursivo(arreglo1, arreglo2, resultado, i, --j, acarreo);

	    }else {
	    	//Se llama recursivamente el metodo disminuyendo la i y restableciendo el tama�o de j
	    	return americanoRecursivo(arreglo1, arreglo2, resultado, --i, arreglo2.length, acarreo);
	    }
	}

	public static int[] americanoRecursivoo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acarreo) {while (true) {
	        int result;
	        int mult;
	        // Caso base que devuelve el resultado de las recursiones
	        if (i <= 0) {
	            return resultado;
	        }
	        // Condicional para iterar recursivamente los arreglos
	        if (j > 0) {
	            // Aqu� asignamos la multiplicaci�n de los dos valores de la posici�n
	            mult = arreglo1[i - 1] * arreglo2[j - 1];
	            // Aqu� sumamos el resultado en la posici�n indicada, el resultado de multiplicaci�n y el acarreo en caso de que haya
	            result = mult + resultado[i + j - 1] + acarreo;
	            // Aqu� separamos el primer d�gito
	            resultado[i + j - 1] = result % 10;
	            // Aqu� separamos el segundo d�gito en caso de que haya
	            acarreo = result / 10;
	            // Este condicional se utiliza en caso de que un n�mero tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	            if (j == 1 && acarreo != 0) {
	                resultado[i + j - 2] = acarreo;
	                acarreo = 0;
	            }
	            // Actualizamos los par�metros para la pr�xima iteraci�n
	            j--;
	        } else {
	            // Actualizamos los par�metros para la pr�xima iteraci�n
	            i--;
	            j = arreglo2.length;
	        }
	    }
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
	}

}
