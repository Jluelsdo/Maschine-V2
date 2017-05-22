import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeSet;

public class MASet
{
	TreeSet<MaschineS> tmenge = new TreeSet<MaschineS>();

	MASet(){}
	
	int dat2tset(BufferedReader br1) throws IOException
		{
			
			int anzahl = 0;
			String input;

			while ((input = br1.readLine()) != null)
				{
					if ((new MaschineS(input).getCrt()) == 1)
						{
						boolean wasSet;
						wasSet= tmenge.add(new MaschineS(input));
							anzahl++;
							
						}
				}

			ein.close();
			return anzahl;
		}

}
