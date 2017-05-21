import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class ZDatM
{
	// KLassenattribute
	FileReader fr1;
	BufferedReader br1;
	FileWriter fw1;
	PrintWriter pr1;
	LinkedList<Maschine> dsliste;
	LinkedList<Maschine> hlist = new LinkedList<Maschine>();

	// Konstruktor
	ZDatM(String dsn, int mod) throws IOException
		{
			switch (mod)
				{
				// lesende Verarbeitung
				case 1:
					fr1 = new FileReader(dsn);
					br1 = new BufferedReader(fr1);
					dsliste = new LinkedList<Maschine>();
				
					fw1 = null;
					pr1 = null;

					break;
				// schreibende Verarbeitung
				case 2:
					fw1 = new FileWriter(dsn, true);
					pr1 = new PrintWriter(fw1);

					fr1 = null;
					br1 = null;
					dsliste = null;
					break;

				}
		}

	// Methoden
	int einlesen() throws IOException
		{
			int anzahl = 0;
			String input;
			while ((input = br1.readLine()) != null)
				{
					dsliste.add(new Maschine(input));
					anzahl++;
				}

			br1.close();

			return anzahl;
		}

	void list2Dat()
		{
			for (int a = 0; a < dsliste.size(); a++)
				{
					pr1.println(dsliste.get(a).ausMaschCSV());

				}
			pr1.close();

		}

	void hlist2Dat()
		{
			for (int a = 0; a < hlist.size(); a++)
				{
					pr1.println(hlist.get(a).ausMaschCSV());

				}
			pr1.close();

		}

	int bubble(int iox)
		{
			int sorts = 0;
			switch (iox)
				{
				// sortieren nach mabez
				case 1:
					for (int j = 0; j < dsliste.size(); j++)
						{
							for (int i = 0; i < dsliste.size() - 1; i++)
								{
									if (dsliste.get(i).getMabez().compareTo(dsliste.get(i + 1).getMabez()) < 0)
										{
											continue;
										}
									swap(i, i + 1);
									sorts++;
								}
						}
					break;

				// sortieren nach preis
				case 2:
					for (int j = 0; j < dsliste.size(); j++)
						{
							for (int i = 0; i < dsliste.size() - 1; i++)
								{
									if (dsliste.get(i).getPreis() < dsliste.get(i + 1).getPreis())
										{
											continue;
										}
									swap(i, i + 1);
									sorts++;
								}
						}
					break;

				// sortieren nach stao
				case 3:
					for (int j = 0; j < dsliste.size(); j++)
						{
							for (int i = 0; i < dsliste.size() - 1; i++)
								{
									if (dsliste.get(i).getStao().compareTo(dsliste.get(i + 1).getStao()) < 0)
										{
											continue;
										}
									swap(i, i + 1);
									sorts++;
								}
						}
					break;
				}

			return sorts;
		}

	void swap(int i, int min)
		{
			Maschine temp = dsliste.get(i);
			dsliste.set(i, dsliste.get(min));
			dsliste.set(min, temp);
		}

	public int sortDA(int iox)

		{
			int sorts = 0;
			LinkedList<Maschine> hlist = new LinkedList<Maschine>();
			ListIterator<Maschine> dslistIter = dsliste.listIterator(0);
			Maschine temp = new Maschine();
			int i = 0;
			switch (iox)
				{
					// sortieren nach mabez
				case 1: 
					while (hlist.size() != dsliste.size())
						{
							if (dslistIter.hasNext())
								temp = dslistIter.next();
							else
								break;
							if (hlist.size() == 0)
								{
									sorts++;
									hlist.add(temp);
								} else if (hlist.get(hlist.size() - 1).getMabez().compareTo(temp.getMabez()) < 0)
								{
									sorts++;
									hlist.add(temp);
								} else
								{
									while (hlist.get(i++).getMabez().compareTo(temp.getMabez()) < 0)
										{
											sorts++;
										}
									hlist.add(--i, temp);
									i = 0;
								}
						}
					break;
					
					// sortieren nach preis
				case 2:
					while (hlist.size() != dsliste.size())
						{
							if (dslistIter.hasNext())
								temp = dslistIter.next();
							else
								break;
							if (hlist.size() == 0)
								{
									sorts++;
									hlist.add(temp);
								} else if (hlist.get(hlist.size() - 1).getPreis() < temp.getPreis())
								{
									sorts++;
									hlist.add(temp);
								} else
								{
									while (hlist.get(i++).getPreis() < temp.getPreis())
										{
											sorts++;
										}
									hlist.add(--i, temp);
									i = 0;
								}
						}
					break;
					
				// sortieren nach stao	
				case 3:

					while (hlist.size() != dsliste.size())
						{
							if (dslistIter.hasNext())
								temp = dslistIter.next();
							else
								break;
							if (hlist.size() == 0)
								{
									sorts++;
									hlist.add(temp);
								} else if (hlist.get(hlist.size() - 1).getStao().compareTo(temp.getStao()) < 0)
								{
									sorts++;
									hlist.add(temp);
								} else
								{
									while (hlist.get(i++).getStao().compareTo(temp.getStao()) < 0)
										{
											sorts++;
										}
									hlist.add(--i, temp);
									i = 0;
								}
						}
					break;

				}

			for (i = 0; i < hlist.size(); i++)
				dsliste.set(i, hlist.get(i));
			return sorts;
		}

	// klassische direkte Auswahl in einer Liste
	int sorts(int iox)
		{
			int sorts = 0;

			switch (iox)
				{
				// sortieren nach mabez
				case 1:

					for (int i = 0; i < dsliste.size() - 1; i++)
						{
							int min = i;
							for (int j = i + 1; j < dsliste.size(); j++)
								{
									if (dsliste.get(j).getMabez().compareTo(dsliste.get(min).getMabez()) < 0)
										{
											min = j;
										}
									sorts++;
								}
							swap(i, min);
							
						}
					break;

				// sortieren nach preis
				case 2:
					for (int i = 0; i < dsliste.size() - 1; i++)
						{
							int min = i;
							for (int j = i + 1; j < dsliste.size(); j++)
								{
									if (dsliste.get(j).getPreis() < dsliste.get(min).getPreis())
										{
											min = j;
										}
									sorts++;
								}
							swap(i, min);
							
						}
					break;
				// sortieren nach stao
				case 3:
					for (int i = 0; i < dsliste.size() - 1; i++)
						{
							int min = i;
							for (int j = i + 1; j < dsliste.size(); j++)
								{
									if (dsliste.get(j).getStao().compareTo(dsliste.get(min).getStao()) < 0)
										{
											min = j;
										}
									sorts++;
								}
							swap(i, min);
							
						}
					break;

				}
			return sorts;
		}
}
