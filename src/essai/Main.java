package essai;

import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Etudiant, String> takeName = (e)->{return e.getNom();};
		Function<String,Character> takeChar =(s)->{return s.charAt(0);};
		Etudiant a = new Etudiant("sari");
		System.out.println(takeChar.apply(takeName.apply(a)));	
	}

}
