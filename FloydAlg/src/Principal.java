import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		int[][] matrixEntrada = criarMatrix(args);
		printMatrix(matrixEntrada);
		floydAlgorithm(matrixEntrada);
		printMatrix(matrixEntrada);



	}

	public static int[][] criarMatrix(String[] args){
		
		int[][] matrixEntrada = null;
		

		if (args.length > 0) {
			File file = new File(args[0]);

			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String currentLine;

				int tamanhoDaMatrix = Integer.valueOf(br.readLine());
				int linha = 0;
				matrixEntrada = new int[tamanhoDaMatrix][tamanhoDaMatrix];
				
				

				while ((currentLine = br.readLine()) != null){
					String[] linhaDividida= currentLine.split(" ");
					
					for(int i = 0; i < tamanhoDaMatrix; i++){
						matrixEntrada[linha][i] = Integer.valueOf(linhaDividida[i]);
					}
					linha++;
							
				


				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Insert a valid path file");
		}


		return matrixEntrada;
	}
	
	public static void printMatrix(int[][] matrix){
		for (int[] row : matrix) 
	        System.out.println(Arrays.toString(row));
	}

	public static int[][] floydAlgorithm(int[][] matrix){

		int[][] matrixDistancia = matrix;
		int numberElementos = matrix.length;

		for (int k = 0; k < numberElementos; k++){
			for (int i = 0; i < numberElementos; i++){
				for (int j = 0; j < numberElementos; j++){
					matrixDistancia[i][j] = matrixDistancia[i][k] + matrixDistancia[k][j] < matrixDistancia[i][j] 
							? matrixDistancia[i][k] + matrixDistancia[k][j]
									: matrixDistancia[i][j];
				}
			}
		}
		return matrixDistancia;

	}

}
