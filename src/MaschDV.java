import java.io.*;
import java.util.LinkedList;
//import java.util.*;

public class MaschDV
{

	public static void main(String[] args) throws IOException
		{
			FileReader fr = new FileReader("MASCH.TXT");
			BufferedReader ein = new BufferedReader(fr);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			LinkedList<Maschine> maschinenListe = new LinkedList<Maschine>();

			String input;
			while ((input = ein.readLine()) != null)
				{
					maschinenListe.add(new Maschine(input));
				}

			ein.close();
			int choice = 0;

			do
				{
					// Main Menü
					System.out.println();
					System.out.println("Bitte waehlen:");
					System.out.println("(1) Knoten der Liste anzeigen");
					System.out.println("(2) Neuer Knoten");
					System.out.println("(3) Knoten löschen");
					System.out.println("(4) Ändern eines Knoten");
					System.out.println("(5) Liste in Datei schreiben");

					System.out.println("(0) Ende");

					choice = Integer.parseInt(in.readLine());
					System.out.println();
					int pos;
					switch (choice)
						{

						case 1:
							for (int k = 0; k < maschinenListe.size(); k++)
								{
									System.out.println("\n\nInhalt des " + (k + 1) + "ten Knoten:");
									maschinenListe.get(k).ausMasch();
									System.out.println("\n");
								}
							break;

						case 2:

							//int lastElement = (maschinenListe.size() - 1);
							do
								{
									System.out.print("\nAn welcher Stelle soll der Knoten erstellt werden?\nKnoten: ");
									pos = Integer.parseInt(in.readLine()) - 1;
								} while (pos >= maschinenListe.size());

							int mnr;
							double pr;
							String mab;
							String so;
							do
								{
									System.out.print("\nGeben sie die Maschinen Nummer ein: ");
									mnr = Integer.parseInt(in.readLine());
								} while (mnr < 1);
							do
								{
									System.out.print("\nGeben sie den Kaufpreis ein: ");
									pr = Double.parseDouble(in.readLine());
								} while (pr <= 1);
							do
								{
									System.out.print("\nGeben sie die Maschinen Bezeichnung ein: ");
									mab = in.readLine();
								} while (!(maschinenListe.get(0).checkChar(mab)));
							do
								{
									System.out.print("\nGeben sie den Maschinen Standort ein: ");
									so = in.readLine();
								} while (!(maschinenListe.get(0).checkChar(so)));

							String csvTemp = mnr + ";" + pr + ";" + mab + ";" + so;

							maschinenListe.add(pos, new Maschine(csvTemp));

							break;

						case 3: //LÖSCHEN

							do
								{
									System.out.print("\nDie Liste enthält " + maschinenListe.size()
											+ " Knoten.\nWelcher Knoten soll gelöscht werden? (1-"
											+ maschinenListe.size() + ")\nPosition : ");
									pos = ((Integer.parseInt(in.readLine())) - 1);
								} while (pos >= maschinenListe.size());
							maschinenListe.remove(pos);
							break;

						case 4: //ÄNDERN
							do
								{
									System.out.print("\nDie Liste enthält " + maschinenListe.size()
											+ " Knoten.\nWelcher Knoten soll bearbeitet werden? (1-"
											+ maschinenListe.size() + ")\nPosition : ");
									pos = ((Integer.parseInt(in.readLine())) - 1);
								} while (pos >= maschinenListe.size());
							do
								{
									// Änderungsmenü
									System.out.println();
									System.out.println("Was möchten sie ändern?");
									System.out.println("(1) Maschinen Nummer");
									System.out.println("(2) Kaufpreis");
									System.out.println("(3) Maschinenbezeichnung");
									System.out.println("(4) Standort");
									System.out.println("(0) Ende");

									choice = Integer.parseInt(in.readLine());
									System.out.println();

									switch (choice)
										{

										case 1:
											System.out
													.print("\nAktueller Eintrag: " + maschinenListe.get(pos).getManr());
											do
												{
													System.out.print("\nGeben sie die neue Maschinen Nummer ein: ");
													mnr = Integer.parseInt(in.readLine());
												} while (mnr < 1);

											maschinenListe.get(pos).setManr(mnr);
											break;

										case 2:
											System.out.print(
													"\nAktueller Eintrag: " + maschinenListe.get(pos).getPreis());
											do
												{
													System.out.print("\nGeben sie den Kaufpreis ein: ");
													pr = Double.parseDouble(in.readLine());
												} while (pr <= 1);
											maschinenListe.get(pos).setPreis(pr);
											break;

										case 3:
											System.out.print(
													"\nAktueller Eintrag: " + maschinenListe.get(pos).getMabez());
											do
												{
													System.out.print("\nGeben sie die Maschinen Bezeichnung ein: ");
													mab = in.readLine();
												} while (!(maschinenListe.get(pos).checkChar(mab)));
											maschinenListe.get(pos).setMabez(mab);
											break;

										case 4:
											System.out
													.print("\nAktueller Eintrag: " + maschinenListe.get(pos).getStao());
											do
												{
													System.out.print("\nGeben sie den Maschinen Standort ein: ");
													so = in.readLine();
												} while (!(maschinenListe.get(pos).checkChar(so)));
											maschinenListe.get(pos).setStao(so);
											break;

										}
								} while (choice != 0);
							choice = 1;
							break;

						case 5: //DATEI SCHREIBEN
							System.out
									.print("\nGeben sie den Namen ein, unter dem die Datei gespeichert werden soll : ");
							String tempa = in.readLine();
							FileWriter csvT = new FileWriter(tempa + ".TXT", true);
							PrintWriter csvText = new PrintWriter(csvT);
							for (int a = 0; a < maschinenListe.size(); a++)
								{
									csvText.println(maschinenListe.get(a).ausMaschCSV());

								}
							csvText.close();
							break;
						}
				} while (choice != 0);

		}

}
