package Project.Superclasa;

import Project.Service.ReadingService;

import java.sql.*;
import java.util.List;
import java.io.*;

public class Animal{

    private static int nr_animals_bought ;
    private static int nr_animals_adopted ;
    protected String type;
    protected String breed;
    protected String sex;
    protected String color;
    protected String availability;
    protected Double price;

    public Animal(String breed, String sex, String color, String type, String availability, Double price) {
        this.type = type;
        this.breed = breed;
        this.sex = sex;
        this.color = color;
        this.availability = availability;
        this.price = price;
    }

    public Animal(String type) {
        this.type = type;
    }

    public Animal() {
        type = " ";
        breed = " ";
        sex = " ";
        color = " ";
        availability = " ";
        price = 0.0;
    }

    public void removeAnimalfromfile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file!");
                return;
            }
            //Contruiesc un nou fisier care la final va fii redenumit cu numele celui vechi.
            File tempFile = new File(inFile.getAbsolutePath());

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            //Citesc din fisierul original si scriu in cel nou toate liniile cu exceptia celei pe care doresc sa o sterg.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Sterg fisierul original!
            if (!inFile.delete()) {
                System.out.println("Nu exista animalul dorit!");
                return;
            }

            //Redenumesc fifiserul nou cu numele fisierului original!
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void buyanimal(int nr_animals_bought){
        Animal.nr_animals_bought = nr_animals_bought - 1;
    }
    public static void adoptanimal(int nr_animals_adopted){ Animal.nr_animals_adopted = nr_animals_adopted - 1; }
    public static void addanimal(int nr_animals_bought){Animal.nr_animals_bought = nr_animals_bought +1;}
    public static void addanimaladopt(int nr_animals_adopted){ Animal.nr_animals_adopted = nr_animals_adopted +1; }


    public static int getNr_animals_bought() {
        return nr_animals_bought;
    }

    public static void setNr_animals_bought(int nr_animals_bought) {
        Animal.nr_animals_bought = nr_animals_bought;
    }

    public static int getNr_animals_adopted() {
        return nr_animals_adopted;
    }

    public static void setNr_animals_adopted(int nr_animals_adopted) {
        Animal.nr_animals_adopted = nr_animals_adopted ;
    }
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void updateangajati() throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:1000/petshop", "root", "12345");
            pst = conn.prepareStatement("SELECT * from Animale");
            rs = pst.executeQuery();
            if (conn != null)
                        conn.close();
            if (rs != null) rs.close();
            if (pst != null) pst.close();
                } catch (SQLException ex) {
                }
    }
}
