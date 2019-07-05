
import java.util.Scanner;

public class Algo_hongrois {
	static Scanner sc = new Scanner(System.in);
	public static int[] la;
	public static int[] ln;
	public static int[] c;
	public static int a;
	public static int b;
	public static int C;

	public static void afficher(String[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				System.out.print("  " + tab[i][j]);
			}
			System.out.println("");
		}
	}

	public static int pluspetit(String[] tab) {

		int ppt = 0, temp = ppt;
		try {
			if ((tab[0] != "0") && (tab[0] != "0.0")) {
				ppt = (int) Integer.parseInt(tab[0]);
			}
		} catch (Exception e) {
			if (tab[0] == "inf") {
				ppt = 10000000;
			}
		}
		for (int i = 0; i < tab.length; i++) {
			try {
				temp = Integer.parseInt(tab[i]);
			} catch (Exception e) {

			}
			if ((ppt >= temp)) {

				ppt = (int) temp;

			}
		}

		temp = 0;
		return ppt;
	}

	public static String[][] couplage(String[][] tab) {
		String[][] tabl = new String[tab.length][tab.length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				tabl[i][j] = tab[i][j];
			}
		}

		boolean dejatrouve = false;

		for (int i = 0; i < tabl.length; i++) {

			for (int j = 0; j < tabl.length; j++) {

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

					dejatrouve = true;
				}

				if (((tabl[i][j] == "0")) && dejatrouve == true) {
					tabl[i][j] = "zb";

					dejatrouve = true;
				}

			}
			dejatrouve = false;
		}

		return tabl;
	}

	public static String[] sous_matrice_dadjonction(String[][] tabb) {
		int compteur = 0, temp = 0;

		boolean trouver = false;
		int[] lncpdze = new int[tabb.length];
		int[] cazb = new int[tabb.length];
		int[] lazedcm = new int[tabb.length];
		for (int i = 0; i < tabb.length; i++) {
			for (int j = 0; j < tabb.length; j++) {
				if (tabb[i][j] == "ze") {
					temp = temp + 1;
				}
			}
			if (temp == 0) {
				lncpdze[compteur] = i;
				compteur = compteur + 1;
			}
			temp = 0;
		}

		ln = lncpdze;

		temp = 0;
		int tt = compteur;
		a = tt;
		compteur = 0;
		int lig = 0;
		for (int i = 0; i < tabb.length; i++) {
			for (int j = 0; j < tabb.length; j++) {
				if (tabb[i][j] == "zb") {
					temp = temp + 1;
					lig = i;

					// System.out.println(i +" et " +j +" et "+lig);
					if (temp != 0) {
						for (int k = 0; k < tt; k++) {
							if (lig == lncpdze[k]) {
								trouver = true;
								if (trouver == true) {
									cazb[compteur] = j;
									compteur = compteur + 1;
								}
							}
						}

					}
				}
				temp = 0;
			}

		}

		c = cazb; // t

		int t = compteur - 1;
		b = t;
		temp = 0;
		compteur = 0;
		int col = 0;
		trouver = false;

		for (int i = 0; i < tabb.length; i++) {
			for (int j = 0; j < tabb.length; j++) {
				if (tabb[i][j] == "ze") {
					temp = temp + 1;
					col = j;
				}
			}
			if (temp != 0) {
				for (int k = 0; k <= t; k++) {
					if (col == cazb[k]) {
						trouver = true;
						// System.out.println(col);
					}
				}
				if (trouver == true) {
					lazedcm[compteur] = i;
					compteur = compteur + 1;
				}
			}
			temp = 0;
			trouver = false;
		}

		la = lazedcm; // compteur
		C = compteur;
		for (int i = 0; i < compteur; i++) {
			// System.out.println(la[i]);
		}

		int s = 0, ss = 0;

		boolean verif = false, verif2 = false;

		int[] ligne = new int[tabb.length * tabb.length];
		for (int i = 0; i <= tt; i++) {
			try {
				ligne[s] = lncpdze[i];
				// System.out.println(ligne[s]);
				s = s + 1;
			} catch (Exception e) {

			}
		}

		for (int i = 0; i <= compteur; i++) {
			ligne[s] = lazedcm[i];

			s = s + 1;
		}

		String[] tabbb = new String[25];
		for (int i = 0; i < tabb.length; i++) {
			for (int j = 0; j <= tt; j++) {
				if ((i == ligne[j])) {
					verif = true;

				}

			}
			if (verif == true) {
				for (int k = 0; k < tabb.length; k++) {
					for (int j = 0; j <= t; j++) {
						if ((i == cazb[j])) {
							verif2 = true;
						}
					}
					if (verif2 = true) {
						tabbb[ss] = tabb[i][k];
					}

					ss = ss + 1;
				}
			}
			verif = false;
			verif2 = false;
		}

		// A enlever
		for (int k = 0; k < tabb.length * tabb.length; k++) {
			// System.out.println(c[k]);
		}
		return tabbb;
		// System.out.println(pluspetit(tabbb));

	}

	public static void amelioration(String[][] tab, int ppt) {
		boolean verif = true;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
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
							tab[i][j] = Integer.toString(Integer.parseInt((tab[i][j])) - ppt);
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
							tab[j][i] = Integer.toString(Integer.parseInt((tab[j][i])) + ppt);
						} catch (Exception e) {

						}
					}
					verif2 = true;
				}
			}

			verif = false;
		}
		// afficher(tab);
	}

	public static int pluspetitd(int[] vecti) {

		int ppt = 0, temp = ppt;

		ppt = vecti[0];

		for (int i = 0; i < vecti.length; i++) {

			if ((ppt >= vecti[i])) {

				ppt = vecti[i];

			}
		}
		return ppt;
	}

	public static void optimisation(String[][] tab) {
		int[] vect = new int[tab.length];
		int[][] tabb = new int[tab.length][tab.length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				try {
					tabb[i][j] = Integer.parseInt(tab[i][j]);
				} catch (Exception e) {
					tabb[i][j] = 1000000000;
				}
			}
		}

		int ppt = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				vect[j] = (tabb[i][j]);
			}
			ppt = pluspetitd(vect);

			if (ppt != 0) {
				for (int j = 0; j < tab.length; j++) {
					try {
						tabb[i][j] = tabb[i][j] - ppt;
					} catch (Exception e) {

					}
				}
			}

		}

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				vect[j] = (tabb[j][i]);
			}
			ppt = pluspetitd(vect);
			// System.out.println(ppt);

			if (ppt != 0) {
				for (int j = 0; j < tab.length; j++) {
					try {
						tabb[j][i] = tabb[j][i] - ppt;
					} catch (Exception e) {

					}
				}
			}

		}

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
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
			for (int j = 0; j < tab.length; j++) {
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

	public static void principal(String[][] tab) {
		String[][] tabb;
		String[] tabv;
		tabb = couplage(tab);
		int ppt = 0;
		System.out.println("");
		// afficher(tabb);
		tabv = sous_matrice_dadjonction(tabb);
		ppt = pluspetit(tabv);
		amelioration(tab, ppt);

	}

	public static int plusgrandtm(String[][] tab) {
		int ppt = 0;
		try {
			ppt = Integer.parseInt(tab[0][0]);
		} catch (Exception e) {

		}
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				try {
					if (ppt <= Integer.parseInt(tab[i][j])) {
						ppt = Integer.parseInt(tab[i][j]);
					}
				} catch (Exception e) {

				}
			}
		}
		return ppt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		String[][] tab ={{"1","0","4","5","3"},{"0","inf","inf","6","0"},{"0","2","0","3","inf"},{"4","0","inf","8","7"},{"inf","1","4","0","3"}};
		String[][] tab ={{"17","15","9","5","12"},{"16","16","10","5","10"},{"12","15","14","11","5"},{"4","8","14","14","13"},{"13","9","8","12","17"}};
		//String[][] tab = { { "7", "3", "5", "7", "10" }, { "6", "inf", "inf", "8", "7" }, { "6", "5", "1", "5", "inf" },{ "11", "4", "inf", "11", "15" }, { "inf", "4", "5", "2", "10" } };
	      //String[][] tab ={{"17","15","9","5","12"},{"16","16","10","5","10"},{"12","15","14","11","5"},{"4","8","14","17","13"},{"13","9","8","12","17"}};
		// String[][] tab ={{"13","16","12","11"},{"15","inf","13","20"},{"5","7","10","6"},{"0","0","0","0"}};
		// String[][] tab ={{"7","3","5","7","10"},{"6","inf","inf","8","7"},{"6","5","1","5","inf"},{"11","4","inf","11","15"},{"inf","4","5","2","10"}};
		
		 System.out.print("Entrer l'ordre de la matrice:");
		 int n=sc.nextInt(); 
		 sc.nextLine();
		 String[][] tabb = new String[tab.length][tab.length];

			String[] tabv = new String[25];
			String[][] original = new String[tab.length][tab.length];
	   // String[][]  tab=new String[n][n];
		 //for(int i=0;i<n;i++){ 
		 //for(int j=0;j<n;j++){
		 //System.out.print("M["+i+"]["+j+"]="); 
		 //tab[i][j]=sc.next(); 
		   //  } 
		//}
		 
		

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				original[i][j] = tab[i][j];
			}
		}

		optimisation(tab);
		afficher(tab);
		
		System.out.println("");

		afficher(couplage(tab));

		Boolean estoptimum = false;
		while (!estoptimum) {
			if (optimum(couplage(tab)) == false) {
				principal(tab);
			} else {
				estoptimum=true;
			}
		}
		System.out.println("Voici le tableau obtenu à l'optimum(affectation minimale) : ");
		afficher(tab);
		
		
      

		int affectation_minimale = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (couplage(tab)[i][j].equals("ze")) {
					try {
						affectation_minimale = affectation_minimale + Integer.parseInt(original[i][j]);
					} catch (Exception e) {

					}
				}
			}
		}

		System.out.println("La valeur de l'affectation minimale est : " + affectation_minimale);
		int pgd = plusgrandtm(original);
		String[][] original2 = new String[tab.length][tab.length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				try {
					original2[i][j] = Integer.toString((pgd - Integer.parseInt(original[i][j])));

				} catch (Exception e) {
					if (original[i][j].equals("inf")) {
						original2[i][j] = "inf";
					}
				}
			}
		}
		
		afficher(original2);
		
		estoptimum=false;
		optimisation(original2);
		// afficher(couplage(original2));
		System.out.println("");
 	
		
		
		
        
       
		
	}

}
