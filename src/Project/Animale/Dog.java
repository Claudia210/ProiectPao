package Project.Animale;

import Project.Superclasa.Animal;
import Project.Service.WritingService;
import java.io.*;
import java.util.*;

public class Dog extends Animal implements BoughtAnimal, AdoptedAnimal {

    private static int nr_adopted_dog ;
    private static int nr_bought_dog ;

    public Dog() {
        super("dog");
    }

    public Dog(String breed, String sex, String color, String availability, Double price) {
        super(breed, sex, color, "dog", availability, price);
    }

    public void buy(Animal animal){
        Dog.setNr_bought_dog(Dog.getNr_bought_dog()-1);
        animal.buyanimal(getNr_animals_bought());
        animal.setAvailability("bought");
    }

    public void newstock(Animal animal,String path){
        Dog.setNr_bought_dog(Dog.getNr_bought_dog()+1);
        animal.setType("dog");
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
        Dog.setNr_adopted_dog(Dog.getNr_adopted_dog()-1);
        animal.adoptanimal(getNr_animals_adopted());
        animal.setAvailability("adopted");
    }

    public void newanimal(Animal animal,String path){
        Dog.setNr_adopted_dog(Dog.getNr_adopted_dog()+1);
        animal.setType("dog");
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


    public static int getNr_adopted_dog() {
        return nr_adopted_dog;
    }

    public static void setNr_adopted_dog(int nr_adopted_dog) {
        Dog.nr_adopted_dog = nr_adopted_dog;
    }

    public static int getNr_bought_dog() {
        return nr_bought_dog;
    }

    public static void setNr_bought_dog(int nr_bought_dog) {
        Dog.nr_bought_dog = nr_bought_dog;
    }
}
