package Project;

import Project.Animale.Cat;
import Project.Animale.Dog;
import Project.Animale.Fish;
import Project.Animale.Hamster;
import Project.Persoana.Client;
import Project.Persoana.Employee;
import Project.Service.ReadingService;
import Project.Service.WritingService;
import Project.Service.AuditService;
import Project.Superclasa.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Optiunile pentru cele 3 meniuri- meniu principal,meniu pentru clienti si meniu pentru angajati
        int option1,option2,option3;
        Scanner scanner = new Scanner(System.in);
        //Doua liste una pentru animalele adoptate si una pentru animalele din petshop pe care le voi folosii pentru afisare
        List<Animal> animalepetshop = new ArrayList<Animal>();
        List<Animal> animaleadoptie = new ArrayList<Animal>();
        //Am folosit un HashMap pentru clienti, iar cheia reprezinta numarul de inregistrare al clientului
        Map<Integer,Client> clients = new HashMap<Integer,Client>() ;
        AuditService auditService = new AuditService();
//Adaug in cele doua liste animalele deja inregistrate in fisier
        BufferedReader br = null;
        ReadingService readingService = new ReadingService("animale_petshop.csv", br);
        List<String> date = readingService.read(readingService.getBr());
        while (date != null) {
            Animal apetshop = new Animal();
            apetshop.setType(date.get(0));
            if(apetshop.getType().equals("cat")) {
                Cat ca = new Cat();
                ca.setNr_bought_cat(ca.getNr_bought_cat()+1);
            }
            if(apetshop.getType().equals("dog")){
                Dog doga = new Dog();
                doga.setNr_bought_dog(doga.getNr_bought_dog()+1);
            }
            if(apetshop.getType().equals("fish")){
                Fish fi = new Fish();
                fi.setNr_bought_fish(fi.getNr_bought_fish()+1);
            }
            if(apetshop.getType().equals("hamster")){
                Hamster ham = new Hamster();
                ham.setNr_bought_hamster(ham.getNr_bought_hamster()+1);
            }
            apetshop.setBreed(date.get(1));
            apetshop.setSex(date.get(2));
            apetshop.setPrice(Double.valueOf(date.get(3)));
            apetshop.setColor(date.get(4));
            apetshop.setAvailability(date.get(5));
            apetshop.setNr_animals_bought(apetshop.getNr_animals_bought()+1);
            animalepetshop.add(apetshop);
            date = readingService.read(readingService.getBr());
        }
        BufferedReader br1 = null;
        ReadingService readingService1 = new ReadingService("animale_adoptie.csv",br1);
        List<String> date1 = readingService1.read(readingService1.getBr());
        while (date1 != null) {
            Animal aadoptie = new Animal();
            aadoptie.setType(date1.get(0));
            if(aadoptie.getType().equals("cat")) {
                Cat ca = new Cat();
                ca.setNr_adopted_cat(ca.getNr_adopted_cat()+1);
            }
            if(aadoptie.getType().equals("dog")){
                Dog doga = new Dog();
                doga.setNr_adopted_dog(doga.getNr_adopted_dog()+1);
            }
            if(aadoptie.getType().equals("fish")){
                Fish fi = new Fish();
                fi.setNr_adopted_fish(fi.getNr_adopted_fish()+1);
            }
            if(aadoptie.getType().equals("hamster")){
                Hamster ham = new Hamster();
                ham.setNr_adopted_hamster(ham.getNr_adopted_hamster()+1);
            }
            aadoptie.setBreed(date1.get(1));
            aadoptie.setSex(date1.get(2));
            aadoptie.setPrice(Double.valueOf(date1.get(3)));
            aadoptie.setColor(date1.get(4));
            aadoptie.setAvailability(date1.get(5));
            aadoptie.setNr_animals_adopted(aadoptie.getNr_animals_adopted()+1);
            animaleadoptie.add(aadoptie);
            date1 = readingService1.read(readingService1.getBr());}

        do {
            System.out.println("1.Client!\n" +
                    "2.Angajat!\n"+
                    "Alege optiunea:");
            option1 = scanner.nextInt();
            if (option1 == 1) {
                do {
                    System.out.println("1.Vezi animalele din petshop!\n" +
                            "2.Vezi animalele din centrul de adoptie!\n" +
                            "3.Inregistreaza-te!\n" +
                            "4.Cumapara un animal!\n" +
                            "5.Adopta un animal!\n"+
                            "Alege optiunea: ");
                    option2 = scanner.nextInt();
                    switch (option2) {
                        case 1:
                            Animal animal = new Animal();
                            System.out.println("Numarul de animale disponibile in petshop este "+ animal.getNr_animals_bought());
                            Cat cat = new Cat();
                            System.out.println("Numarul de pisici disponibile in petshop este: " + cat.getNr_bought_cat());
                            Dog dog = new Dog();
                            System.out.println("Numarul de catei disponibili in petshop este " + dog.getNr_bought_dog());
                            Hamster hamster = new Hamster();
                            System.out.println("Numarul de hamsteri disponibili in petshop este " + hamster.getNr_bought_hamster());
                            Fish fish = new Fish();
                            System.out.println("Numarul de pesti disponibili in petshop este " + fish.getNr_bought_fish());
                            for (Animal animal1 : animalepetshop)
                                System.out.println(animal1.getType()+" "+animal1.getBreed()+" "+animal1.getSex()+" "+animal1.getPrice()+" "+animal1.getColor()+" "+animal1.getAvailability()+"\n");
                            break;
                        case 2:
                            Animal animal4 = new Animal();
                            System.out.println("Numarul de animale disponibile in cenrtul de adoptie este "+ animal4.getNr_animals_adopted());
                            Cat cat3 = new Cat();
                            System.out.println("Numarul de pisici disponibile in centrul de adoptie este: " + cat3.getNr_adopted_cat());
                            Dog dog3 = new Dog();
                            System.out.println("Numarul de catei disponibili in centrul de adoptie este " + dog3.getNr_adopted_dog());
                            Hamster hamster3 = new Hamster();
                            System.out.println("Numarul de hamsteri disponibili in centrul de adoptie este " + hamster3.getNr_adopted_hamster());
                            Fish fish3 = new Fish();
                            System.out.println("Numarul de pesti disponibili in centrul de adoptie este " + fish3.getNr_adopted_fish());
                            for (Animal animal1 : animaleadoptie)
                                System.out.println(animal1+"\n");
                            break;
                        case 3:
                            String a = scanner.nextLine();
                            System.out.println("First Name :\n");
                            String first_name = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Last Name :");
                            String last_name = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Adress :");
                            String adress = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Phone Number :");
                            String phone_number = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("Mail :");
                            String mail = scanner.nextLine();
                            System.out.println("\n");
                            System.out.println("What animal do you wish :");
                            String animal_dorit = scanner.nextLine();
                            System.out.println("\n");
                            Client client = new Client(first_name , last_name, adress, phone_number, mail, animal_dorit);
                            client.setNr_clients(Client.getNr_clients()+1);
                            Integer nr_de_inregistrare = client.getNr_clients();
                            clients.put(nr_de_inregistrare,client);
                            //Adaug clientul nou inregistrat in fisierul csv
                            WritingService writingService = new WritingService("clienti_inregistarti.csv");
                            List<String> clienti = new ArrayList<>(Arrays.asList(first_name,last_name,adress,phone_number,mail,animal_dorit));
                            writingService.write(clienti);
                            break;
                        case 4:
                            String atype,abreed,asex,acolor;
                            Double aprice;
                            String b = scanner.nextLine();
                            System.out.println("What animal do you want to buy?\n"+
                                "Type: ");
                            atype = scanner.nextLine();
                            System.out.println("\nBreed: ");
                            abreed = scanner.nextLine();
                            System.out.println("\nSex: ");
                            asex = scanner.nextLine();
                            System.out.println("\nPrice: ");
                            aprice = scanner.nextDouble();
                            String g = scanner.nextLine();
                            System.out.println("\nColor: ");
                            acolor = scanner.nextLine();
                            //Dupa ce clientul isi alege animalul, animalul respectiv este sters din fisier
                            String lineToRemove = atype+","+abreed+","+asex+","+aprice.toString()+","+acolor+","+"available";
                            Animal animal2 = new Animal(abreed,asex,acolor,atype,"available",aprice);
                            animal2.removeAnimalfromfile("animale_petshop.csv",lineToRemove);
                            for (Animal animal1 : animalepetshop)
                                if(animal1 == animal2){
                                    if(atype.equals("cat")) {
                                        Cat cat1 = new Cat(abreed,asex,acolor,"available",aprice);
                                        cat1.buy(animal1);
                                        auditService.audit("buy");
                                    }
                                    if(atype.equals("dog")){
                                        Dog dog1 = new Dog(abreed,asex,acolor,"available",aprice);
                                        dog1.buy(animal1);
                                        auditService.audit("buy");
                                    }
                                    if(atype.equals("fish")){
                                        Fish fish1 = new Fish(abreed,asex,acolor,"available",aprice);
                                        fish1.buy(animal1);
                                        auditService.audit("buy");
                                    }
                                    if(atype.equals("hamster")){
                                        Hamster hamster1 = new Hamster(abreed,asex,acolor,"available",aprice);
                                        hamster1.buy(animal1);
                                        auditService.audit("buy");
                                    }

                                }
                            break;

                    case 5:
                        String a1type,a1breed,a1sex,a1color;
                        Double a1price;
                        String c = scanner.nextLine();
                        System.out.println("What animal do you want to adopt?\n"+
                                "Type: ");
                        a1type = scanner.next();
                        System.out.println("\nBreed: ");
                        a1breed = scanner.next();
                        System.out.println("\nSex: ");
                        a1sex = scanner.next();
                        System.out.println("\nColor: ");
                        a1color = scanner.next();
                        //La fel ca mai sus dupa alegere animalul adoptat va fii sters
                        a1price = 0.0;
                        //String lineToRemove1 = a1type+","+a1breed+","+a1sex+","+a1price.toString()+","+a1color+",available";
                        String lineToRemove1 ="cat,persian,feminin,0.0,alba,available";
                        Animal animal3 = new Animal(a1breed,a1sex,a1color,a1type,"available",a1price);
                        animal3.removeAnimalfromfile("animale_adoptie.csv",lineToRemove1);
                        for (Animal animal1 : animalepetshop)
                            if(animal1 == animal3){
                                if(a1type.equals("cat")) {
                                    Cat cat2 = new Cat(a1breed,a1sex,a1color,"available",a1price);
                                    cat2.adopt(animal1);
                                    auditService.audit("adopt");
                                }
                                if(a1type.equals("dog")){
                                    Dog dog2 = new Dog(a1breed,a1sex,a1color,"available",a1price);
                                    dog2.adopt(animal1);
                                    auditService.audit("adopt");
                                }
                                if(a1type.equals("fish")){
                                    Fish fish2 = new Fish(a1breed,a1sex,a1color,"available",a1price);
                                    fish2.adopt(animal1);
                                    auditService.audit("adopt");
                                }
                                if(a1type.equals("hamster")){
                                    Hamster hamster2 = new Hamster(a1breed,a1sex,a1color,"available",a1price);
                                    hamster2.adopt(animal1);
                                    auditService.audit("adopt");
                                }

                            }
                        break;
                    default:
                        System.out.println("Invalid option!");
                }


                }while (option2 < 6);
            } else {
                System.out.println("Inregistreaza-te!\n");
                Employee employee = new Employee();
                String d = scanner.nextLine();
                System.out.println("First name: ");
                String first_name = scanner.nextLine();
                System.out.println("Last name: ");
                String last_name = scanner.nextLine();
                System.out.println("Password: ");
                int password = scanner.nextInt();
                //Functia de inregistrare verifica daca angajatul a introdus parola corecta
                int inrg = employee.inregistrare(password);
                auditService.audit("inregistrare");
                //Toti angajatii inregistrati vor fii adaugati in fisierul angajatilor
                WritingService writingService = new WritingService("angajati_inregistarti.csv");
                List<String> angajati = new ArrayList<>(Arrays.asList(first_name,last_name));
                writingService.write(angajati);
                //Daca parola este gresita operatiunile sunt intrerupte
                if(inrg == 0)
                {
                    System.out.println("Parola gresita!");
                    break;
                }
                else
                {   System.out.println("V-ati inregistrat cu succes!");
                 do {
                     System.out.println("1.Adauga un nou animal in petshop!\n" +
                            "2.Adauga un nou animal in centrul de adoptii!\n"+
                             "Alege optiunea:");
                     option3 = scanner.nextInt();
                     switch (option3)
                     {//Anagajatul are optiunea de a adauga  noi animale in oricare dintre cele doua fisiere
                         case 1:
                             String atype,abreed,asex,acolor;
                             Double aprice;
                             System.out.println("What animal do you want to add?\n"+
                                     "Type: ");
                             String e = scanner.nextLine();
                             atype = scanner.nextLine();
                             System.out.println("\nBreed: ");
                             abreed = scanner.nextLine();
                             System.out.println("\nSex: ");
                             asex = scanner.nextLine();
                             System.out.println("\nPrice: ");
                             aprice = scanner.nextDouble();
                             String k = scanner.nextLine();
                             System.out.println("\nColor: ");
                             acolor = scanner.nextLine();
                             Animal animal1 = new Animal(abreed,asex,acolor,atype,"available",aprice);
                             if(atype.equals("cat")) {
                                         Cat cat1 = new Cat(abreed,asex,acolor,"available",aprice);
                                         cat1.newstock(animal1,"animale_petshop.csv");
                                     }
                             if(atype.equals("dog")){
                                         Dog dog1 = new Dog(abreed,asex,acolor,"available",aprice);
                                         dog1.newanimal(animal1,"animale_petshop.csv");
                                     }
                             if(atype.equals("fish")){
                                         Fish fish1 = new Fish(abreed,asex,acolor,"available",aprice);
                                         fish1.newstock(animal1,"animale_petshop.csv");
                                     }
                             if(atype.equals("hamster")){
                                         Hamster hamster1 = new Hamster(abreed,asex,acolor,"available",aprice);
                                         hamster1.newstock(animal1,"animale_petshop.csv");
                                     }
                             animalepetshop.add(animal1);
                             break;

                         case 2:
                             String type,breed,sex,color;
                             Double price;
                             System.out.println("What animal do you want to add?\n"+
                                     "Type: ");
                             String f = scanner.nextLine();
                             type = scanner.nextLine();
                             System.out.println("\nBreed: ");
                             breed = scanner.nextLine();
                             System.out.println("\nSex: ");
                             sex = scanner.nextLine();
                             price = 0.0;
                             System.out.println("\nColor: ");
                             color = scanner.nextLine();
                             Animal animal = new Animal(breed,sex,color,type,"available",price);
                             if(type.equals("cat")) {
                                 Cat cat1 = new Cat(breed,sex,color,"available",price);
                                 cat1.newanimal(animal,"animale_adoptie.csv");
                             }
                             if(type.equals("dog")){
                                 Dog dog1 = new Dog(breed,sex,color,"available",price);
                                 dog1.newanimal(animal,"animale_adoptie.csv");
                             }
                             if(type.equals("fish")){
                                 Fish fish1 = new Fish(breed,sex,color,"available",price);
                                 fish1.newanimal(animal,"animale_adoptie.csv");
                             }
                             if(type.equals("hamster")){
                                 Hamster hamster1 = new Hamster(breed,sex,color,"available",price);
                                 hamster1.newanimal(animal,"animale_adoptie.csv");
                             }
                             animaleadoptie.add(animal);
                             break;
                         default:
                             System.out.println("Optiune invalida!");
                     }

                }while (option3 < 3);
            }
            }
        } while (option1 < 3);

    }
}
