package essai;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Etudiant, String> takeName = (e)->{return e.getNom();};
		Etudiant a = new Etudiant("sari");
		System.out.println(takeName.apply(a));
		
		
	}

}
