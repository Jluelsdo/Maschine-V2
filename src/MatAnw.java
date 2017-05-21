import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatAnw
{

	public static void main(String[] args) throws IOException
		{
			// File/Buffered -reader, Filewriter
			// FileReader fr1 = new FileReader("mat_.txt");
			FileWriter fw1 = new FileWriter("test_.txt");
			// BufferedReader br1 = new BufferedReader(fr1);

			FileReader fr2 = new FileReader("mat3_3.txt");
			FileWriter fw2 = new FileWriter("test3_3.txt");
			BufferedReader br2 = new BufferedReader(fr2);

			FileReader fr3 = new FileReader("mat3_2.txt");
			FileWriter fw3 = new FileWriter("test3_2.txt");
			BufferedReader br3 = new BufferedReader(fr3);

			FileReader fr4 = new FileReader("mat5_6.txt");
			FileWriter fw4 = new FileWriter("test5_6.txt");
			BufferedReader br4 = new BufferedReader(fr4);

			FileReader fr5 = new FileReader("mat6_7.txt");
			FileWriter fw5 = new FileWriter("test6_7.txt");
			BufferedReader br5 = new BufferedReader(fr5);

			// Matrizen
			Mat mat_ = new Mat();
			if (mat_.matAus(fw1))
				{
					System.out.println("GUT");
				} else
				System.out.println("Schlecht");

			Mat mat3_3 = new Mat(br2);
			if (mat3_3.matAus(fw2))
				{
					System.out.println("GUT");
				} else
				System.out.println("Schlecht");
			Mat mat3_2 = new Mat(br3);
			if (mat3_2.matAus(fw3))
				{
					System.out.println("GUT");
				} else
				System.out.println("Schlecht");
			Mat mat5_6 = new Mat(br4);
			if (mat5_6.matAus(fw4))
				{
					System.out.println("GUT");
				} else
				System.out.println("Schlecht");
			Mat mat6_7 = new Mat(br5);
			if (mat6_7.matAus(fw5))
				{
					System.out.println("GUT");
				} else
				System.out.println("Schlecht");

			// Multiplikation Ergebnis Matrix
			FileWriter fwR = new FileWriter("Ergebnis_MatMul.txt");
			Mat resMatMul = new Mat();

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = 0;

			do
				{
					// Main Menü
					System.out.println();
					System.out.println("Bitte waehlen:");
					System.out.println("(1) mat_ * mat3_3");
					System.out.println("(2) mat3_3 * mat3_2");
					System.out.println("(3) mat5_6 * mat_6_7");
					System.out.println("(4) mat5_6 * mat3_3");
					System.out.println("(5) mat3_3 * mat3_3");

					System.out.println("(0) Ende");

					choice = Integer.parseInt(in.readLine());
					System.out.println();

					switch (choice)
						{

						case 1:
							if (mat_.matMul(mat3_3).crt != -3)
								{

									resMatMul = mat_.matMul(mat3_3);
									if (resMatMul.matAus(fwR))
										{
											System.out.println("GUT");
										} else
										System.out.println("Schlecht");

								} else
								System.out.println("Multiplizieren nicht möglich");

							break;

						case 2:
							if (mat3_3.matMul(mat3_2).crt != -3)
								{

									resMatMul = mat3_3.matMul(mat3_2);
									if (resMatMul.matAus(fwR))
										{
											System.out.println("GUT");
										} else
										System.out.println("Schlecht");

								} else
								System.out.println("Multiplizieren nicht möglich");
							break;

						case 3:
							if (mat5_6.matMul(mat6_7).crt != -3)
								{

									resMatMul = mat5_6.matMul(mat6_7);
									if (resMatMul.matAus(fwR))
										{
											System.out.println("GUT");
										} else
										System.out.println("Schlecht");

								} else
								System.out.println("Multiplizieren nicht möglich");
							break;

						case 4:
							if (mat5_6.matMul(mat3_3).crt != -3)
								{

									resMatMul = mat5_6.matMul(mat3_3);
									if (resMatMul.matAus(fwR))
										{
											System.out.println("GUT");
										} else
										System.out.println("Schlecht");

								} else
								System.out.println("Multiplizieren nicht möglich");
							break;

						case 5:
							if (mat3_3.matMul(mat3_3).crt != -3)
								{

									resMatMul = mat3_3.matMul(mat3_3);
									if (resMatMul.matAus(fwR))
										{
											System.out.println("GUT");
										} else
										System.out.println("Schlecht");

								} else
								System.out.println("Multiplizieren nicht möglich");
							break;
						}
				} while (choice != 0);

		}
}
