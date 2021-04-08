package AnimalKingdomApp;

import java.util.ArrayList;

public class Main {
    public static ArrayList<animals> filteredList = new ArrayList<animals>();
    public static void main (String[] args){
        homework();
        
    }

    public static void filter(ArrayList<animals> list, tester testing) {
		filteredList.clear();
		for (animals a : list) {
			if (testing.test(a)) {
				filteredList.add(a);
			}
		}
	}

    private static void homework(){
        ArrayList<animals> animalList = new ArrayList<>();
		animalList.add(new mammals("Panda", 1869));
		animalList.add(new mammals("Zebra", 1778));
		animalList.add(new mammals("Koala", 1816));
		animalList.add(new mammals("Sloth", 1804));
		animalList.add(new mammals("Armadillo", 1758));
		animalList.add(new mammals("Raccoon", 1758));
		animalList.add(new mammals("Bigfoot", 2021));

		animalList.add(new birds("Pigeon", 1837));
        animalList.add(new birds("Peacock", 1821));
        animalList.add(new birds("Toucan", 1758));
        animalList.add(new birds("Parrot", 1824));
        animalList.add(new birds("Swan", 1758));

        animalList.add(new fish("Salmon", 1758));
        animalList.add(new fish("Catfish", 1817));
        animalList.add(new fish("Perch", 1758));
	
		System.out.println("\n***List all the animals in descending order by year named***\n");
		animalList.sort((a1, a2) -> a2.getYear() - a1.getYear());
		animalList.forEach(animal -> System.out.println(animal));

		System.out.println("\n*** List all the animals alphabetically ***\n");
		animalList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        animalList.forEach(animal -> System.out.println(animal));

		System.out.println("\n*** List all the animals order by how they move ***\n");
		animalList.sort((a1, a2) -> a1.move().compareToIgnoreCase(a2.move()));
        animalList.forEach(animal -> System.out.println(animal));

		System.out.println("\n*** List only those animals the breath with lungs ***\n");
		filter(animalList, animal -> animal.breath().equalsIgnoreCase("lungs"));
        filteredList.forEach(animal -> System.out.println(animal.getName() + " " + animal.reproduce() + " " + animal.move() + " " + animal.breath() + " " + animal.year));

		System.out.println("\n*** List only those animals that breath with lungs and were named in 1758 ***\n");
        filter(animalList, animal -> animal.breath().equalsIgnoreCase("lungs") && animal.getYear() == 1758);
        filteredList.forEach(animal -> System.out.println(animal.getName() + " " + animal.reproduce() + " " + animal.move() + " " + animal.breath() + " " + animal.year));

		System.out.println("\n*** List only those animals that lay eggs and breath with lungs ***\n");
        filter(animalList, animal -> animal.breath().equalsIgnoreCase("lungs") && animal.reproduce().equalsIgnoreCase("eggs"));
        filteredList.forEach(animal -> System.out.println(animal.getName() + " " + animal.reproduce() + " " + animal.move() + " " + animal.breath() + " " + animal.year));

		System.out.println("\n*** List alphabetically only those animals that were named in 1758 ***\n");
		filter(animalList, animal -> animal.getYear() == 1758);
        filteredList.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()));
        filteredList.forEach(animal -> System.out.println(animal.getName() + " " + animal.reproduce() + " " + animal.move() + " " + animal.breath() + " " + animal.year));
    }
}
