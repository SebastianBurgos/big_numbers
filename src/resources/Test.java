package resources;

import java.util.ArrayList;
/*
 * Autores:
 * 			David Alberto Martínez Garcia
 * 			Esteban Pelaez Villamil
 * 			Diego Armando Perea Alarcón
 * 			Juan Camilo Tamayo Amariles
 *
 * Ciudad: Armenia - Quindío
 *
 * */
public class Test {

		public static void main(String[] args) {

			int arreglo2[] = {5,7,8};
			int arreglo1[] = {2,4,7,9};
			ArrayList<Integer>array1 = new ArrayList<Integer>();
			ArrayList<Integer>array2 = new ArrayList<>();
			array1.add(2); array1.add(4);array1.add(7); array1.add(9);
			array2.add(5); array2.add(7);array2.add(8);
			//mostrarArreglo(americanaIterativa(arreglo1, arreglo2));
			//System.out.println(americanaIterativaList(array1, array2));
//			mostrarArreglo(americanoRecursivo(arreglo1, arreglo2, new int [arreglo1.length + arreglo2.length] , arreglo1.length, arreglo2.length, 0));
			//mostrarArreglo(inglesaIterativa(arreglo1, arreglo2));
			//System.out.println(inglesaIterativaList(array1, array2));
			mostrarArreglo(inglesaRecursivo(arreglo1, arreglo2,new int [arreglo1.length + arreglo2.length],
					0, arreglo2.length, 0, arreglo1.length));
			//mostrarArreglo(multiplicarHindu(arreglo1, arreglo2));
			//mostrarArreglo(multiplicarRuso(arreglo2, arreglo1));
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
	            //se llama recursivamente el metodo disminuyendo la j
	            return americanoRecursivo(arreglo1, arreglo2, resultado, i, j-1, acarreo);

		    }else {
		    	//Se llama recursivamente el metodo disminuyendo la i y restableciendo el tamaño de j
		    	return americanoRecursivo(arreglo1, arreglo2, resultado, i-1, arreglo2.length, acarreo);
		    }
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
		/*
		 * Método de multiplicación Inglesa de forma iterariva de forma dinámica
		 */
		public static ArrayList<Integer> inglesaIterativaList(ArrayList<Integer> arreglo1, ArrayList<Integer> arreglo2) {

			//Esta linea se hace para llenar el arraylist con 0's de acuerdo al tamaño
			ArrayList<Integer> resultado = new ArrayList<>();
			resultado = llenarArray(resultado, arreglo1.size()+arreglo2.size());
			int sum = 0;
			int a=0;
			int b=0;
			//En esta variable se guarda el acarreo en caso de que haya
			int acc=0;
			//Se declara una variable axuiliar con el tamaño del arreglo del multiplicando
			int iRes = arreglo1.size();

			//En este ciclo, se recorre el arreglo de izquierda a derecha para simular la multiplicación Inglesa
			for(int i=0; i < arreglo1.size()-1; i++) {

				//Se obtiene los valores de los digitos del multiplicador
				a= arreglo2.get(i);

				//En este ciclo, se recorre el segundo arreglo de izquierda a derecha para simular la multiplicación Inglesa
				for(int j=arreglo2.size(); j >= 0;j--) {

					//Obtiene los valores de los digitos del multiplicando
					b= arreglo1.get(j);

					//Realiza la suma de la multiplicación de ambos números más el número que se encuentra acarreado.
					sum = (b*a) +acc;
					//Se reinicia el valor acarreado
					acc = 0;

					//Condición establecida para verificar si resulta un accarreo
					if(sum>=10) {

						//Se obtiene el segundo digito del numero que da como resultado un numero con accarreo
						acc = sum/10;
					}
					//Obtenemos el primer digito del numero, el cual es quien se suma
					sum = sum%10;
					//Asignamos a la posicion iRes de la posicion mas el resultado de la operacion almacenada en sum
					resultado.set(iRes, sum+resultado.get(iRes));
					//Si el numero es mayor que nueve necesita acarreo
					if(resultado.get(iRes)>9) {
						//sumamos el acarreo
						resultado.set(iRes-1, resultado.get(iRes-1)+(resultado.get(iRes)/10));
						resultado.set(iRes, resultado.get(iRes)%10);
					}
					//Si terminamos el ciclo y queda algo dentro del acarreo asignamos el ultimo acarreo
					if(j==0 && acc!=0) {
						//se asigna en la posicion mas externa el acarreo restante
						resultado.set(iRes-1, acc+resultado.get(iRes-1));
					}

					iRes--;
				}
				//reiniciamos el acarreo
				acc=0;
				//reiniciamos el valor de iRes
				iRes = arreglo1.size()+(i+1);
			}
			//Se retorna el resultado
			return resultado;
		}
		/*
		 * Metodo que simula la multiplicación inglesa de manera recursiva
		 * */
		public static int[] inglesaRecursivo(int arreglo1[], int arreglo2[], int resultado[], int i, int j, int acc, int iRes) {

			int sum = 0;
			//Caso base donde se termina cuanto termina de multiplicar los numeros del arreglo1
			if (i>=arreglo1.length-1) {

				return resultado;
			}
			//Caso recursivo donde es una simulacion de iteracion
			if(j>=0) {

				//Se multiplican los numeros y se tiene en cuenta el acarreo
				sum = (arreglo1[j]*arreglo2[i]) +acc;
				acc = 0;
				//En caso de que la suma sea mayor a 10, es porque tiene acarreo, entonces se tiene en cuenta
				if(sum>=10) {

					acc = sum/10;
				}
				sum = sum%10;
				//Se asigna la suma al resultado y se le suma lo que haya ahí
				resultado[iRes] = sum+resultado[iRes];
				//Esta parte del codigo es donde se hacen las sumas despues de multiplicar
				if(resultado[iRes]>9) {
					resultado[iRes-1] = resultado[iRes-1]+ (resultado[iRes]/10);
					resultado[iRes] = resultado[iRes]%10;
				}
				//Esta parte del codigo es para tener en cuenta el acarreo final
				if(j==0 && acc!=0) {
					resultado[iRes-1] = acc+resultado[iRes-1];
				}

				iRes--;
				//Se llama otra vez el metodo disminuyendo i para simular un ciclo
				return inglesaRecursivo(arreglo1, arreglo2, resultado, i, j-1, acc, iRes);
			}else {
				acc=0;
				iRes = arreglo1.length+(i+1);
				//Se llama otra vez el metodo aumentando la i y reiniciando la j
				return inglesaRecursivo(arreglo1, arreglo2, resultado, i+1, arreglo2.length, acc, iRes);
			}

		}

