package algoritmos;

import java.util.ArrayList;

public interface MetodoAlgoritmo {
	//Americano Iterativo, Inglesa Iterativa, Hindu, Ruso
	void multiplicar(int[] arreglo1, int[] arreglo2);

	//Americano Iterativo Dinamico, Inglesa Iterativa Dinamica
	void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2);

	//Americano Recursivo
	void multiplicar(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acarreo);

	//Inglesa Recursiva
	void multiplicar(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acc, int iRes);
}
