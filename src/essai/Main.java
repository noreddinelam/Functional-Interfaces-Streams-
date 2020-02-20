package essai;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		
		Function<Etudiant, String> takeName = (e)->{return e.getNom();};
		Function<String,Character> takeChar =(s)->{return s.charAt(0);};
		Etudiant a = new Etudiant("sari");
		System.out.println(takeChar.apply(takeName.apply(a)));
		
		////////////////////////////////////////////////////////////////
		Consumer<Etudiant> changeName = (e)->{e.nom = "pichou";};
		changeName.accept(a);
		System.out.println("NOM CHANGE :" + a.nom);
		
		////////////////////////////////////////////////////////////////
		Predicate<Etudiant> predicate = (e)->{return e.nom.equals("sari");};
		System.out.println(predicate.test(a));
		
		////////////////////////////////////////////////////////////////
		Supplier<Etudiant> supplier = ()->{return new Etudiant("imed cherryPick");};
		System.out.println(supplier.get().nom);
	}

}
