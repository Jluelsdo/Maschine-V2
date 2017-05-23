
public class MaschineS implements Comparable<MaschineS>
{

	private int manr;
	private int crt = 1;
	private double preis;
	private String mabez, stao;

	MaschineS()
	{

	}

	MaschineS(String csvString)
	{
		String[] s = csvString.split(";");

		boolean[] korrekt = new boolean[4];

		korrekt[0] = setManr(Integer.parseInt(s[0]));
		korrekt[1] = setPreis(Double.parseDouble(s[1]));
		korrekt[2] = setMabez(s[2]);
		korrekt[3] = setStao(s[3]);

		for (int i = 0; i < korrekt.length; i++)
			{
				if (!korrekt[i])
					{
						crt = 2;
					}
			}
	}

	// get Methoden
	public int getManr()
		{
			return manr;
		}

	public double getPreis()
		{
			return preis;
		}

	public String getMabez()
		{
			return mabez;
		}

	public String getStao()
		{
			return stao;
		}

	public int getCrt()
		{
			return crt;
		}

	// set Methoden
	public boolean setManr(int manr)
		{
			if (manr >= 1)
				{
					this.manr = manr;
					return true;
				} else

				return false;
		}

	public boolean setPreis(double kohlen)
		{
			if (kohlen > 1)
				{
					preis = kohlen;
					return true;
				} else
				return false;
		}

	public boolean setMabez(String name)
		{
			if (checkChar(name))
				{
					mabez = name;
					return true;
				} else // trotzdem eintragen??? Referenz I
				return false;
		}

	public boolean setStao(String staO)
		{
			if (checkChar(staO))
				{
					stao = staO;
					return true;
				} else
				return false;
		}

	// Hilfsmethoden
	public boolean checkChar(String bez)
		{
			if ((bez.charAt(0) >= 'A') && (bez.charAt(0) <= 'Z'))
				{
					return true;
				} else
				return false;
		}

	// Methoden

	void ausMasch()
		{
			System.out.println("Maschinen Nr: " + manr + "\nPreis: " + preis + "\nMaschinen Bezeichnung: " + mabez
					+ "\nStandort: " + stao);

		}

	String ausMaschCSV()
		{
			String csvGen = manr + ";" + preis + ";" + mabez + ";" + stao;
			return csvGen;
		}

	double abschreibung(int laufz)
		{
			return (preis / laufz);

		}

	
	public int compareTo(MaschineS in)
		{
			if ((this.manr == in.manr)&&(this.mabez == in.mabez)&&(this.preis==in.preis)){
				return 0;
			}else return 1;
		}
}
