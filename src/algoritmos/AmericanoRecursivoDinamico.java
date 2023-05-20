package algoritmos;

import java.util.ArrayList;
import java.util.Collections;

public class AmericanoRecursivoDinamico implements MetodoAlgoritmo{

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		int i = arreglo1.size();
		int j = arreglo2.size();
		int tama�oResultado = i+j;
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(tama�oResultado, 0));
		americanoRecursivo(arreglo1, arreglo2, resultado, i, j, 0);
	}

	public static ArrayList<Integer> americanoRecursivoo(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2, ArrayList<Integer> resultado, int i, int j, int acarreo) {
	    int result;
	    int mult;

	    // Caso base que devuelve el resultado de las recursiones
	    if (i <= 0) {
	        return resultado;
	    }

	    // Condicional para iterar recursivamente los arreglos
	    if (j > 0) {
	        // Aqu� asignamos la multiplicaci�n de los dos valores de la posici�n
	        mult = arreglo1.get(i - 1) * arreglo2.get(j - 1);
	        // Aqu� sumamos el resultado en la posici�n indicada, el resultado de multiplicaci�n y el acarreo en caso de que haya
	        result = mult + resultado.get(i + j - 1) + acarreo;
	        // Aqu� separamos el primer d�gito
	        resultado.set(i + j - 1, result % 10);
	        // Aqu� separamos el segundo d�gito en caso de que haya
	        acarreo = result / 10;

	        // Este condicional se utiliza en caso de que un n�mero tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	        if (j == 1 && acarreo != 0) {
	            resultado.add(i + j - 2, acarreo);
	            acarreo = 0;
	        }

	        // Se llama recursivamente el m�todo disminuyendo la j
	        return americanoRecursivoo(arreglo1, arreglo2, resultado, i, j - 1, acarreo);
	    } else {
	        // Se llama recursivamente el m�todo disminuyendo la i y restableciendo el tama�o de j
	        return americanoRecursivoo(arreglo1, arreglo2, resultado, i - 1, arreglo2.size(), acarreo);
	    }
	}


	public static ArrayList<Integer> americanoRecursivo(ArrayList<Integer> arreglo1,
			ArrayList<Integer> arreglo2, ArrayList<Integer> resultado, int i, int j, int acarreo) {while (true) {
	        int result;
	        int mult;

	        // Caso base que devuelve el resultado de las recursiones
	        if (i <= 0) {
	            return resultado;
	        }

	        // Condicional para iterar recursivamente los arreglos
	        if (j > 0) {
	            // Aqu� asignamos la multiplicaci�n de los dos valores de la posici�n
	            mult = arreglo1.get(i - 1) * arreglo2.get(j - 1);
	            // Aqu� sumamos el resultado en la posici�n indicada, el resultado de multiplicaci�n y el acarreo en caso de que haya
	            result = mult + resultado.get(i + j - 1) + acarreo;
	            // Aqu� separamos el primer d�gito
	            resultado.set(i + j - 1, result % 10);
	            // Aqu� separamos el segundo d�gito en caso de que haya
	            acarreo = result / 10;

	            // Este condicional se utiliza en caso de que un n�mero tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	            if (j == 1 && acarreo != 0) {
	                resultado.add(i + j - 2, acarreo);
	                acarreo = 0;
	            }

	            // Actualizamos los par�metros para la pr�xima iteraci�n
	            j--;
	        } else {
	            // Actualizamos los par�metros para la pr�xima iteraci�n
	            i--;
	            j = arreglo2.size();
	        }
	    }
	}

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		// TODO Auto-generated method stub

	}
}
