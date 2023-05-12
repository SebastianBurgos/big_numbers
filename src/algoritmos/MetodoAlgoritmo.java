package algoritmos;

import java.util.ArrayList;

public interface MetodoAlgoritmo {
	//Americano Iterativo, Americano Recursivo, Inglesa Recursiva, Inglesa Iterativa, Hindu, Ruso
	void multiplicar(int[] arreglo1, int[] arreglo2);

	//Americano Iterativo Dinamico, Inglesa Iterativa Dinamica
	void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2);}
