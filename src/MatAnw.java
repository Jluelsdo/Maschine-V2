import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatAnw {

	public static void main(String[] args) throws IOException{

		FileWriter fw1 = new FileWriter("test1_Outfile.txt");
		FileWriter fw2 = new FileWriter("test2_Outfile.txt");
		FileWriter fwR = new FileWriter("Ergebnis_MatMul.txt");
		FileReader fr1 = new FileReader("Mat1.txt");
		FileReader fr2 = new FileReader("Mat2.txt");
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		BufferedReader br2 = new BufferedReader(fr2);
		
		Mat testMat1 = new Mat(br1);
		Mat testMat2= new Mat(br2);
		Mat resultatMatMul = new Mat();
		
		
		
		
		//Ausgaben und Multiplikation
		
		testMat1.matAus(fw1);
		
		testMat2.matAus(fw2);
		
		if (testMat1.matMul(testMat2).crt != -3){

			resultatMatMul = testMat1.matMul(testMat2);	
			resultatMatMul.matAus(fwR);

		}else System.out.println("Multiplizieren nicht möglich");
		
		
	}

}
