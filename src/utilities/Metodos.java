package utilities;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Metodos {
	public static void imprimirMatriz(int[][] matriz) {
		// Mostramos la matriz leída
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++)
				System.out.print(matriz[i][j] + " ");
			System.out.println();
		}
		System.out.println("\n");
	}

	/**
	 * INICIO DE METODOS DE MULTIPLICACIÓN DE MATRICES
	 */

	/**
	 * Metodo 1: NaivStandard
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC Es la matriz resultado que se retornara
	 * @param N
	 * @param P
	 * @param M
	 * @return
	 */
	public static void NaivStandard(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M){
        int aux;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                aux = 0;
                for (int k = 0; k < P; k++) {
                    aux += matrizA[i][k] * matrizB[k][j];
                }
                matrizC[i][j] = aux;
            }
        }
    }

	/**
	 * Metodo 2: NaivOnArray
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
    public static void NaivOnArray(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P , int M){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrizC[i][j] = 0;
                for (int k = 0; k < P; k++) {
                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
    }

    /**
	 * Metodo 3: NaivKhan
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
    public static void NaivKhan(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M) {
        int t, sum, err;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum = 0;
                err = 0;
                for (int k = 0; k < P; k++) {
                    err = err + matrizA[i][k] * matrizB[k][j];
                    t = sum + err;
                    err = (sum - t) + err;
                    sum = t;
                }
                matrizC[i][j] = sum;
            }
        }
    }

    /**
     * Metodo 4: NaivLoopUnrollingTwo
     * @param matrizA
     * @param matrizB
     * @param matrizC
     * @param N
     * @param P
     * @param M
     */
    public static void NaivLoopUnrollingTwo(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M) {
        int i, j, k;
        int aux;
        if (P % 2 == 0) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < P; k += 2) {
                        aux += matrizA[i][k] * matrizB[k][j] + matrizA[i][k + 1] * matrizB[k + 1][j];
                    }
                    matrizC[i][j] = aux;
                }
            }
        } else {
            int PP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 2) {
                        aux += matrizA[i][k] * matrizB[k][j] + matrizA[i][k + 1] * matrizB[k + 1][j];
                    }
                    matrizC[i][j] = aux + matrizA[i][PP] * matrizB[PP][j];
                }
            }
        }

    }

    /**
     * Metodo 5: NaivLoopUnrollingThree
     * @param matrizA
     * @param matrizB
     * @param matrizC
     * @param N
     * @param P
     * @param M
     */
    public static void NaivLoopUnrollingThree(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M) {
        int i, j, k;
        int aux;
        if (P % 3 == 0) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < P; k += 3) {
                        aux += matrizA[i][k]*matrizB[k][j] + matrizA[i][k+1]*matrizB[k+1][j] + matrizA[i][k+2]*matrizB[k+2][j];
                    }
                    matrizC[i][j] = aux;
                }
            }
        } else if (P % 3 == 1) {
            int PP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 3) {
                        aux += matrizA[i][k]*matrizB[k][j] + matrizA[i][k+1]*matrizB[k+1][j] + matrizA[i][k+2]*matrizB[k+2][j];
                    }
                    matrizC[i][j] = aux + matrizA[i][PP]*matrizB[PP][j];
                }
            }
        } else {
            int PP = P - 2;
            int PPP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 3) {
                        aux += matrizA[i][k]*matrizB[k][j] + matrizA[i][k+1]*matrizB[k+1][j] + matrizA[i][k+2]*matrizB[k+2][j];
                    }
                    matrizC[i][j] = aux + matrizA[i][PP]*matrizB[PP][j] + matrizA[i][PPP]*matrizB[PPP][j];
                }
            }
        }
    }

    /**
     * Metodo 6: naivLoopUnrollingFour
     * @param A
     * @param B
     * @param Result
     * @param N
     * @param P
     * @param M
     */
    public static void NaivLoopUnrollingFour(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
        int i, j, k;
        int aux;

        if (P % 4 == 0) {
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < P; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j]
                                + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux;
                }
            }
        } else if (P % 4 == 1) {
            int PP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j]
                                + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j];
                }
            }
        } else if (P % 4 == 2) {

            int PP = P - 2;
            int PPP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j]
                                + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j];
                }
            }
        } else {
            int PP = P - 3;
            int PPP = P - 2;
            int PPPP = P - 1;
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    aux = 0;
                    for (k = 0; k < PP; k += 4) {
                        aux += A[i][k]*B[k][j] + A[i][k+1]*B[k+1][j] + A[i][k+2]*B[k+2][j]
                                + A[i][k+3]*B[k+3][j];
                    }
                    Result[i][j] = aux + A[i][PP]*B[PP][j] + A[i][PPP]*B[PPP][j]
                            + A[i][PPPP]*B[PPPP][j];
                }
            }
        }
    }

    /**
     * Metodo 7: WinogradOriginal
     * @param A
     * @param B
     * @param Result
     * @param N
     * @param P
     * @param M
     */
    public static void WinogradOriginal(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
        int i, j, k;
        int aux;
        int upsilon = P % 2;
        int gamma = P - upsilon;
        int[] y = new int[M];
        int[] z = new int[N];

        for (i = 0; i < M; i++) {
            aux = 0;
            for (j = 0; j < gamma; j += 2) {
                aux += A[i][j] * A[i][j+1];
            }
            y[i] = aux;
        }

        for (i = 0; i < N; i++) {
            aux = 0;
            for (j = 0; j < gamma; j += 2) {
                aux += B[j][i] * B[j+1][i];
            }
            z[i] = aux;
        }

        if (upsilon == 1) {
            /*
             * P is odd
             * The value A[i][P]*B[P][k] is missing in all auxiliary sums.
             */
            int PP = P - 1;
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k];
                }
            }
        } else {
            /*
             * P is even
             * The result can be computed with the auxiliary sums.
             */
            for (i = 0; i < M; i++) {
                for (k = 0; k < N; k++) {
                    aux = 0;
                    for (j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j+1][k]) * (A[i][j+1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }

        // Liberar memoria
        y = null;
        z = null;
    }

    /**
     * Metodo 8: WinogradScaled
     * @param A
     * @param B
     * @param Result
     * @param N
     * @param P
     * @param M
     */
    public static void WinogradScaled(int[][] A, int[][] B, int[][] Result, int N, int P, int M) {
        /* Create scaled copies of A and B */
        int[][] CopyA = new int[N][P];
        int[][] CopyB = new int[P][M];
        /* Scaling factors */
        double a = NormInf(A, N, P);
        double b = NormInf(B, P, M);
        double lambda = Math.floor(0.5 + Math.log(b/a)/Math.log(4));
        /* Scaling */
        MultiplyWithScalar(A, CopyA, N, P, (int) Math.pow(2, lambda));
        MultiplyWithScalar(B, CopyB, P, M, (int) Math.pow(2, -lambda));
        /* Using Winograd with scaled matrices */
        WinogradOriginal(CopyA, CopyB, Result, N, P, M);
    }

    public static void MultiplyWithScalar(int[][] A, int[][] B, int N, int M, int scalar) {
        int i, j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                B[i][j] = A[i][j] * scalar;
            }
        }
    }

    public static int NormInf(int[][] A, int N, int M) {
        int i, j;
        double max = Double.NEGATIVE_INFINITY;
        for (i = 0; i < N; i++) {
            double sum = 0.0;
            for (j = 0; j < M; j++) {
                sum += Math.abs(A[i][j]);
            }
            if (sum > max) {
                max = sum;
            }
        }
        return (int) max;
    }

    /**
     * Metodo 9: StrassenNaiv
     * @param matrizA
     * @param matrizB
     * @param matrizC
     * @param N
     * @param P
     * @param M
     */
    public static void StrassenNaiv(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M) {

        int MaxSize, k, m, NewSize, i, j;
        //MaxSize = max(N,P);
        MaxSize = max(N,P);
        //MaxSize = max(MaxSize,M);

        if (MaxSize < 16) {
            MaxSize = 16; // otherwise it is not possible to compute k
        }
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;

        NewSize = m * (int) Math.pow(2,k);

        // add zero rows and columns to use Strassens algorithm
        int[][] NewA = new int[NewSize][];
        int[][] NewB = new int[NewSize][];
        int[][] AuxResult = new int[NewSize][];
        for (i = 0; i < NewSize; i++){
            NewA[i] = new int[NewSize];
            NewB[i] = new int[NewSize];
            AuxResult[i] = new int[NewSize];
        }


        for (i = 0; i < NewSize; i++) {
            for (j = 0; j < NewSize; j++) {
                NewA[i][j] = 0;
                NewB[i][j] = 0;
            }
        }
        for (i = 0; i < N; i++) {
            for (j = 0; j < P; j++) {
                NewA[i][j] = matrizA[i][j];
            }
        }
        for (i = 0; i < P; i++) {
            for (j = 0; j < M; j++) {
                NewB[i][j] = matrizB[i][j];
            }
        }
        StrassenNaivStep(NewA, NewB, AuxResult, NewSize, m);
        // extract the result
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                matrizC[i][j] = AuxResult[i][j]; //Result
            }
        }
    }

    public static int max (int N, int P){
        if (N < P){
            return P;
        } else {
            return N;
        }

    }


    private static void Minus(int[][] A, int[][] B, int[][] Result, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Result[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    private static void Plus(int[][] A, int[][] B, int[][] Result, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Result[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    public static void StrassenNaivStep(int[][] A, int[][] B, int[][] Result, int N, int m) {
        int i, j, NewSize;

        if ((N % 2 == 0) && (N > m)){
            NewSize = N / 2;

            // decompose A and B
            // create ResultPart, Aux1,...,Aux7 and Helper1, Helper2
            int[][] A11 = new int[NewSize][];
            int[][] A12 = new int[NewSize][];
            int[][] A21 = new int[NewSize][];
            int[][] A22 = new int[NewSize][];
            int[][] B11 = new int[NewSize][];
            int[][] B12 = new int[NewSize][];
            int[][] B21 = new int[NewSize][];
            int[][] B22 = new int[NewSize][];

            int[][] ResultPart11 = new int[NewSize][];
            int[][] ResultPart12 = new int[NewSize][];
            int[][] ResultPart21 = new int[NewSize][];
            int[][] ResultPart22 = new int[NewSize][];

            int[][] Helper1 = new int[NewSize][];
            int[][] Helper2 = new int[NewSize][];

            int[][] Aux1 = new int[NewSize][];
            int[][] Aux2 = new int[NewSize][];
            int[][] Aux3 = new int[NewSize][];
            int[][] Aux4 = new int[NewSize][];
            int[][] Aux5 = new int[NewSize][];
            int[][] Aux6 = new int[NewSize][];
            int[][] Aux7 = new int[NewSize][];

            for (i = 0; i < NewSize; i++){

                A11[i] = new int[NewSize];
                A12[i] = new int[NewSize];
                A21[i] = new int[NewSize];
                A22[i] = new int[NewSize];
                B11[i] = new int[NewSize];
                B12[i] = new int[NewSize];
                B21[i] = new int[NewSize];
                B22[i] = new int[NewSize];

                ResultPart11[i] = new int[NewSize];
                ResultPart12[i] = new int[NewSize];
                ResultPart21[i] = new int[NewSize];
                ResultPart22[i] = new int[NewSize];

                Helper1[i] = new int[NewSize];
                Helper2[i] = new int[NewSize];

                Aux1[i] = new int[NewSize];
                Aux2[i] = new int[NewSize];
                Aux3[i] = new int[NewSize];
                Aux4[i] = new int[NewSize];
                Aux5[i] = new int[NewSize];
                Aux6[i] = new int[NewSize];
                Aux7[i] = new int[NewSize];
            }

            //fill new matrices
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A11[i][j] = A[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A12[i][j] = A[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A21[i][j] = A[NewSize + i][j];
                }
            }

            for( i = 0; i < NewSize; i++) {
                for (j = 0; j < NewSize; j++) {
                    A22[i][j] = A[NewSize + i][NewSize + j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B11[i][j] = B[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B12[i][j] = B[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B21[i][j] = B[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B22[i][j] = B[NewSize + i][NewSize + j];
                }
            }

            // computing the seven aux. variables
            Plus(A11, A22, Helper1, NewSize, NewSize);
            Plus(B11, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux1, NewSize, m);

            Plus(A21, A22, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B11, Aux2, NewSize, m);

            Minus(B12, B22, Helper1, NewSize, NewSize);
            StrassenNaivStep(A11, Helper1, Aux3, NewSize, m);

            Minus(B21, B11, Helper1, NewSize, NewSize);
            StrassenNaivStep(A22, Helper1, Aux4, NewSize, m);

            Plus(A11, A12, Helper1, NewSize, NewSize);
            StrassenNaivStep(Helper1, B22, Aux5, NewSize, m);

            Minus(A21, A11, Helper1, NewSize, NewSize);
            Plus(B11, B12, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux6, NewSize, m);

            Minus(A12, A22, Helper1, NewSize, NewSize);
            Plus(B21, B22, Helper2, NewSize, NewSize);
            StrassenNaivStep(Helper1, Helper2, Aux7, NewSize, m);

            // computing the four parts of the result
            Plus(Aux1, Aux4, ResultPart11, NewSize, NewSize);
            Minus(ResultPart11, Aux5, ResultPart11, NewSize, NewSize);
            Plus(ResultPart11, Aux7, ResultPart11, NewSize, NewSize);

            Plus(Aux3, Aux5, ResultPart12, NewSize, NewSize);

            Plus(Aux2, Aux4, ResultPart21, NewSize, NewSize);

            Plus(Aux1, Aux3, ResultPart22, NewSize, NewSize);
            Minus(ResultPart22, Aux2, ResultPart22, NewSize, NewSize);
            Plus(ResultPart22, Aux6, ResultPart22, NewSize, NewSize);

            // store results in the "result matrix"
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][j] = ResultPart11[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][NewSize + j] = ResultPart12[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][j] = ResultPart21[i][j];
                }
            }

            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j];
                }
            }

            // free helper variables
            A11 = null;
            A12 = null;
            A21 = null;
            A22 = null;

            B11 = null;
            B12 = null;
            B21 = null;
            B22 = null;

            ResultPart11 = null;
            ResultPart12 = null;
            ResultPart21 = null;
            ResultPart22 = null;

            Helper1 = null;
            Helper2 = null;

            Aux1 = null;
            Aux2 = null;
            Aux3 = null;
            Aux4 = null;
            Aux5 = null;
            Aux6 = null;
            Aux7 = null;

        } else {
            // use naiv algorithm
             NaivStandard(A, B, Result, N, N, N);
        }
    }

    /**
     * Metodo 10: StrassenWinograd
     * @param matrizA
     * @param matrizB
     * @param matrizC
     * @param N
     * @param P
     * @param M
     */
    public static void StrassenWinograd(int[][] matrizA, int[][] matrizB, int[][] matrizC, int N, int P, int M) {

        int MaxSize, k, m, NewSize, i, j;
        MaxSize = max(N,P);
        MaxSize = max(MaxSize,M);
        if ( MaxSize < 16){
            MaxSize = 16; // otherwise it is not possible to compute k
        }
        k = (int) Math.floor(Math.log(MaxSize)/Math.log(2)) - 4;
        m = (int) Math.floor(MaxSize * Math.pow(2,-k)) + 1;
        NewSize = m * (int) Math.pow(2,k);


        // add zero rows and columns to use Strassens algorithm
        int[][] NewA = new int[NewSize][];
        int[][] NewB = new int[NewSize][];
        int[][] AuxResult = new int[NewSize][];
        for (i = 0; i < NewSize; i++){
            NewA[i] = new int[NewSize];
            NewB[i] = new int[NewSize];
            AuxResult[i] = new int[NewSize];
        }

        for( i = 0; i < NewSize; i++){
            for( j = 0; j < NewSize; j++){
                NewA[i][j] = 0;
                NewB[i][j] = 0;
            }
        }
        for( i = 0; i < N; i++){
            for( j = 0; j < P; j++){
                NewA[i][j] = matrizA[i][j];
            }
        }
        for( i = 0; i < P; i++){
            for( j = 0; j < M; j++){
                NewB[i][j] = matrizB[i][j];
            }
        }

        StrassenWinogradStep(NewA, NewB, AuxResult, NewSize, m);

        // extract the result
        for( i = 0; i < N; i++){
            for( j = 0; j < M; j++){
                matrizC[i][j] = AuxResult[i][j];
            }
        }
    }

    private static void StrassenWinogradStep(int[][] A, int[][] B, int[][] Result, int N, int m) {
        int i, j , NewSize;

        if( (N % 2 == 0) && (N > m) ) { // recursive use of StrassenNaivStep
            NewSize = N / 2;

            // decompose A and B
            // create ResultPart, Aux1,...,Aux7 and Helper1, Helper2
            int[][] A1 = new int[NewSize][];
            int[][] A2 = new int[NewSize][];
            int[][] B1 = new int[NewSize][];
            int[][] B2 = new int[NewSize][];

            int[][] A11 = new int[NewSize][];
            int[][] A12 = new int[NewSize][];
            int[][] A21 = new int[NewSize][];
            int[][] A22 = new int[NewSize][];
            int[][] B11 = new int[NewSize][];
            int[][] B12 = new int[NewSize][];
            int[][] B21 = new int[NewSize][];
            int[][] B22 = new int[NewSize][];

            int[][] ResultPart11 = new int[NewSize][];
            int[][] ResultPart12 = new int[NewSize][];
            int[][] ResultPart21 = new int[NewSize][];
            int[][] ResultPart22 = new int[NewSize][];

            int[][] Helper1 = new int[NewSize][];
            int[][] Helper2 = new int[NewSize][];

            int[][] Aux1 = new int[NewSize][];
            int[][] Aux2 = new int[NewSize][];
            int[][] Aux3 = new int[NewSize][];
            int[][] Aux4 = new int[NewSize][];
            int[][] Aux5 = new int[NewSize][];
            int[][] Aux6 = new int[NewSize][];
            int[][] Aux7 = new int[NewSize][];
            int[][] Aux8 = new int[NewSize][];
            int[][] Aux9 = new int[NewSize][];

            for (i = 0; i < NewSize; i++){
                A1[i] = new int[NewSize];
                A2[i] = new int[NewSize];
                B1[i] = new int[NewSize];
                B2[i] = new int[NewSize];
                A11[i] = new int[NewSize];
                A12[i] = new int[NewSize];
                A21[i] = new int[NewSize];
                A22[i] = new int[NewSize];
                B11[i] = new int[NewSize];
                B12[i] = new int[NewSize];
                B21[i] = new int[NewSize];
                B22[i] = new int[NewSize];

                ResultPart11[i] = new int[NewSize];
                ResultPart12[i] = new int[NewSize];
                ResultPart21[i] = new int[NewSize];
                ResultPart22[i] = new int[NewSize];

                Helper1[i] = new int[NewSize];
                Helper2[i] = new int[NewSize];

                Aux1[i] = new int[NewSize];
                Aux2[i] = new int[NewSize];
                Aux3[i] = new int[NewSize];
                Aux4[i] = new int[NewSize];
                Aux5[i] = new int[NewSize];
                Aux6[i] = new int[NewSize];
                Aux7[i] = new int[NewSize];
                Aux8[i] = new int[NewSize];
                Aux9[i] = new int[NewSize];
            }

            // fill new matrices
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A11[i][j] = A[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A12[i][j] = A[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A21[i][j] = A[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    A22[i][j] = A[NewSize + i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B11[i][j] = B[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B12[i][j] = B[i][NewSize + j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B21[i][j] = B[NewSize + i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    B22[i][j] = B[NewSize + i][NewSize + j];
                }
            }

            // computing the 4 + 9 aux. variables
            Minus(A11, A21, A1, NewSize, NewSize);
            Minus(A22, A1, A2, NewSize, NewSize);
            Minus(B22, B12, B1, NewSize, NewSize);
            Plus(B1, B11, B2, NewSize, NewSize);

            StrassenWinogradStep(A11, B11, Aux1, NewSize, m);
            StrassenWinogradStep(A12, B21, Aux2, NewSize, m);
            StrassenWinogradStep(A2, B2, Aux3, NewSize, m);
            Plus(A21, A22, Helper1, NewSize, NewSize);
            Minus(B12, B11, Helper2, NewSize, NewSize);
            StrassenWinogradStep(Helper1, Helper2, Aux4, NewSize, m);
            StrassenWinogradStep(A1, B1, Aux5, NewSize, m);
            Minus(A12, A2, Helper1, NewSize, NewSize);
            StrassenWinogradStep(Helper1, B22, Aux6, NewSize, m);
            Minus(B21, B2, Helper1, NewSize, NewSize);
            StrassenWinogradStep(A22, Helper1, Aux7, NewSize, m);
            Plus(Aux1, Aux3, Aux8, NewSize, NewSize);
            Plus(Aux8, Aux4, Aux9, NewSize, NewSize);

            // computing the four parts of the result
            Plus(Aux1, Aux2, ResultPart11, NewSize, NewSize);
            Plus(Aux9, Aux6, ResultPart12, NewSize, NewSize);
            Plus(Aux8, Aux5, Helper1, NewSize, NewSize);
            Plus(Helper1, Aux7, ResultPart21, NewSize, NewSize);
            Plus(Aux9, Aux5, ResultPart22, NewSize, NewSize);

            // store results in the "result matrix"
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][j] = ResultPart11[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[i][NewSize + j] = ResultPart12[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][j] = ResultPart21[i][j];
                }
            }
            for( i = 0; i < NewSize; i++){
                for( j = 0; j < NewSize; j++){
                    Result[NewSize + i][NewSize + j] = ResultPart22[i][j];
                }
            }

            // free helper variables
            A1 = null;
            A2 = null;
            B1 = null;
            B2 = null;

            A11 = null;
            A12 = null;
            A21 = null;
            A22 = null;

            B11 = null;
            B12 = null;
            B21 = null;
            B22 = null;

            ResultPart11 = null;
            ResultPart12 = null;
            ResultPart21 = null;
            ResultPart22 = null;

            Helper1 = null;
            Helper2 = null;

            Aux1 = null;
            Aux2 = null;
            Aux3 = null;
            Aux4 = null;
            Aux5 = null;
            Aux6 = null;
            Aux7 = null;

        } else {
            // use naiv algorithm
            NaivStandard(A, B, Result, N, N, N);
        }
    }


	/**
	 * Metodo 11: iii3SequentialBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
	public static void III3SequentialBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
        for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                            }
                        }
                    }
                }
            }
        }
    }



	/**
	 * Metodo 12: iii4ParallelBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
	public static void III4ParallelBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
		Arrays.stream(new int[]{0}).parallel().forEach(i1 -> {
            for (i1 = 0; i1 <size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                                }
                            }
                        }
                    }
                }
            }
        });
    }

	/**
	 * Metodo 13: iv3SequentialBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
	public static void IV3SequentialBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
		 for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizC[i][k] += matrizA[i][j] * matrizB[j][k];
                            }
                        }
                    }
                }
            }
        }
    }

	/**
	 * Metodo 14: iv4ParallelBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 */
	public static void IV4ParallelBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
		IntStream.range(0, size / bsize).parallel().forEach(i1 -> {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1 * bsize; i < (i1 + 1) * bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizC[i][k] += matrizA[i][j] * matrizB[j][k];
                            }
                        }
                    }
                }
            }
        });
	}

	/**
	 * Metodo 15: v3SequentialBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 */
	public static void V3SequentialBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
		for (int i1 = 0; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    for (int i = i1; i < i1 + bsize && i < size; i++) {
                        for (int j = j1; j < j1 + bsize && j < size; j++) {
                            for (int k = k1; k < k1 + bsize && k < size; k++) {
                                matrizC[k][i] += matrizA[k][j] * matrizB[j][i];
                            }
                        }
                    }
                }
            }
       }
	}

	/**
	 * Metodo 16: v4ParallelBlock
	 * @param matrizA
	 * @param matrizB
	 * @param matrizC
	 * @param size
	 * @param bsize
	 * @return
	 * @return
	 */
	public static void V4ParallelBlock(int[][] matrizA, int[][] matrizB, int[][] matrizC, int size, int bsize, int aux){
        IntStream.range(0, 1).parallel().forEach(_i -> {
            for (int i1 = 0; i1 < size; i1 += bsize) {
                for (int j1 = 0; j1 < size; j1 += bsize) {
                    for (int k1 = 0; k1 < size; k1 += bsize) {
                        for (int i = i1; i < i1 + bsize && i < size; i++) {
                            for (int j = j1; j < j1 + bsize && j < size; j++) {
                                for (int k = k1; k < k1 + bsize && k < size; k++) {
                                    matrizC[k][i] += matrizA[k][j] * matrizB[j][i];
                                }
                            }
                        }
                    }
                }
            }
        });
	}
}
