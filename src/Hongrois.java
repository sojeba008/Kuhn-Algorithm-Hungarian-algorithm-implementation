import java.util.ArrayList;

public class Hongrois {
	private int size;
	private String[][] tab;
	public static int[] la;
	public static int[] ln;
	public static int[] c;
	public static int a;
	public static int b;
	public static int C;
	
	
	public Hongrois(int size,String[][] tab){
		this.tab=tab;
	}
	
	
	public static String[][] process(String[][] tab) {
		String[][] tabb;
		String[] tabv;
		tab = coupling(tab);

		ArrayList lineWithoutZe = new ArrayList();
		lineWithoutZe.clear();
		ArrayList ColWithZbOnMakedLine = new ArrayList(); 
		ColWithZbOnMakedLine.clear();
		//System.out.println(lineWithoutZe.contains("5"));;
		int lineNumber=-1;
		for (String[] line : tab) {
			int counter=0;
			lineNumber+=1;
			for (String el : line) {
				if(el.equals("ze")) break;
				counter+=1;
			}
			if(counter==tab[0].length) lineWithoutZe.add(lineNumber);
		}
		
		
		int oldlineWithoutZeSize=-1;
		int oldColWithZbOnMakedLineSize=-1;
		int colNumber=-1;
		//System.out.println(lineWithoutZe.size());
		while(oldlineWithoutZeSize!=lineWithoutZe.size() || oldColWithZbOnMakedLineSize!= ColWithZbOnMakedLine.size())
		{	
			oldlineWithoutZeSize=lineWithoutZe.size();
			oldColWithZbOnMakedLineSize= ColWithZbOnMakedLine.size();
			lineNumber=-1;
			
			for (String[] line : tab) {
				lineNumber+=1;
				colNumber=-1;
				for (String el : line) {
					colNumber+=1;
					if(el.equals("zb") && lineWithoutZe.contains(lineNumber) && !ColWithZbOnMakedLine.contains(colNumber)){
						ColWithZbOnMakedLine.add(colNumber);
					}
				}
			}
			
			

			lineNumber=-1;
			for (String[] line : tab) {
				lineNumber+=1;
				colNumber=-1;			
				for (String el : line) {
					colNumber+=1;
					if(el.equals("ze") && ColWithZbOnMakedLine.contains(colNumber) && !lineWithoutZe.contains(lineNumber)){
						lineWithoutZe.add(lineNumber);
					}
					
				}
			}
			
			
		}
		
		

		
		ArrayList ValuesOfRemainingMatrix=new ArrayList();
		ValuesOfRemainingMatrix.clear();
		lineNumber=-1;
		for (String[] line : tab) {
			lineNumber+=1;
			colNumber=-1;			
			for (String el : line) {
				colNumber+=1;
				if(lineWithoutZe.contains(lineNumber) && !ColWithZbOnMakedLine.contains(colNumber)) {
					ValuesOfRemainingMatrix.add(el);
				}
				
			}
		}
		//System.out.println(lineWithoutZe);
		//System.out.println(ColWithZbOnMakedLine);
		//System.out.println(ValuesOfRemainingMatrix);
		int lowerstValue=Integer.MAX_VALUE;
		for (Object object : ValuesOfRemainingMatrix) {
			if(object!="inf"){
				if(Integer.parseInt((String) object)<lowerstValue)
				{
					lowerstValue=Integer.parseInt((String) object);
				}
			}
			
		}
		//System.out.println(lowerstValue);
		
		for (int i = 0; i<tab.length;i++)
		{
			for (int j=0;j<tab[0].length;j++)
			{
				if(tab[i][j]=="ze" || tab[i][j]=="zb") tab[i][j]="0";
				//System.out.print(" "+tab[i][j]);
			}
		}
		
		//Hongrois.toString(tab);
		for (int i = 0; i<tab.length;i++) {		
			for (int j=0;j<tab[0].length;j++) {
				if(!lineWithoutZe.contains(i) && ColWithZbOnMakedLine.contains(j)) {
					if(tab[i][j]=="inf") tab[i][j]=Integer.toString(Integer.MAX_VALUE);
					tab[i][j]=Integer.toString(Integer.parseInt(tab[i][j])+lowerstValue);
				}
				
			}
		}
		
		for (int i = 0; i<tab.length;i++) {		
			for (int j=0;j<tab[0].length;j++) {
				if(lineWithoutZe.contains(i) && !ColWithZbOnMakedLine.contains(j)) {
					if(tab[i][j]=="inf") tab[i][j]=Integer.toString(Integer.MAX_VALUE);
					tab[i][j]=Integer.toString(Integer.parseInt(tab[i][j])-lowerstValue);
					//System.out.println(tab[i][j]);
				}
				
			}
		}
		
		

		return tab;
		

	}


