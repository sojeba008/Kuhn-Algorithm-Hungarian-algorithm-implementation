
public class test {

	public static void main(String[] args) {
		int size=5;
		//String[][] tab ={{"17","15","9","5","12"},{"16","16","10","5","10"},{"12","15","14","11","5"},{"4","8","14","17","13"},{"13","9","8","12","17"}};
		//String[][] tab ={{"1","0","4","5","3"},{"0","inf","inf","6","0"},{"0","2","0","3","inf"},{"4","0","inf","8","7"},{"inf","1","4","0","3"}};
		String[][] tab ={{"17","15","5","551","12"},{"16","16","104","58","4"},{"12","15","14","0","5"},{"4","85","14","17","13"},{"13","99455","14","12","17"}};
		Hongrois hongrois=new Hongrois(5, tab);
		String[][] original = new String[size][size];
		

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				original[i][j] = tab[i][j];
			}
		}
		
		Hongrois.optimization(tab);
		Hongrois.toString(tab);
		System.out.println("");

		Hongrois.toString(Hongrois.coupling(tab));

		Boolean estoptimum = false;
		while (!estoptimum) {
			if (Hongrois.optimum(Hongrois.coupling(tab)) == false) {
				Hongrois.process(tab);
			} else {
				estoptimum=true;
			}
		}
		System.out.println("Optimum Matrix is: ");
		Hongrois.toString(tab);
		
		

		int affectation = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
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
		System.out.println(pgd);
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
		
		hongrois.toString(original2);
		
		
		
		tab=original2;

		Hongrois.optimization(tab);
		Hongrois.toString(tab);
		
		System.out.println("");

		Hongrois.toString(Hongrois.coupling(tab));

		estoptimum = false;
		while (!estoptimum) {
			if (Hongrois.optimum(Hongrois.coupling(tab)) == false) {
				Hongrois.process(tab);
			} else {
				estoptimum=true;
			}
		}
		System.out.println("Optimum Matrix is:  ");
		Hongrois.toString(tab);
		
		

	     affectation = 0;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
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
