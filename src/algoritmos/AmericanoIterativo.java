package algoritmos;

import java.util.ArrayList;

public class AmericanoIterativo implements MetodoAlgoritmo{

	@Override
	public void multiplicar(int[] arreglo1, int[] arreglo2) {
		americanaIterativa(arreglo1, arreglo2);
	}

	/*
	 * Este metodo realiza una multiplicación americana de forma iterativa con arreglos normales
	 *
	 * */
	public static int[] americanaIterativa (int arreglo1[], int arreglo2[])
	{
	    int resultado[]= new int [arreglo1.length + arreglo2.length];	//Aqui declaramos y asignamos el tamaño al arreglo que nos da el resultado de la multiplicación
	    int acarreo = 0;	//Esta variable es el acarreo
	    int result;
	    int mult;

	    //Este arreglo se recorre de manera tal que su primer numero sea el de la izquierda
	    for (int i = arreglo1.length; i > 0; i--) {
	    	//Este arreglo se recorre de manera tal que su primer numero sea el de la izquierda
	        for (int j = arreglo2.length; j > 0 ; j--) {
	        	//Aqui asignamos la multiplicacion de los dos valores de la posición
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
	        }
	    }
	    return resultado;
	}

	@Override
	public void multiplicar(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {
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
