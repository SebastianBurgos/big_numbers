package algoritmos;

import java.util.ArrayList;
import java.util.Collections;

public class AmericanoRecursivoDinamico implements MetodoAlgoritmo{

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
		int i = arreglo1.size();
		int j = arreglo2.size();
		int tamañoResultado = i+j;
	    ArrayList<Integer> resultado = new ArrayList<>(Collections.nCopies(tamañoResultado, 0));
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
	        // Aquí asignamos la multiplicación de los dos valores de la posición
	        mult = arreglo1.get(i - 1) * arreglo2.get(j - 1);
	        // Aquí sumamos el resultado en la posición indicada, el resultado de multiplicación y el acarreo en caso de que haya
	        result = mult + resultado.get(i + j - 1) + acarreo;
	        // Aquí separamos el primer dígito
	        resultado.set(i + j - 1, result % 10);
	        // Aquí separamos el segundo dígito en caso de que haya
	        acarreo = result / 10;

	        // Este condicional se utiliza en caso de que un número tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	        if (j == 1 && acarreo != 0) {
	            resultado.add(i + j - 2, acarreo);
	            acarreo = 0;
	        }

	        // Se llama recursivamente el método disminuyendo la j
	        return americanoRecursivoo(arreglo1, arreglo2, resultado, i, j - 1, acarreo);
	    } else {
	        // Se llama recursivamente el método disminuyendo la i y restableciendo el tamaño de j
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
	            // Aquí asignamos la multiplicación de los dos valores de la posición
	            mult = arreglo1.get(i - 1) * arreglo2.get(j - 1);
	            // Aquí sumamos el resultado en la posición indicada, el resultado de multiplicación y el acarreo en caso de que haya
	            result = mult + resultado.get(i + j - 1) + acarreo;
	            // Aquí separamos el primer dígito
	            resultado.set(i + j - 1, result % 10);
	            // Aquí separamos el segundo dígito en caso de que haya
	            acarreo = result / 10;

	            // Este condicional se utiliza en caso de que un número tenga acarreo y ya haya llegado a su fin, con el fin de tenerlo en cuenta
	            if (j == 1 && acarreo != 0) {
	                resultado.add(i + j - 2, acarreo);
	                acarreo = 0;
	            }

	            // Actualizamos los parámetros para la próxima iteración
	            j--;
	        } else {
	            // Actualizamos los parámetros para la próxima iteración
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
