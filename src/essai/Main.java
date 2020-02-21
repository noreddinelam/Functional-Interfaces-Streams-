package essai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		///-> STREAMS :
		System.out.println("\nSTREAMS :\n");
		List<Personne> listP = Arrays.asList(
				new Personne(1.80, 70, "A", "Nicolas", Couleur.BLEU),
				new Personne(1.56, 50, "B", "Nicole", Couleur.VERRON),
				new Personne(1.75, 65, "C", "Germain", Couleur.VERT),
				new Personne(1.68, 50, "D", "Michel", Couleur.ROUGE),
				new Personne(1.96, 65, "E", "Cyrille", Couleur.BLEU),
				new Personne(2.10, 120, "F", "Denis", Couleur.ROUGE),
				new Personne(1.90, 90, "G", "Olivier", Couleur.VERRON)
		);	
		///-> Parcourt :
		Stream<Personne> stream = listP.stream();
		Consumer<Personne> consumer = (p)->{System.out.println(p);};
		stream.forEach(consumer);
		
		///-> Make Generator :
		UnaryOperator<Integer> unaryOperator = (i) -> {return i+1;};
		Stream.iterate(1, unaryOperator).limit(4).forEach(System.out::println);
		
		///-> Filtrage :
		System.out.println("\nFILTRAGE :");
		Stream<Personne> stream2 = listP.stream();
		Predicate<Personne> predicate2 = (p)->{return (p.getPoids() > 50);};
		stream2.filter(predicate2).forEach(System.out::println);
		
		///-> Avoir les champs qui nous interessent :
		System.out.println("\nMAPPING :");
		Stream<Personne> stream3 = listP.stream();
		Function<Personne, Double> fnc = (p)->{return p.getTaille();};
		stream3.map(fnc).forEach(System.out::println);
		
		///-> Collect element of Stream in a list :
		System.out.println("\nCollecting :");
		Stream<Personne> stream4 = listP.stream();
		Function<Personne, Double> fnc2 = (p)->{return p.getPoids();};
		List<Double> list = stream4.map(fnc2).collect(Collectors.toList());
		System.out.println(list);
		
		///-> Collect element in Collection (EX : HashSet) :
		System.out.println("\nCollection :");
		Stream<Personne> stream5 = listP.stream();
		Function<Personne, String> fnc3 = (p)->{return p.getPrenom();};
		Supplier<HashSet<String>> supplier2 = ()->{return new HashSet<>();};
		HashSet<String> hashSet = stream5.map(fnc3).collect(Collectors.toCollection(supplier2));
		System.out.println(hashSet);
		
		///-> Avoir un resultat unique (EX : la somme des poids )
		System.out.println("\nReducing :");
		Stream<Personne> stream6 = listP.stream();
		Function<Personne, Double> function = (p) -> {return p.getPoids();};
		BinaryOperator<Double> binaryOperator = (x,y)-> {return x+y;};
		System.out.println(stream6.map(function).reduce(binaryOperator));
		
		///-> lecture d'un fichier avec les stream :
	}

}
