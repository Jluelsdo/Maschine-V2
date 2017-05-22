import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MASetAnw
{

	public static void main(String[] args) throws IOException
		{
			MASet test = new MASet();
			FileReader fr = new FileReader("MASCH.TXT");
			BufferedReader ein = new BufferedReader(fr);
			test.dat2tset(ein);
			String[] csvs = test.set2Stringf(1);
			for (int i = 0;i<csvs.length;i++)
				System.out.println("CSV "+(i+1)+" : "+csvs[i]);
		}

}
