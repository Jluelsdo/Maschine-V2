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
		}

}