	public static void toString(String[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				System.out.print("  " + tab[i][j]);
			}
			System.out.println("");
		}
	System.out.println("\n");	
	}
	

	public static int lowest(String[] tab) {

		int lwst = 0, temp = lwst;
		try {
			if ((tab[0] != "0") && (tab[0] != "0.0")) {
				lwst = (int) Integer.parseInt(tab[0]);
			}
		} catch (Exception e) {
			if (tab[0] == "inf") {
				lwst = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < tab.length; i++) {
			if(tab[i]!="inf" && tab[i]!=null && !tab.equals("0"))
			{
			try {
				temp = Integer.parseInt(tab[i]);
			} catch (Exception e) {

			}
			if ((lwst >= temp)) {

				lwst = (int) temp;

			}
		 }

		}

		return lwst;
	}

	public static String[][] coupling(String[][] tab) {
		String[][] tabl = new String[tab.length][tab[0].length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				tabl[i][j] = tab[i][j];
			}
		}

		boolean alreadyFound = false;

		for (int i = 0; i < tabl.length; i++) {

			for (int j = 0; j < tabl[0].length; j++) {

				if (tabl[i][j].equals("0")) {
					tabl[i][j] = "ze";

					for (int k = 0; k < tabl.length; k++) {
						if (tabl[k][j].equals("0")) {
							tabl[k][j] = "zb";
						}
					}
					for (int k = 0; k < tabl.length; k++) {
						if (tabl[i][k].equals("0")) {
							tabl[i][k] = "zb";

						}
					}

					alreadyFound = true;
				}

				if (((tabl[i][j] == "0")) && alreadyFound == true) {
					tabl[i][j] = "zb";

					alreadyFound = true;
				}

			}
			alreadyFound = false;
		}

		return tabl;
	}

	//public static String[] sous_matrice_dadjonction(String[][] tab) {
		

	//}

	public static void improvement(String[][] tab, int lwst) {
		boolean verif = true;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				for (int k = 0; k < 1; k++) {
					if ((ln[k] == i)) {
						verif = false;
					} else if ((la[k] == i)) {
						verif = false;
					} else {
						verif = true;
					}
				}
				if (verif == false) {
					if (tab[i][j].equals("0")) {

					} else {
						try {
							tab[i][j] = Integer.toString(Integer.parseInt((tab[i][j])) - lwst);
							// System.out.println(tab[i][j]);
						} catch (Exception e) {
						}
					}
				}
			}
		}

		verif = false;
		boolean verif2 = true;
		for (int i = 0; i < tab.length; i++) {

			for (int k = 0; k < 1; k++) {
				if (c[k] == i) {
					verif = true;

				}
			}
			if (verif == true) {
				for (int j = 0; j < tab.length; j++) {
					for (int k = 0; k < 1; k++) {
						if ((ln[k] == j)) {
							verif2 = false;
						} else if ((la[k] == j)) {
							verif2 = false;
						} else {
							verif2 = true;
						}
					}
					if (verif2 == true) {
						try {
							tab[j][i] = Integer.toString(Integer.parseInt((tab[j][i])) + lwst);
						} catch (Exception e) {

						}
					}
					verif2 = true;
				}
			}

			verif = false;
		}
		// toString(tab);
	}

	public static int lowestd(int[] vecti) {

		int lwst = 0, temp = lwst;

		lwst = vecti[0];

		for (int i = 0; i < vecti.length; i++) {

			if ((lwst >= vecti[i])) {

				lwst = vecti[i];

			}
		}
		return lwst;
	}

	public static void optimization(String[][] tab) {
		int[] vect = new int[tab[0].length];

		int[][] tabb = new int[tab.length][tab[0].length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				try {
					tabb[i][j] = Integer.parseInt(tab[i][j]);
				} catch (Exception e) {
				
					tabb[i][j] = 1000000000;
				}
			}
		}

		int lwst = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				vect[j] = (tabb[i][j]);
			}
			lwst = lowestd(vect);

			if (lwst != 0) {
				for (int j = 0; j < tab[0].length; j++) {
					try {
						tabb[i][j] = tabb[i][j] - lwst;
					} catch (Exception e) {

					}
				}
			}

		}
		
		int[] vect2 = new int[tab.length];
		for (int i = 0; i < tab[0].length; i++) {
			for (int j = 0; j < tab.length; j++) {
				//System.out.println(i+" et "+j+" "+tabb[j][i]);
				vect2[j] = (tabb[j][i]);
			}
			lwst = lowestd(vect2);
			// System.out.println(lwst);

			if (lwst != 0) {
				for (int j = 0; j < tab[0].length; j++) {
					try {
						tabb[j][i] = tabb[j][i] - lwst;
					} catch (Exception e) {

					}
				}
			}

		}

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (tab[i][j].equals("inf")) {
					tab[i][j] = "inf";
				} else {
					tab[i][j] = Integer.toString(tabb[i][j]);
				}
			}
		}

	}

	public static boolean optimum(String[][] tab) {
		int c = 0;

		boolean verif1 = false, verif2 = false, verif = false;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (tab[i][j].equals("ze")) {
					c = c + 1;
				}
			}

		}
		if (c == tab.length) {
			return verif1 = true;
		}
		return false;
		//c = 0;
		//for (int i = 0; i < tab.length; i++) {
		//for (int j = 0; j < tab.length; j++) {
		//	if (tab[j][i].equals("ze")) {
		//		c = c + 1;
		//	}
		//}
		//}

		//if (c == tab.length) {
		//verif2 = true;
		//}
		//if ((verif1 == true) && (verif2 = true)) {
		//verif = true;
		//}
		//return verif;
	}

	//public static void principal(String[][] tab) {
		//String[][] tabb;
		//String[] tabv;
		//tabb = coupling(tab);
		//int lwst = 0;
		//System.out.println("");
		// toString(tabb);
		//tabv = sous_matrice_dadjonction(tabb);
		//lwst = lowest(tabv);
		//improvement(tab, lwst);

	//}

	public static int greatestValue(String[][] tab) {
		int lwst = 0;
		try {
			lwst = Integer.parseInt(tab[0][0]);
		} catch (Exception e) {

		}
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				try {
					if (lwst <= Integer.parseInt(tab[i][j])) {
						lwst = Integer.parseInt(tab[i][j]);
					}
				} catch (Exception e) {

				}
			}
		}
		return lwst;
	}


}
