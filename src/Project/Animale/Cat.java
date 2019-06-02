package Project.Animale;
import Project.Service.WritingService;
import Project.Superclasa.Animal;

import java.io.*;
import java.util.*;

public class Cat extends Animal implements BoughtAnimal, AdoptedAnimal {

    private static int nr_adopted_cat  ;
    private static int nr_bought_cat ;

    public Cat() {
        super("cat");
    }

    public Cat(String breed, String sex, String color, String availability, Double price) {
        super(breed, sex, color, "cat", availability, price);
    }

    public void buy(Animal animal){
        Cat.setNr_bought_cat(getNr_bought_cat()-1);
        animal.buyanimal(getNr_animals_bought());
        animal.setAvailability("bought");
    }

    public void newstock(Animal animal,String path){
        Cat.setNr_bought_cat(getNr_bought_cat()+1);
        animal.setType("cat");
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
        Cat.setNr_adopted_cat(getNr_adopted_cat()-1);
        animal.adoptanimal(getNr_animals_adopted());
        animal.setAvailability("adopted");
    }

    public void newanimal(Animal animal,String path){
        Cat.setNr_adopted_cat(getNr_adopted_cat()-1);
        animal.setType("cat");
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


    public static int getNr_adopted_cat() {
        return nr_adopted_cat;
    }

    public static void setNr_adopted_cat(int nr_adopted_cat) {
        Cat.nr_adopted_cat = nr_adopted_cat ;
    }

    public static int getNr_bought_cat() {
        return nr_bought_cat;
    }

    public static void setNr_bought_cat(int nr_bought_cat) {
        Cat.nr_bought_cat = nr_bought_cat;
    }
}
