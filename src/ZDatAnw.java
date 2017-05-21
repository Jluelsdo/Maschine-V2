import java.io.IOException;

public class ZDatAnw
{

	public static void main(String[] args) throws IOException
		{
			ZDatM lesend = new ZDatM("test.TXT", 1);
			ZDatM lesend2 = new ZDatM("MASCH.TXT", 1);
			ZDatM schreibend = new ZDatM("outFile.TXT",2);
			ZDatM schreibend2 = new ZDatM("outFile2.TXT",2);
			int anzahl = lesend.einlesen();
			System.out.println("Datensätze1: "+anzahl);
			anzahl = lesend2.einlesen();
			System.out.println("Datensätze2: "+anzahl);
			
			anzahl=lesend.sorts(2);
			System.out.println("sorts1 "+anzahl);
			anzahl=lesend2.sortDA(1);
			System.out.println("sortsDA "+anzahl);
			
			schreibend.dsliste=lesend.dsliste;
			schreibend.list2Dat();
			schreibend2.dsliste=lesend2.dsliste;
			schreibend2.list2Dat();

		}

}
