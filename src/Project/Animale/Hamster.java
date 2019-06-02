package Project.Animale;

import Project.Service.WritingService;
import Project.Superclasa.Animal;

import java.util.ArrayList;
import java.util.List;

public class Hamster extends Animal implements BoughtAnimal, AdoptedAnimal {

    private static int nr_adopted_hamster ;
    private static int nr_bought_hamster ;

    public Hamster() {
        super("hamster");
    }

    public Hamster(String breed, String sex, String color, String availability, Double price) {
        super(breed, sex, color, "hamster", availability, price);
    }

    public void buy(Animal animal){
        Hamster.setNr_bought_hamster(Hamster.getNr_bought_hamster()-1);
        animal.buyanimal(getNr_animals_bought());
        animal.setAvailability("bought");
    }

    public void newstock(Animal animal,String path){
        Hamster.setNr_bought_hamster(Hamster.getNr_bought_hamster()+1);
        animal.setType("hamster");;
        animal.addanimal(getNr_animals_bought());
        animal.setAvailability("available");
        WritingService writingService = new WritingService(path);
        List<String> line = new ArrayList<>();
        line.add(animal.getType());
        line.add(animal.getBreed());
        line.add(animal.getColor());
        line.add(animal.getPrice().toString());
        line.add(animal.getSex());
        line.add(animal.getAvailability());
        writingService.write(line);
    }

    public void adopt(Animal animal){
        Hamster.setNr_adopted_hamster(Hamster.getNr_adopted_hamster()-1);
        animal.adoptanimal(getNr_animals_adopted());
        animal.setAvailability("adopted");
    }

    public void newanimal(Animal animal,String path){
        Hamster.setNr_adopted_hamster(Hamster.getNr_adopted_hamster()+1);
        animal.setType("hamster");
        animal.addanimaladopt(getNr_animals_adopted());
        animal.setAvailability("available");
        WritingService writingService = new WritingService(path);
        List<String> line = new ArrayList<>();
        line.add(animal.getType());
        line.add(animal.getBreed());
        line.add(animal.getColor());
        line.add(animal.getPrice().toString());
        line.add(animal.getSex());
        line.add(animal.getAvailability());
        writingService.write(line);
    }


    public static int getNr_adopted_hamster() {
        return nr_adopted_hamster;
    }

    public static void setNr_adopted_hamster(int nr_adopted_hamster) {
        Hamster.nr_adopted_hamster = nr_adopted_hamster;
    }

    public static int getNr_bought_hamster() {
        return nr_bought_hamster;
    }

    public static void setNr_bought_hamster(int nr_bought_hamster) {
        Hamster.nr_bought_hamster = nr_bought_hamster;
    }
}