		public static int[] multiplicarHindu(int[] arreglo1, int[] arreglo2) {
			int multiplicacion; //aqui guardaremos el producto de las multiplicaciones
			int resultado[] = new int[arreglo1.length+arreglo2.length]; //le damos el tamaño al arreglo resultado

			//recorremos el arreglo de manera normal con los 2 ciclos
			for(int i = 0; i<arreglo1.length; i++) {
				for (int j = 0; j < arreglo2.length; j++) {
					//Hacemos la multiplicacion de las posiciones del arreglo
					multiplicacion = arreglo1[i]*arreglo2[j];
					//acalaracion del metodo con un arreglo unidimensional
					//El metodo hindu utiliza las diagonales para luego sumar los numeros de esas diagonales, con un arreglo
					//unidimensional podemos evitar el paso de recorrer las diagonales y sumar directamente

					//Obtenemos el numero mas significativo y lo insertamos en la diagonal correspondiente
					resultado[i+j] += multiplicacion/10;

					//obtenemos el numero menos significativo y lo insertamos en la siguiente diagonal
					resultado[i+j+1] += multiplicacion%10;
				}
			}
			//Ya estan hechas las multiplicaciones y tenemos los valores de las sumas de las diagonales, ahora hacemos los acarreos
			int valor = 0;
			//Recorremos el arreglo de la suma de las diagonales de izquierda a derecha
			for (int i = resultado.length-1; i > 0 ; i--) {
				valor = resultado[i];
				//Obtenemos el valor menos sigificativo y lo dejamos en el lugar del arreglo
				resultado[i] = valor%10;
				//le sumamos el valor a la izquierda y con esto concluimos el acarreo
				resultado[i-1] += valor/10;
			}


			return resultado;
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
		public static ArrayList<Integer> llenarArray(ArrayList<Integer> arreglo, int n){

			for(int i=0; i<n;  i++) {

				arreglo.add(0);
			}
			return arreglo;
		}

		public static void mostrarArreglo(int arreglo[]){

	        for(int i=0; i<arreglo.length ; i++){

	            System.out.print(arreglo[i]+ "\t");

	        }
	        System.out.println();
	    }

}
