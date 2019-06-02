package Project.Animale;

import Project.Superclasa.Animal;
import Project.Service.WritingService;
import java.io.*;
import java.util.*;

public class Fish extends Animal implements BoughtAnimal, AdoptedAnimal {

    private static int nr_adopted_fish  ;
    private static int nr_bought_fish;

    public Fish() {
        super("fish");
    }

    public Fish(String breed, String sex, String color, String availability, Double price) {
        super(breed, sex, color, "fish", availability, price);
    }

    public void buy(Animal animal){
        Fish.setNr_bought_fish(Fish.getNr_bought_fish()-1);;
        animal.buyanimal(getNr_animals_bought());
        animal.setAvailability("bought");
    }

    public void newstock(Animal animal,String path){
        Fish.setNr_bought_fish(Fish.getNr_bought_fish()+1);;
        animal.setType("fish");
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
        Fish.setNr_adopted_fish(Fish.getNr_adopted_fish()-1);
        animal.adoptanimal(getNr_animals_adopted());
        animal.setAvailability("adopted");
    }

    public void newanimal(Animal animal,String path){
        Fish.setNr_adopted_fish(Fish.getNr_adopted_fish()-1);
        animal.setType("fish");
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


    public static int getNr_adopted_fish() {
        return nr_adopted_fish;
    }

    public static void setNr_adopted_fish(int nr_adopted_fish) {
        Fish.nr_adopted_fish = nr_adopted_fish;
    }

    public static int getNr_bought_fish() {
        return nr_bought_fish;
    }

    public static void setNr_bought_fish(int nr_bought_fish) {
        Fish.nr_bought_fish = nr_bought_fish;
    }
}
