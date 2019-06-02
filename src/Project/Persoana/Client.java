package Project.Persoana;

import Project.Superclasa.Person;

import java.sql.*;

public class Client extends Person {
    private int id;
    private String adress;
    private String phone_number;
    private String mail;
    private String animal_dorit;
    private static int nr_clients;//nr de clienti

    public Client() {
        super();
    }

    public Client(String last_name, String first_name, String adress, String phone_number, String mail, String animal_dorit) {
        super(last_name, first_name);
        this.adress = adress;
        this.phone_number = phone_number;
        this.mail = mail;
        this.animal_dorit = animal_dorit;
    }

    public void updateclienti() throws SQLException
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:1000/petshop","root","12345");

            String query = " insert into users (client_id,first_name, last_name,adress,phone_number,animal_dorit)"
                    + " values (?, ?, ?, ?, ?)";


            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, Integer.valueOf(id) );
            preparedStmt.setString (2, String.valueOf(Date.valueOf(first_name)));
            preparedStmt.setString   (3, String.valueOf(last_name));
            preparedStmt.setString(4, String.valueOf(adress));
            preparedStmt.setString(5, String.valueOf(phone_number));
            preparedStmt.setString(6,String.valueOf(animal_dorit));
            preparedStmt.execute();
            if(conn != null)
                conn.close();
        } catch (SQLException ex){}

    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTip_de_animal_dorit() {
        return animal_dorit;
    }

    public void setTip_de_animal_dorit(String animal_dorit) {
        this.animal_dorit = animal_dorit;
    }

    public static int getNr_clients() {
        return nr_clients;
    }

    public static void setNr_clients(int nr_clients) {
        Client.nr_clients = nr_clients;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
