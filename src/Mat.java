import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Mat
{
	int n = 0;
	int m = 0;
	double a[][];
	int crt = 1;

	Mat()
	{
	}

	Mat(BufferedReader br1) throws IOException
	{
		LinkedList<String> matList = new LinkedList<String>();
		String pz;
		while ((pz = br1.readLine()) != null)
			{
				matList.add(pz);

			}
		n = matList.size();
		// Ersten Datensatz lesen und Spaltenanzahl m bestimmen
		String[] sTemp = matList.get(0).split(";");
		m = sTemp.length;
		a = new double[n][m];
		// weitere Datensätze einlesen und Spaltenanzahl überprüfen
		for (int i = 0; i < n; i++)
			{
				sTemp = matList.get(i).split(";");
				if (sTemp.length != m)
					{
						crt = -1;
					} else
					{

						for (int j = 0; j < m; j++)
							{
								a[i][j] = Double.parseDouble(sTemp[j]);
							}
					}

			}
	}

	boolean matAus(FileWriter fx)
		{
			String csvTemp = "";
			PrintWriter pr1 = new PrintWriter(fx);
			for (int i = 0; i < n; i++)
				{

					for (int j = 0; j < m; j++)
						{

							csvTemp += a[i][j];
							if (j < (m - 1))
								{
									csvTemp += ";";
								}

						}
					pr1.println(csvTemp);
					csvTemp = "";
				}
			pr1.close();
			return true;
		}

	Mat matMul(Mat b)
		{
			Mat resultat = new Mat();
			int m2, n2;
			double help[][];
			if (b.a.length == a[0].length)
				{ // Prüfung ob Matrizen multiplizierbar
					n2 = a.length;
					m2 = b.a[0].length;
					help = new double[n2][m2]; //Hilfsarray entprechend der Zeilen und Spalten erstellen

					for (int i = 0; i < n2; i++) //Zeilen
						{
							for (int j = 0; j < m2; j++) //Spalten
								{

									for (int k = 0; k < b.a.length; k++) // Multiplikation
										{
											help[j][j] += a[i][k] * b.a[k][j];
										}
								}
						}
					resultat.a = help;
				} else
				{
					resultat.crt = -3;
				} // wenn Matrizen nicht multiplizierbar CRT = -3
			return resultat;
		}

}
