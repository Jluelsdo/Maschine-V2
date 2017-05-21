import java.io.*;
import java.util.*;

public class MaschAnw
{
	static String[] maschGeber()
		{

			String[] csvFeld = new String[20];
			csvFeld[0] = "23;200;Presse;Halle1";
			csvFeld[1] = "456;300;CNC;Halle1";
			csvFeld[2] = "-321;23000;Messtisch;Labor";//F
			csvFeld[3] = "567;900;Drehbank;Schloßerei";
			csvFeld[4] = "999;1000;Schweißgerät;Schloßerei";
			csvFeld[5] = "876;700;Fluxkompensator;Labor";
			csvFeld[6] = "16623;23;armPresse;Galvanik";//F
			csvFeld[7] = "253;90;SaftpresseA;galvanik";//F
			csvFeld[8] = "16722;1000;3D Drucker;Labor";//F
			csvFeld[9] = "2984;1200;Roboter;Lackiererei";
			csvFeld[10] = "454567;1600;Drehbank;Schloßerei";
			csvFeld[11] = "9;1300;Schweißgerät;Schloßerei";
			csvFeld[12] = "876;800;Fluxkompensator;Pausenraum";
			csvFeld[13] = "5676;100;Drehbank;Schloßerei";
			csvFeld[14] = "989;400;Schweißgerät;Schloßerei";
			csvFeld[15] = "376;600;Lötstation;Labor";
			csvFeld[16] = "242424;1100;Roboter;Lackiererei";
			csvFeld[17] = "254;500;Roboter;Lackiererei";
			csvFeld[18] = "205;1500;Roboter;Lackiererei";
			csvFeld[19] = "204;1400;Roboter;Lackiererei";
			
			
			return csvFeld;
		}

	public static void main(String[] args) throws IOException
		{

			// (S1) Schritt 1
			System.out.println("Testinstanz mit Standard Konstruktor und Ausgabe durch ausMasch()\n\n");
			Maschine test = new Maschine();
			test.ausMasch();
			System.out.println("\n\n");

			// (S2) Schritt 2 
			System.out.println(
					"Maschinen Instanzen für die CSV Strings aus maschGeber().\nPrüfung und entsprechende Ausgabe\n\n\n");
			String[] csvF = maschGeber(); // CSV Strings aus maschGeber in ein Array laden
			//Maschine[] maschinenArray = new Maschine[8]; // Maschinen Array für Instanzen durch CSV Array
			List<Maschine> maschinenListe = new LinkedList<Maschine>(); // Liste für korrekte Maschinen Instanzen
			for (int i = 0; i < csvF.length; i++)
				{
					//maschinenArray[i] = new Maschine(csvF[i]);
					if (new Maschine(csvF[i]).getCrt() == 1) // korrekte Maschinen Instanz in Maschinenliste speichern
						{
							maschinenListe.add(new Maschine (csvF[i]));
							System.out.println("\nMaschine erfolgreich eingetragen:\n");
							//maschinenArray[i].ausMasch();
							new Maschine (csvF[i]).ausMasch();
							System.out.println("\n");
						} else
						{
							System.out.println("\nDie " + (i + 1)
									+ ". Maschinen Instanz enthielt fehlerhafte Werte.\nFehlerhafte Instanz:\n");
							new Maschine (csvF[i]).ausMasch();//maschinenArray[i].ausMasch(); // Referenz I Maschine Ausgabe wird null
						}
				}

			// (S3)&(S4) Schritt 3&4
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = 0;

			do
				{
					// Main Menü
					System.out.println();
					System.out.println("Bitte waehlen:");
					System.out.println("(1) Abschreibungswert einer Maschine berechnen");
					System.out.println("(2) Maschinenliste als Textdatei speichern");
				
					System.out.print("(0) Ende\n\nIhre Eingabe: ");

					choice = Integer.parseInt(in.readLine());
					System.out.println();

					switch (choice)
						{
						// (S3)
						case 1:
							System.out.print(
									"\nDie Liste enthält "+ maschinenListe.size() +" Elemente!\nWelche Maschine soll untersucht werden?\nPosition auf Maschinenliste: ");
							int mnr = Integer.parseInt(in.readLine());
							mnr -= 1;
							if (mnr<maschinenListe.size()){
							System.out.print("Welche Laufzeit hatte die Maschine?\nLaufzeit in Tagen: ");
							int lz = Integer.parseInt(in.readLine());
							
							System.out.println("Der Abschreibungswert der Maschine beträgt: "
									+ maschinenListe.get(mnr).abschreibung(lz)); 
							}else {
								System.out.println("Falsche Eingabe, kein Eintrag vorhanden");
							}
							break;
						// (S4)	
						case 2:

							FileWriter csvT = new FileWriter("MASCH.TXT", true);
							PrintWriter csvText = new PrintWriter(csvT);
							for (int a = 0; a < maschinenListe.toArray().length; a++)
								{
									csvText.println(maschinenListe.get(a).ausMaschCSV());

								}
							csvText.close();
							//}
							break;
		}
				} while (choice != 0);

		}

}
