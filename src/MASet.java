import java.io.BufferedReader;
import java.io.IOException;

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
							if (tmenge.add(new MaschineS(input)))
								anzahl++;
						}
				}
			boolean[] wasAdded = new boolean[anzahl];
			for (int i = 0; i < anzahl; i++)
				{
					if (wasAdded[i])
						System.out.println((i + 1) + "te Maschine wurde eingetragen!\n");
					else
						System.out.println((i + 1) + "te Maschine wurde NICHT eingetragen!\n");
				}
			br1.close();
			return anzahl;
		}

}
