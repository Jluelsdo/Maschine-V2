import java.io.*;

public class MaschinenTest
{

	public static void main(String[] args) throws IOException
		{
			String csv = "123;23;aAA;BBB";
			Maschine test = new Maschine(csv);
			
			//test.setManr(-1);
			test.ausMasch();
			System.out.println(test.ausMaschCSV());
		}

}
