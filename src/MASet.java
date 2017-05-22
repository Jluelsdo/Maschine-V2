import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

import java.util.TreeSet;

public class MASet
{
	TreeSet<MaschineS> tmenge = new TreeSet<MaschineS>();

	MASet()
	{
	}

	int dat2tset(BufferedReader br1) throws IOException
		{
			int anzahl = 0;
			String input;

			while ((input = br1.readLine()) != null)
				{
					if ((new MaschineS(input).getCrt()) == 1)
						{
							if (tmenge.add(new MaschineS(input)))  //Es wird nur die erste Maschine eingetragen?!
								{
									System.out.println("Done!\n");
									anzahl++;
								} else
								{
									System.out.println("Not added!");
								}
						}
				}

			br1.close();
			return anzahl;
		}

	String[] set2Stringf(int a)
		{
			String[] csvStrings = new String[tmenge.size()];
			switch (a)
				{
				case 1:
					Iterator<MaschineS> iti = tmenge.iterator();
					int i = 0;
					csvStrings[0] = tmenge.first().ausMaschCSV();
					while (iti.hasNext())
						{
							csvStrings[i] = (iti.next().ausMaschCSV());
							i++;
						}
					break;
				}
			return csvStrings;
		}
}
