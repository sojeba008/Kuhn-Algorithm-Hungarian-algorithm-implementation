
public class test {

	public static void main(String[] args) {
		int size=0;
		String[][] tab ={{"17","15","9","5","12"},{"16","16","10","5","10"},{"12","15","14","11","5"},{"4","8","14","17","13"},{"13","9","8","12","17"}};
		//String[][] tab ={{"1","0","4","5","3"},{"0","inf","inf","6","0"},{"0","2","0","3","inf"},{"4","0","inf","8","7"},{"inf","1","4","0","3"}};
		//String[][] tab ={{"17","15","5","551","12","5"},{"16","16","104","58","4","5"},{"12","15","14","0","5","5"},{"4","85","14","17","13","5"},{"13","99455","14","12","17","5"},{"13","9","8","12","17","5"}};
		//String[][] tab ={{"9","12","9","6","9","6","9","10"},
		//					{"7","8","5","4","3","8","15","5","5"},
		//			{"6","3","16","18","3","19","6","8"},
		//				{"6","1","17","6","5","11","7","9"},
		//				{"5","0","13","4","5","6","1","2"},
		//				{"12","13","4","12","3","1","12","14"},
		//				{"3","12","3","7","13","6","8","3"},
		//				{"13","4","1","5","5","5","4","9"},
		//				};
		//String[][] tab ={{"11","0","4"},
			//	{"7","39","23","0"},
				//{"0","7","0"},};
//		String[][] tab ={{"2","0","9","0","4"},
		//				{"13","12","7","0","7"},
		//	{"5","8","7","0","1"},
		//		{"6","13","4","4","0"},
		//		{"0","5","0","2","6"},
		//		};
		
	//	String[][] tab ={{"13","16","12","11"},
		//			{"15","inf","13","20"},
		//	{"5","7","10","6"}
		//	};
	//String[][] tab ={{"inf","8","7"},
		//				{"7","6","4"},
			//{"0","0","0"}
				//};
		//System.out.println(tab[1].length);
		Hongrois hongrois=new Hongrois(tab.length, tab);
		size=tab.length;
		String[][] original = new String[size][tab[0].length];
		

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				original[i][j] = tab[i][j];
			}
		}
		
		Hongrois.optimization(tab);
		Hongrois.toString(tab);
		System.out.println("");

		Hongrois.toString(Hongrois.coupling(tab));

		Boolean estoptimum = false;
		while (!estoptimum) {
		
			tab=Hongrois.coupling(tab);
			if (Hongrois.optimum((tab)) == false) {
				tab=Hongrois.process(tab);
				
				
			} else {
				estoptimum=true;
				break;
			}
			
		}
		System.out.println("Optimum Matrix is: ");
		Hongrois.toString(tab);
		
		

		int affectation = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (hongrois.coupling(tab)[i][j].equals("ze")) {
					try {
						affectation = affectation + Integer.parseInt(original[i][j]);
					} catch (Exception e) {

					}
				}
			}
		}

		System.out.println("The value of the minimum assignement is : : " + affectation);
		
		
		
		hongrois.toString(original);
		
		
		int pgd = Hongrois.greatestValue(original);
		//System.out.println(pgd);
		String[][] original2 = new String[tab.length][tab.length];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				try {
					original2[i][j] = Integer.toString((pgd - Integer.parseInt(original[i][j])));

				} catch (Exception e) {
					if (original[i][j].equals("inf")) {
						original2[i][j] = "inf";
					}
				}
			}
		}
		
		hongrois.toString(original2);
		
		
		
		tab=original2;

		Hongrois.optimization(tab);
		Hongrois.toString(tab);
		
		System.out.println("");

		Hongrois.toString(Hongrois.coupling(tab));

		estoptimum = false;
		while (!estoptimum) {
			if (Hongrois.optimum(Hongrois.coupling(tab)) == false) {
				tab=Hongrois.coupling(tab);
				Hongrois.process(tab);
			} else {
				estoptimum=true;
				break;
			}
		}
		System.out.println("Optimum Matrix is:  ");
		Hongrois.toString(tab);
		
		

	     affectation = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (Hongrois.coupling(tab)[i][j].equals("ze")) {
					try {
						affectation = affectation + Integer.parseInt(original[i][j]);
					} catch (Exception e) {

					}
				}
			}
		}

		System.out.println("The value of the maximum assignement is : " + affectation);
		
		
		
		
		
		
		
		
	}

}
